package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {

    //candidates = [2,3,6,7], target = 7

    List<List<Integer>> res = new ArrayList<>();
    public static void main(String args[]){

        //new Sample().combinationSum();

    }





//subset

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, 0, subList);
        return res;
    }

    private void findSubsets(int[] nums,int index,List<Integer> temp){
        res.add(new ArrayList<>(temp));

        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            findSubsets(nums,i,temp);
            temp.remove(temp.size()-1);
        }


    }




    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates,target,new ArrayList<>(),0);
        return  res;
    }

    private void dfs(int[] nums,int target,List<Integer> temp,int start){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }else if(target<0){
            return;
        }else{
            for(int i=start;i<nums.length;i++){
                 temp.add(nums[i]);
                 dfs(nums,target-nums[i],temp,i);
                 temp.remove(temp.size()-1);
            }

        }



    }


}
