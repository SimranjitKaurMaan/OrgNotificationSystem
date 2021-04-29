package com.simran.services;

public interface IPublisher
{
    void register(ISubscriber subscriber);
    void unregister(ISubscriber subscriber);
    void notifySubscribers();
}
