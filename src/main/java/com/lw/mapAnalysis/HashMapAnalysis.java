package com.lw.mapAnalysis;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-27
 */
public class HashMapAnalysis {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();

        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
    }
}
