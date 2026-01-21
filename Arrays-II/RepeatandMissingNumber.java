// Repeat and Missing Number

import java.util.*;
public class RepeatandMissingNumber {
    public int[] findRepeatandMissing(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        int curSum=0;
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                curSum+=nums[i];
                set.add(nums[i]);
            }else{
                ans[0]=nums[i];
            }
        }
        int n=nums.length;
        int total=n*(n+1)/2;
        ans[1]=total-curSum;
        return ans;
    }
}
