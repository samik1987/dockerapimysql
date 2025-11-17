package com.example.dockerapimysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Message {

    public Message() {
    }

    public Message(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Id
    public int id;
    public String msg;
}
