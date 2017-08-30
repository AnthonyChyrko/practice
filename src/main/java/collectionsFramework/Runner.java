package collectionsFramework;

import exercise.exr01.Cat;
import gherkin.lexer.Ca;

import java.util.*;

/**
 * Created by Anton_Chyrko on 8/29/2017.
 */
public class Runner {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);

        for(Map.Entry entry : hashMap.entrySet()){
            System.out.println(entry.getKey());
        }
    }
//        System.out.println("Display entries in HashMap");
//        System.out.println(hashMap);
//        Map<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
//        System.out.println("\nDisplay entries in ascending order of key");
//        System.out.println(treeMap);
//        Map<String, Integer> linkedHashMap = new LinkedHashMap<String,Integer>(16, 0.75f, true);
//        linkedHashMap.put("Smith", 30);
//        linkedHashMap.put("Anderson", 31);
//        linkedHashMap.put("Lewis", 29);
//        linkedHashMap.put("Cook", 29);
//        System.out.println("\nThe age for " + "Lewis is "
//                + linkedHashMap.get("Lewis").intValue());
//        System.out.println(linkedHashMap);
//    }
//        Collection<Cat> hashSet = new HashSet<>();
//
//        Cat barsik = new Cat("barsik", 3);
//        Cat murzik = new Cat("murzik", 4);
//        Cat vasiliy = new Cat("vasiliy", 5);
//        hashSet.add(barsik);
//        hashSet.add(murzik);
//        barsik.setAge(6);
//        hashSet.add(barsik);
//        for (Cat cat : hashSet) {
//            System.out.println(cat.getAge());
//            cat.toString();
//        }
//        System.out.println(hashSet.contains(barsik));



}
