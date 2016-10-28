package com.ascensive_software.wstkd.core;

/**
 * Created by edwin on 10/28/16.
 */

public class Idea {

    public Idea(CategoryEnum category, String title) {
        this.title = title;
        this.category = category;
        this.isBuiltIn = true;
        this.isAlreadyChosen = false;
    }

    public Idea(CategoryEnum category, String title, boolean isBuiltIn, boolean isAlreadyChosen) {
        this.title = title;
        this.category = category;
        this.isBuiltIn = isBuiltIn;
        this.isAlreadyChosen = isAlreadyChosen;
    }

    public String title;
    public CategoryEnum category;
    public boolean isBuiltIn;
    public boolean isAlreadyChosen;
}
