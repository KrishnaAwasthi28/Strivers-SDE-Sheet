package Strings;
public class RabinKarp {
    private final int PRIME=0;
    public double calculateHash(String str){
        double hash=0;
        for(int i=0;i<str.length();i++){
            hash+=str.charAt(i)*Math.pow(PRIME,i);
        }
        return hash;
    }
    public double updateHash(double prevHash,char oldChar,char newChar,int patternLength){
        double newHash=(prevHash-oldChar)/PRIME;
        newHash+=newChar*Math.pow(PRIME,patternLength-1);
        return newHash;
    }
    public int rabinKarp(String text, String pattern) {
        int t=text.length();
        int p=pattern.length();
        double textHash=calculateHash(text.substring(0,p));
        double patternHash=calculateHash(pattern);
        for(int i=0;i<t-p;i++){
            if(textHash==patternHash){
                if(text.substring(i,i+p).equals(pattern)) return i;
            }
            if(i<t-p){
                textHash=updateHash(textHash,text.charAt(i),text.charAt(i+p),p);
            }
        }
        return -1;
    }
}
