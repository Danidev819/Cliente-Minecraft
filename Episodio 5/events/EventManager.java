package me.danipro.tutorialclient.client.events;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class EventManager {

    private Map<Class<?>, ArrayHelper<EventData>> REGISTRY_MAP = new HashMap<Class<?>, ArrayHelper<EventData>>();

    public void register(Object o) {

        for (Method method : o.getClass().getDeclaredMethods()) {
            if (!isMethodBad(method)) {
                register(method, o);
            }
        }
    }

    public void register(Object o, Class<? extends Event> clazz) {
        for (Method method : o.getClass().getDeclaredMethods()) {
            if (!isMethodBad(method, clazz)) {
                register(method, o);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void register(Method method, Object o) {
        Class<?> clazz = method.getParameterTypes()[0];
        final EventData methodData = new EventData(o, method, method.getAnnotation(EventTarget.class).value());

        if (!methodData.target.isAccessible()) {
            methodData.target.setAccessible(true);
        }

        if (REGISTRY_MAP.containsKey(clazz)) {
            if (!REGISTRY_MAP.get(clazz).contains(methodData)) {
                REGISTRY_MAP.get(clazz).add(methodData);
                sortListValue((Class<? extends Event>) clazz);
            }
        } else {
            REGISTRY_MAP.put((Class<? extends Event>) clazz, new ArrayHelper<EventData>() {
                {
                    this.add(methodData);
                }
            });
        }
    }

    public void unregister(final Object o) {

        for (ArrayHelper<EventData> flexibalArray : REGISTRY_MAP.values()) {
            for (EventData methodData : flexibalArray) {
                if (methodData.source.equals(o)) {
                    flexibalArray.remove(methodData);
                }
            }
        }

        cleanMap(true);
    }

    public void unregister(final Object o, final Class<? extends Event> clazz) {
        if (REGISTRY_MAP.containsKey(clazz)) {
            for (final EventData methodData : REGISTRY_MAP.get(clazz)) {
                if (methodData.source.equals(o)) {
                    REGISTRY_MAP.get(clazz).remove(methodData);
                }
            }

            cleanMap(true);
        }
    }

    public void cleanMap(boolean b) {

        Iterator<Entry<Class<?>, ArrayHelper<EventData>>> iterator = REGISTRY_MAP.entrySet().iterator();

        while (iterator.hasNext()) {
            if (!b || iterator.next().getValue().isEmpty()) {
                iterator.remove();
            }
        }
    }

    public void removeEnty(Class<? extends Event> clazz) {

        Iterator<Entry<Class<?>, ArrayHelper<EventData>>> iterator = REGISTRY_MAP.entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(clazz)) {
                iterator.remove();
                break;
            }
        }
    }

    private void sortListValue(Class<? extends Event> clazz) {

        ArrayHelper<EventData> flexibleArray = new ArrayHelper<EventData>();

        for (byte b : EventPriority.VALUE_ARRAY) {
            for (EventData methodData : REGISTRY_MAP.get(clazz)) {
                if (methodData.priority == b) {
                    flexibleArray.add(methodData);
                }
            }
        }

        REGISTRY_MAP.put(clazz, flexibleArray);
    }

    private boolean isMethodBad(final Method method) {

        return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventTarget.class);
    }

    private boolean isMethodBad(Method method, Class<? extends Event> clazz) {
        return isMethodBad(method) || method.getParameterTypes()[0].equals(clazz);
    }

    public ArrayHelper<EventData> get(final Class<? extends Event> clazz) {
        return REGISTRY_MAP.get(clazz);
    }

    public void shutdown() {
        REGISTRY_MAP.clear();
    }

}
