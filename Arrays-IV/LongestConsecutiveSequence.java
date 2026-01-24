// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

import java.util.HashSet;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int maxLen=0;
        for(Integer ele:set){
            int prev=ele-1;
            if(!set.contains(prev)){
                int len=1;
                int next=ele+1;
                while(set.contains(next)){
                    len++;
                    next++;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}
