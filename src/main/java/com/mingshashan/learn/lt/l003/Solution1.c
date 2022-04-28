#include <stdio.h>
#include <string.h>

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * @param s 
 * @return int 
 * 用类似滑动窗口
 */
int lengthOfLongestSubstring(char * s){
    // 获取字符串长度
    int length = strlen(s);
    // ASCII共128个
    int temp[128];
    for (int i = 0; i < 128; i++) {
        temp[i] = -1;
    }

    // res放结果（longest substring without repeating characters）
    int res = 0;

    // 从0开始
    int left = 0, right = 0;
    while (right < length) {
        char c = *(s + right);
        // 先执行right++有个好处就是计算len的时候直接right-left就可以
        right++;
        // 如果窗口中已经有了，则需要temp[c]和left比较，如果>left，则left变，否则left不变
        if (temp[c] > -1) {
            left = left < temp[c] ? temp[c] : left;
        }

        temp[c] = right;
        int len = right - left;
        res = res > len ? res : len; 
    }
    
    return res == 0 ? length : res;
}
