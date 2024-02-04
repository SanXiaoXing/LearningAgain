package cn.sanxiaoxing.projo;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/02/03/15:00
 * @Description: 地址分配
 */
public class Address {

    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
