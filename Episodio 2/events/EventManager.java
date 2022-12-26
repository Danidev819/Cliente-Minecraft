package me.danipro.tutorialclient.client.events;

import java.lang.reflect.Method;
import java.util.*;

public class EventManager {

    private static final Map<Class<? extends Event>, ArrayList<EventData>> REGISTRY_MAP = new HashMap<>();

    private static void sortListValue(final Class<? extends Event> clazz) {
        final ArrayList<EventData> events = new ArrayList<>();

        for (EventPriority priority : EventPriority.values()) {
            for (EventData eventData : EventManager.REGISTRY_MAP.get(clazz)) {

                if (eventData.priority == priority) {
                    events.add(eventData);
                }
            }
        }
        REGISTRY_MAP.put(clazz, events);
    }

    private static boolean isEventMethod(Method method) {
        return method.getParameterTypes().length == 1 && method.isAnnotationPresent(EventTarget.class);
    }

    private static boolean isEventMethod(Method method, Class<? extends Event> clazz) {
        return isEventMethod(method) || !method.getParameterTypes()[0].equals(clazz);
    }

    public static ArrayList<EventData> get(Class<? extends Event> clazz) {
        return REGISTRY_MAP.get(clazz);
    }

    public static void cleanMap(boolean removeOnlyEmptyValues) {
        final Iterator<Map.Entry<Class<? extends Event>, ArrayList<EventData>>> iterator = REGISTRY_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            
            if (!removeOnlyEmptyValues || iterator.next().getValue().isEmpty()) {
                iterator.remove(); 
            }
        }
    }

    public static void unregister(Object object, Class<? extends Event> clazz) {
        if (REGISTRY_MAP.containsKey(clazz)) {
            REGISTRY_MAP.get(clazz).removeIf(eventData -> eventData.source.equals(object));
        }

        cleanMap(true);
    }

    public static void unregister(Object object) {
        for (ArrayList<EventData> events : REGISTRY_MAP.values()) {
            for (int i = events.size(); i >= 0; i--) {
                if (events.get(i).source.equals(object)) {
                    events.remove(i);
                }
            }
        }

        cleanMap(true);
    }

    public static void register(Method method, Object object) {
        final Class<?> clazz = method.getParameterTypes()[0]; 
        final EventData eventData = new EventData(object, method, method.getAnnotation(EventTarget.class).value()); 

        if (eventData.target.isAccessible()) {
            eventData.target.setAccessible(true);
        }


        if (REGISTRY_MAP.containsKey(clazz)) {

            if (!REGISTRY_MAP.get(clazz).contains(eventData)) {
                REGISTRY_MAP.get(clazz).add(eventData);
                sortListValue((Class<? extends Event>) clazz);
            }
        }

        else {
            REGISTRY_MAP.put((Class<? extends Event>) clazz, new ArrayList<EventData>() {{
                add(eventData);
            }});
        }
    }

    public static void register(Object object, Class<? extends Event> clazz) {
        for (Method method : object.getClass().getMethods()) {

            if (isEventMethod(method, clazz)) {
                register(method, object); 
            }
        }
    }

    public static void register(Object object) {
        for (Method method : object.getClass().getMethods()) {

            if (isEventMethod(method)) {
                register(method, object); 
            }
        }
    }

    public static void register(Object... objects) {
        Arrays.asList(objects).forEach(EventManager::register);
    }

}
