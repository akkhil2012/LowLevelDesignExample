package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {

    public static void main(String aths[]){

        //int[][] res = new Sample().merge();

    }


    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount];
        Arrays.fill(dp,amount+1);
        for(int coin : coins){
            for(int i=0;i<amount;i++){
                if(i>coin){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
       return dp[amount]==amount+1?0:dp[amount];
    }


    public int uniquePaths(int m, int n) {

        int[] dp = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[j]=1;
                }else {
                    dp[i] +=dp[j-1];
                }
            }
        }

        return dp[n-1];

    }


    public int[][] merge(int[][] intervals) {

        List<int[]> lst = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int[] pre = intervals[0];
        lst.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
             if(intervals[i][0]<pre[1]){
                 pre[1] = Math.max(pre[1],intervals[i][1]);
             }else{
                 pre = intervals[i];
                 lst.add(pre);
             }
        }

        //return new int[lst.size()][];
        return lst.toArray(new int[lst.size()][]);


    }
}
