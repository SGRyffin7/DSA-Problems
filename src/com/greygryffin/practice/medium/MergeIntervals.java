package com.greygryffin.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] ar = {{1,3},{2,6},{8,10},{15,18}};
        new MergeIntervals().merge(ar);
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> def = new ArrayList<>();
        def.add(intervals[0][0]);
        def.add(intervals[0][1]);
        res.add(def);
        for(int i=1; i<intervals.length; i++) {
            if(res.get(res.size()-1).get(1)>=intervals[i][0]) {
                if(res.get(res.size()-1).get(1)<intervals[i][1])
                    res.get(res.size() - 1).set(1, intervals[i][1]);
            } else {
                def = new ArrayList<>();
                def.add(intervals[i][0]);
                def.add(intervals[i][1]);
                res.add(def);
            }
        }
        int[][] resAr = new int[res.size()][2];
        for(int i=0; i<res.size(); i++) {
            resAr[i][0] = res.get(i).get(0);
            resAr[i][1] = res.get(i).get(1);
        }
        return resAr;
    }
}
