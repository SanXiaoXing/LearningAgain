package cn.sanxiaoxinng;

import java.util.Random;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/27/22:57
 * @Description: 随机生成验证码
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(createRandomCode(5));
    }
    public static String createRandomCode(int n) {
        //定义一个for循环用于控制产生多少随机字符
        Random random = new Random();
        String code = "";
        for (int i = 1; i <= n; i++) {
            //定义一个随机数，用于控制产生的随机字符
            int type = random.nextInt(3);
            //将产生的随机数转换为字符
            switch (type){
                case 0:
                    //随机生成一个数字
                    code += random.nextInt(10);
                    break;
                case 1:
                    //随机生成一个小写字母
                    char ch1 = (char)(random.nextInt(26) + 97);
                    code += ch1;
                    break;
                case 2:
                    //随机生成一个大写字母
                    char ch2 = (char)(random.nextInt(26) + 65);
                    code += ch2;
                    break;
            }
        }
        return code;
    }
}
