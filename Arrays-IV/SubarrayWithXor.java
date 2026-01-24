// Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equals to B.

import java.util.HashMap;
public class SubarrayWithXor {
    public static int countSubarraysWithXor(int[] A, int B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int prefixXor = 0;
        int count = 0;
        freq.put(0, 1);
        for (int num : A) {
            prefixXor ^= num;
            int required = prefixXor ^ B;
            count += freq.getOrDefault(required, 0);
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
}
