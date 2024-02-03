package cn.sanxiaoxinng.constructor;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/28/20:53
 * @Description: 构造器使用______________快捷键 `Alt` + `Insert`
 */
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    double height;
    public Student(){
        System.out.println("无参构造器");
    }
    public Student(String name){
        System.out.println("有参构造器");
    }

    public Student(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

}
