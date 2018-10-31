package com.codeup.springblog;

public class Post {
    private String title;
    private String body;
    private int id;



    public Post(int id, String title, String body) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
