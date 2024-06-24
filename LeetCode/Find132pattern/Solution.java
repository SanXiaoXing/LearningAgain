package Find132pattern;

import java.util.Stack;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/06/23/19:05
 * @Description: 用于调试内容
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        // 如果数组为空或长度小于3，无法构成132模式，直接返回false
        if (nums == null || nums.length < 3) {
            return false;
        }

        // 栈用于维护单调递减序列
        Stack<Integer> stack = new Stack<>();
        // third代表当前找到的最大second元素
        int third = Integer.MIN_VALUE;

        // 从后往前遍历数组
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果当前元素小于third，说明存在132模式
            if (nums[i] < third) {
                return true;
            }
            // 维护单调递减栈，如果当前元素大于栈顶元素，不断弹出栈顶元素并更新third
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                // 更新third，栈顶元素出栈并赋值给third
                third = stack.pop();
            }
            // 将当前元素压入栈
            stack.push(nums[i]);
        }

        // 遍历完数组后，如果没有找到符合条件的子序列，返回false
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.find132pattern(nums)); // false

        int[] nums2 = {3, 1, 4, 2};
        System.out.println(solution.find132pattern(nums2)); // true
    }
}
