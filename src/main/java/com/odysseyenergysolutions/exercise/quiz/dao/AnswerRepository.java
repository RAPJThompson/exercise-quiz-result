package com.odysseyenergysolutions.exercise.quiz.dao;

import com.odysseyenergysolutions.exercise.quiz.model.QuizResult;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<QuizResult, Integer> {}
