package com.ascensive_software.wstkd.core;

import java.io.Serializable;

/**
 * Created by edwin on 10/30/16.
 */

public class Data implements Serializable {
    public CategoryEnum selectedCategory;
    public Idea[] learnIdeas;
    public Idea[] playIdeas;
    public Idea[] relaxIdeas;
    public Idea[] loveIdeas;
    public Idea[] helpIdeas;
    public Idea[] othersIdeas;
}
