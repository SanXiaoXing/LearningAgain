package cn.sanxiaoxinng;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/28/11:00
 * @Description: 模拟双色球
 */
public class Test6 {
    public static void main(String[] args) {
//        int[] usernum = input();
//        System.out.println("最终的号码是：");
//        printArray(usernum);

        int[] usernum = creatRandomNum();
        printArray(usernum);
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/1/28 0028 11:56
     * @Description: 按照格式打印出来数组
     */
    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/1/28 0028 11:57
     * @Description: 输入一个数组用于投注（前六个为红色，后六个为蓝色）
     */
    public static int[] input() {
        int[] arr = new int[7];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length - 1; i++) {

            while (true) {
                System.out.println("请输入第" + (i + 1) + "个红球号码，1-33，不能重复：");
                int num = scanner.nextInt();
                if (num > 33 || num < 1) {
                    System.out.println("输入错误，请重新输入");
                } else {
                    //判断号码是否重复
                    if (exist(arr, num)){
                        System.out.println("输入有重复，请重新输入");
                    } else {
                        arr[i] = num;
                        break;
                    }
                }
            }
        }
        //输入一个蓝球号码
        while (true) {
            System.out.println("请输入一个蓝球号码");
            int number = scanner.nextInt();
            if (number < 1 || number >16) {
                System.out.println("输入有问题，请按照正确范围输入数字");
            }else {
                arr[6] = number;
                break;
            }
        }
        return arr;
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/1/28 0028 11:57
     * @Description: 是否有重复的数字，如果有则返回true，反之
     */
    public static boolean exist(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                break;
            }
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/1/28 0028 11:58
     * @Description: 随机生成一个一组数据
     */
    public static int[] creatRandomNum() {
        int[] num = new int[7];
        Random random = new Random();
        for (int i = 0; i < num.length - 1; i++) {

            while (true) {
                // 随机生成一个红色号码，范围是1-33
                int number = random.nextInt(33) + 1;
                //判断红色号码是否重复
                if (!exist(num, number)) {
                    // 不重复，放入数组
                    num[i] = number;
                    break;
                }
            }
        }
        //随机生成一个蓝色号码，范围是1-16
        num[6] = random.nextInt(16) + 1;
        return num;
    }

    /**
     * @Author: SanXiaoXing
     * @Date: 2024/1/28 0028 11:59
     * @Description: 判断用户中将情况
     */
    public static void judge(int[] userNum, int[] luckyNum){

    }

}

