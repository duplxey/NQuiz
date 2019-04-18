package com.duplxey.nquiz.quiz;

import java.util.LinkedList;

public class Quiz {

    private String name;
    private String description;
    private QuizCategory category;
    private LinkedList<Question> questions;

    public Quiz(String name, String description, QuizCategory category, LinkedList<Question> questions) {
        this.name = name;
        this.description = description;
        this.category = category;
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

    public LinkedList<Question> getQuestions() {
        return questions;
    }
}