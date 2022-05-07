package com.mingshashan.learn.lt.l006;

/**
 * 6. Zigzag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * 可以看到，组成之字一个角度的长度为2N，组成一个之字需要 3N-2
 *
 * T = (N + N - 2) = 2N - 2
 * if (N <= (m%T) < T) -> l(m) = 2N - (m % T)
 * if (m % T) < N -> l(m) = (m % T) % N
 * so can find the result string elements(1...N) the index in s
 * l1 -> 1, T+1, 2T+1 -> i*T + 1, N+i*T+(n-x) -> (1,)
 * l2 -> 2, T, T+2, 2T, 2T+2 -> i*T + 2和i*T
 * l3 -> 3, T-1, T+3, 2T-1, 2T+3 -> i*T+3 和i*T-1
 * ...
 * lx -> x, (6+0*T+(6-x)), T+x, (6+1*T+(6-x)), 2T+x -> i*T + x 和N+i*T+(n-x)
 * ...
 * ln -> N, T+N, 2T+N -> i*T + N --> (i*T + N) N+i*T+(n-n)
 * 这样即可直接算结果（注意索引需要-1）
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class Solution_006_V2 {


    public String convert(String s, int numRows) {
        if (1 == s.length() || 1 == numRows) {
            return s;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int t = numRows * 2 - 2;
        for (int i = 1; i <= numRows; i++) {
            // n -> for while loop
            int n = 0;
            // n * t + i
            int ci = n * t + i;
            // numRows + n * t + (numRows-i)
            int zi = numRows + n * t + (numRows - i);

            while (ci <= length) {
                sb.append(s.charAt(ci - 1));
                if (zi <= length && (zi - ci) % t != 0) {
                    sb.append(s.charAt(zi - 1));
                }
                ++n;
                ci = n * t + i;
                zi = numRows + n * t + (numRows - i);
            }

        }
        return sb.toString();
    }


}