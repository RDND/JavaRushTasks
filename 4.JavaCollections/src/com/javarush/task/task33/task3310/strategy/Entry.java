package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;


public class Entry implements Serializable
{
    final Long key;
    String value;
    Entry next;
    final int hash;
    public Entry(int hash, Long key, String value, Entry next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
        return value != null ? value.equals(entry.value) : entry.value == null;
    }

    public final Long getKey()
    {
        return key;
    }
    public final String getValue()
    {
        return value;
    }
    @Override
    public int hashCode()
    {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }
    @Override
    public String toString()
    {
        return getKey() + "=" + getValue();
    }
}