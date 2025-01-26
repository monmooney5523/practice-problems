package com.mamoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CandiesProblem {

    public List<Boolean> kidsWithCandiesV1(int[] candies, int extraCandies) {

        if(candies.length > 0){
            ArrayList<Boolean> result = new ArrayList<>();
            // first determine the highest # of candies and the lowest # of candies in the array
            int lowestCandiesArr = Integer.MAX_VALUE;
            int highestCandiesArr = Integer.MIN_VALUE;

            for(int i=0; i<candies.length; i++){
                if(candies[i] < lowestCandiesArr){
                    lowestCandiesArr = candies[i];
                }
                if(candies[i] > highestCandiesArr){
                    highestCandiesArr = candies[i];
                }
            };

            // now that you have the lowest and highest possible count of candies
            // add in the extra candies

            //int lowestWithExtra = lowestCandiesArr + extraCandies;
            //int highestWithExtra = highestCandiesArr + extraCandies;

            // basically the lowest with extra doesn't matter
            // if any int + extra >= highestCandiesArr, then they should return true;

            for(int i=0; i<candies.length; i++){
                result.add(candies[i] + extraCandies >= highestCandiesArr);
            }

            return result;
        } else {
            return new ArrayList<Boolean>();
        }
    }

    public List<Boolean> kidsWithCandiesV2(int[] candies, int extraCandies) {

        if(candies.length > 0){
            ArrayList<Boolean> result = new ArrayList<>();
            // first determine the highest # of candies and the lowest # of candies in the array
            int lowestCandiesArr = Integer.MAX_VALUE;
            int highestCandiesArr = Integer.MIN_VALUE;

            // use an enhanced for loop
            for (int candy : candies) {
                if (candy < lowestCandiesArr) {
                    lowestCandiesArr = candy;
                }
                if (candy > highestCandiesArr) {
                    highestCandiesArr = candy;
                }
            }

            // use an enhanced for loop
            for (int candy : candies) {
                result.add(candy + extraCandies >= highestCandiesArr);
            }

            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Boolean> kidsWithCandiesV3(int[] candyCounts, int extraCandies) {
        List<Boolean> kidsWithCandies = new ArrayList<>();
        if (candyCounts.length > 0) {
            // can use stream function to determine the highest
            int highestCandies = Arrays.stream(candyCounts).max().getAsInt();
            // lowestCandies variable is not used - removed

            // use enhanced for loop
            for (int candyCount : candyCounts) {
                kidsWithCandies.add(candyCount + extraCandies >= highestCandies);
            }

            return kidsWithCandies;
        } else {
            // can use empty list function instead of creating your own
            return Collections.emptyList();
        }
    }
}
