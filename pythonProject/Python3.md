# 迭代器

迭代器是一个可以记住遍历的位置的对象。

迭代器对象从集合的第一个元素开始访问，直到所有的元素被访问完结束。迭代器只能往前不会后退。

迭代器有两个基本的方法：`iter()` 和 ` next()`。

```python
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
```

```
输出： 1 2 3 4 5
```

# 生成器

`yield` 是一个关键字，用于定义生成器函数，生成器函数是一种特殊的函数，可以在迭代过程中逐步产生值，而不是一次性返回所有结果。

```python
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
```

# `lambda` 匿名函数

`lambda` 只是一个表达式，函数体比 **def** 简单很多

```python
x = lambda a : a + 10 
```
