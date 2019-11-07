package com.ing;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;

public class MapFilter<K,V>{

    public Map<Integer,String> map = new HashMap<>();

    public MapFilter(){
        map.put(1000, "Miao");
        map.put(5, "Felipe");
        map.put(500,"Rodrigo");
    }

    public static void main(String[] args) {
        BiPredicate<Integer, String> filter = (i,s) -> i>500 && (s.startsWith("M") || s.startsWith("R"));
        MapFilter<Integer, String> mapFilter = new MapFilter<>();
        System.out.println("Before: " + mapFilter.map);
        mapFilter.map = mapFilter.filterMap(filter, mapFilter.map);
        System.out.println("After: " + mapFilter.map);
    }

    public Map<K,V> filterMap(BiPredicate<K, V> filter, Map<K,V> map){
        ConcurrentHashMap<K,V> conMap = new ConcurrentHashMap<>(map);
        Set<K> keys = conMap.keySet();
        for (K k : keys){
            V v = conMap.get(k);
            if (filter.test(k, v)){
                conMap.remove(k,v);
            }
        }
        return conMap;
    }

}