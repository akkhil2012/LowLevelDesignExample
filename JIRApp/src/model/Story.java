package model;

import java.util.List;

public class Story extends  Task{

    List<Story> subStories;

    public Story(String entityName) {
        super(entityName);
    }

    @Override
    void updateStatus(Status status) {

    }
}
