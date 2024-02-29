package hashmap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

public class HashMapIMPL {

    private LinkedList<Entry>[] linkedLists = new LinkedList[5];

    public HashMapIMPL(){
    }


    public void put(Integer key, String value) {
        int hash = getHash(key);
        if(linkedLists[hash]==null){
            linkedLists[hash]=new LinkedList<>();
        }
        linkedLists[hash].stream().filter(entry -> key.equals(entry.getId())).findFirst().ifPresent(entry -> linkedLists[hash].remove(entry));
        linkedLists[hash].addLast(new Entry(key, value));
    }

    private static int getHash(Integer key) {
        int hash = key % 5;
        return hash;
    }

    public boolean remove(Integer key) {
        int hash = getHash(key);
        Optional<Entry> entryOptional = linkedLists[hash].stream().filter(entry -> key.equals(entry.getId())).findFirst();
        if (entryOptional.isPresent()) {
            linkedLists[hash].remove(entryOptional.get());
            return true;
        } else {
            return false;
        }
    }

    public boolean containsKey(Integer key) {
        int hash = getHash(key);
        Optional<Entry> entryOptional = linkedLists[hash].stream().filter(entry -> key.equals(entry.getId())).findFirst();
        if (entryOptional.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public void print(){
        Arrays.stream(linkedLists).filter(Objects::nonNull).forEach(entries -> {
            entries.forEach(System.out::println);
        });
    }

    public static void main(String[] args) {
        HashMapIMPL hashMapIMPL = new HashMapIMPL();
        hashMapIMPL.put(1,"mani");
        hashMapIMPL.put(2,"gopal");
        hashMapIMPL.put(3,"dhanesh");
        hashMapIMPL.put(1,"vj");
        hashMapIMPL.remove(3);
        System.out.println(hashMapIMPL.containsKey(2));
        hashMapIMPL.print();
    }
}
