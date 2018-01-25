# Android SDK编写学习笔记
![cmd-markdown-logo](http://easyread.ph.126.net/0VFTTm-_JBL9K5OrGvB9-w==/7917068660175540901.jpg)

最近公司希望将来某一天能让其他人能使用公司的平台，所以要开发SDK，但是自己对这方面的经验又不足，研究了两天，稍微有点东西写下来。

* 一个全局配置类，主要得到全局上下文环境，以后会加入一些简单的配置信息。

```
             SdkContext.init(this);

```

* 一个接口,主要用来写对外开放的方法。

```
public interface IAkiraService {

    void connect(String mac, ConnectResponse response);//连接

    void getUser(UserResponse response);//获取用户信息

}
```

* 一个接口实现类

```
/**
 * SDK接口实现类
 * Created by zhoujiaqi on 2018/1/24.
 */

public class AkiraImpl implements IAkiraService {

    @Override
    public void connect(String mac, ConnectResponse response) {
        LogUtils.v(String.format("connect %s", mac));
        response.onResponse(0,true);
    }

    @Override
    public void getUser(UserResponse response) {
        LogUtils.v("disconnect");
        UserModel userModel = new UserModel();
        userModel.setAge(10);
        userModel.setUid(10001);
        userModel.setName("仙道彰");
        response.onResponse(0,userModel);
    }

}
```
* 一个代理类，这里用了Java的动态代理模式

```
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
```



* 一个管理类，用来获取代理类的示例
```
public class Akira {

    private static IAkiraService instance;
    public static IAkiraService getInstance() {
        if (instance == null) {
            synchronized (Akira.class) {
                if (instance == null) {
                    IAkiraService service = new AkiraImpl();
                    instance = (IAkiraService) new TransactionHandler().getInstance(service);
                }
            }
        }
        return instance;
    }
}
```

* 结果返回接口，这边因为每个实现方法返回数据不一样，就设计了一个父接口支持泛型，子接口写真正返回数据类型。
为什么要这样子呢？因为别人用你的SDK的时候，你返回泛型的话，他压根不知道是什么数据。。

```
//父接口
public interface TResponse<T> {
    void onResponse(int code, T data);
}
//子接口
public interface UserResponse extends TResponse<UserModel> {

}
```
* 最后在我们的项目中测试使用

```
//先再Application中初始化
public class MyApplication extends Application {

    private static MyApplication instance;
    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SdkContext.init(this);
    }
}


//Activity中使用
 btn_getuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Akira.getInstance().getUser(new UserResponse() {
                    @Override
                    public void onResponse(int code, UserModel data) {
                        LogUtils.e(data.toString()+"");
                        tv_detail.setText(data.toString());
                    }
                });

            }
        });

```


* 明天继续学习。。。还是不清楚大厂的SDK怎么做的,哎。。。。。。












