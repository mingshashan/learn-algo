
bool isHappy(int n){
    while (n != 1 && n != 4) {
        int sum = 0;
        while (n) {
            int mod = n % 10;
            sum += mod * mod;
            n /= 10;
        }
        n = sum;
    }
    return n == 1;
}
