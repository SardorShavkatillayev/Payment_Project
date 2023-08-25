package com.example.payment_project.repository.user;

import com.example.payment_project.connection.ConnectioConfig;
import com.example.payment_project.model.Card;
import com.example.payment_project.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    private static  UserRepositoryImpl userRepository = new UserRepositoryImpl();

    Connection connection = ConnectioConfig.getconnection();

    private UserRepositoryImpl() {
    }


    @Override
    public int create(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueries.CREATE);
            preparedStatement.setObject(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(user.getCreated_date()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(user.getUpdate_date()));
            preparedStatement.executeUpdate();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("PrepareStatementda xatolik yuz berdi");
        }
    }

    @Override
    public User getById(UUID id) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UserSqlQueries.FIND_BY_ID);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return new User(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueries.GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet));
            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("GetUsersda xatolik");
        }

    }

    @Override
    public List<Card> deleteById(UUID id) {
        return null;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueries.FIND_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Username bilan topishda muammo roy berdi ");
        }
        return Optional.empty();
    }

    public static UserRepositoryImpl getInstance() {

        return userRepository;
    }


}


