#### springboot2.x部署证书


##### 1.准备好ssl证书

我们这里是将证书合成了jks格式的，需要注意的是合成证书时，使用的`证书密码`，`证书别名`还可以合成其它格式的，并将其放到项目的根目录下，直接放resources文件夹下就好

##### 2.修改配置文件和配置类 

- 配置文件
```yml
server:
  #https监听端口
  port: 8080
  #http监听端口
  httpPort: 8888
  ssl:
    #证书路径 一般都是放在根目录
    key-store: classpath:ssl.jks
    #证书的密码
    key-password: 123456
    #证书的类型
    key-store-type: JKS
    #证书别名
    key-alias: huluwa
```

- 新增配置类
```java
@Configuration
public class HttpsConfig {

    @Value("${server.httpPort}")
    private Integer httpPort;

    @Value("${server.port}")
    private Integer httpsPort;

    @Bean
    public TomcatServletWebServerFactory servletContainer() { //springboot2 新变化

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {

            @Override
            protected void postProcessContext(Context context) {

                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
        return tomcat;
    }

    private Connector initiateHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        return connector;
    }

}
```

#### 3.本地测试

- 修改本地的host文件，将`127.0.0.1` 映射到你证书绑定的二级域名


在host文件末尾加上

```jshelllanguage
127.0.0.1  dd.fangxinqian.cn
```

我的证书绑定的是`*.fangxinqian.cn`，我本地就将`127.0.0.1`映射到了 `dd.fangxinqian.cn`

- 浏览器测试


 
我项目中暴露了一个`hello`的方法，浏览器使用`https://dd.fangxinqian.cn:8080/hello` 如果有响应就是证书部署成功啦

#### 注意

- 部署了证书以后，就不能使用`http`协议来访问项目啦，项目会强制跳转到`https`


 项目地址：https://github.com/niezhiliang/spring-boot-study/tree/master/spring-boot-https





