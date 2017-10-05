package com.javarush.task.task28.task2811;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/*Класс ReadWriteMap должен предоставлять корректный доступ к объекту Map из многих потоков, но в его реализации были допущены ошибки. Найди их и исправь.

P.S. Для корректной работы Map в многопоточной среде, желательно пользоваться стандартной реализацией,
например ConcurrentHashMap из пакета java.util.concurrent. Но иногда требуется работа с другим типом мапы,
например LinkedHashMap и тогда предложенное решение будет как никогда кстати.
ReentrantReadWriteLock*/

public class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock;
    private final Lock writeLock;

    public ReadWriteMap(Map<K, V> map) {
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
        this.map = map;
    }

    public V put(K key, V value) {
        try {
            writeLock.lock();
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key) {
        try {
            readLock.lock();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }
}
