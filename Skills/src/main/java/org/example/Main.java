package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<MThread> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            MThread mThread = new MThread("#" + i, lock);
            list.add(mThread);
        }
        list.forEach(MThread::start);
    }
}