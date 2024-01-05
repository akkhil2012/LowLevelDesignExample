package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {

      //  System.out.println(" max is " + new Sample().lengthOfLongestSubstring("au"));

      //  new Sample().minWindow("ADOBECODEBANC","ABC");
        System.out.println(new Sample().minWindow("ADOBECODEBANC","ABC"));

    }



    //s = "abcabcbb"
    //Output: 3
    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int start=0,end=0;
        int n = s.length();
        if(n==0)
            return 0;
        Map<Character,Integer> map = new HashMap<>();
        while(end<n){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                max = Math.max(max,end-start);
                start = Math.max(start,map.get(ch)+1);
            }
            max = Math.max(max,end-start+1);
            map.put(ch,end++);
        }
        return  max;
    }



    // find Min window
    public String minWindow(String s, String t) {
       // Map<Character,Integer> map = new HashMap<>();

        int[] map = new int[128];
        t.chars()
                .mapToObj(c ->(char)c)
                .forEach(val -> map[val]++);
       int end=0,start=0;
       int n = s.length();
       int m = t.length();int count=m;
       int startIndex=0;
       int minLen = Integer.MAX_VALUE;
       char[] chArray = s.toCharArray();
       while(end<n){
          // char current = s.charAt(end);
           if(map[chArray[end++]]-->0){
               count--;
           }

           while(count==0){
                if(end-start<minLen){
                    startIndex = start;
                    minLen = end-start;
                }


               if(map[chArray[start++]]++==0){
                   count++;
               }
           }
       }
        return  minLen==Integer.MAX_VALUE?"":new String(chArray,startIndex,minLen);


    }



}
