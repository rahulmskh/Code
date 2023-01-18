import java.util.*;
public class HashMapCode {
    static class HashMap<K,V>{ //generic
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n - node
        private  int N; //N - buckets
        private LinkedList<Node> buckets[]; // N = buckets.length

        public HashMap(){
            this.N = 5;
            this.buckets = new LinkedList[5];
            for (int i = 0; i < 5 ; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }
        private int searchInLinkedList(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size() ; i++) {
                if(ll.get(i).key == key){
                    return  i;
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            for (int i = 0; i < N*2 ; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i <oldBucket.length ; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size() ; j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInLinkedList(key,bi); //d = -1

            if(di == -1){ // key doesn't exists
                buckets[bi].add(new Node(key, value));
                n++;
            } else { // key exists
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lamda = (double) n/N;
            if(lamda > 2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLinkedList(key,bi); //d = -1

            if(di == -1){ // key doesn't exists
                return false;
            } else { // key exists
                return true;
            }
        }
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLinkedList(key,bi); //d = -1

            if(di == -1){ // key doesn't exists
                return null;
            } else { // key exists
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLinkedList(key,bi); //d = -1

            if(di == -1){ // key doesn't exists
                return null;
            } else { // key exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length ; i++) { //bi
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size() ; j++) { //di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n == 0;
        }
    }
    public static void main(String args[]){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("india",200);
        map.put("China",198);
        map.put("Russia",188);
        map.put("United State",180);

        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size() ; i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));

        }
      map.remove("Russia");
        System.out.println(map.get("Russia"));
    }
}
