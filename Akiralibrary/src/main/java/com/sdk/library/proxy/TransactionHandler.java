package com.sdk.library.proxy;

import com.sdk.library.Utils.LogUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public class TransactionHandler implements InvocationHandler {



    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class clazz = target.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }



    //当通过代理类的对象发起对重写的方法的调用时，都会转为对如下的invoke方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //method方法的返回值是returnVal
        LogUtils.e("++++++before " + method.getName() + "++++++");
        Object returnVal = method.invoke(target, args);
        LogUtils.e("++++++after " + method.getName() + "++++++");
        return returnVal;
    }
}
