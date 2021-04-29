package com.simran.services;

import java.util.Map;
import java.util.UUID;

public class Team implements ISubscriber
{
    private String id;
    private String name;
    private Map<String,Employee> employees;
    private IPublisher publisher;

    public Team(String name, Map<String, Employee> employees,IPublisher publisher) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.employees = employees;
        this.publisher = publisher;
        this.publisher.register(this);
    }

    @Override
    public void update(Post post) {

    }
}
