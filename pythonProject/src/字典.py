# 字典定义
from time import process_time_ns

dictName = {'Name': 'Zara', 'Age': 7, 'Class': 'First'}

# 定义空字典
dict2 = {}
dict3 = dict()

print(f"字典1的内容是{dict2},类型是{type(dict2)}")
print(f"字典2的内容是{dict3},类型是{type(dict3)}")

# 定义重复key字典
dict4 = {'Name': 'Zara', 'Age': 7, 'Name': 'Manni'}
print(f"字典4的内容是{dict4}")

dict_age = dictName['Age']
print(f"字典1中Age的值是{dict_age}")


# 定义潜逃字典
stu_score_dict = {
    'stu1': {'Chinese': 66, 'Math': 100, 'English': 90},
    'stu2': {'Chinese': 70, 'Math': 90, 'English': 100},
    'stu3': {'Chinese': 98, 'score': 82, 'English': 92}
}
print(f"字典1中的值是{stu_score_dict}")
score = stu_score_dict['stu1']['Chinese']
print(f"字典1中stu1的Chinese的值是{score}")

if __name__ == '__main__':
    print(f"字典1中的值是{stu_score_dict}")
    score = stu_score_dict['stu1']['Chinese']
    print(f"字典1中stu1的Chinese的值是{score}")
    msg_dict = {}
    msg = "aaabbbssscccc"
    for i in range (len(msg)):
        test = msg[i]
        if test not in msg_dict:
            msg_dict[test] = 1
        else:
            msg_dict[test] += 1
        print(test)
        print(msg_dict)