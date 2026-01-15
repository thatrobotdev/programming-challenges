# Choose max number of fib sequence generated
MAX = 30

class Solution:
    # Exponential (recursive) algorithm
    # Complexity:
    #   Time: O(φ^n)
    #   Space: O(n)
    def fib_recursive(self, n: int) -> int:
        if n < 2: return n
        return self.fib_recursive(n - 1) + self.fib_recursive(n - 2)
    
    # Polynomial algorithm
    # Complexity:
    #   Time: O(n)
    #   Space: O(n)
    def fib_polynomial_array(self, n: int) -> int:
        if n < 2: return n;
    
        fibNums = [0, 1]

        for i in range(2, n + 1):
            fibNums.append(fibNums[i - 1] + fibNums[i - 2]);

        return fibNums[n];

if __name__ == '__main__':
    s = Solution()

    # Choose fib implementation here
    fib = s.fib_polynomial_array
    
    for i in range(MAX + 1):
        print(f"n = {i}: {fib(i)}")
