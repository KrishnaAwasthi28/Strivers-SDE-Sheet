// 118. Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it:

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<Integer> generateRow(int row){
        int ans=1;
        List<Integer> r=new ArrayList<>();
        r.add(1);
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans=ans/col;
            r.add(ans);
        }
        return r;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            res.add(generateRow(i));
        }
        return res;
    }
}
