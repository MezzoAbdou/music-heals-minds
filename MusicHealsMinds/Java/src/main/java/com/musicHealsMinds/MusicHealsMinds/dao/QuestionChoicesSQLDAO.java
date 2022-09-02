package com.musicHealsMinds.MusicHealsMinds.dao;

import com.musicHealsMinds.MusicHealsMinds.model.QuestionChoices;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionChoicesSQLDAO implements QuestionChoicesDAO {
    private JdbcTemplate jdbcTemplate;
    public QuestionChoicesSQLDAO(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<QuestionChoices> getAllChoices() {
        List<QuestionChoices> choices = new ArrayList<>();
        String sql = "SELECT * FROM choices;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            choices.add(mapRowToAnswers(results));
        }
        return choices;

    }
    @Override
    public QuestionChoices getChoice (int choiceId){
        QuestionChoices choice = new QuestionChoices();
        String sql = "SELECT * choices WHERE choice_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, choiceId);
        if (results.next()){
            choice = mapRowToAnswers(results);
        }
        return choice;
    }
    @Override
    public void createChoice(QuestionChoices choice){
        String sql = "INSERT INTO choices (choice_1, choice_1, choice_3, choice_id, question_id)" +
                "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, choice.getChoice1(), choice.getChoice2(), choice.getChoice3(), choice.getChoiceId(), choice.getQuestionId() );
    }
    @Override
    public QuestionChoices updatedChoice(){
        String sql = "UPDATE choices SET choice = ? WHERE choice_id = ?;"; //this right? I THINK YOU NEED A JOINS
        int updateChoice = jdbcTemplate.update(sql, updatedChoice().getChoice1(), updatedChoice().getChoiceId() );
        return getChoice(updateChoice);
    }
    @Override
    public void deleteChoice(){
        String sql = "DELETE FROM choices WHERE choice_id = ?;";
        jdbcTemplate.update(sql);
    }


    private QuestionChoices mapRowToAnswers (SqlRowSet rowSet){
        QuestionChoices questionChoices = new QuestionChoices();
        questionChoices.setChoice1(rowSet.getString("choice_1"));
        questionChoices.setChoice2(rowSet.getString("choice_2"));
        questionChoices.setChoice3(rowSet.getString("choice_3"));
        questionChoices.setChoiceId(rowSet.getInt("choice_id"));
        questionChoices.setQuestionId(rowSet.getInt("question_id"));
        return questionChoices;
    }
    }
