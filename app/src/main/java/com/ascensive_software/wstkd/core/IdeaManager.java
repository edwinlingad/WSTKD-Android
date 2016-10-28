package com.ascensive_software.wstkd.core;

import android.widget.Toast;

/**
 * Created by edwin on 10/28/16.
 */

public class IdeaManager {

    private RandomNumberGenerator randomNumberGenerator;

    public IdeaManager() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public String GetNextIdea(){
        int index = randomNumberGenerator.GetRandomNumber(builtInIdeas.length);
        return builtInIdeas[index].title;
    }

    public void SetCategory(CategoryEnum category) {
        throw new UnsupportedOperationException();
    }

    public void ResetToDefault() {
        throw new UnsupportedOperationException();
    }

    public void AddNewIdea(String title, CategoryEnum category) {
        throw new UnsupportedOperationException();
    }

    private Idea builtInIdeas[] = {
            new Idea(CategoryEnum.Learn, "Read a book"),
            new Idea(CategoryEnum.Learn, "Learn a new song"),
            new Idea(CategoryEnum.Learn, "Learn a magic trick"),
            new Idea(CategoryEnum.Learn, "Learn a new dance move"),
            new Idea(CategoryEnum.Learn, "Study Math"),
            new Idea(CategoryEnum.Learn, "Study Science"),
            new Idea(CategoryEnum.Learn, "Study History"),
            new Idea(CategoryEnum.Learn, "Do a science project"),

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

            new Idea(CategoryEnum.Help, "Sort your clothes by color"),
            new Idea(CategoryEnum.Help, "Clean the living room"),
            new Idea(CategoryEnum.Help, "Clean the bedroom"),
            new Idea(CategoryEnum.Help, "Clean the bathroom"),
            new Idea(CategoryEnum.Help, "Tend the garden"),

            new Idea(CategoryEnum.Love, "Write a letter to a family member"),
            new Idea(CategoryEnum.Love, "Write a letter to a friend"),
            new Idea(CategoryEnum.Love, "Send a message to a friend"),
            new Idea(CategoryEnum.Love, "Hug a loved one"),
            new Idea(CategoryEnum.Love, "Give a loved one a hug"),
            new Idea(CategoryEnum.Love, "Talk to a loved one about your day"),
            new Idea(CategoryEnum.Love, "Make Christmas, Valentine's or Birthday cards"),
    };
}

