/**
 * @author Dell
 * @create 2019-05-03 17:09
 */
// 面试题56（二）：数组中唯一只出现一次的数字
// 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
// 找出那个吃出现一次的数字。
public class Solution {
    /**
     * 找出数组中只出现一次的数字，其他数字都出现三次
     * @param nums 数字
     * @return 只出现一次的数字
     */
    public int findNumberAppearingOnce(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] bits = new int[32];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            for (int j = 0; j < 32; j++) {
                bits[j] += (val & 1);
                val = val >> 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0)
                res += Math.pow(2, i);
        }
        return res;
    }
}
