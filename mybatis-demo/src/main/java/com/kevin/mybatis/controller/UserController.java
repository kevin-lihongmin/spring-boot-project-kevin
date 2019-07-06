package com.kevin.mybatis.controller;

import com.kevin.mybatis.dao.UserMapper;
import com.kevin.mybatis.entity.User;
import com.kevin.mybatis.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  用户控制器
 * @author kevin
 * @date 2019/7/6 22:27
 * @since 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getUser")
    public User getUser() {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(1);

        List<User> users = userMapper.selectByExample(example);
        if (users == null || users.isEmpty()) {
            return new User();
        }
        return users.get(0);
    }

}
