package com.mani.hashtable;

/**
 * Created by gbs05347 on 26-07-2020.
 */

public class Entry {

    private Integer key;

    public Entry(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    private String value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
