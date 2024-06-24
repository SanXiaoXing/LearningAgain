package nextGreaterElements;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/06/24/21:49
 * @Description:
 *
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * 示例 1:
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 */
public class Solution {
    /**
     * 寻找数组中每个元素的下一个最大值。
     * 对于给定的循环数组，返回一个新的数组，其中每个元素是原数组中对应位置元素的下一个最大值。
     * 如果不存在下一个更大元素，则对应位置的数组元素为-1。
     *
     * @param nums 原数组，假设为一个循环数组
     * @return 包含每个元素下一个最大值的数组
     */
    public static int[] nextGreaterElements(int[] nums) {
        // 数组长度
        int n = nums.length;
        // 结果数组，初始化为-1，表示没有下一个更大元素
        int[] result = new int[n];
        Arrays.fill(result, -1);
        // 使用栈来辅助寻找下一个更大元素
        Stack<Integer> stack = new Stack<>();

        // 遍历数组两次，以处理环形数组的特性
        for (int i = 0; i < 2 * n; i++) {
            // 当前遍历到的元素
            int num = nums[i % n];
            // 如果栈不为空且栈顶元素小于当前元素，则栈顶元素的下一个更大元素为当前元素
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            // 如果当前遍历位置小于原数组长度，则将位置入栈，用于后续寻找下一个更大元素
            if (i < n) {
                stack.push(i);
            }
        }

        // 返回结果数组
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));  // 输出 [2, -1, 2]
    }

}
