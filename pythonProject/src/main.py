def list_while_func():
    """
    使用while循环遍历列表内容函数
    :return: None
    """
    my_list = ['yx', 'test', 'python', 'learning', 'css', 'javascript']
    index = 0
    while index < len(my_list):
        # 通过index取出对应下标元素
        element = my_list[index]
        print(f"列表元素：{element}")
        # 将循环加一
        index += 1


def list_for_func():
    """
    使用for循环遍历列表
    :return: None
    """
    my_list = ['yx', 'test', 'python', 'learning', 'css', 'javascript', 4]
    for element in my_list:
        print(f"列表元素：{element}")


# list_while_func()
list_for_func()
