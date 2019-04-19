package com.duplxey.nquiz.quiz;

import java.util.LinkedList;

public class Quiz {

    private String name;
    private String description;
    private QuizCategory category;
    private QuizDifficulty difficulty;
    private LinkedList<Question> questions;

    public Quiz(String name, String description, QuizCategory category, QuizDifficulty difficulty, LinkedList<Question> questions) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public QuizCategory getCategory() {
        return category;
    }

    public QuizDifficulty getDifficulty() {
        return difficulty;
    }

    public LinkedList<Question> getQuestions() {
        return questions;
    }

    public void print() {
        System.out.println("============");
        System.out.println(name);
        System.out.println(description);
        System.out.println(category);
        System.out.println(difficulty);
        System.out.println("============");
        for (Question q : questions) {
            System.out.println(q.getText());
        }
    }
}
