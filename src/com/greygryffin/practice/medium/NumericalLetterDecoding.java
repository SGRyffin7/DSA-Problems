package com.greygryffin.practice.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/decode-ways/
 */
public class NumericalLetterDecoding {
    public static void main(String[] args) {
        System.out.println(new NumericalLetterDecoding().numDecodings("1123", 0, new HashMap<Integer, Integer>()));
    }
    public int numDecodings(String s, int tmp, Map<Integer, Integer> mem) {
        if(mem.containsKey(tmp)) return mem.get(tmp);
        if(tmp == s.length()) {
            mem.put(tmp, 1);
            return 1;
        }
        if(s.charAt(tmp) == '0') {
            mem.put(tmp, 0);
            return 0;
        }
        int count = 0;
        if(s.length() - tmp > 1) {
            String substring = s.substring(tmp, tmp + 2);
            if (Integer.parseInt(substring) < 27)
                count += numDecodings(s, tmp + 2, mem);
        }
        count += numDecodings(s, tmp + 1, mem);
        mem.put(tmp, count);
        return count;
    }

}
