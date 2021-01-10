// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/10/2021

//丑数，手动维护三个排序好的数组
//2，4，6，8，10
//3，6，9，12，15
//5，10，15，20，25
//从三个数组中找到最小值加入结果数组，并移动指针
public class NthUglyNumber {
    public int nthUglyNumber(int n) {

        // 建立指针
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;

        // 建立长度为n的结果数组
        for(int i = 1; i < n; i++) {
            // 新建三个数组的最小值
            int n2 = res[a] * 2;
            int n3 = res[b] * 3;
            int n5 = res[c] * 5;

            // 将最小的值放入结果数组中
            res[i] = Math.min(Math.min(n2, n3), n5);

            // 判断并移动指针
            if(res[i] == n2) a++;
            if(res[i] == n3) b++;
            if(res[i] == n5) c++;
        }
        return res[n - 1];
    }
}
