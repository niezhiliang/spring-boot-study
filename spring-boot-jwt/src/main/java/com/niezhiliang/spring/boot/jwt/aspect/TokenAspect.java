package com.niezhiliang.spring.boot.jwt.aspect;

import com.niezhiliang.spring.boot.jwt.domain.User;
import com.niezhiliang.spring.boot.jwt.exception.TokenException;
import com.niezhiliang.spring.boot.jwt.repository.UserRepository;
import com.niezhiliang.spring.boot.jwt.utils.JWTUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/29 上午11:14
 */
@Component
@Aspect
public class TokenAspect {

    private static final String TOKEN = "Authentication";

    private AntPathMatcher pathMatcher = new AntPathMatcher();
    /**
     * 匿名方法列表
     */
    @Value("${jwt.whiteLists}")
    private List<String> whiteLists;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    @Pointcut("within(com.niezhiliang.spring.boot.jwt.controller..* )")
    public void checkToken () {}

    @Before("checkToken()")
    public void checkToken (JoinPoint joinPoint) {
        //如果在白名单 跳过token校验
        boolean flag = false;
        for (String u : whiteLists) {
            if (pathMatcher.match(u, request.getRequestURI())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            //校验token合法性
            chkToken(request);
        }
    }


    private void chkToken(HttpServletRequest request) {

        String token = request.getHeader(TOKEN);
        if (token == null || "".equals(token)) {
            throw new TokenException(1,"token不能为空");
        }
        //通过token获取用户名
        String userName = JWTUtils.getUserName(token);
        //通过用户名查出该用户
        User user = userRepository.findUserByAccount(userName);
        if (user == null || !JWTUtils.checkToken(token,userName,user.getPassword())) {
            throw new TokenException(2,"token不合法或已经失效，请重新获取");
        }

    }
}
