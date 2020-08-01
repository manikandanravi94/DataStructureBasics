package com.mani.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by gbs05347 on 26-07-2020.
 */
public class HashMapImpl {

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(Integer key, String value){
        int index=hashing(key);
        LinkedList<Entry> bucket = entries[index];
        if(bucket==null){
            entries[index]= new LinkedList();
        }else{
        for(Entry entry: bucket){
                if(entry.getKey()==key){
                    entry.setValue(value);
                    return;
                }}}
        entries[index].addLast(new Entry(key,value));
    }

    public String get(int key){
        String value=null;
        int index= hashing(key);
        List<Entry> bucket = entries[index];
        if(bucket!=null){
            for(Entry entry: bucket){
                if(entry.getKey()==key){
                    value=entry.getValue();
                }}
        }
        return value;
    }

    private void remove(int key){
        int index= hashing(key);
        List<Entry> bucket = entries[index];
        if(bucket!=null){
            for(Entry entry: bucket)
                if(entry.getKey()==key){
            entries[index].remove(entry);}
        }

    }

    private int hashing(int key){
        return key% entries.length;
    }


    /**  return in multiple lines and used linked hashmap
    public static void firstNonRepeatCharacter(String s){
        char[] charArray = s.toCharArray();
        Map<Character,Integer> charCountMap= new LinkedHashMap<>();
        for(int i=0;i<charArray.length;i++){
            if(charCountMap.containsKey(charArray[i])){
                int count=charCountMap.get(charArray[i]);
                charCountMap.put(charArray[i],++count);
            }else{
                int count=1;
                charCountMap.put(charArray[i],count);
            }
        }
        for(Map.Entry<Character, Integer> m: charCountMap.entrySet()){
            if(m.getValue()==1){
                System.out.println("first non repeated character: "+m.getKey());
                break;
            }
        }
    }*/

    public static void firstNonRepeatCharacter(String s){
        char[] charArray = s.toCharArray();
        Map<Character,Integer> charCountMap= new HashMap<>();
        for(int i=0;i<charArray.length;i++){
            int count =charCountMap.get(charArray[i])!=null?charCountMap.get(charArray[i]):0;
            charCountMap.put(charArray[i],++count);
        }
        for(int i=0;i<charArray.length;i++){
            if(charCountMap.get(charArray[i])==1){
                System.out.println(charArray[i]);
            break;}
        }
    }

    public static void main(String[] args) {
        HashMapImpl.firstNonRepeatCharacter("a green apple");
        HashMapImpl hashMap = new HashMapImpl();
        hashMap.put(1,"mani");
        hashMap.put(2,"anbu");
        hashMap.put(3,"madav");
        hashMap.put(1,"manikandan");
        hashMap.remove(11);
        System.out.println(hashMap.get(1));

    }
}
