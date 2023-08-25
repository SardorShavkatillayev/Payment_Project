package com.example.payment_project.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseModel {
    private String username;
    private String password;


    @Builder
    public User(UUID id, LocalDateTime created_date, LocalDateTime update_date, String username, String password) {
        super(id, created_date, update_date);
        this.username = username;
        this.password = password;
    }

    public User(ResultSet resultSet) throws SQLException {
        super((UUID) resultSet.getObject(1),
                resultSet.getTimestamp(4).toLocalDateTime(),
                resultSet.getTimestamp(5).toLocalDateTime());
        this.username = resultSet.getString(2);
        this.password = resultSet.getString(3);

    }
}
