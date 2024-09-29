package com.greygryffin.practice.medium;
/*
https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().calc(15,15));
    }

    public int uniquePaths(int m, int n) {
        double res = 1.0;
        if(n<m) {
            int tmp = n;
            n=m;
            m=tmp;
        }
        int i=m+n-2;
        int j=m-1;
        while(j>1) {
            res /= j;
            j--;
        }
        while(i>n-1) {
            res *= i;
            i--;
        }

        return (int)Math.ceil(res);
    }

    public int calc(int n, int m){
        if(m==0) return 1;
        n=n+m;
        double res = 1;
        int c=m;
        for(int i=0; i<c; i++){
            res *= n;
            n--;
            if(m>1) {
                res /= m;
                m--;
            }
        }
        return (int) Math.round(res);
    }
}
