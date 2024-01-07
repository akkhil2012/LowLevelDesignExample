package service;

import model.Task;

import java.util.List;

public interface SprintStrategy {

    void addTask(Task task);

    void removeTask(String taskId);

    void assignTask(String task,String  userId);


    List<Task> fetchAllTasks();
}
