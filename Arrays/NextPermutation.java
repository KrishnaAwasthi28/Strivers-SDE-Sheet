// 31. Next Permutation

public class NextPermutation {
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int s, int e, int[] arr) {
        while (s < e) {
            swap(s, e, arr);
            s++;
            e--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        if (idx != -1) {
            int swap_idx = idx;
            for (int j = n - 1; j >= idx + 1; j--) {
                if (nums[j] > nums[idx]) {
                    swap_idx = j;
                    break;
                }
            }
            swap(idx, swap_idx, nums);
        }
        reverse(idx + 1, n - 1, nums);
    }
}
