package Heap;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {


    public static void  main(String args[]){
        // new Sample().frequencySort("tree");
         System.out.println(">> " + new Sample().frequencySort("tree"));
    }




    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mapper = new HashMap<>();
        for(String s : strs){
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String sorted = String.valueOf(chArray);
            if(mapper.containsKey(sorted)){
                mapper.get(sorted).add(s);
            }else{
                mapper.put(sorted,s);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> en : mapper.entrySet()){
            res.add(new ArrayList<>(en.getValue()));
        }

        return res;
    }


    //Input: s = "tree"
//Output: "eert"
    public String frequencySort(String s) {

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));

        for(char c : map.keySet()){
            queue.add(c);
        }


        StringBuilder stringBuilder = new StringBuilder();
        while(!queue.isEmpty()){
             char c = queue.poll();
             for(int i=0;i<map.get(c);i++){
                 stringBuilder.append(c);
             }
        }

        return  String.valueOf(stringBuilder);

    }

}


