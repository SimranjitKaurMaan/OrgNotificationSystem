package com.simran.services;

import java.util.UUID;

public class Post
{
    private String id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Post(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }
}
