package me.danipro.tutorialclient.client.events;

import me.danipro.tutorialclient.client.Client;

import java.lang.reflect.InvocationTargetException;

public abstract class Event {

    private boolean cancelled;

    public enum State {
        PRE("PRE", 0), POST("POST", 1);
        private State(String string, int number) {
        }
    }

    public Event call() {
        this.cancelled = false;
        Event.call(this);
        return this;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {

        this.cancelled = cancelled;
    }

    private static void call(Event event) {
        ArrayHelper<EventData> dataList = Client.getInstance().eventManager.get(event.getClass());
        if (dataList != null) {
            for (EventData data : dataList) {
                try {
                    data.target.invoke(data.source, event);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
