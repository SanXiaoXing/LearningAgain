import sys
List = [1, 2, 3, 4, 5]
# 创建迭代器
creat_iterator = iter(List)

while True:
    try:
        print(next(creat_iterator))
    except StopIteration:
        sys.exit()