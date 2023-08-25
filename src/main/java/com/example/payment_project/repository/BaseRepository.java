package com.example.payment_project.repository;

import com.example.payment_project.model.BaseModel;
import com.example.payment_project.model.Card;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface BaseRepository<T extends BaseModel> {

    int create(T model);
    T getById(UUID id) throws SQLException;
    List<T> getAll();
    List<Card> deleteById(UUID id);

}
