class Student:
    def __init__(self, name, age, addr):
        self.name = name
        self.age = age
        self.addr = addr
if __name__ == '__main__':
    for i in range(3):
        print(f"当前录入的第{i+1}个学生信息")
        name = input("请输入学生姓名：")
        age = int(input("请输入学生年龄："))
        addr = input("请输入学生地址：")
        print(f"学生{ i + 1}信息录入完成，信息为「学生姓名：{name}，学生年龄：{age}，学生地址：{addr}」")