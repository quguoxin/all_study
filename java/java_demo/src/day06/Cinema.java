package day06;

import java.util.Arrays;

public class Cinema {
    public static void main(String[] args) {
        int[][] ticket = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
        };

        int row = (int) (Math.random() * 10);
        int line = (int) (Math.random() * 6);
        while (ticket[row][line] == 1) {
            System.out.println("第" + (row + 1) + "排，第" + (line + 1) + "列已售出，将为您重选！");
            row = (int) (Math.random() * 10);
            line = (int) (Math.random() * 6);
        }
        ticket[row][line] = 1;
        System.out.println("已为您随机出票！！！");
        System.out.println("********************\n万达影城\n复仇者联盟3\n日期：2018/5/14\n座位号：" + (row + 1) + "排" + (line + 1) + "号\n********************");
        System.out.println("\t\t\t\t银幕");
        System.out.println("         1  2  3  4  5  6 ");
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + (i + 1) + "排\t" + Arrays.toString(ticket[i]));
        }
    }



}
