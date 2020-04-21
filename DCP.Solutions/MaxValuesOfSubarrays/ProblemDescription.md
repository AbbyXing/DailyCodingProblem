# Problem #18: Maximum Values Of Subarrays (Hard)

## Asked By:

This problem was asked by Google.

## Description:
 
Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

## Example:

For example, given array = `[10, 5, 2, 7, 8, 7]` and k = 3, we should get: `[10, 7, 8, 8]`, since:

- 10 = max(10, 5, 2)
- 7 = max(5, 2, 7)
- 8 = max(2, 7, 8)
- 8 = max(7, 8, 7)

## Note:

Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.