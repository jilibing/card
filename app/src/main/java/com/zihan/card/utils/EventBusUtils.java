package com.zihan.card.utils;

import com.squareup.otto.Bus;

/**
 * Created by jilibing on 2016/6/22/0022.
 */
public class EventBusUtils {

    private static EventBusUtils instance;
    private Bus bus;

    private EventBusUtils(){
        bus = new Bus();
    }

    public static EventBusUtils getInstance() {
        if(instance == null) {
            synchronized (EventBusUtils.class) {
                if(instance == null) {
                    instance = new EventBusUtils();
                }
            }
        }

        return instance;
    }

    public void register(Object o) {
        bus.register(o);
    }

    public void unregister(Object o) {
        bus.unregister(o);
    }

    public void post(Object o) {
        bus.post(o);
    }
}
