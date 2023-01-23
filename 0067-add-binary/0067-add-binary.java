class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        int i = a.length()-1, j = b.length()-1;
        boolean carryOver = false;
        while (i>=0 && j>=0){
            if (a.charAt(i)=='1' && b.charAt(j)=='1'){
                res.append(carryOver ? '1' : '0');
                carryOver = true;
            }
            else if (a.charAt(i)=='0' && b.charAt(j)=='0'){
                res.append(carryOver ? '1' : '0');
                carryOver = false;
            }
            else {
                res.append(carryOver ? '0' : '1');
            }
            i--;
            j--;
        }
        
        while (i>=0){
            if (a.charAt(i)=='1'){
                res.append(carryOver ? '0' : '1');
            }
            else if (a.charAt(i)=='0'){
                res.append(carryOver ? '1' : '0');
                carryOver = false;
            }
            i--;
        }
        
        
        while (j>=0){
            if (b.charAt(j)=='1'){
                res.append(carryOver ? '0' : '1');
            }
            else if (b.charAt(j)=='0'){
                res.append(carryOver ? '1' : '0');
                carryOver = false;
            }
            j--;
        }
        
        if (carryOver)
            res.append('1');
        
        return res.reverse().toString();
    }
}