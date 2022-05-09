


// int reverse(int x){
//     if (0 == x) {
//         return 0;
//     }
//     int MIN_VALUE = 0x80000000;
//     int MAX_VALUE = 0x7fffffff;
//     long result = 0;
//     while (x != 0) {
//         int mod = x % 10;
//         result = result * 10 + mod;
//         if (result > MAX_VALUE || result < MIN_VALUE) {
//             return 0;
//         }

//         x /= 10;
//     }
    
//     return (int)result;
// }

int reverse(int x){
    if (0 == x) {
        return 0;
    }
    int max = (1<<30)/5;

    int result = 0;
    while (x != 0) {
        if (result > max || result < -max) {
            return 0;
        }
       
        result = result * 10 + x % 10;
        x /= 10;
    }
    
    return result;
}
