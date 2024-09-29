package com.greygryffin.practice.random;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().lcs("sagar", "jarag"));
    }

    public String lcs(String a, String b) {
        return lcs(a, b, 0, 0);
    }

    private String lcs(String a, String b, int i, int j) {
        if(i == a.length() || j == b.length()) return "";

        String kept = "";
        if(a.charAt(i) == b.charAt(j)) {
            kept = a.charAt(i) + lcs(a, b, i+1, j+1);

        }
        String skipA = lcs(a, b, i+1, j);
        String skipB = lcs(a, b, i, j+1);

        if(kept.length() >= skipA.length() && kept.length() >= skipB.length())
            return kept;
        else if(skipA.length() >= skipB.length())
            return skipA;
        else
            return skipB;
    }

}
