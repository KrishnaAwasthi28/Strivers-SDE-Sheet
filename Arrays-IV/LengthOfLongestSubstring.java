
import java.util.*;
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxL=0;
        HashSet<Character> set=new HashSet<>();
        int left=0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxL=Math.max(maxL,right-left+1);
        }
        return maxL;
    }
}
