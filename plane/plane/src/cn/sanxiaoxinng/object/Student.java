package cn.sanxiaoxinng.object;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/28/13:17
 * @Description: 统计学生的成绩
 */
public class Student {
    String name;
    double chineseScore;
    double mathScore;

    public void printScore(){
        System.out.println( name + " 的语文成绩是: " + chineseScore + " ，数学成绩是: " + mathScore + " ,总成绩为： " + (chineseScore + mathScore) );
    }
    public void printAverage(){
        System.out.println(name + " 平均成绩是: " + (chineseScore + mathScore) / 2.0);
    }
}
