import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl {
    static class HashMap<K,V> //generics OR parameterize types
    {
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n; // n:Total number of nodes
        private int N; // N:Total number of buckets

        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        private int hashfunction(K key){
            int bi=Math.abs(key.hashCode()); //positive hashcode
            return bi%N; //bucket index 0 to N-1
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll=buckets[bi];
            int di=0; //data index
            while(di<ll.size()){
                if(ll.get(di).key==key)
                {
                    return di;
                }
            }
             return -1; //data index doesn't exists
        }

        private void rehash(){
            LinkedList<Node> oldBuckets[]=buckets;
            buckets=new LinkedList[N*2];
            for(int i=0;i< buckets.length;i++){
                    buckets[i]=new LinkedList<>();
            }
            for( int i=0;i< oldBuckets.length;i++){
                LinkedList<Node> ll=oldBuckets[i];
                for(int j=0;j<ll.size();j++){
                Node node=ll.get(j);
                put(node.key,node.value);
                }
            }
        }

        public V get (K key){
            int bi=hashfunction(key); //bucket index
            int di=searchInLL(key,bi); //data index in LL

            if(di==-1) //Key doesn't exists
            {
                return null;
            }
            else //key exists
            {
                Node data=buckets[bi].get(di);
                return data.value;
            }
        }

        public boolean containsKey(K key){
            int bi=hashfunction(key); //bucket index
            int di=searchInLL(key,bi); //data index in LL

            if(di==-1) //Key doesn't exists
            {
             return false;
            }
            else //key exists
            {
                return true;
            }
        }

        public V remove(K key){
            int bi=hashfunction(key); //bucket index
            int di=searchInLL(key,bi); //data index in LL

            if(di==-1) //Key doesn't exists
            {
                return null;
            }
            else //key exists
            {
                Node data=buckets[bi].remove(di);
                n--;
                return data.value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for (int bi=0;bi< buckets.length;bi++){
                LinkedList<Node> ll=buckets[bi];
                for(int di=0;di<ll.size();di++){
                    Node node=ll.get(di);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty (K key){
            return n==0;
        }


        public void put(K key, V value){
                int bi=hashfunction(key); //bucket index
                int di=searchInLL(key,bi); //data index in LL

                if(di==-1) //Key doesn't exists
                {
                    buckets[bi].add(new Node(key,value));
                    n++;
                }
                else //key exists
                {
                Node data=buckets[bi].get(di);
                data.value=value; //update value
                }

                double lambda=n/N;
                if(lambda>2.0) //rehashing
                {
                    rehash();
                }
        }
    }

    public static void main(String args[]){
        HashMap<String , Integer> map=new HashMap<>();
        map.put("I",120);
        map.put("U",20);
        map.put("E",10);

    }
}
