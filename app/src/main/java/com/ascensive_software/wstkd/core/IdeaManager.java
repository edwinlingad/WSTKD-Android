package com.ascensive_software.wstkd.core;

import com.ascensive_software.utils.DataSharedPreferences;
import com.ascensive_software.wstkd.WSTKDApplication;
import com.ascensive_software.wstkd.core.Enums.CategoryEnum;
import com.ascensive_software.wstkd.core.Enums.IdeaTypeEnum;

import java.util.ArrayList;

/**
 * Created by edwin on 10/28/16.
 */

public class IdeaManager {

    private RandomNumberGenerator randomNumberGenerator;
    private WSTKDApplication application_;

    public CategoryEnum getSelectedCategory_() {
        return selectedCategory_;
    }

    private CategoryEnum selectedCategory_;
    private IdeaTypeEnum selectedIdeaType_;

    private final String SELECTED_CATEGORY = "SELECTED_CATEGORY";
    private final String SELECTED_IDEA_TYPE = "SELECTED_IDEA_TYPE";

    public IdeaManager(WSTKDApplication application) {
        randomNumberGenerator = new RandomNumberGenerator();
        application_ = application;

        int value = DataSharedPreferences.loadInt(application_, SELECTED_CATEGORY);
        selectedCategory_ = CategoryEnum.values()[value];

        value = DataSharedPreferences.loadInt(application_, SELECTED_IDEA_TYPE);
        selectedIdeaType_ = IdeaTypeEnum.values()[value];
    }

    public String getNextIdea(){

        String ideaString = "Add activity ideas for this category";
        Idea[] ideas;
        int categoryIdx;

        if(selectedCategory_ == CategoryEnum.All) {
            categoryIdx = randomNumberGenerator.generateRandomNumber(5);
        } else {
            categoryIdx = selectedCategory_.ordinal()-1;
        }

        int ideaTypeIdx = selectedIdeaType_.ordinal();
        if(selectedIdeaType_ == IdeaTypeEnum.All) {
            ideaTypeIdx = randomNumberGenerator.generateRandomNumber(2) + 1;
        }

        if(ideaTypeIdx == 1) { // built in
            ideas = getBuiltInDataCategoryMap().get(categoryIdx);
        } else {
            ideas = getCustomDataCategoryMap().get(categoryIdx);
        }

        if(ideas.length == 0 && selectedIdeaType_== IdeaTypeEnum.All)
            ideas = getBuiltInDataCategoryMap().get(categoryIdx);

        if(ideas.length != 0) {
            int index = randomNumberGenerator.generateRandomNumber(ideas.length);
            ideaString = ideas[index].title;
        }

        return ideaString;
    }

    public void setCategory(CategoryEnum category) {
        selectedCategory_ = category;
        DataSharedPreferences.saveInt(application_, SELECTED_CATEGORY, category.ordinal());
    }

    public void setIdeaType(IdeaTypeEnum ideaType) {
        selectedIdeaType_ = ideaType;
        DataSharedPreferences.saveInt(application_, SELECTED_IDEA_TYPE, ideaType.ordinal());
    }

    public void resetToDefault() {

        setCategory(CategoryEnum.All);
        setIdeaType(IdeaTypeEnum.All);

        SavedData data = new SavedData();
        data.learnIdeas = new Idea[0];
        data.playIdeas = new Idea[0];
        data.relaxIdeas = new Idea[0];
        data.loveIdeas = new Idea[0];
        data.helpIdeas = new Idea[0];

        Storage storage = new Storage(application_);
        storage.save(data);

        saveddata_ = data;
    }

    public void addNewIdea(String title, CategoryEnum category) {
        throw new UnsupportedOperationException();
    }

    private SavedData saveddata_;
    private SavedData getSavedData() {
        if(saveddata_ == null) {
            Storage storage = new Storage(application_);
            saveddata_ = storage.load();

            if(saveddata_ == null) {
                resetToDefault();
            }
        }

        return saveddata_;
    }

    private ArrayList<Idea[]> customDataCategoryMap_;
    private ArrayList<Idea[]> getCustomDataCategoryMap() {
        if(customDataCategoryMap_ == null) {
            SavedData data = getSavedData();

            customDataCategoryMap_ = new ArrayList<>();
            customDataCategoryMap_.add(data.learnIdeas);
            customDataCategoryMap_.add(data.playIdeas);
            customDataCategoryMap_.add(data.relaxIdeas);
            customDataCategoryMap_.add(data.loveIdeas);
            customDataCategoryMap_.add(data.helpIdeas);
        }

        return customDataCategoryMap_;
    }

    private ArrayList<Idea[]> builtInDataCategoryMap_;
    private ArrayList<Idea[]> getBuiltInDataCategoryMap() {
        if(builtInDataCategoryMap_ == null) {
            BuiltInIdeas builtInIdeas = new BuiltInIdeas(application_);

            builtInDataCategoryMap_ = new ArrayList<>();
            builtInDataCategoryMap_.add(builtInIdeas.getIdeas(CategoryEnum.Learn));
            builtInDataCategoryMap_.add(builtInIdeas.getIdeas(CategoryEnum.Play));
            builtInDataCategoryMap_.add(builtInIdeas.getIdeas(CategoryEnum.Relax));
            builtInDataCategoryMap_.add(builtInIdeas.getIdeas(CategoryEnum.Love));
            builtInDataCategoryMap_.add(builtInIdeas.getIdeas(CategoryEnum.Help));
        }

        return builtInDataCategoryMap_;
    }
}

