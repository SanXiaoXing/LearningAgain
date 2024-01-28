package cn.sanxiaoxinng.test_case;

import java.util.Scanner;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/27/23:22
 * @Description: 评委打分，数组进行选择，去掉一个最高分，去掉一个最低分，求取剩下的平均分
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.printf("当前选手的得分是：" + getAverageScore(6));
    }

    public static double getAverageScore(int number) {
        //定义一个动态数组
        int[] score = new int[number];
        //输入分数
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的打分：");
            score[i] = sc.nextInt();
        }

        int sum = 0;
        int max = score[0];
        int min = score[0];

        //求出最高分和最低分
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
            if (score[i] > max) {
                max = score[i];
            }
            if (score[i] < min) {
                min = score[i];
            }
        }
        return (sum - max - min) * 1.0 / (score.length - 2);
    }
}
