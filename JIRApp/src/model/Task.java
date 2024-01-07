package model;

public abstract class Task {

    String entityId;

    public Task(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    String entityName;
    abstract void updateStatus(Status status);


}
