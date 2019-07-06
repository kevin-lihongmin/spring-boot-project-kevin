package com.kevin.jdbc.entity;

/**
 *  数据库实体
 * @author kevin
 * @date 2019/7/6 16:05
 * @since 1.0.0
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
