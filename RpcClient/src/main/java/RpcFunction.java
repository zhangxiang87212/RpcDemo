import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.util.Arrays;

/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
public class RpcFunction implements InvocationHandler {
    private String host;
    private int port;

    public <T> T refer(Class<T> interfaceClass, String host, int port) throws Exception {
        this.host = host;
        this.port = port;
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] {interfaceClass}, this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //指定 provider 的 ip 和端口
        Socket socket = new Socket(this.host, this.port);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        //传方法名
        output.writeObject(method.getName());
        //传参数类型
        output.writeObject(method.getParameterTypes());
        //传参数值
        System.out.println(method.getName() + Arrays.toString(method.getParameterTypes()) + Arrays.toString(args));
        output.writeObject(args);
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        //读取结果
        return input.readObject();
    }
}
