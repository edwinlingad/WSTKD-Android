package com.ascensive_software.wstkd;

import android.app.Application;

import com.ascensive_software.wstkd.core.Enums.CategoryEnum;
import com.ascensive_software.wstkd.core.SavedData;
import com.ascensive_software.wstkd.core.IdeaManager;
import com.ascensive_software.wstkd.core.Storage;

import java.util.HashMap;

/**
 * Created by edwin on 10/28/16.
 */

public class WSTKDApplication extends Application {

    public WSTKDApplication() {
        initResourceIdToCategoryEnumMap();
        initResourceIdToIconIdMap();
        initCategoryEnumToIconIdMap();
    }

    private void initResourceIdToCategoryEnumMap() {
        resourceIdToCategoryEnumMap_ = new HashMap<>();
        resourceIdToCategoryEnumMap_.put(R.id.cat_all, CategoryEnum.All);
        resourceIdToCategoryEnumMap_.put(R.id.cat_learn, CategoryEnum.Learn);
        resourceIdToCategoryEnumMap_.put(R.id.cat_play, CategoryEnum.Play);
        resourceIdToCategoryEnumMap_.put(R.id.cat_relax, CategoryEnum.Relax);
        resourceIdToCategoryEnumMap_.put(R.id.cat_love, CategoryEnum.Love);
        resourceIdToCategoryEnumMap_.put(R.id.cat_help, CategoryEnum.Help);
    }

    private void initResourceIdToIconIdMap() {
        categoryIdToIconIdMap_ = new HashMap<>();
        categoryIdToIconIdMap_.put(R.id.cat_all, R.drawable.ic_all);
        categoryIdToIconIdMap_.put(R.id.cat_learn, R.drawable.ic_learn);
        categoryIdToIconIdMap_.put(R.id.cat_play, R.drawable.ic_play);
        categoryIdToIconIdMap_.put(R.id.cat_relax, R.drawable.ic_relax);
        categoryIdToIconIdMap_.put(R.id.cat_love, R.drawable.ic_love);
        categoryIdToIconIdMap_.put(R.id.cat_help, R.drawable.ic_help);
    }

    private void initCategoryEnumToIconIdMap() {
        categoryEnumToIconIdMap_ = new HashMap<>();
        categoryEnumToIconIdMap_.put(CategoryEnum.All, R.drawable.ic_all);
        categoryEnumToIconIdMap_.put(CategoryEnum.Learn, R.drawable.ic_learn);
        categoryEnumToIconIdMap_.put(CategoryEnum.Play, R.drawable.ic_play);
        categoryEnumToIconIdMap_.put(CategoryEnum.Relax, R.drawable.ic_relax);
        categoryEnumToIconIdMap_.put(CategoryEnum.Love, R.drawable.ic_love);
        categoryEnumToIconIdMap_.put(CategoryEnum.Help, R.drawable.ic_help);
    }

    private int[] _catIds = {
            R.id.cat_all,
            R.id.cat_learn,
            R.id.cat_play,
            R.id.cat_relax,
            R.id.cat_love,
            R.id.cat_help,
    };
    public int[] getCatIds() {
        return _catIds;
    }

    private IdeaManager ideaManager_ = null;
    public IdeaManager getIdeaManager() {
        if(ideaManager_ == null)
            ideaManager_ = new IdeaManager(this);
        return ideaManager_;
    }

    private HashMap<Integer, CategoryEnum> resourceIdToCategoryEnumMap_;
    public HashMap<Integer, CategoryEnum> getIdToCategoryMap() {
        return resourceIdToCategoryEnumMap_;
    }

    private HashMap<Integer, Integer> categoryIdToIconIdMap_;
    public HashMap<Integer, Integer> getIdToIconMap() {
        return categoryIdToIconIdMap_;
    }

    private HashMap<CategoryEnum, Integer> categoryEnumToIconIdMap_;
    public HashMap<CategoryEnum, Integer> getCategoryEnumToIconIdMap() {
        return categoryEnumToIconIdMap_;
    }

    private SavedData data_;
    public SavedData getData() {
        return data_;
    }

    private Storage storage_;
    public Storage getStorage_() {
        return storage_;
    }

}
