package com.odysseyenergysolutions.exercise.quiz.controller;

import com.odysseyenergysolutions.exercise.quiz.model.Answers;
import com.odysseyenergysolutions.exercise.quiz.service.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class QuizController {
    private AnswerServiceImpl answerService;

    @Autowired
    public QuizController(AnswerServiceImpl answerService) {
        this.answerService = answerService;
    }

    @PostMapping("answers/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void submitUserAnswers(@PathVariable("username") String username, @RequestBody Answers userAnswers) {
        answerService.submitUserAnswers(username, userAnswers);
    }
}
