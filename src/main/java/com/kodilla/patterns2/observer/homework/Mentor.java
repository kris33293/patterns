package com.kodilla.patterns2.observer.homework;

public class Mentor implements Inform{

    private final String mentorName;
    private int count;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Task tasks) {
        System.out.println(mentorName + ": New Task: " + tasks.getName() + "\n" +
                " (total: " + tasks.getTasks().size() + " tasks)");
        count++;
    }

    public int getCount() {
        return count;
    }
}
