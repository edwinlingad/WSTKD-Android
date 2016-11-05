package com.ascensive_software.wstkd.core;

import com.ascensive_software.wstkd.core.Enums.CategoryEnum;
import com.ascensive_software.wstkd.core.Enums.IdeaTypeEnum;

import java.io.Serializable;

/**
 * Created by edwin on 10/30/16.
 */

public class SavedData implements Serializable {
    public Idea[] learnIdeas;
    public Idea[] playIdeas;
    public Idea[] relaxIdeas;
    public Idea[] loveIdeas;
    public Idea[] helpIdeas;
}
