package com.app.todoApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Title;
    private boolean Completed;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public void setCompleted(boolean b) {
        this.Completed = b;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public boolean isCompleted() {
        return Completed;
    }

}
