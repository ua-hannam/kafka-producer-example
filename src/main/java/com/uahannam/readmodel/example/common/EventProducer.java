package com.uahannam.readmodel.example.common;

import org.springframework.context.ApplicationEventPublisher;

public class EventProducer {

    private static ApplicationEventPublisher eventPublisher;

    public static void publishEvent(Object eventObject) {
        eventPublisher.publishEvent(eventObject);
    }

    public static void setEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        eventPublisher = applicationEventPublisher;
    }

}
