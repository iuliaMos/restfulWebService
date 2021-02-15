package com.example;

public class Greeting {

    private Integer id;
    private String content;

    public Greeting(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
