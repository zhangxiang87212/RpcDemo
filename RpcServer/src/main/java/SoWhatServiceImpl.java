/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
public class SoWhatServiceImpl implements SoWhatService {
    @Override
    public String sayHello(String name, Integer age) {
        System.out.println("Provider:" + " 你好啊 " + name + ";age" + age);
        return "你好啊 " + name + ";age" + age;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("Provider:" + " 你好啊 " + name);
        return "你好啊 " + name;
    }
}
