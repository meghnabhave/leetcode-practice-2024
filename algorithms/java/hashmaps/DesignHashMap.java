
public class DesignHashMap {

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> mymap = new MyHashMap(3);
        mymap.put(1, 2);
        mymap.put(2, 2);
        mymap.put(3, 2);
        mymap.put(4, 2);
        mymap.remove(1);
        System.out.println(2);
    }
    
}

class MyHashMap<K, V> {

    MyEntry<K, V>[] values;
    int MAX_SIZE;

    // Constructor
    public MyHashMap() {
        MAX_SIZE = 100;
        values = new MyEntry[MAX_SIZE];
    }

    public MyHashMap(Integer size) {
        MAX_SIZE = size;
        values = new MyEntry[MAX_SIZE];
    }

    // Needed methods
    public void put(K key, V value) {
        if (values[key.hashCode()%MAX_SIZE] == null ){
            // no collisions
            values[key.hashCode()%MAX_SIZE] = new MyEntry(key, value);
        } else {
            // collision, we have to check if key already exists, if not add at end of list.
            MyEntry cur = values[key.hashCode()%MAX_SIZE];
            MyEntry prev = null;
            while (cur != null && cur.key != key) {
                prev = cur;
                cur = cur.next;
            }

            if (cur == null) {
                // key does not exist, add to end of list
                prev.next = new MyEntry(key, value);
            } else {
                // key exists, change the value
                prev.value = value;
            }
        }
    }

    public V get(K key) {
        V retVal = null;
        if (values[key.hashCode()%MAX_SIZE] != null ){
            // value might be present, check through list
            MyEntry cur = values[key.hashCode()%MAX_SIZE];
            while (cur != null && cur.key != key) {
                cur = cur.next;
            }

            if (cur != null) {
                // key exists, change the value
                retVal = (V)cur.value;
            }
        }
        return retVal;
    }

    public void remove(K key) {
        if (values[key.hashCode()%MAX_SIZE] != null ) {
            // key MIGHT exist, we have to check
            MyEntry cur = values[key.hashCode()%MAX_SIZE];
            MyEntry prev = null;
            while (cur != null && cur.key != key) {
                prev = cur;
                cur = cur.next;
            }

            if (cur != null) {
                // key exists, remove the entry
                if (prev == null) {
                    // slot is null
                    values[key.hashCode()%MAX_SIZE] = null;
                } else {
                    prev.next = cur.next;
                }
            }
        }
    }
}

class MyEntry<K, V> {
    K key;
    V value;
    MyEntry<K, V> next;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}