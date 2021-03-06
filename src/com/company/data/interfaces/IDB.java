package com.company.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
