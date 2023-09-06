package org.example;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class MThread extends Thread {
//    private ReentrantLock lock;
    private ReentrantReadWriteLock lock;
    private ReadLock readLock;
    private WriteLock writeLock;
    private String name;

    public MThread(String name, ReentrantReadWriteLock lock) {
        this.name = name;
        this.lock = lock;
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    @Override
    public void run() {
        write();
        read();
    }

    void read() {
        readLock.lock();
        try {
            System.out.println("Read start name: " + name);
            Thread.sleep(1000);
            System.out.println("Read end name: " + name);
        } catch (Exception e) {
        } finally {
            readLock.unlock();
        }

    }

    void write() {
        try {
            writeLock.lock();
            System.out.println("Write start name: " + name);
            Thread.sleep(1000);
            System.out.println("Write end name: " + name);
        } catch (Exception e) {
        } finally {
            writeLock.unlock();
        }
    }
}
