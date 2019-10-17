package com.demo.curd.shared.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

public class User {
    private int id;

    //使用groups属性来给分组命名，然后在需要的地方指定命令即可
    @NotBlank(groups=NAME.class)
    private String name;

    @Min(1)
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public interface NAME{}
}