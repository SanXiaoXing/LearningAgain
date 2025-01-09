import time
from datetime import datetime, timedelta
from tqdm import tqdm

# 设置下班时间为当天的17:30:00
end_time = datetime.now().replace(hour=17, minute=30, second=0)
print(f'end_time: {end_time}')

# 循环检查当前时间，直到达到下班时间
while True:
    current_time = datetime.now()
    print(f'current_time: {current_time}')

    # 如果当前时间达到或超过下班时间，结束循环
    if current_time >= end_time:
        print("下班时间到了！")
        break

    # 计算当前时间到下班时间的剩余秒数
    remaining_seconds = (end_time - current_time).total_seconds()
    print(f'remaining_seconds: {remaining_seconds}')

    # 使用tqdm库创建进度条，倒计时剩余秒数
    for _ in tqdm(range(int(remaining_seconds)), desc="倒计时", leave=False):
        time.sleep(1)

# 使用tqdm库创建一个处理每个元素的进度条
pbar = tqdm(["a","b","c","d"])
for char in pbar:
    # 设置进度条的描述为当前处理的字符
    pbar.set_description("Processing %s" % char)
    time.sleep(1)  # 模拟处理每个字符需要1秒的时间
