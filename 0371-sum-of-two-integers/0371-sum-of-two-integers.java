class Solution {
    public int getSum(int a, int b) {
        while (b != 0){
            int xor = a ^ b;
            int carry = a & b;
            a = xor;
            b = carry << 1;
        }
        return a;
    }
}