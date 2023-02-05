class Solution {
    public String convert(String s, int numRows) {
        if (s.length()==1 || numRows==1)
            return s;
        StringBuilder res = new StringBuilder();
        int n = 0, len = s.length(), charsInSection = 2*numRows-2;
        
        for (n=0; n<numRows; n++){
            int i = n;
            while (i < len){
                res.append(s.charAt(i));
                if (n != 0 && n != numRows-1){
                    int charsInBetween = charsInSection - 2*n;
                    int j = i + charsInBetween;
                    if (j < len)
                        res.append(s.charAt(j));
                }
                i += charsInSection;
            }
        }
        
        return res.toString();
    }
}

/*
PAY,PALI,SHIR,ING  3
012,3456,7890,123
P       A       H       N
A   P   L   S   I   I   G
Y       I       R
PAHNAPLSIIGYIR

0 -> 0+n+(n-2) -> 4+n+(n-2) -> 8+n+(n-2) -> end
1 -> 1+n-(n-2) -> 3+n-(n-2) -> 5+n-(n-2) -> 7+n-(n-2) -> 9+n-(n-2) -> 11+n-(n-2) -> end
2 -> 2+n+(n-2) -> 6+n+(n-2) -> end



PAY,PA,LISH,IR,ING      4
012,34,5678,90,123
P           I           N
A       L   S       I   G
Y   A       H   R
P           I
PINALSIGYAHRPI

0 -> 0+n+(n-2) -> 6+n+(n-2) -> end
1 -> 1+n -> 5+n-(n-2) -> 7+n -> 11+n-(n-2) -> end
2 -> 2+n-2 -> 4+n -> 8+n-2 -> end
3 -> 3+n+(n-2) -> end
*/