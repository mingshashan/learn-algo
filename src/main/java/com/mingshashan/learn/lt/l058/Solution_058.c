#include <stdio.h>
#include <stdlib.h>
#include <string.h>


/**
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * @param s 
 * @return int 
 */
int lengthOfLastWord(char * s){
    int length = strlen(s);
    if (!length) {
        return 0;
    }

    int resultLength = 0;
    for (int i = length - 1; i >= 0; i--) {
        if (*(s + i) == ' ' && resultLength == 0) {
            continue;
        }
        if (*(s + i) != ' ') {
            resultLength++;
        }
        if (*(s + i) == ' ' && resultLength != 0) {
            break;
        }
    }

    return resultLength;
}

int main() {
    char *s = "Hello World";
    int result = lengthOfLastWord(s);
    printf("result length: %d\n", result);
    return 0;   
}