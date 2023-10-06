package com.study.java.ch06;

import java.util.*;

public class Ex07Map {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("A","하이");
        map.put("B","바이");
        map.put("C","마이");
        map.put("D","자이");

        for(Map.Entry<String,String> e : map.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        System.out.println();

        for(Iterator<String> it = map.keySet().iterator(); it.hasNext();){
            String key = it.next();
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println();

        Set<String> sk = Collections.singleton("하이");
        map.values().removeAll(sk);

        for(Iterator<String> it = map.keySet().iterator(); it.hasNext();){
            String key = it.next();
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println(map.containsValue("자이"));
    }
}
