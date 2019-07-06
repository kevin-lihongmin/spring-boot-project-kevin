package com.kevin.jdbc.controller;

import com.kevin.jdbc.entity.User;
import com.kevin.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  数据库实体{@link User} 控制层
 * @author kevin
 * @date 2019/7/6 16:05
 * @since 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *  获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {

        return userService.getUser(id);
    }

}
