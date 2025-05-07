package com.example.him.db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectorTest {

    @Test
    void getConnection() {
        boolean conn;
        try(Connection connection = DatabaseConnector.getConnection()){
            conn = true;
        }catch (SQLException e){
            conn = false;
        }

        //assert
        assertTrue(conn);
    }
}