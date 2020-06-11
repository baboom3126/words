package com.patrickeng.words.app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "UserSimple")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "UserId", length = 32)
    private String userId;
    private int number;
    private String name;

    @Override
    public String toString() {
        return String.format("Person[userId=%s, name='%s']", userId, name);
    }

    public String getUserId() {
        return userId;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

}
