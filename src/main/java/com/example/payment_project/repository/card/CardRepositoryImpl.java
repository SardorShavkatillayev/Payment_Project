package com.example.payment_project.repository.card;

import com.example.payment_project.connection.ConnectioConfig;
import com.example.payment_project.model.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CardRepositoryImpl implements CardRepository {

    private static  CardRepositoryImpl cardRepository = new CardRepositoryImpl();
    Connection connection = ConnectioConfig.getconnection();

    @Override
    public int create(Card card) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CardSqlQueris.CREATE);
            preparedStatement.setObject(1, card.getId());
            preparedStatement.setString(2, card.getPassword());
            preparedStatement.setString(3, card.getCard_number());
            preparedStatement.setDouble(4, card.getBalance());
            preparedStatement.setObject(5, card.getUser_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("PrepareStatementda xatolik yuz berdi cardda");
        }

    }



    @Override
    public Card getById(UUID id) throws SQLException {
        return null;
    }

    @Override
    public List<Card> getAll() {
        List<Card> cards = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CardSqlQueris.GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cards.add(new Card(resultSet));
            }

            return cards;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("GetCardda xatolik");
        }
    }

    @Override
    public List<Card> deleteById(UUID id) {
        return null;
    }


    public static CardRepositoryImpl getInstance() {
        return cardRepository;
    }

    @Override
    public Optional<Card> find_By_Card_Number(String card_number) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CardSqlQueris.FIND_BY_CARD_NUMBER);
            preparedStatement.setString(1, card_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Card(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("card_number bilan topishda muammo roy berdi ");
        }
        return Optional.empty();
    }
}
