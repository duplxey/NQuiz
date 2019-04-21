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

    public Quiz(String name, String description, QuizCategory category, QuizDifficulty difficulty) {
        this(name, description, category, difficulty, new LinkedList<Question>() {});
    }

    public Quiz(String name) {
        this(name, "No description given.", QuizCategory.FUN, QuizDifficulty.EASY, new LinkedList<Question>() {});
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(int questionId) {
        questions.remove(questionId);
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(QuizCategory category) {
        this.category = category;
    }

    public void setDifficulty(QuizDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setQuestions(LinkedList<Question> questions) {
        this.questions = questions;
    }

    public String info() {
        return name + " (" + description + ") " + "(" + category + ") " + "(" + difficulty + ")";
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
