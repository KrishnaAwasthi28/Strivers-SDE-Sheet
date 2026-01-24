
import java.util.*;
public class LongestSubarrayWithSumK {
    public int longestSubarrayWithSumK(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem=sum-k;
            if(map.containsKey(rem)){
                int stIdx=map.get(rem);
                int len=i-stIdx;
                maxLen=Math.max(len,maxLen);
            }
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return maxLen;
    }
}
