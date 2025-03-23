import socket

socket_client = socket.socket()
# 连接服务器
socket_client.connect(("127.0.0.1", 8888))

# 发送数据
while True:
    data = input('请输入要发送的数据：')
    socket_client.send(data.encode('utf-8'))
    if data == '/exit':
        break
    # 接收数据
    data = socket_client.recv(1024)
    print('接收到的数据为：', data.decode('utf-8'))

# 关闭连接
socket_client.close()