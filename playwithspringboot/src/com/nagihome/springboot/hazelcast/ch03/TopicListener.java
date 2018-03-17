package com.nagihome.springboot.hazelcast.ch03;

import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

public class TopicListener implements MessageListener<String> {

    @Override
    public void onMessage(Message<String> message) {
        System.out.println("Message Recevied: " + message.getMessageObject());
    }
}
