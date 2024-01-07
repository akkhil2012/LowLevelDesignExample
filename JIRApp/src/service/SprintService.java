package service;

import model.Sprint;
import model.Task;

import java.util.List;

public class SprintService {

    Sprint sprint;

    public SprintService(Sprint sprint) {
        this.sprint = sprint;
    }

    public void addTask(Task task) {
        sprint.getSprintStrategy().addTask(task);
    }

    public void removeTask(String storyId) {
        sprint.getSprintStrategy().removeTask(storyId);
    }

    public void assignTask(String enitiy,String userId) {
        sprint.getSprintStrategy().assignTask(enitiy,userId);
    }

    public List<Task> fetchTasks() {
        return sprint.getSprintStrategy().fetchAllTasks();
    }
}
