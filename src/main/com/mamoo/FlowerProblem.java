package com.mamoo;

public class FlowerProblem {

    public boolean notWorkingSolutionV1(int[] flowerbed, int n){
        if(flowerbed != null && flowerbed.length > 0 && flowerbed.length > n){
            int countOfAvailableSpots = 0;
            int i=0;
            int j=i-1;
            int k=i+1;
            while(countOfAvailableSpots <= n && i < flowerbed.length){
                if(flowerbed[i++] == 1){
                    //countOfAvailableSpots--;
                    j++;
                    k++;
                }else{
                    int numBefore = Integer.MIN_VALUE;
                    int numAfter = Integer.MIN_VALUE;
                    // need to check if its a valid spot
                    // check to see if there is a number before
                    if(j >= 0){
                        numBefore = flowerbed[j];
                        j++;
                        // increase j after pulling
                    } if(k < flowerbed.length){
                        numAfter = flowerbed[k];
                        k++;
                        // increase k after pulling
                    }

                    // if there is no number before and no number after, then we are ok
                    // if the number before is 0 and the number after is 0, then we are ok
                    if(numBefore <= 0 && numAfter <= 0){
                        countOfAvailableSpots++;
                    }

                    //if(numBefore > 0 || numAfter > 0){
                    //    countOfAvailableSpots--;
                    //}
                }
            }
            // if there are less available spots than n -> false
            // if there are at least enough spots (or more) -> true
            return countOfAvailableSpots >= n;
        }
        else{
            return false;
        }
    }

    // Runtime: 1ms Beats 96.72%
    // Memory: 45.53MB Beats 75.42%
    public boolean canPlaceFlowersV1(int[] flowerbed, int n) {
        if(flowerbed != null && flowerbed.length > 0 && flowerbed.length >= n){
            // plant the flowers as we go - fifo
            int i=0;
            int j=i-1;
            int k=i+1;
            while(i < flowerbed.length && n != 0){
                if(flowerbed[i] == 1){
                    // skip
                    i++;
                    j++;
                    k++;
                }else{
                    int beforeVal = Integer.MIN_VALUE;
                    int afterVal = Integer.MIN_VALUE;
                    if(j >= 0){
                        // able to set the before value
                        beforeVal = flowerbed[j];
                    }
                    if(k < flowerbed.length){
                        // able to set the after value
                        afterVal = flowerbed[k];
                    }
                    if(beforeVal <= 0 && afterVal <=0){
                        flowerbed[i] = 1;
                        n--;

                    }
                    i++;
                    j++;
                    k++;
                }

            }
            return n == 0;
        }else{
            return false;
        }
    }

    // Runtime: 1ms Beats 96.72%
    // Memory: 45.96MB Beats 22.59%
    public boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        // move else case first - edge cases
        // need to check if n is at least 0, otherwise will fail on last check
        // if n is 0, no flowers to be added - true
        if (flowerbed == null || flowerbed.length == 0 || (n > 0 && flowerbed.length < n)) {
            return false;
        }

        int availableSpots = 0;
        int i = 0;
        while (i < flowerbed.length) {
            // check that the current spot is available
            if (flowerbed[i] == 0 &&
                    // check that the before adjacent spot is available
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    // check that the after adjacent spot is available
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                // plant the flower
                flowerbed[i] = 1;
                availableSpots++;

                // check as we go if we have filled enough spots
                // need to do >= because n can be 0
                if (availableSpots >= n) {
                    return true;
                }
            }
            i++;
        }

        return availableSpots >= n;
    }
}
