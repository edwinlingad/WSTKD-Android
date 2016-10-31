package com.ascensive_software.wstkd.core;

import com.ascensive_software.wstkd.WSTKDApplication;

import java.util.ArrayList;

/**
 * Created by edwin on 10/28/16.
 */

public class IdeaManager {

    private RandomNumberGenerator randomNumberGenerator;
    private WSTKDApplication application_;

    public IdeaManager(WSTKDApplication application) {
        randomNumberGenerator = new RandomNumberGenerator();
        application_ = application;
    }

    public String getNextIdea(){

        String ideaString;
        Data data = getData();

        Idea[] ideas;

        if(data.selectedCategory == CategoryEnum.All) {
            int categoryIndex = randomNumberGenerator.generateRandomNumber(6);
            ideas = dataCategoryMap_.get(categoryIndex);
        } else {
            int idx = data.selectedCategory.ordinal()-1;
            ideas = dataCategoryMap_.get(idx);
        }

        int index = randomNumberGenerator.generateRandomNumber(ideas.length);
        ideaString = ideas[index].title;

        return  ideaString;
    }

    public void setCategory(CategoryEnum category) {
        getData().selectedCategory = category;
    }

    public void resetToDefault() {
        BuiltInIdeas builtInIdeas = new BuiltInIdeas();

        Data data = new Data();
        data.selectedCategory = CategoryEnum.All;
        data.learnIdeas = builtInIdeas.getIdeas(CategoryEnum.Learn);
        data.playIdeas = builtInIdeas.getIdeas(CategoryEnum.Play);
        data.relaxIdeas = builtInIdeas.getIdeas(CategoryEnum.Relax);
        data.loveIdeas = builtInIdeas.getIdeas(CategoryEnum.Love);
        data.helpIdeas = builtInIdeas.getIdeas(CategoryEnum.Help);
        data.othersIdeas = builtInIdeas.getIdeas(CategoryEnum.Others);

        Storage storage = new Storage(application_);
        storage.save(data);

        data_ = data;
    }

    public void addNewIdea(String title, CategoryEnum category) {
        throw new UnsupportedOperationException();
    }

    private Data data_;
    private Data getData() {
        if(data_ == null) {
            Storage storage = new Storage(application_);
            data_ = storage.load();

            if(data_ == null) {
                resetToDefault();
            }

            createDataCategoryMap();
        }

        return data_;
    }

    private ArrayList<Idea[]> dataCategoryMap_;
    private void createDataCategoryMap() {
        dataCategoryMap_ = new ArrayList<>();
        dataCategoryMap_.add(data_.learnIdeas);
        dataCategoryMap_.add(data_.playIdeas);
        dataCategoryMap_.add(data_.relaxIdeas);
        dataCategoryMap_.add(data_.loveIdeas);
        dataCategoryMap_.add(data_.helpIdeas);
        dataCategoryMap_.add(data_.othersIdeas);
    }
}

