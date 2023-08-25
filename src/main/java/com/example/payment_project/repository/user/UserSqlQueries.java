package com.example.payment_project.repository.user;

public interface UserSqlQueries {
    String CREATE = """
            insert into my_user (id,username,password,created_date,update_date)
            values(?,?,?,?,?);
            """;
    String FIND_BY_ID = "select * from my_user where id = ?;";

    String GET_ALL = "select * from my_user";
    String UPDATE = "update my_user set ? = ? where ?=?; ";
    String FIND_BY_USERNAME = "select * from my_user where username = ?;";
}
