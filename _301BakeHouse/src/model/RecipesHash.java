package model;
public class RecipesHash {
    private static class Object {
        String key;
        String value;
        boolean isDeleted;

        public Object(String key, String value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    private Object[] table;
    private int size;

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

    public void display() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null && !table[i].isDeleted) {
                System.out.println("Index " + i + ": " + table[i].key + " -> " + table[i].value);
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}
