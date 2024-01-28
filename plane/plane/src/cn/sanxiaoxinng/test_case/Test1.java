package cn.sanxiaoxinng.test_case;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/01/27/22:44
 * @Description: 预定飞机票
 */
public class Test1 {
    public static void main(String[] args) {
        double price = getTicketPrice(1000, 11, "经济舱");
        System.out.println("价格为：" + price);
    }

    public static double getTicketPrice(double price, int month, String type) {
        //判断是否是旺季
        if (month >= 5 && month <= 10 ) {
            //旺季
            switch (type){
                case "头等舱":
                    price *= 0.9;
                    break;
                case "经济舱":
                    price *= 0.85;
                    break;
            }
        }else {
            //非旺季
            switch (type){
                case "头等舱":
                    price *= 0.7;
                    break;
                case "经济舱":
                    price *= 0.65;
                    break;
            }
        }
        return price;
    }
}
