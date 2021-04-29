package com.simran.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Ceo implements IPublisher
{
    private String id;
    private String name;
    private Map<String,Team> teams;
    private List<ISubscriber> subscribers;
    private Post post;

    public Ceo(String name, Map<String, Team> teams)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.teams = teams;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void register(ISubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unregister(ISubscriber subscriber) {
       this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (ISubscriber subscriber: subscribers) {
            subscriber.update(this.post);
        }
    }

    public void createPost(String name,String description)
    {
        Post post = new Post(name,description);
        this.post = post;
        notifySubscribers();
    }
}
