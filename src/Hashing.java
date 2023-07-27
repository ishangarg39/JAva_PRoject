import java.util.*;
import java.util.Map;

public class Hashing {
    public static void main(String args[]){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("I",20);
        map.put("U",30);
        map.put("E",10);
        if(map.containsKey("T")) {
            System.out.println(map);
        }
        else {
            System.out.println("null");
        }
        for(Map.Entry<String,Integer> val:map.entrySet()){

            System.out.println(val.getKey()+":"+val.getValue());
        }

        Set<String> mapkey=map.keySet();
        for(String key:mapkey){
            System.out.println(key+':'+map.get(key));
        }
    }
}
