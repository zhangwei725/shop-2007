package com.pingxixi.proxy;

import com.pingxixi.dao.CategoryDao;
import com.pingxixi.utils.DbManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * 打开链接
 * 释放资源操作
 * 面向切面编程 实现原理
 * 统计SQL执行的时间
 */
public class DaoProxy implements InvocationHandler {
    private Object target;

    public Object newProxyInstance(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader()
                , object.getClass().getInterfaces(),
                this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object invoke = method.invoke(target, args);
        System.out.println("程序的执行时间: " + (System.currentTimeMillis() - startTime));
        return invoke;
    }
}
