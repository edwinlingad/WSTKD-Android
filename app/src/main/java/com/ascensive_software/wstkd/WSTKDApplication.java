package com.ascensive_software.wstkd;

import android.app.Application;

import com.ascensive_software.wstkd.core.IdeaManager;

/**
 * Created by edwin on 10/28/16.
 */

public class WSTKDApplication extends Application {

    private IdeaManager _ideaManager = null;
    public IdeaManager getIdeaManager() {
        if(_ideaManager == null)
            _ideaManager = new IdeaManager();
        return _ideaManager;
    }

    public WSTKDApplication() {
        _ideaManager = new IdeaManager();
    }

}
