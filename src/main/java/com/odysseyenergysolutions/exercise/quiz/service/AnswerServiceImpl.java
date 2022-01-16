package com.odysseyenergysolutions.exercise.quiz.service;

import com.google.gson.Gson;
import com.odysseyenergysolutions.exercise.quiz.dao.AnswerRepository;
import com.odysseyenergysolutions.exercise.quiz.model.Answers;
import com.odysseyenergysolutions.exercise.quiz.model.QuizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class AnswerServiceImpl {
    private AnswerRepository answerRepository;
    private Answers correctAnswers;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.correctAnswers = getCorrectAnswers();
        this.answerRepository = answerRepository;
    }

    public void submitUserAnswers(String username, Answers userAnswers) {
        if(correctAnswers == null) {
            throw new IllegalStateException("Correct Answers Unavailable");
        }
        int numCorrect = correctAnswers.getNumMatchingAnswers(userAnswers);
        QuizResult quizResult = new QuizResult();
        quizResult.setQuizUser(username);
        quizResult.setCorrectAnswers(numCorrect);
        quizResult.setWrongAnswers(correctAnswers.getNumQuestions() - numCorrect);

        answerRepository.save(quizResult);
    }

    private Answers getCorrectAnswers() {
        if (correctAnswers == null) {
            String correctAnswersJsonString = null;
            try {
                correctAnswersJsonString = Files.readString(Paths.get(getClass().getResource("/quiz/correct_answers.json").toURI()), StandardCharsets.UTF_8);
                correctAnswers = new Gson().fromJson(correctAnswersJsonString, Answers.class);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

        return correctAnswers;
    }
}
