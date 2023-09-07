class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0, r=letters.length-1;
        
        if (target >= letters[r] || target < letters[l])
            return letters[l];
        
        while (l <= r){
            int mid = (int)(l+r)/2;
            if (mid > 0 && letters[mid-1] <= target && letters[mid] > target)
                return letters[mid];
            if (letters[mid] <= target)
                l = mid+1;
            else if (letters[mid] > target)
                r = mid-1;
        }
        
        return letters[l];
    }
}

/*
"e"
"e","e","e","k","q","q","q","v","v","y"

*/