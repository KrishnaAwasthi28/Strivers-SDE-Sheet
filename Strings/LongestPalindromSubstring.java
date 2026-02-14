package Strings;

public class LongestPalindromSubstring {

    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        String LPS="";
        for(int i=1;i<s.length();i++){
            int low=i;
            int high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==s.length()) break;
            }
            String palindrom=s.substring(low+1,high);
            if(palindrom.length()>LPS.length()) LPS=palindrom;

            low=i-1;
            high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==s.length()) break;
            }
            palindrom=s.substring(low+1,high);
            if(palindrom.length()>LPS.length()) LPS=palindrom;
        }
        return LPS;
    }
}
