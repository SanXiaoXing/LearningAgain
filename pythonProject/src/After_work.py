import time
from datetime import datetime, timedelta
from tqdm import tqdm

end_time = datetime.now().replace(hour=17, minute=30, second=0)
print(f'end_time: {end_time}')

while True:
    current_time = datetime.now()
    print(f'current_time: {current_time}')

    if current_time >= end_time:
        print("下班时间到了！")
        break

    remaining_seconds = (end_time - current_time).total_seconds()
    print(f'remaining_seconds: {remaining_seconds}')

    for _ in tqdm(range(int(remaining_seconds)), desc="倒计时", leave=False):
        time.sleep(1)

pbar = tqdm(["a","b","c","d"])
for char in pbar:
    pbar.set_description("Processing %s" % char) # 设置描述
    time.sleep(1)  # 每个任务分配1s