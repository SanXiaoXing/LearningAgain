class Phone:
    # 定义一个私有变量__is_5G_enable，用于表示5G功能是否启用
    __is_5G_enable = False

    def __check_5G(self):
        """
        检查5G功能是否已启用
        """
        if self.__is_5G_enable:
            print("5G is enabled")
        else:
            print("5G is disabled")

    def call_by_5G(self):
        """
        使用5G进行通话
        首先调用__check_5G方法检查5G功能是否已启用，然后进行通话
        """
        self.__check_5G()
        print("正在通话中")


if __name__ == '__main__':
    # 创建一个Phone类的实例
    phone = Phone()
    # 调用call_by_5G方法进行通话
    phone.call_by_5G()
