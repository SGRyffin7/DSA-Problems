package com.greygryffin.practice.random;

import java.util.Random;

public class SongShuffleWithLimit {

    int[] list;
    int limit;
    int shuffleEnd = -1, switchPoint = -1;
    SongShuffleWithLimit(int arr[], int limit) {
        this.list = arr;
        this.limit = limit;
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4};
        SongShuffleWithLimit shuffler = new SongShuffleWithLimit(in, 2);
        for(int i=0; i<6; i++){
            System.out.println(shuffler.shuffle());
        }
    }

    public int shuffle() {
        int selected = new Random().nextInt(shuffleEnd+1, list.length);
        if(shuffleEnd<limit-1) {
            switchPoint++;
            shuffleEnd++;
        } else {
            if(switchPoint<limit-1)
                switchPoint++;
            else
                switchPoint = 0;
        }
        int tmp = list[selected];
        list[selected] = list[switchPoint];
        list[switchPoint] = tmp;
        return tmp;
    }
}
