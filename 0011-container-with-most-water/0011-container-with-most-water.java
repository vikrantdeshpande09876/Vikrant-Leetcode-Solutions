class Solution {
    public int maxArea(int[] height) {
        int n=height.length, l=0, r=n-1;
        int area = Integer.MIN_VALUE;
        while (l < r){
            area = Math.max(area, (r-l)*Math.min(height[r], height[l]));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return area;
    }
}