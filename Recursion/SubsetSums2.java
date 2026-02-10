import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSums2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort to handle duplicates
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);              // pick
            backtrack(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);   // backtrack
        }
    }
}
