// You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

// Your task is to find:

// The maximum number of jobs that can be completed within their deadlines.
// The total maximum profit earned by completing those jobs.
// Examples :

// Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
// Output: [2, 60]
// Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).

import java.util.*;
public class JobSequencing {
    public static ArrayList<Integer> maxProfit(int[] deadline,int[] profit){
        int n=deadline.length;
        for(int d:deadline){
            n=Math.max(n,d);
        }
        int[] assignJob=new int[n+1];
        Arrays.fill(assignJob,-1);
        int len=profit.length;
        Integer[] index=new Integer[len];
        for(int i=0;i<len;i++){
            index[i]=i;
        }
        Arrays.sort(index,(a,b)-> profit[b]-profit[a]);
        int count=0,maxP=0;
        for(int i=0;i<len;i++){
            int idx=index[i];
            int d=deadline[idx];
            while(assignJob[d]!=-1) d--;
            if(d==0) continue;
            count++;
            assignJob[d]=idx+1;
            maxP+=profit[idx];
        }
        ArrayList<Integer> res=new ArrayList<>();
        res.add(count);
        res.add(maxP);
        return res;
    }
}

