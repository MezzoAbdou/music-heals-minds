package com.musicHealsMinds.MusicHealsMinds.dao;

import com.musicHealsMinds.MusicHealsMinds.model.TriviaQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class QuestionsSQLDAO implements QuestionDAO {

    private JdbcTemplate jdbcTemplate;

    public QuestionsSQLDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TriviaQuestion> getAllQuestions() {
        List<TriviaQuestion> triviaQuestions = new ArrayList<>();
        String sql = "SELECT * FROM questions;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
        triviaQuestions.add(mapRowToQuestion(results));
        }
        return triviaQuestions;
    }

    @Override
    public TriviaQuestion specificQuestion(int questionId) {
        TriviaQuestion answer = new TriviaQuestion();
        String sql = "SELECT * FROM questions WHERE question_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, questionId);
        if (results.next()){
          answer = mapRowToQuestion(results);
        }
        return answer;
    }

    @Override
    public void createQuestion(TriviaQuestion question) {
        String sql = "INSERT INTO questions (question) VALUES (?);";
        jdbcTemplate.update(sql, question.getQuestion());


    }

    @Override
    public TriviaQuestion updatedQuestion() {
        String sql = " UPDATE questions SET question = ? WHERE question_id = ?;";
        int updatedQuestion = jdbcTemplate.update(sql, updatedQuestion().getQuestion(), updatedQuestion().getQuestionId());
        return specificQuestion(updatedQuestion);
    }

    @Override
    public void deleteQuestion() {
        String sql = "DELETE FROM questions WHERE question_id = ?;";
        jdbcTemplate.update(sql);
    }

    private TriviaQuestion mapRowToQuestion(SqlRowSet rowSet){
        TriviaQuestion question = new TriviaQuestion();
        question.setQuestionId(rowSet.getInt("question_id"));
        question.setQuestion(rowSet.getString("question"));
        return question;
    }
}
