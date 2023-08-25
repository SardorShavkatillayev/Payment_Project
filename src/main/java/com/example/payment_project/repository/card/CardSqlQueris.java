package com.example.payment_project.repository.card;

public interface CardSqlQueris {

    String CREATE = """
            insert into card (id,password,card_number,balance,user_id)
            values(?,?,?,?,?);
            """;
    String FIND_BY_CARD_NUMBER = "select * from card where card_number = ?;";

    String GET_ALL = "select * from card";


}
