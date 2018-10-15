package com.blibli.academy.project.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


/**
 * @author baich
 * Shiro的配置
 *
 */
@Configuration
@Slf4j
public class ShiroConfig {

    /**
     * shiro的拦截配置
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        log.info("shiro拦截---------ShiroConfiguration.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/login", "anon");

        /*
         * swagger 的
         */
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");

        /* 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
         * 这里设置error 拦截使没有权限的跳转至这儿
         */
        shiroFilterFactoryBean.setLoginUrl("/error");

        shiroFilterFactoryBean.setSuccessUrl("/success");

        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

          /*
        过滤链定义，从上向下顺序执行，一般将 放在最为下边  这是一个坑呢，一不小心代码就不好使了;
         authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
         */
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 告诉 shiro 我的的散列方式。
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        log.info("散列方法进入----------");
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShiroRealm myShiroRealm(){
        log.info("方法进入-------myshirorealm");
        ShiroRealm myShiroRealm = new ShiroRealm();
        //注入凭证匹配器
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }


    /**
     * 安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        log.info("安全管理方法------------");
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        // 自定义缓存实现使用redis
        securityManager.setCacheManager(cacheManager());
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        log.info("代理安全方法-------------- ");
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * @return
     * 数据库异常处理
     */
    @Bean(name="simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver
    createSimpleMappingExceptionResolver() {
        log.info("映射问题---------------");
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseError");
        mappings.setProperty("UnauthorizedException","403");
        r.setExceptionMappings(mappings);
        r.setDefaultErrorView("error");
        r.setExceptionAttribute("ex");
        return r;
    }



    /**
     * cookie对象
     * 这个参数是cookie的名称，对应前端的复选框名称= rememberMe
     * 记住我cookie生效时间30天，单位秒;
     */
    private SimpleCookie rememberMeCookie() {
        //
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // <！  - >
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }


    /**
     *  cookie管理对象;记住我功能
     *  rememberMe cookie加密的密钥建议每个项目都不一样默认AES算法密钥长度（128 256 512位
     */
    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag =="));
        return cookieRememberMeManager; }

    /**
     * redis 缓存-----登陆用户只加载一次模块儿权限
     * @return
     */
    private RedisManager redisManager() {
        return new RedisManager();
    }

    private RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager; }
}
