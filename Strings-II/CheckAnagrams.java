import java.util.*;
public class CheckAnagrams {
    public boolean isAnagram(String s1, String s2) {
        Map<Character,Integer> h1=new HashMap<>();
        Map<Character,Integer> h2=new HashMap<>();
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            if(h1.containsKey(ch)){
                h1.put(ch,h1.get(ch)+1);
            }else{
                h1.put(ch,1);
            }
        }
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            if(h2.containsKey(ch)){
                h2.put(ch,h2.get(ch)+1);
            }else{
                h2.put(ch,1);
            }
        }
        if(h1.equals(h2)) return true;
        else return false;

    }
}
