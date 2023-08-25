package com.example.payment_project.repository.card;

import com.example.payment_project.model.Card;
import com.example.payment_project.model.User;
import com.example.payment_project.repository.BaseRepository;

import java.util.Optional;

public interface CardRepository extends BaseRepository<Card> {


    Optional<Card> find_By_Card_Number(String card_number);






}
