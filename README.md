# Android SDK编写学习笔记
![cmd-markdown-logo](http://easyread.ph.126.net/0VFTTm-_JBL9K5OrGvB9-w==/7917068660175540901.jpg)

最近公司希望将来某一天能让其他人能使用公司的平台，所以要开发SDK，但是自己对这方面的经验又不足，研究了两天，稍微有点东西写下来。

* 一个全局配置类，主要得到全局上下文环境，之后会加入一些简单的配置信息。

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


