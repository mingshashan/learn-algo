
bool isPalindrome(int x){
    if (x < 0) {
        return false;
    }

    if (x < 10) {
        return true;
    }
    
    int temp = x;
    int p = 0;
    int max = 2147483647;

    while (temp) {
        if (p > ((max - temp % 10) / 10)) {
            return false;
        }
        p = p * 10 + temp % 10;
        temp /= 10;
    }

    return x == p;
}