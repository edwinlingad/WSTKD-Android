package com.ascensive_software.wstkd.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by edwin on 10/30/16.
 */

public class BuiltInIdeas {
    public Idea[] getIdeas(CategoryEnum category) {
        Idea[] ideas = null;
        switch (category) {
            case Learn:
                ideas = learnIdeas_;
                break;
            case Play:
                ideas = playIdeas_;
                break;
            case Relax:
                ideas = relaxIdeas_;
                break;
            case Love:
                ideas = loveIdeas_;
                break;
            case Help:
                ideas = helpIdeas_;
                break;
            case Others:
                ideas = othersIdeas_;
                break;
            case All:
                ideas = getAllIdeas_();
                break;
        }

        return  ideas;
    }

    private Idea allIdeas_[] = null;
    private Idea[] getAllIdeas_() {
        if(allIdeas_ == null) {
            ArrayList<Idea> list = new ArrayList<Idea>();
            list.addAll(Arrays.asList(learnIdeas_));
            list.addAll(Arrays.asList(playIdeas_));
            list.addAll(Arrays.asList(relaxIdeas_));
            list.addAll(Arrays.asList(loveIdeas_));
            list.addAll(Arrays.asList(helpIdeas_));
            list.addAll(Arrays.asList(othersIdeas_));

            allIdeas_ = (Idea[])list.toArray();
        }

        return  allIdeas_;
    }

    private Idea learnIdeas_[] = {
            new Idea(CategoryEnum.Learn, "Read a book"),
            new Idea(CategoryEnum.Learn, "Learn a new song"),
            new Idea(CategoryEnum.Learn, "Learn a magic trick"),
            new Idea(CategoryEnum.Learn, "Learn a new dance move"),
            new Idea(CategoryEnum.Learn, "Study Math"),
            new Idea(CategoryEnum.Learn, "Study Science"),
            new Idea(CategoryEnum.Learn, "Study History"),
            new Idea(CategoryEnum.Learn, "Do a science project")
    };

    private Idea playIdeas_[] = {
            new Idea(CategoryEnum.Play, "Do jumping jacks"),
            new Idea(CategoryEnum.Play, "Play board games"),
            new Idea(CategoryEnum.Play, "Ride a bike"),
            new Idea(CategoryEnum.Play, "Play a ball game"),
            new Idea(CategoryEnum.Play, "Play a game on the tablet"),
            new Idea(CategoryEnum.Play, "Play video games"),
            new Idea(CategoryEnum.Play, "Make paper airplanes"),
            new Idea(CategoryEnum.Play, "Play sudoku"),
            new Idea(CategoryEnum.Play, "Run laps in the backyard"),
            new Idea(CategoryEnum.Play, "Draw a portrait of the person closest to you"),
            new Idea(CategoryEnum.Play, "Play online games"),
            new Idea(CategoryEnum.Play, "Draw anything"),
            new Idea(CategoryEnum.Play, "Do coloring activities"),
    };

    private Idea relaxIdeas_[] = {
            new Idea(CategoryEnum.Relax, "Watch tv"),
            new Idea(CategoryEnum.Relax, "Lie down and do nothing"),
            new Idea(CategoryEnum.Relax, "Take a bath"),
            new Idea(CategoryEnum.Relax, "Take a walk"),
            new Idea(CategoryEnum.Relax, "Take funny selfies"),
            new Idea(CategoryEnum.Relax, "Post a status update in social media"),
            new Idea(CategoryEnum.Relax, "Eat a fruit"),
            new Idea(CategoryEnum.Relax, "Eat a cookie"),
            new Idea(CategoryEnum.Relax, "Make a wish list of things you want to do"),
            new Idea(CategoryEnum.Relax, "Make a gift wish list"),
            new Idea(CategoryEnum.Relax, "Count your money"),
            new Idea(CategoryEnum.Relax, "Look at old pictures or albums"),
            new Idea(CategoryEnum.Relax, "Watch shows online"),
    };

    private Idea loveIdeas_[] = {
            new Idea(CategoryEnum.Love, "Write a letter to a family member"),
            new Idea(CategoryEnum.Love, "Write a letter to a friend"),
            new Idea(CategoryEnum.Love, "Send a message to a friend"),
            new Idea(CategoryEnum.Love, "Hug a loved one"),
            new Idea(CategoryEnum.Love, "Give a loved one a hug"),
            new Idea(CategoryEnum.Love, "Talk to a loved one about your day"),
            new Idea(CategoryEnum.Love, "Make Christmas, Valentine's or Birthday cards"),
    };

    private Idea helpIdeas_[] = {
            new Idea(CategoryEnum.Help, "Sort your clothes by color"),
            new Idea(CategoryEnum.Help, "Clean the living room"),
            new Idea(CategoryEnum.Help, "Clean the bedroom"),
            new Idea(CategoryEnum.Help, "Clean the bathroom"),
            new Idea(CategoryEnum.Help, "Tend the garden"),
    };

    private Idea othersIdeas_[] = {
            new Idea(CategoryEnum.Love, "Do nothing all day"),
    };

}
