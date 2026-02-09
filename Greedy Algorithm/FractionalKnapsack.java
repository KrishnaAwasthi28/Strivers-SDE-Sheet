// Given two arrays, val[] and wt[] , representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
// Return the maximum value as a double, rounded to 6 decimal places.

// Examples :

// Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
// Output: 240.000000
// Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240

import java.util.*;
public class FractionalKnapsack {
    public class Item implements Comparable<Item>{
        int val;
        int wt;
        double ratio;
        Item(int v,int w){
            val=v;
            wt=w;
            ratio=(double)val/(double)wt;
        }
        public int compareTo(Item that){
            if(this.ratio<=that.ratio) return 1;
            return -1;
        }
    }
    public double fractionalKnapsack(int val[],int wt[],int capacity){
        int n=val.length;
        ArrayList<Item> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Item(val[i],wt[i]));
        }
        Collections.sort(list);
        double res=0.0;
        for(Item item:list){
            if(item.wt>=capacity){
                res+=(capacity*item.ratio);
                capacity=0;
            }else{
                res+=item.val;
                capacity-=item.wt;
            }
            if(capacity==0) break;
        }
        return res;
    }
}
