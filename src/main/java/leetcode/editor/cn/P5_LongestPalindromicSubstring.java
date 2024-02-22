//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7069 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长回文子串
 *
 * @author DY
 * @date 2024-02-22 17:43:36
 */
public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("aacabdkacaa"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            int[] dp = new int[n];
            dp[0] = 1;
            int maxIndex = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], cal(s, i));
                System.out.println(dp[i]+" "+maxIndex);
                if (dp[i] > dp[maxIndex]) maxIndex = i;
            }
            System.out.println(maxIndex);
            System.out.println(Arrays.toString(dp));
            return s.substring(maxIndex - dp[maxIndex] + 1, maxIndex - dp[maxIndex] + 1 + dp[maxIndex]);

        }

        public int cal(String s, int index) {
            for (int i = 0; i <= index; i++) {
                int flag = 1;
                for (int j = i; j <= (index+i) / 2; j++) {
                    if (s.charAt(j) != s.charAt(index - j + i)) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    return index - i + 1;
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}