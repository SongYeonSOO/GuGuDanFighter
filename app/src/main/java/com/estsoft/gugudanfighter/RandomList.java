package com.estsoft.gugudanfighter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bit on 2016-05-20.
 */
public class RandomList {
    public static List<Integer> sortedList = genList();
    public static Set<Integer> setList = null;

    private RandomList() {
    }

    ;

    public static List<Integer> getRandomList() {
        List<Integer> newList = new ArrayList<>(sortedList);
        Collections.shuffle(newList);
        Log.d("test", newList.toString());
        return newList;
    }

    private static List<Integer> genList() {
        if (setList == null) {
            setList = new HashSet<>();
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    int num = i * j;
                    if (!setList.contains(num)) setList.add(num);
                }
            }
        }
        sortedList = new ArrayList(setList);
        Log.d("genList", "genList Called");
        return sortedList;
    }
}
