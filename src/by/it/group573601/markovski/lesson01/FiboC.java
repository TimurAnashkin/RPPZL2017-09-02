package by.it.group573601.markovski.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(int n, int m){
        ArrayList<Long> ans = getPeriod(m);
        long period = ans.size() - 2; // находим размер периода Пизано
        int index = (int)(n % period);
        return ans.get(index);
    }

    ArrayList<Long> getPeriod(long m) { //метод, возвращающий список, в котором на два элемента больше, чем в периоде Пизано
        ArrayList<Long> list = new ArrayList();
        list.add((long)0);
        list.add((long)1);
        for (int i = 2; i < m*6 ; i++){
            list.add((list.get(i - 1) + list.get(i - 2)) % m);
            if (list.get(i) == 1 && list.get(i - 1) == 0){
                break;
            }
        }
        return list;
    }


}

