#include <stdio.h>

#define MAX 30
#define fib fib_recursive

// Exponential (recursive) algorithm
int fib_recursive(int n) {
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fib_recursive(n - 1) + fib_recursive(n - 2);
}

// Polynomial algorithm
int fib_polynomial(int n) {
    int fibNums[n + 2];

    fibNums[0] = 0;
    fibNums[1] = 1;

    for(int i = 2; i <= n; i++) {
        fibNums[i] = fibNums[i - 1] + fibNums[i - 2]; 
    }

    return fibNums[n];
}

int main() {
    for (int i = 0; i <= MAX; i++) {
        printf("n = %i: %i\n", i, fib(i));
    }
}
