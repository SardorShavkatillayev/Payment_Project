package com.example.payment_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectioConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/payment";

    private static final String PASSWORD = "sardor2003";
    private static final String USERNAME = "postgres";

    public static Connection getconnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Coonectionda muammo roy berdi yoki Driver classni topa olmadi(ConnectionConfig)");
        }

    }

}
/*
create table card
(
id
    password    varchar(4),
    card_number varchar(16) unique ,
    balance     double precision default 100000000,
    user_id     uuid references my_user(id)
);

*/