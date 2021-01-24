// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/21/2021

// 柠檬水找零 贪心算法
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) { //case1: 5
                five ++;

            } else if (bills[i] == 10) { // case2：10
                if (five == 0) {
                    return false;
                }
                five --;
                ten ++;

            } else { // case3:10 有10先找10，因为5可以用于更多情况
                if (five > 0 && ten > 0) {
                    five --;
                    ten --;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
