#include <stdio.h>

// Unoptomized Bubble Sort
void sortColors(int* nums, int numsSize) {
    for (int i = 0; i < numsSize; i++) {
        for (int j = 0; j < numsSize - 1; j++) {
            if(nums[j] > nums[j + 1]) {
                // swap
                int temp = nums[j + 1];
                nums[j + 1] = nums[j];
                nums[j] = temp;
            }
        }
    }
}

void printNums(int* nums, int numsSize) {
    printf("[");

    for (int i = 0; i < numsSize - 1; i++) {
        printf("%i, ", nums[i]);
    }

    printf("%i]\n", nums[numsSize - 1]);
}

void evaluateCase(int* nums, int* expected, int numsSize) {
    printf("Input: nums = ");

    printNums(nums, numsSize);

    printf("Output: ");

    sortColors(nums, numsSize);

    printNums(nums, numsSize);

    printf("Expected: ");

    printNums(expected, numsSize);

    printf("\n");
}

int main() {
    int nums1[] = {0, 2, 1, 1, 1, 0};
    int expected1[] = {0, 0, 1, 1, 1, 2};
    int numsSize = sizeof(nums1) / sizeof(nums1[0]);

    evaluateCase(nums1, expected1, numsSize);

    int nums2[] = {1, 1, 0};
    int expected2[] = {0, 1, 1};
    numsSize = sizeof(nums2) / sizeof(nums2[0]);

    evaluateCase(nums2, expected2, numsSize);
}
