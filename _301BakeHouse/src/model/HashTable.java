package model;

import java.util.LinkedList;
import java.util.List;

public class HashTable<T> {
    private final Object[] hashTable;

    public HashTable(int size) {
        hashTable = new Object[size];
    }

    public void displayHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null){
                System.out.println(i + ":" + hashTable[i]);
            }else {
                System.out.println(i + ":" + hashTable[i].toString());
            }
        }
    }

    public int hashFunction(T key) {
        return key.hashCode() % hashTable.length;
    }

    public int add(T item) {
        int home = hashFunction(item);
        int i = home;

        do {
            if (hashTable[i] == null) {
                hashTable[i] = item;
                System.out.println("add successful");
                return i;
            } else {
                i = (i + 1) % hashTable.length;
                System.out.println("Collision. Probing location " + i + "...");
            }
        } while (i != home);

        return -1;
    }
    public boolean delete(T item) {
        int home = hashFunction(item);
        int i = home;

        do {
            if (hashTable[i] != null && hashTable[i].equals(item)) {
                hashTable[i] = null;
                System.out.println("delete successfully");
                return true;
            }
            i = (i + 1) % hashTable.length;
        } while (i != home && hashTable[i] != null);
        System.out.println("delete fault");
        return false; // Item not found
    }
}
