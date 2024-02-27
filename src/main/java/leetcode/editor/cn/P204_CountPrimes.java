//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
//
// Related Topics 数组 数学 枚举 数论 👍 1140 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 计数质数
 *
 * @author DY
 * @date 2024-02-27 19:26:00
 */
public class P204_CountPrimes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P204_CountPrimes().new Solution();
        solution.countPrimes(10);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[5000005];
            Arrays.fill(isPrime, true);
            isPrime[1] = false;
            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int res = 0;
            for (int i = 1; i < n; i++) {

                if (isPrime[i]) {
//                    System.out.println(i);
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}