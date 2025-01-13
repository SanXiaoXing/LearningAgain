import yaml
import pyautogui
import time
import pyperclip

# 从 YAML 字符串中解析内容
def parse_yaml(yaml_content):
    try:
        return yaml.safe_load(yaml_content)
    except Exception as e:
        print(f"解析 YAML 内容失败: {e}")
        return None

# 模拟键盘逐行输入，带缩进处理
def simulate_typing(data, delay, indent_level=0):
    indent = "  " * indent_level  # 每层缩进两个空格
    if isinstance(data, dict):
        for key, value in data.items():
            if isinstance(value, (dict, list)):
                pyautogui.typewrite(f"{indent}{key}:")
                pyautogui.press('enter')
                simulate_typing(value, delay, indent_level + 1)  # 递归处理嵌套数据
            else:
                pyautogui.typewrite(f"{indent}{key}: {value}")
                pyautogui.press('enter')
            time.sleep(delay)
    elif isinstance(data, list):
        for item in data:
            if isinstance(item, (dict, list)):
                pyautogui.typewrite(f"{indent}-")
                pyautogui.press('enter')
                simulate_typing(item, delay, indent_level + 1)  # 递归处理嵌套数据
            else:
                pyautogui.typewrite(f"{indent}- {item}")
                pyautogui.press('enter')
            time.sleep(delay)
    else:
        # 使用剪贴板输入中文字符
        pyperclip.copy(f"{indent}{data}")  # 将内容复制到剪贴板
        pyautogui.hotkey('ctrl', 'v')  # 粘贴到目标区域
        pyautogui.press('enter')
        time.sleep(delay)

if __name__ == "__main__":
    # 输入 YAML 内容
    print("请输入 YAML 内容，结束输入请按两次 Enter:")
    lines = []
    while True:
        line = input()
        if line == "":  # 检测空行结束输入
            break
        lines.append(line)

    yaml_content = "\n".join(lines)

    # 解析等待时间
    try:
        first_delay = float(input("请输入开始前的等待时间（秒）: ").strip())
    except ValueError:
        print("无效的输入，使用默认开始等待时间 5 秒")
        first_delay = 5

    try:
        delay_between_lines = float(input("请输入每行输出的等待时间（秒）: ").strip())
    except ValueError:
        print("无效的输入，使用默认每行等待时间 1 秒")
        delay_between_lines = 1

    print(f"\n将在 {first_delay} 秒后开始键盘输入，每行输入间隔为 {delay_between_lines} 秒。\n")

    # 提示用户准备好输入窗口
    input("请将光标放置在目标输入区域，并按 Enter 开始...")

    # 开始前的等待时间
    print(f"等待 {first_delay} 秒后开始...")
    time.sleep(first_delay)

    # 解析 YAML 内容
    parsed_data = parse_yaml(yaml_content)

    if parsed_data is not None:
        print("开始模拟键盘输入...")
        simulate_typing(parsed_data, delay_between_lines)
        print("输入完成！")
    else:
        print("解析 YAML 内容失败，脚本已终止。")
