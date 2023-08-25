package com.example.payment_project.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Card extends BaseModel {

    private String password;
    private String card_number;
    private Double balance;
    private UUID user_id;

    {
        this.balance = 10000000.0;
    }

    @Builder
    public Card(UUID id, LocalDateTime created_date, LocalDateTime update_date, String password, String card_number, Double balance, UUID user_id) {
        super(id, created_date, update_date);
        this.password = password;
        this.card_number = card_number;
        this.balance = balance;
        this.user_id = user_id;
    }

    public Card(ResultSet resultSet) {
        try {
            setId((UUID) resultSet.getObject(1));
            this.password = resultSet.getString(2);
            this.card_number = resultSet.getString(3);
            this.balance = resultSet.getDouble(4);
            this.user_id = (UUID) resultSet.getObject(5);
            setCreated_date(resultSet.getTimestamp(6).toLocalDateTime());
            setUpdate_date(resultSet.getTimestamp(7).toLocalDateTime());
        } catch (SQLException e) {
            throw new RuntimeException("card resultsetda hatolik");
        }
    }

    public Card(String password, String card_number, UUID user_id) {
        this.password = password;
        this.card_number = card_number;
        this.user_id = user_id;
    }

}
