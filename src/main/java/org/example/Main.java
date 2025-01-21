package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

import static org.example.entity.StringSet.findUniqueWords;

public class Main {
    public static void main(String[] args) {

        Task t1 = new Task("ProjectA", "Login Page", "Ann", Priority.HIGH, Status.IN_PROGRESS);
        Task t2 = new Task("ProjectB", "Payment Module", "Bob", Priority.MED, Status.ASSIGNED);
        Task t3 = new Task("ProjectA", "UI Refactor", "Ann", Priority.LOW, Status.IN_QUEUE);
        Task t4 = new Task("ProjectC", "Database Migration", "Carol", Priority.HIGH, Status.IN_QUEUE);
        Task t5 = new Task("ProjectD", "Analytics Setup", null, Priority.MED, Status.IN_QUEUE);

        Set<Task> annTasks = new HashSet<>();
        annTasks.add(t1);
        annTasks.add(t3);

        Set<Task> bobTasks = new HashSet<>();
        bobTasks.add(t2);

        Set<Task> carolTasks = new HashSet<>();
        carolTasks.add(t4);

        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(t5);

        TaskData taskData = new TaskData(annTasks, bobTasks, carolTasks, unassignedTasks);

        Set<Task> allTasks = taskData.getTasks("all");
        System.out.println("All tasks: " + allTasks);

        Set<Task> annSet = taskData.getTasks("ann");
        System.out.println("Ann's tasks: " + annSet);

        Set<Task> bobSet = taskData.getTasks("bob");
        System.out.println("Bob's tasks: " + bobSet);

        Set<Task> carolSet = taskData.getTasks("carol");
        System.out.println("Carol''s tasks: " + carolSet);


        Set<Task> unassigned = taskData.getUnassignedTasks();
        System.out.println("Unassigned tasks: " + unassigned);

        Set<Task> annBobIntersect = taskData.getIntersection(annSet, bobTasks);
        if (!annBobIntersect.isEmpty()) {
            System.out.println("Ann ve Bob'a atanmış ortak task(lar): " + annBobIntersect);
        } else {
            System.out.println("Ann ve Bob arasında ortak (aynı) task yok.");
        }

        System.out.println("----------------------------------------------");

        Set<String> uniqueWords = findUniqueWords();
        System.out.println("Unique kelime sayısı: " + uniqueWords.size());
        System.out.println("Alfabetik sıradaki unique kelimeler:");
        System.out.println(uniqueWords);
    }
}