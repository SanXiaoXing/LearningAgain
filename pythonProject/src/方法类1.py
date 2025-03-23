class Students:
    name = None
    age = None
    gender = None
    def say_hi(self):
        print(f"hi, my name is {self.name}")

    def say_hello(self, msg):
        print(f"hello, my name is {self.name}, {msg}")

if __name__ == "__main__":
    stu = Students()
    stu.name = "小明"
    stu.say_hello("how are you?")