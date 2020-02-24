package build.dream.common.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Objects;

public class RpcClientProxy<T> implements InvocationHandler {
    private Socket socket;

    private Socket obtainSocket() throws IOException {
        if (Objects.nonNull(socket)) {
            return socket;
        }
        socket = new Socket();
        socket.connect(addr);
        return socket;
    }

    private Class<T> serviceInterface;
    private InetSocketAddress addr;

    public RpcClientProxy(Class<T> serviceInterface, String ip, String port) {
        this.serviceInterface = serviceInterface;
        this.addr = new InetSocketAddress(ip, Integer.parseInt(port));
    }

    public T getClientIntance() {
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Socket socket = null;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;

        try {
            // 2.创建Socket客户端，根据指定地址连接远程服务提供者
            socket = obtainSocket();

            // 3.将远程服务调用所需的接口类、方法名、参数列表等编码后发送给服务提供者
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeUTF(serviceInterface.getSimpleName());
            output.writeUTF(method.getName());
            output.writeObject(method.getParameterTypes());
            output.writeObject(args);

            // 4.同步阻塞等待服务器返回应答，获取应答后返回
            input = new ObjectInputStream(socket.getInputStream());
            return input.readObject();
        } finally {
            if (socket != null) socket.close();
            if (output != null) output.close();
            if (input != null) input.close();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int index = 0; index < 1000; index++) {
            RpcClientProxy client = new RpcClientProxy<>(IHello.class, "leopard", "6666");
            IHello hello = (IHello) client.getClientIntance();
            System.out.println(hello.sayHello("socket rpc"));
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
