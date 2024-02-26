//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2762 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author DY
 * @date 2024-02-26 21:00:05
 */
public class P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        Map<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {

            if (Objects.equals(digits, "")) return res;

            dfs("", 0, digits);
            return res;
        }

        public void dfs(String ans, int index, String digits) {
            if (index == digits.length()) {
                res.add(ans);
                return;
            }
            String s = map.get(digits.charAt(index));
            for (int i = 0; i < s.length(); i++) {
                dfs(ans + s.charAt(i), index + 1, digits);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}