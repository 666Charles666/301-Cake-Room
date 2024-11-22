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
        return Math.abs(key.hashCode()) % hashTable.length;
    }

    // 辅助哈希函数
    public int hashFunction2(T key) {
        return 1 + (Math.abs(key.hashCode()) % (hashTable.length - 1));
    }

    public int add(T item) {
        int home = hashFunction(item);
        int i = home;
        int stepLong = hashFunction2(item);

        do {
            if (hashTable[i] == null) {
                hashTable[i] = item;
                System.out.println("add successfully!");
                return i;
            } else {
                i = (i + stepLong) % hashTable.length;
                System.out.println("have a crash,Probing location " + i + "...");
            }
        } while (i != home);
        System.out.println("add default");
        return -1;
    }
    public boolean delete(T item) {
        int home = hashFunction(item);
        int i = home;
        int stepLong = hashFunction2(item);

        do {
            if (hashTable[i] != null && hashTable[i].equals(item)) {
                hashTable[i] = null;
                System.out.println("delete successfully!");
                return true;
            }
            i = (i + stepLong) % hashTable.length;
        } while (i != home && hashTable[i] != null);
        System.out.println("delete fault");
        return false; // Item not found
    }
    public T get(int index) {
        if (index >= 0 && index < hashTable.length) {
            return (T) hashTable[index];
        }
        return null;
    }


//    public static void main(String[] args) {
//        HashTable<Integer> h = new HashTable<>(10); // Example with Integer type
//        int data;
//
//        do {
//            System.out.print("Enter value: ");
//            data = new java.util.Scanner(System.in).nextInt();
//            if (data != 0) {
//                int loc = h.add(data);
//                if (loc != -1) {
//                    System.out.println("Item " + data + " stored at location " + loc);
//                } else {
//                    System.out.println("Error. Cannot store " + data + ". Table is full.");
//                }
//            }
//        } while (data != 0);
//
//        h.displayHashTable();
//    }
}
