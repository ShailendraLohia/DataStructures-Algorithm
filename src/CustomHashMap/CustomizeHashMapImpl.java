package CustomHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

// https://github.com/sarahkaylor/os-spring-2019/blob/master/java/com/os/structures/map/MapImpl.java

public class CustomizeHashMapImpl {
    public static void main(String[] args) {
        CustomizeHashMap hashMapCustom = new CustomizeHashMap(1000);
        hashMapCustom.put("abc", 12);
        //hashMapCustom.put("abc", 100);
        hashMapCustom.put("def", 121);

        System.out.println("Get: " + hashMapCustom.get("abc"));
        System.out.println("HashMapSize: " + hashMapCustom.size());
        System.out.println("Remove: " + hashMapCustom.remove("abc"));
        System.out.println("Get: " + hashMapCustom.get("abc"));

    }
}

    class Entry<Key,Value> {
        Key key;
        Value value;

        Entry(Key key, Value value) {
            this.key=key;
            this.value=value;
        }
    }
     class CustomizeHashMap<Key,Value> {
        private ArrayList<Entry<Key,Value>>[] entries;
        int capacity;
        int size;

        CustomizeHashMap(int capacity) {
            this.capacity=capacity;
            entries=createArray(capacity);
            this.size=0;
        }

         // this is separated into a function to deal with the Java compiler warning about
         // creating arrays of generic types.
        private ArrayList<Entry<Key,Value>>[] createArray(int size) {
            @SuppressWarnings("unchecked")
            ArrayList<Entry<Key, Value>>[] array =
                    (ArrayList<Entry<Key,Value>>[])new ArrayList<?>[size];
            return array;
        }

        private int findIndexEntries(Key key) {
            int hash=key.hashCode();
            int index = hash%capacity;
            return index;
        }

        private int findListIndex(List<Entry<Key,Value>> list, Key key) {
            ListIterator<Entry<Key,Value>> iterator = list.listIterator();
            while(iterator.hasNext()) {
                Entry<Key,Value> entry = iterator.next();
                if(entry.key==key) {
                    return iterator.previousIndex();
                }
            }
            return -1;
        }

        public int size() {
            return size;
        }

        public void put(Key key, Value value) {
            int index=findIndexEntries(key);
            if(entries[index]==null) {
                entries[index]= new ArrayList<>();
            }

            int foundIndex=findListIndex(entries[index],key);
            if(foundIndex >= 0) {
                entries[index].remove(foundIndex);
            }
            else {
                ++size;
            }

            entries[index].add(new Entry<Key,Value>(key,value));

        }

        public Optional<Value> get(Key key) {
            int index= findIndexEntries(key);
            if(entries[index]==null) {
                return Optional.empty();
            }
            int foundIndex = findListIndex(entries[index],key);

            if(foundIndex<0)
                return Optional.empty();

            return Optional.of(entries[index].get(foundIndex).value);
        }

        public boolean remove(Key key) {
            int index = findIndexEntries(key);
            if(entries[index] == null) {
                return false;
            }
            int foundIndex = findListIndex(entries[index], key);
            if(foundIndex < 0) {
                return false;
            }
            entries[index].remove(foundIndex);
            --size;
            return true;
        }

    }



