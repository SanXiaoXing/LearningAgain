package cn.sanxiaoxinng;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/28/10:49
 * @Description: 打印三角形
 * @Output:
 *
 *      *
 *     * *
 *    * * *
 *   * * * *
 *  * * * * *
 *
 *
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 */
public class Test5 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < (n - i) ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= (2*i - 1); j++) {
//                System.out.print("*");
                System.out.print(j % 2 == 0 ? " " : "*");
            }
            System.out.println();
        }
    }
}
