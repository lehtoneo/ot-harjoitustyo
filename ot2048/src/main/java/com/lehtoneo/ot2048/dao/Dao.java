/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.dao;

import com.lehtoneo.ot2048.domain.User;
import java.sql.*;
import java.util.*;

public interface Dao {
    void create(User user) throws SQLException;
    User read(String username) throws SQLException;
    List<User> list() throws SQLException;
}
