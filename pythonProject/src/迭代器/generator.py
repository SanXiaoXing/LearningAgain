from collections.abc import Callable, Iterable


def countdown(n: int):
    while n > 0:
        yield n
        n -= 1

def create_generator():

    # 创建生成器对象
    generator = countdown(5)

    # 通过迭代生成器获取值
    print(next(generator))  # 输出: 5
    print(next(generator))  # 输出: 4
    print(next(generator))  # 输出: 3

    # 使用 for 循环迭代生成器
    for value in generator:
        print(value)  # 输出: 2 1

if __name__ == "__main__":
    create_generator()
    x: Callable[[int, int], int] = lambda a ,b : a + b
    print(f"输出匿名函数的结果为{x(1, 2)}") # 输出匿名函数的结果为3
    num1 = [1, 2, 3, 4, 5]
    num2 = [5, 4, 3, 2, 1]
    y: Iterable[int] = list(map(lambda a ,b : a - b, num1 , num2))
    print(f"输出匿名函数的结果为{y}") # 输出匿名函数的结果为[-4, -2, 0, 2, 4]