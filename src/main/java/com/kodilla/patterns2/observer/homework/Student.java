package com.kodilla.patterns2.observer.homework;


public interface Student {
    void registerMentor(Mentor mentor);
    void notifyMentors();
    void removeMentor(Mentor mentor);
}
