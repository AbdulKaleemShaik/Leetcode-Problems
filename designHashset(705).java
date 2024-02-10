import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    int size;
    List<List<Integer>> buck;

    public MyHashSet() {
        size = 1000;
        buck = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buck.add(new LinkedList<>());
        }
    }

    public int hash(int id) {
        return id % size;
    }

    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = buck.get(index);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }

    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = buck.get(index);
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> bucket = buck.get(index);
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */