package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HashTable<E> {
    private final List<E>[] hashTable;

    public HashTable(int size){
        hashTable=new List[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public int hushFunction(int key){
        return Math.abs(key%hashTable.length);
    }

    public int add(E item){
        int key = item.hashCode();
        int index = hushFunction(key);
        hashTable[index].add(item);
        return index;
    }
    public void displayHashTable(){
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print("Slot " + i + ": ");
            for (E item : hashTable[i]) {
                System.out.print(item + " -> ");
            }
            System.out.println("null");
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        HashTable<String> myHashSC = new HashTable<>(10);
//        System.out.println("please enter");
//        while (true) {
//            String data = scanner.nextLine();
//            if (data.isEmpty()) {
//                break;
//            }
//            int index = myHashSC.add(data);
//            System.out.println("Inserted '" + data + "' at slot: " + index);
//        }
//
//        System.out.println("Final hash table:");
//        myHashSC.displayHashTable();
//    }
}
