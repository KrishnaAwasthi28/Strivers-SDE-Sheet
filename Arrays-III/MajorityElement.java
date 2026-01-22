// 169. Majority Element
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res=0;
        int freq=0;
        for(int i=0;i<nums.length;i++){
            if(freq==0) res=nums[i];
            if(res==nums[i]) freq++;
            else freq--;
        }

        return res;        
    }
}
