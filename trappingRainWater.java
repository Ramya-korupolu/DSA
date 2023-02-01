class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];        
        int[] rightMax = new int[height.length];        
        int n = height.length;
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[n - i - 1] = Math.max(height[n - i - 1], rightMax[n - i]);
        }

        int waterTrapped = 0;
        for(int i = 1; i < n - 1; i++){
            waterTrapped += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return waterTrapped;
    }
}
