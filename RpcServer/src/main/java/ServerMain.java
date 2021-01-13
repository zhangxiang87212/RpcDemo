/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
public class ServerMain
{
    public static void main(String[] args)
    {
        //服务提供者 暴露出接口
        SoWhatService service = new SoWhatServiceImpl();
        try
        {
            ServiceFramework.export(service, 1412);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
