package com.odysseyenergysolutions.exercise.quiz.service;

import com.odysseyenergysolutions.exercise.quiz.model.Answers;

public interface AnswerService {
    public void submitUserAnswers(String username, Answers userAnswers);
}
