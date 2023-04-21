
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.

 

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.


Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
  
  
 
explanation:

-> as we can return any peak value, we can take the advantage of this. 
-> we can say that the array is the sequence of the mountains.
-> while we are using the binary search, we will enter into any one of the mountain.
  
  lets consider this is the only mountain having the peak that we return. 
  
  it has three forms:
      1 2 3 4 5          5 4 3 2 1       1 4 6 3 2
        
      from this we can say that 
         - if  ele < next ele  ==> peak is right to it
                  we can eleminate the elements that are left to it
         - if  ele > next ele  ==> peak is left to it or it can be the peak
                  we can eleminate the elements that are right to it  
                  
      this is the algorithm that we use in the binary search.
         
         
         
  
  
Iterative method : 
  
class Solution {
   public int findPeakElement(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        int left = 0, right = nums.length - 1;
        int mid = 0;

        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}



recursive method:


class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int left, int right){
        if(left == right) {
            return left;
        }

        int mid = (left + right) / 2;

        if(nums[mid] > nums[mid + 1]){
            return search(nums, left, mid);
        } 
        return search(nums, mid + 1, right);
    }
}
