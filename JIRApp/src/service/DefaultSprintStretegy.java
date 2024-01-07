package service;

import model.Task;
import respository.JiraRepository;

import java.util.List;

public class DefaultSprintStretegy implements SprintStrategy {


    JiraRepository jiraRepository;


    public DefaultSprintStretegy() {
        this.jiraRepository = new JiraRepository();
    }

    @Override
    public void addTask(Task task) {
        this.jiraRepository.addTask(task);
    }

    @Override
    public void removeTask(String taskId) {
        this.jiraRepository.removeTask(taskId);
    }

    @Override
    public void assignTask(String task, String userId) {
        this.jiraRepository.assignTask(task,userId);
    }

    @Override
    public List<Task> fetchAllTasks() {
        return this.jiraRepository.fetchAllTasks();
    }
}
