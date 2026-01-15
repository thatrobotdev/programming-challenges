MAX = 30

class Solution:
    # Exponential (recursive) algorithm
    def fib(self, n: int) -> int:
        if n == 0: return 0
        if n == 1: return 1
        return self.fib(n - 1) + self.fib(n - 2)

if __name__ == '__main__':
    s = Solution()
    
    for i in range(MAX + 1):
        print("n = " + str(i) + ": " + str(s.fib(i)))
