package com.greygryffin.practice.easy;

public class GcdEuclidean {

    int getGcd(int a, int b) {
        if(a<0 || b<0) {
            return -1;
        }
        if(b==0) {
            return a;
        }
        if(a>b){
            int t = a;
            a = b;
            b = t;
        }
        return getGcd(b, a%b);
    }

}
