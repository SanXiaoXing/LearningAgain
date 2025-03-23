list = [1, 2, 3, 4, 5]
# 创建迭代器
creat_iterator = iter(list)
def my_iterator():
    print(next(creat_iterator))  # 输出：1
    print(next(creat_iterator))  # 输出：2

def for_iterator():
    for item in creat_iterator:
        print(item)




if __name__ == '__main__':
    my_iterator()
    for_iterator()