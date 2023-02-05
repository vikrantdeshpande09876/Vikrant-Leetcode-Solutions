class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k=0, i=0, j=0;
        double prev=0, middle=0;
        int l1=nums1.length, l2=nums2.length, mid=(int)(l1+l2)/2;
        
        while (i < l1 && j < l2 && k <= mid){
            if (nums1[i] < nums2[j]){
                prev = middle;
                middle = nums1[i++];
            }
            else{
                prev = middle;
                middle = nums2[j++];
            }
            k++;
        }
        
        while (i < l1 && k <= mid){
            prev = middle;
            middle = nums1[i++];
            k++;
        }
        
        while (j < l2 && k <= mid){
            prev = middle;
            middle = nums2[j++];
            k++;
        }
        
        return ((l1+l2)%2==0) ? (prev + middle)/2 : middle;
    }
}