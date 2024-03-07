package cn.sanxiaoxing.arraylist;

import java.util.ArrayList;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/03/07/21:13
 * @Description: 熟悉ArrayList提供常用方法
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        /**
         * @Author: SanXiaoXing
         * @Date: 2024/3/7 0007 21:14
         * @Description: 创建一个arraylist集合对象
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("San");
        list.add("Xiao");
        list.add("Xing");
        System.out.println(list);

        /**
         * @Author: SanXiaoXing
         * @Date: 2024/3/7 0007 21:16
         * @Description: 往集合中的某个位置添加元素
         */
        list.add(1, "XiaoXing");
        System.out.println(list);

        /**
         * @Author: SanXiaoXing
         * @Date: 2024/3/7 0007 21:18
         * @Description: 根据索引获取元素
         */
        String str = list.get(1);
        System.out.println(str);

        /**
         * @Author: SanXiaoXing
         * @Date: 2024/3/7 0007 21:18
         * @Description: 获取集合大小（返回集合中存储的元素个数）
         */
        System.out.println(list.size());

        /**
         * @Author: SanXiaoXing
         * @Date: 2024/3/7 0007 21:20
         * @Description:根据索引删除集合中的某个元素值，会返回被删除的元素值
         */
        System.out.println(list.remove(1));
        System.out.println(list);

        /**
         * @Author: SanXiaoXing
         * @Date: 2024/3/7 0007 21:22
         * @Description: 直接删除某个元素，删除成功返回true，反之
         */
        System.out.println(list.remove("Xing"));


        /**
         * @Author: SanXiaoXing
         * @Date: 2024/3/7 0007 21:24
         * @Description: 修改索引位置的数据，并将修改前的值返回
         */
        System.out.println(list.set(1, "XiaoXing"));
        System.out.println(list);
    }

}
