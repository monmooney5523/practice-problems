package com.mamoo;

import java.util.ArrayList;


public class MergeStringsPractice {

    public static String mergeAlternatelyV1(String word1, String word2) {
        String[] word1Arr = word1.split("");
        String[] word2Arr = word2.split("");

        // cases
        // case - empties
        if(word1Arr == null || word2Arr == null){
            if(word1Arr == null && word2Arr == null){
                return "";
            }else if(word1Arr == null){
                // return word2 - no merge
                return word2;
            }else{
                // return word1 - no merge
                return word1;
            }
        } else {
            StringBuilder result = new StringBuilder("");
            // see who has the greater length
            int word1ArrLength = word1Arr.length;
            int word2ArrLength = word2Arr.length;
            // case 1 - words are the same length (easy - no extra appendage)
            if(word1ArrLength == word2ArrLength){
                for(int i=0; i<word1ArrLength; i++){
                    result.append(word1Arr[i]);
                    result.append(word2Arr[i]);
                }
                return result.toString();
            } // case 2 - need to append the extra word1 letters to the end of word
            else if(word1ArrLength > word2ArrLength){
                for(int i=0; i<word2ArrLength; i++){
                    result.append(word1Arr[i]);
                    result.append(word2Arr[i]);
                }
                for(int i=word2ArrLength; i<word1ArrLength; i++){
                    result.append(word1Arr[i]);
                }
                return result.toString();
            } // case 3 - word2 is longer than word1, need to append the extra word2 letters
            else{
                for(int i=0; i<word1ArrLength; i++){
                    result.append(word1Arr[i]);
                    result.append(word2Arr[i]);
                }
                for(int i=word1ArrLength; i<word2ArrLength; i++){
                    result.append(word2Arr[i]);
                }
                return result.toString();
            }
        }

    }

    public static String mergeAlternatelyV2(String word1, String word2) {
        // toCharArray is faster than split("")
        // also String objects use extra memory than chars
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        // will never be null, but if word is "" then length will be 0
        if (word1Arr.length == 0 || word2Arr.length == 0) {
            return word1Arr.length == 0 ? word2 : word1;
        }

        // create a string builder with a predetermined capacity
        StringBuilder mergedString = new StringBuilder(word1Arr.length + word2Arr.length);

        int i = 0, j = 0;

        // simplified loop logic
        // can iterate through both at the same time - no need for if/else cases as above
        // will keep going until both arrays are empty
        while (i < word1Arr.length || j < word2Arr.length) {
            if (i < word1Arr.length) {
                mergedString.append(word1Arr[i++]);
            }
            if (j < word2Arr.length) {
                mergedString.append(word2Arr[j++]);
            }
        }

        return mergedString.toString();
    }

    public static void main(String[] args){

        TestObject testObject1 = new TestObject("abc", "pqr");
        TestObject testObject2 = new TestObject("ab", "pqrs");
        TestObject testObject3 = new TestObject("abcd", "pq");
        TestObject testObject4 = new TestObject("", "");
        TestObject testObject5 = new TestObject("", "abc");
        TestObject testObject6 = new TestObject("abc", "");

        ArrayList<TestObject> testObjects = new ArrayList<>();
        testObjects.add(testObject1);
        testObjects.add(testObject2);
        testObjects.add(testObject3);
        testObjects.add(testObject4);
        testObjects.add(testObject5);
        testObjects.add(testObject6);

        for(TestObject testObject : testObjects){
            //mergeAlternately(testObject.word1, testObject.word2);
            mergeAlternatelyV2(testObject.word1, testObject.word2);
        }
    }
}
