package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Task implements Student  {

    private final List<Mentor> mentors;
    private final List<String> tasks;
    private final String name;

    public Task(String name) {
        this.mentors = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task){
        tasks.add(task);
        notifyMentors();
    }
    @Override
    public void registerMentor(Mentor mentor){
        mentors.add(mentor);
    }

    @Override
    public void notifyMentors() {
        for (Inform mentor : mentors) {
            mentor.update(this);
        }
    }

    @Override
    public void removeMentor(Mentor mentor){
        mentors.remove(mentor);
    }

    public String getName() {
        return name;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
