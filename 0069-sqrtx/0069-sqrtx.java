class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        if (x == 2)
            return 1;
        
        int l = 2, r = x/2, mid = 0;
        while (l <= r){
            mid = (int) (l+r)/2;
            int sqr = x/mid;
            if (sqr == mid)
                return mid;
            if (sqr > mid)
                l = mid+1;
            else
                r = mid-1;
        }
        return l-1;
    }
}
/*
8
3,2
3
*/