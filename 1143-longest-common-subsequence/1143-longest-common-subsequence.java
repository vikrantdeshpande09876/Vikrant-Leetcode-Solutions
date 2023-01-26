class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] table = new int[m+1][n+1];
        for (int i=1; i<=m; i++){                //first 'i' chars chosen from text1
            for (int j=1; j<=n; j++){            //first 'j' chars chosen from text2
                // choose the max from previously computed numCommon(text1[0:iPrev], text2[0:jPrev])
                if (text1.charAt(i-1)==text2.charAt(j-1))
                    table[i][j] = table[i-1][j-1] + 1;
                else
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                // System.out.println("i="+i+"j="+j+" : "+text1.charAt(i-1)+" , "+text2.charAt(j-1)+" : "+table[i][j]);
            }
        }
        return table[m][n];
    }
}


/*
"ace" , "abade"

  .  a  b  a  d  e
. 0  0  0  0  0  0
a 0  1  1  1  1  1
c 0  1  1  2  2  2
e 0  1  1  2  2  3
*/