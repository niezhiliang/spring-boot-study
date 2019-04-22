#### 我的第一个springboot项目

在开始写博客之前，先吐槽一下，以前开发都是使用`springmvc`,各种xml配置文件非常繁杂，各种操蛋，以前搭建一个`springmvc`框架得大半天，这里复制一点，
别的地方复制一点，到你复制完成以后，把它放到容器中启动起来，各种报错，各种看不懂，说实话，我到现在都搭不起一个`springmvc`的框架,好在springboot横空出世
，拯救了一大波像我这样的渣渣。一个main方法就启动了一个项目。使用了springboot以后整个世界都变好啦。再也不想用springmvc来开发啦。

##### 1.使用idea开发工具创建一个Maven项目

这里我们就叫`spring-boot-first-demo`,项目目录如下：





##### 2.添加springboot启动的最简依赖配置文件如下

```xml
    <groupId>com.niezhiliang</groupId>
    <artifactId>spring-boot-first-demo</artifactId>
    <version>1.0-SNAPSHOT</version>
    
    <!-- springboot父依赖,提供相关的Maven默认依赖,这样就可以省略version -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.3.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```


#### 3.编写启动类

在项目最外层创建一个`Application.java`

```java
@SpringBootApplication//springboot启动的注解，这个一定不能少
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
```

#### 4.编写向外暴露的controller接口

为了简化项目的结构，我们继续在启动类里面写`controller`的代码，完整的代码如下

```java
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @RequestMapping(value = "/")
    public String index() {
        return "hello springboot";
    }

}
```

#### 5.运行`Application`的`main`方法，启动`springboot`项目

在浏览器访问：`127.0.0.1:8080/`，如果出现了 `hello springboot` 说明你成功啦。


#### 6.注意

- springboot默认的端口也是`8080`，如果想修改，直接在resources目录创建一个`application.yml`

`yml`是一种配置文件编写的语法，我们以前一般用到的都是`.propertits`文件，`yml`可以让配置看起来更简洁，看起来舒服很多。
内容如下：

```yml
server:
  port: 8088
```

