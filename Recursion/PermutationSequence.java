import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k = k - 1;
        
        int a = n; // Variable to track remaining digits for factorial calculation
        for (int i = 0; i < n; i++) {
            int size = fact(a - 1);
            int b = k / size;
            sb.append(nums.get(b));
            k = k % size;
            a--; 
            nums.remove(b); 
        }
        return sb.toString();
    }

    public int fact(int n) {
        if (n <= 1) return 1;
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f = f * i;
        }
        return f;
    }
}
