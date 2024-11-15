package model;

import java.util.LinkedList;
import java.util.List;

public class HashTable<T> {
    private  Object[] hashTable;

    public HashTable(int size) {
        hashTable = new Object[size];
    }

    public void displayHashTable() {
        System.out.println("Hash Table (using Linear Probing)\n======================");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(i + ". " + hashTable[i]);
        }
    }

    public int hashFunction(T key) {
        return key.hashCode() % hashTable.length; // Use hashCode() for any type
    }

    public int add(T item) {
        int home = hashFunction(item);
        int loc = home;

        do {
            if (hashTable[loc] == null) { // Slot is free
                hashTable[loc] = item;
                return loc;
            } else { // Collision resolution
                loc = (loc + 1) % hashTable.length; // Probe ahead by 1 with wraparound
                System.out.println("Collision. Probing location " + loc + "...");
            }
        } while (loc != home); // While not returned to original home (i.e., hash table is full)

        return -1; // Hash table is full
    }

    public static void main(String[] args) {
        HashTable<Integer> h = new HashTable<>(10); // Example with Integer type
        int data;

        do {
            System.out.print("Enter value: ");
            data = new java.util.Scanner(System.in).nextInt();
            if (data != 0) {
                int loc = h.add(data);
                if (loc != -1) {
                    System.out.println("Item " + data + " stored at location " + loc);
                } else {
                    System.out.println("Error. Cannot store " + data + ". Table is full.");
                }
            }
        } while (data != 0);

        h.displayHashTable();
    }
}
