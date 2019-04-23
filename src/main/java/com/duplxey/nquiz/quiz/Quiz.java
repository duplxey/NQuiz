package com.duplxey.nquiz.quiz;

import com.duplxey.nquiz.util.FileUtil;
import com.duplxey.nquiz.util.GsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Quiz {

    private String name;
    private String description;
    private QuizCategory category;
    private QuizDifficulty difficulty;
    private LinkedList<Question> questions;

    // Transient to prevent serialization
    private transient File file = null;

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

    public void save() {
        if (file == null) {
            file = new File(QuizManager.getQuizDirectory(), name + ".json");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileUtil.writeToFile(file.getPath(), GsonUtil.getInstance().getGson().toJson(this));
    }

    public void delete() {
        if (file == null) return;
        file.delete();
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

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(int questionId) {
        questions.remove(questionId);
    }

    public void setQuestions(LinkedList<Question> questions) {
        this.questions = questions;
    }

    public void clearQuestions() {
        questions.clear();
    }

    public String info() {
        return name + " (" + description + ") " + "(" + category + ") " + "(" + difficulty + ")";
    }
}
