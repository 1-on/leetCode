//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4341 👎 0


package leetcode.editor.cn;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author DY
 * @date 2024-02-16 01:48:26
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P20_ValidParentheses().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()) return false;
                    Character peek = stack.peek();
                    stack.pop();
                    if (c == ')' && peek != '(') return false;
                    if (c == ']' && peek != '[') return false;
                    if (c == '}' && peek != '{') return false;
                }
            }
            if (!stack.isEmpty()) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}