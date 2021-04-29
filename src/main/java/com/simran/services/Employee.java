package com.simran.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Employee implements ISubscriber, IPublisher
{
    private String id;
    private String name;
    private Boolean onLeave;
    private IPublisher publisher;
    private Post post;
    private List<ISubscriber> subscribers;

    public Employee(String name,IPublisher publisher)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.onLeave = false;
        this.publisher = publisher;
        this.publisher.register(this);
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void update(Post post)
    {
        this.post = post;
        printPost();
    }

    private void printPost()
    {
        System.out.println("New post: " + post);
    }

    @Override
    public void register(ISubscriber subscriber)
    {
       this.subscribers.add(subscriber);
    }

    @Override
    public void unregister(ISubscriber subscriber)
    {
       this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers()
    {
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
