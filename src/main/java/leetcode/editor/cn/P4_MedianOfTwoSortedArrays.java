//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7007 👎 0


package leetcode.editor.cn;

import java.util.Map;

/**
 * 寻找两个正序数组的中位数
 *
 * @author DY
 * @date 2024-02-18 13:46:08
 */
public class P4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        int[] n1 = {};
        int[] n2 = {1};
        double medianSortedArrays = solution.findMedianSortedArrays(n1, n2);
        System.out.println(medianSortedArrays);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n1, n2;

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            n1 = nums1.length;
            n2 = nums2.length;
            int start1 = 0;
            int end1 = n1 - 1;
            int start2 = 0;
            int end2 = n2 - 1;
            int left = (n1 + n2 + 1) / 2;
            int right = (n1 + n2 + 2) / 2;
            double res = (find(nums1, nums2, start1, end1, start2, end2, left) + find(nums1, nums2, start1, end1, start2, end2, right)) / 2.0;
            System.out.println(res);
            return res;
        }

        public double find(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2, int k) {
            if (s1 >= n1) {
                return nums2[s2 + k - 1];
            }
            if (s2 >= n2) {
                return nums1[s1 + k- 1];
            }

            if (k == 1) {
                return Math.min(nums1[s1], nums2[s2]);
            }
            int k1 = k / 2;
            int nextK = 0;
            int index1 = Math.min(s1 + k1 - 1, e1);
            int index2 = Math.min(s2 + k1 - 1, e2);
            if (nums1[index1] < nums2[index2]) {
                nextK = k - (index1 - s1 + 1);
                s1 = index1 + 1;
            }
            if (nums1[index1] >= nums2[index2]) {
                nextK = k - (index2 - s2 + 1);
                s2 = index2 + 1;
            }

            return find(nums1, nums2, s1, e1, s2, e2, nextK);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}