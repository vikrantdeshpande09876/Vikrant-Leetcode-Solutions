class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int count = 0, start = intervals[0][0], end = intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0] < end){         // overlap observed
                count++;
            }
            else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return count;
    }
}

/*
[1,2],[1,3],[2,3],[3,14],[4,6],[5,7],[6,9]
0      1      1           1     2     2

[1,2],[1,3],[2,3],[4,6],[5,7],[6,9],[3,14]

*/