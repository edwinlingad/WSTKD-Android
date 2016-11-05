package com.ascensive_software.wstkd.core;

import android.app.Application;

import com.ascensive_software.wstkd.core.Enums.CategoryEnum;

import java.util.ArrayList;

/**
 * Created by edwin on 10/30/16.
 */

public class BuiltInIdeas {

    private final String builtInIdeasFileName_ = "configs/builtins";
    private Application application_;
    public BuiltInIdeas(Application application) {
        application_ = application;

        allocLists();
        loadBuiltInIdeas();
    }

    private void allocLists() {
        learnIdeas_ = new ArrayList<>();
        playIdeas_ = new ArrayList<>();
        relaxIdeas_ = new ArrayList<>();
        loveIdeas_ = new ArrayList<>();
        helpIdeas_ = new ArrayList<>();
    }

    private void loadBuiltInIdeas() {
        com.ascensive_software.utils.AssetReader.readTextAsset(application_, builtInIdeasFileName_,
                new com.ascensive_software.utils.AssetReader.ReadLineCallBack() {

                    @Override
                    public void onReadLine(String line) {
                        String idea = line.substring(2);
                        switch(line.charAt(0)) {
                            case '0':
                                learnIdeas_.add(new Idea(CategoryEnum.Learn, idea));
                                break;
                            case '1':
                                playIdeas_.add(new Idea(CategoryEnum.Play, idea));
                                break;
                            case '2':
                                relaxIdeas_.add(new Idea(CategoryEnum.Relax, idea));
                                break;
                            case '3':
                                loveIdeas_.add(new Idea(CategoryEnum.Love, idea));
                                break;
                            case '4':
                                helpIdeas_.add(new Idea(CategoryEnum.Help, idea));
                                break;
                            default:
                                break;
                        }
                    }
                });
    }

    public Idea[] getIdeas(CategoryEnum category) {
        Idea[] ideas = null;
        switch (category) {
            case Learn:
                ideas = learnIdeas_.toArray(new Idea[0]);
                break;
            case Play:
                ideas = playIdeas_.toArray(new Idea[0]);
                break;
            case Relax:
                ideas = relaxIdeas_.toArray(new Idea[0]);
                break;
            case Love:
                ideas = loveIdeas_.toArray(new Idea[0]);
                break;
            case Help:
                ideas = helpIdeas_.toArray(new Idea[0]);
                break;
        }

        return  ideas;
    }

    private ArrayList<Idea> learnIdeas_;
    private ArrayList<Idea> playIdeas_;
    private ArrayList<Idea> relaxIdeas_;
    private ArrayList<Idea> loveIdeas_;
    private ArrayList<Idea> helpIdeas_;
}
