package me.danipro.tutorialclient.client.events;

public enum EventPriority {
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4);

    private final byte priority;

    EventPriority(byte priority) {
        this.priority = priority;
    }

    public byte getPriority() {
        return this.priority;
    }
}
