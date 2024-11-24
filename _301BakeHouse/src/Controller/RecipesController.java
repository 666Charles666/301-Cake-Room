package model;

import java.io.Serializable;

public class RecipesHash implements Serializable {
    public static class Object implements Serializable{
        public String key;
        public String value;
        public boolean isDeleted;

        public Object(String key, String value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    public Object[] table;
    public int size;

    public RecipesHash(int size) {
        this.size = size;
        this.table = new Object[size];
    }

    // 主哈希函数
    private int hashFunction1(String key) {
        return Math.abs(key.hashCode()) % size;
    }


    private int hashFunction2(String key) {
        return 1 + (Math.abs(key.hashCode()) % (size - 1));
    }


    public void add(String key, String value) {
        int index = hashFunction1(key);
        int step = hashFunction2(key);
        int i = 0;


        while (table[index] != null && !table[index].isDeleted && !table[index].key.equals(key)) {
            i++;
            index = (hashFunction1(key) + i * step) % size;
        }


        table[index] = new Object(key, value);
    }


    public String get(String key) {
        int index = hashFunction1(key);
        int step = hashFunction2(key);
        int i = 0;


        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                return table[index].value;
            }
            i++;
            index = (hashFunction1(key) + i * step) % size;
        }

        return null;
    }


    public void delete(String key) {
        int index = hashFunction1(key);
        int step = hashFunction2(key);
        int i = 0;

        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                table[index].isDeleted = true;
                return;
            }
            i++;
            index = (hashFunction1(key) + i * step) % size;
        }
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (table[i] != null && !table[i].isDeleted) {
                stringBuilder.append("Index " + i + ": " + table[i].key + " -> " + table[i].value + "\n");
            } else {
                stringBuilder.append("Index " + i + ": null\n");
            }
        }
        return stringBuilder.toString();
    }

}
