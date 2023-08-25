package com.example.payment_project.service;

import com.example.payment_project.model.Card;
import com.example.payment_project.model.User;
import com.example.payment_project.repository.card.CardRepositoryImpl;
import com.example.payment_project.repository.user.UserRepositoryImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class CardServise {

    private  static    CardServise cardservice =new CardServise();

    private  CardRepositoryImpl cardRepository = CardRepositoryImpl.getInstance();


    public UUID saveCard(Card card) {
        if (card.getPassword().isEmpty() || card.getCard_number().isEmpty()) {
            throw new RuntimeException("Password or card-Number is empty");
        }
        Optional<Card> cardByCardName = cardRepository.find_By_Card_Number(card.getCard_number());
        if (cardByCardName.isPresent()) {
            throw new RuntimeException("This card %s already exist".formatted(card.getCard_number()));
        }
        card.setId(UUID.randomUUID());
//        card.setCreated_date(LocalDateTime.now());
//        card.setUpdate_date(LocalDateTime.now());
        try {
            int res = cardRepository.create(card);
            if (res == 1) {
                return card.getId();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("cardni saqlashda xatolik roy berdi");
        }
        return null;
    }

    public static CardServise getInstance() {
        return cardservice;
    }
}
