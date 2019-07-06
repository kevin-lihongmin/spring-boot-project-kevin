package com.kevin.jdbc.service;

import com.kevin.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  用户业务层
 * @author kevin
 * @date 2019/7/6 16:11
 * @since 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *   获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    public User getUser(Long id) {
        return jdbcTemplateImpl(id);
    }

    /**
     *  使用{@link DataSource} 实现方式
     * @param id 用户id
     * @return 用户信息
     */
    private User DataSourceImpl(Long id) {
        User user = new User();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    /**
     *  使用{@link JdbcTemplate} 实现方式
     *
     * @param id 用户id
     * @return 用户信息
     */
    private User jdbcTemplateImpl(Long id) {
        User user = new User();

        jdbcTemplate.query("select * from user where id = " + id, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
            }
        });
        return user;
    }
}
