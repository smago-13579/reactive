package com.example.demo.service;

import com.example.demo.annotation.InjectMap;
import com.example.demo.component.AbstractHandler;
import com.example.demo.component.OneHandler;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class DemoServiceThree {
    private final Map<String, AbstractHandler> handlerMap;

    public DemoServiceThree(@InjectMap({OneHandler.class})
                            Map<String, AbstractHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @PostConstruct
    void init() {
        System.out.println("DemoServiceThree: " + handlerMap);
    }

    public void handle(String type) {
        System.out.println("DemoServiceThree: handle method is running...");
        handlerMap.get(type).handle();
    }
}
