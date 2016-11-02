package com.ascensive_software.wstkd;

import android.app.Application;

import com.ascensive_software.wstkd.core.CategoryEnum;
import com.ascensive_software.wstkd.core.Data;
import com.ascensive_software.wstkd.core.IdeaManager;
import com.ascensive_software.wstkd.core.Storage;

import java.util.HashMap;

/**
 * Created by edwin on 10/28/16.
 */

public class WSTKDApplication extends Application {

    public WSTKDApplication() {
        initIdToCategoryMap();
        initIdToIconMap();
    }

    private void initIdToCategoryMap() {
        idToCategoryMap_ = new HashMap<>();
        idToCategoryMap_.put(R.id.cat_all, CategoryEnum.All);
        idToCategoryMap_.put(R.id.cat_learn, CategoryEnum.Learn);
        idToCategoryMap_.put(R.id.cat_play, CategoryEnum.Play);
        idToCategoryMap_.put(R.id.cat_relax, CategoryEnum.Relax);
        idToCategoryMap_.put(R.id.cat_love, CategoryEnum.Love);
        idToCategoryMap_.put(R.id.cat_help, CategoryEnum.Help);
    }

    private void initIdToIconMap() {
        categoryToIconMap_ = new HashMap<>();
        categoryToIconMap_.put(R.id.cat_all, R.drawable.ic_all);
        categoryToIconMap_.put(R.id.cat_learn, R.drawable.ic_learn);
        categoryToIconMap_.put(R.id.cat_play, R.drawable.ic_play);
        categoryToIconMap_.put(R.id.cat_relax, R.drawable.ic_relax);
        categoryToIconMap_.put(R.id.cat_love, R.drawable.ic_love);
        categoryToIconMap_.put(R.id.cat_help, R.drawable.ic_help);
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

    private HashMap<Integer, CategoryEnum> idToCategoryMap_;
    public HashMap<Integer, CategoryEnum> getIdToCategoryMap() {
        return idToCategoryMap_;
    }

    private HashMap<Integer, Integer> categoryToIconMap_;
    public HashMap<Integer, Integer> getIdToIconMap() {
        return categoryToIconMap_;
    }

    private Data data_;
    public Data getData() {
        return data_;
    }

    private Storage storage_;
    public Storage getStorage_() {
        return storage_;
    }

}
