package model;

import service.DefaultSprintStretegy;
import service.SprintStrategy;

import java.util.List;


/*
Create spring using Builder pattern
 */
public class Sprint {

    String name;

    public SprintStrategy getSprintStrategy() {
        return sprintStrategy;
    }

    public SprintData getSprintData() {
        return sprintData;
    }

    SprintStrategy sprintStrategy;
    SprintData sprintData;

    public Sprint(String name) {
        this.name = name;
        this.sprintStrategy = new DefaultSprintStretegy();
        this.sprintData = new SprintData();
    }

    public static SprintBuilder builder(){
        return new SprintBuilder();
    }

    public static class SprintBuilder{
        SprintStrategy sprintStrategy;
        SprintData sprintData;

        public SprintBuilder withStretegy(){
            this.sprintStrategy = new DefaultSprintStretegy();
            return  this;
        }

        public SprintBuilder withSprintData(){
            this.sprintData = new SprintData();
            return  this;
        }

        public Sprint build(String sprintName){
            Sprint sprint = new Sprint(sprintName);
            sprint.sprintStrategy= this.sprintStrategy;
            sprint.sprintData = this.sprintData;
            return  sprint;
        }


    }

}
