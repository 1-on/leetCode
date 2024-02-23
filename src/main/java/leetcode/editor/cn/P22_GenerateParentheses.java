//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3521 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author DY
 * @date 2024-02-23 15:12:08
 */
public class P22_GenerateParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P22_GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs("(", 1, n);
            return list;
        }

        public void dfs(String s, int deep, int n) {
            if (s.length() == n * 2) {
                if (judge2(s)) {
                    list.add(s);
                }
                return;
            }
            if (!judge(s)) return;
            dfs(s + "(", deep + 1, n);
            dfs(s + ")", deep + 1, n);
        }

        public boolean judge(String s) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left += 1;
                }
                if (s.charAt(i) == ')') {
                    right += 1;
                }
                if (right > left) return false;
            }
            return true;
        }

        public boolean judge2(String s) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left += 1;
                }
                if (s.charAt(i) == ')') {
                    right += 1;
                }
            }
            if (right != left) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}