import pyautogui
import time
import pyperclip

# 模拟逐字键盘输入
def simulate_typing_by_character(lines, first_delay, delay_between_chars):
    print(f"等待 {first_delay} 秒后开始...")
    time.sleep(first_delay)  # 开始前的等待时间

    for line in lines:
        for char in line:  # 按字符逐一输入
            if char.isprintable():  # 判断字符是否为可打印字符（避免回车等特殊字符）
                pyautogui.typewrite(char)  # 输入字符
                time.sleep(delay_between_chars)  # 每个字符的等待时间
            else:
                pyautogui.press(char)  # 输入回车等特殊字符
                time.sleep(delay_between_chars)
        pyautogui.press('enter')  # 模拟回车键
        time.sleep(delay_between_chars)  # 每行的附加等待时间

if __name__ == "__main__":
    print("请输入 YAML 内容，结束输入请按两次 Enter:")
    lines = []
    while True:
        line = input()
        if line == "":  # 检测空行结束输入
            break
        lines.append(line)

    try:
        first_delay = float(input("请输入开始前的等待时间（秒）: ").strip())
    except ValueError:
        print("无效的输入，使用默认开始等待时间 5 秒")
        first_delay = 5

    try:
        delay_between_chars = float(input("请输入每个字符输出的等待时间（秒）: ").strip())
    except ValueError:
        print("无效的输入，使用默认每个字符等待时间 0.1 秒")
        delay_between_chars = 0.1

    print(f"\n将在 {first_delay} 秒后开始键盘输入，每个字符输入间隔为 {delay_between_chars} 秒。\n")
    input("请将光标放置在目标输入区域，并按 Enter 开始...")

    # 模拟逐字键盘输入
    print("开始模拟键盘输入...")
    simulate_typing_by_character(lines, first_delay, delay_between_chars)
    print("输入完成！")
