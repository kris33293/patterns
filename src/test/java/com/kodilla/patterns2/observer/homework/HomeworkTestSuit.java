package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuit {

    @Test
    public void testUpdate() {
        //Given
        Task task = new Task("Student1 tasks");
        Task task1 = new Task("Student2 tasks");
        Task task2 = new Task("Student3 tasks");

        Mentor mentor1 = new Mentor("mentor1");
        Mentor mentor2 = new Mentor("mentor2");

        task.registerMentor(mentor1);
        task1.registerMentor(mentor2);
        task2.registerMentor(mentor2);

        //When
        task.addTask("problem 1");
        task.addTask("problem 2");
        task.addTask("problem 3");

        task1.addTask("problem 1");
        task1.addTask("problem 2");
        task1.addTask("problem 3");

        task2.addTask("problem 1");
        task2.addTask("problem 2");

        //Then
        assertEquals(3, mentor1.getCount());
        assertEquals(5, mentor2.getCount());


    }

}
