// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  12/28/2020

// 一遍循环

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i>=0; i--) {
            if (digits[i] < 9) { //不需要进位时直接加一
                digits[i]++;
                return digits; //完成即可返回
            }
            digits[i]=0; //需要进位时当前位为0
        }
        int[] a = new int[digits.length+1]; //如果全部需要进位才会进行到这一步，建立新数组
        a[0]=1;
        return a;
    }
}
