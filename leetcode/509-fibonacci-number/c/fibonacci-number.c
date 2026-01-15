#include <stdio.h>

// Choose max number of fib sequence generated
#define MAX 30

// Choose fib implementation
#define fib fib_polynomial_sliding

/*
    Exponential (recursive algorithm)
    Complexity:
        Time: O(φ^n)
        Space: O(n)
*/
int fib_recursive(int n) {
    if(n < 2) return n;
    return fib_recursive(n - 1) + fib_recursive(n - 2);
}

/*
    Unoptomized polynomial algorithm using array
    Complexity:
        Time: O(n)
        Space: O(n)
*/
int fib_polynomial_array(int n) {
    if(n < 2) return n;

    int fibNums[n];

    fibNums[0] = 0;
    fibNums[1] = 1;

    for(int i = 2; i <= n; i++) {
        fibNums[i] = fibNums[i - 1] + fibNums[i - 2]; 
    }

    return fibNums[n];
}

/*
    Optimized polynomial algorithm using sliding window
    Complexity:
        Time: O(n)
        Space: O(1)
*/
int fib_polynomial_sliding(int n) {
    if(n < 2) return n;

    int prev = 0;
    int curr = 1;

    for(int i = 2; i <= n; i++) {
        int next = prev + curr;
        prev = curr;
        curr = next;
    }

    return curr;
}

int main() {
    for (int i = 0; i <= MAX; i++) {
        printf("n = %i: %i\n", i, fib(i));
    }
}
