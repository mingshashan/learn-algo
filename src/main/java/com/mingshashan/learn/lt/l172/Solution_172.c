
/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * 
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * @param n 
 * @return int 
 */
int trailingZeroes1(int n){
    int res = 0;
    for (int i = 5; i <= n; i *= 5) {
        res += n / i;
    }
    return res;
}

int trailingZeroes(int n){
    int res = 0;
    while (n >0)
    {
        res += n / 5;
        n = n / 5;
    }

    return res;
}
