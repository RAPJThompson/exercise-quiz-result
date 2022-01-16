package com.odysseyenergysolutions.exercise.quiz.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Answers {
    int numQuestions = 3;
    String question1;
    boolean question2;
    int question3;

    public int getNumMatchingAnswers(Answers answers) {
        int correctCount = 0;
        if(question1.equals(answers.question1)) correctCount++;
        if(question2 == answers.question2) correctCount++;
        if(question3 == answers.question3) correctCount++;
        return correctCount;
    }
}
