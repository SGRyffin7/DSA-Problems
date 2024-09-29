package com.greygryffin.practice.medium;

import java.util.*;

/*
https://leetcode.com/problems/group-anagrams/
 */
public class AnagramGroups {
    public static void main(String[] args) {
        new AnagramGroups().isAnagram("abbbbbbbbbbb","aaaaaaaaaaab");
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ana = new HashMap<String, List<String>>();

        for (String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List<String> l = ana.getOrDefault(key, new ArrayList<>());
            l.add(str);
            ana.put(key, l);
        }

        List<List<String>> res = new ArrayList<>();
        for(String key: ana.keySet()) {
            res.add(ana.get(key));
        }
        return res;
    }

    boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        Map<Character, Integer> chMap = new HashMap<>();
        for(int i=0; i<str2.length(); i++) {
            chMap.put(str1.charAt(i), chMap.getOrDefault(str1.charAt(i), 0)+1);
            chMap.put(str2.charAt(i), chMap.getOrDefault(str2.charAt(i), 0)-1);
        }
        for(Character ch : chMap.keySet()){
            if(chMap.get(ch) != 0) return false;
        }
        return true;
    }

    /**
     * Convert characters contained in word to a key, which contain character and count.
     * this key will be same for all anagrams
     * @param strs
     * @return
     */
    private List<List<String>> tryTwo(String[] strs) {
        Map<Set<String>, List<String>> anaGroups = new HashMap<Set<String>, List<String>>();

        for(String word : strs) {
            Set<String> anaKey = getStringAnaKey(word);
            if(anaGroups.containsKey(anaKey)) {
                anaGroups.get(anaKey).add(word);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(word);
                anaGroups.put(anaKey, newList);
            }
        }

        return anaGroups.values().stream().toList();
    }

    private Set<String> getStringAnaKey(String word){
        HashMap<Character, Integer> anaKey= new HashMap<>();
        for(char c : word.toCharArray()) {
            anaKey.put(c, anaKey.getOrDefault(c, 0)+1);
        }

        Set<String> anaSet = new HashSet<>();
        for(Map.Entry<Character, Integer> entry : anaKey.entrySet()) {
            anaSet.add(entry.getKey() + entry.getValue().toString());
        }

        return anaSet;
    }
}
