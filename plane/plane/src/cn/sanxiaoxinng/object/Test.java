package cn.sanxiaoxinng.object;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/28/13:27
 * @Description: 用于测试
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "SanXiaoXing";
        student.chineseScore = 100.00;
        student.mathScore = 150.00;
        student.printScore();
        student.printAverage();
    }
}
