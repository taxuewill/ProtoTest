package com.segway.prototest.entry;

import java.io.Serializable;

/**
 * Created by will on 19-2-19.
 */

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int id;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
