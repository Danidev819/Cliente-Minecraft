package me.danipro.tutorialclient.client.events;

public class EventCancelable extends Event {

    private boolean cancelled = false;

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

}
