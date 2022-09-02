package com.musicHealsMinds.MusicHealsMinds.dao;

import com.musicHealsMinds.MusicHealsMinds.model.Answers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswersSQLDAO implements AnswersDAO{
    private JdbcTemplate jdbcTemplate;

    public AnswersSQLDAO(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Answers> getAllAnswers() {
        List<Answers> answers = new ArrayList<>();
        String sql = "SELECT * FROM answers;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            answers.add(mapRowToAnswers(results));
        }
        return answers;
    }

    @Override
    public Answers getAnswer(int answerId) {
        Answers answer = new Answers();
        String sql = "SELECT * FROM answers WHERE answer_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, answerId);
        while (results.next()){
            answer = mapRowToAnswers(results);
        }
        return answer;
    }
    @Override
    public void createAnswer(Answers answer) {
    String sql = "INSERT INTO answers (answer_id, answer, question_id) VALUES (?,?,?)";
    jdbcTemplate.update(sql, answer.getAnswerId(),answer.getAnswer(), answer.getQuestionId());
    }
        @Override
    public Answers updatedAnswer(Answers updatedAnswer) {
        //Answers answers = null;
        String sql = " UPDATE answers SET answer = ? WHERE answer_id = ?; ";
        int updated = jdbcTemplate.update(sql, updatedAnswer.getAnswer(), updatedAnswer.getAnswerId());
        return getAnswer(updated);
    }
        @Override
    public void deleteAnswer(int answerId) {
        String sql = "DELETE FROM answer WHERE answer_id = ?; ";
        jdbcTemplate.update(sql, answerId);

    }
    private Answers mapRowToAnswers(SqlRowSet rowSet){
        Answers answers = new Answers();
        answers.setAnswerId(rowSet.getInt("answer_id"));
        answers.setAnswer(rowSet.getString("answer"));
        answers.setQuestionId(rowSet.getInt("question_id"));
        return answers;
    }

}
