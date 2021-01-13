/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
public class RunMain {
    public static void main(String[] args) {
        try {
            RpcFunction rpcFunction = new RpcFunction();
            //服务调用者 需要设置依赖
            SoWhatService service = rpcFunction.refer(SoWhatService.class, "127.0.0.1", 1412);
            System.out.println("Consumer: " + service.sayHello(" sowhat1412", 33));
            System.out.println("Consumer: " + service.sayHello(" sowhat1412"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
