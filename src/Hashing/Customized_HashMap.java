package Hashing;

/**
 * Created by Shailendra on 3/11/2017.
 */
public class Customized_HashMap {
    public static void main(String args[])
    {
        CustomHashMap<String, Integer> hashMapCustom = new CustomHashMap<String, Integer>(16);
        hashMapCustom.put("abc", 12);
        hashMapCustom.put("abc", 100);
        hashMapCustom.put("nikki", 121);
        hashMapCustom.put("abc", 200);
        hashMapCustom.put("nikki", 122);
        hashMapCustom.put("abc", 150);
        hashMapCustom.put("nikki", 125);
        hashMapCustom.put("ritu",1234);
        hashMapCustom.put("shaile",59454);
        //hashMapCustom.display();

        //String key="nikki";
        //System.out.println("value corresponding to key "+key+" = "+ hashMapCustom.get("nikki"));
        System.out.println(hashMapCustom.get("nikki"));
        System.out.println(hashMapCustom.contains("shaile"));
        //System.out.println("\n\nvalue corresponding to key "+key+" removed = "+  hashMapCustom.remove("nikki"));
        hashMapCustom.display();
    }

}


class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next;

    Entry(K key,V value,Entry<K,V> next) {
        this.key=key;
        this.value=value;
    }
}

class CustomHashMap<K,V> {
    Entry<K,V>[] table;
    int capacity;

    CustomHashMap(int capacity) {
        this.capacity=capacity;
        table=new Entry[capacity];
    }

    int hash(K key) {
        int code=key.hashCode();
        int pos=code%capacity;
        return Math.abs(pos);
    }

    void put(K key,V value) {

        if(key==null){
            return;
        }
        Entry<K,V> entry= new Entry(key,value,null);
        int position=hash(key);
        if(table[position]==null) {
            table[position]=entry;
        }
        else{
            Entry<K,V> current=table[position];
            while(current!=null) {
                if(current.next==null) {
                    if(current.key==key) {// if key is same then override value and return
                        current.value=value;
                        return;
                    }
                }
                current=current.next;
            }
            current.next=entry;
        }
    }

    V get(K key) {
        V value=null;
        int position=hash(key);
        if(table[position]!=null) {
            Entry<K,V> current=table[position];
            while(current!=null && current.key!=key) {
                current=current.next;
            }
            if(current!=null)
                value=current.value;
        }
        return value;
    }

    void display()
    {
        for(int k=0;k<capacity;k++) {
            Entry<K, V> entry=table[k];
            if (entry == null)
                continue;

            while(entry!=null)
            {
                System.out.print(entry.key+" -> "+entry.value+"  ,");
                entry=entry.next;
            }
            System.out.println();
        }
    }
    boolean contains(K key) {
        if(key==null) {
            return false;
        }
        int position=hash(key);
        if(table[position]!=null) {
            Entry<K,V> current=table[position];
            while(current!=null) {
                if(current.key.equals(key))
                    return true;
                current=current.next;
            }
        }
        return false;
    }
}