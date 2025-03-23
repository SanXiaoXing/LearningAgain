import socket

# 创建socket
socket_server = socket.socket()

# 绑定端口
socket_server.bind(('127.0.0.1', 8888))

# 监听
socket_server.listen()

# 接收客户端连接
conn, addr = socket_server.accept()
print(f'客户端连接成功,客户端地址：{addr}')

while True:
    # 接收客户端发送的数据
    data = conn.recv(1024)
    if data.decode("UTF-8") == '/exit':
        break
    print('客户端发送的数据：', data.decode("UTF-8"))

    # 发送数据给客户端
    msg = input('请输入要发送的数据：')
    conn.send(f'欢迎用户, 返回数据是：{msg}'.encode("UTF-8"))

