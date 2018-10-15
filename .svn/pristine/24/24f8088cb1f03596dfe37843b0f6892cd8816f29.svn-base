package com.blibli.academy.project.config;

import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.UserService;
import com.blibli.academy.project.service.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author baich
 * shiro的配置域----------主要是身份的验证和权限的分配
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserServices userServices;


    /**主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        log.info("身份验证---- MyShiroRealm.doGetAuthenticationInfo()");

        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();

        log.info("有没有token证书   "+ token.getCredentials());
        /*
         *通过username从数据库中查找 User对象，如果找到，没找到.
         *实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
         */
        UserService userservice = userServices.findUsername(username);
       log.info("----->>userInfo=  "+userservice);
        if(userservice == null){
            return null;
        }
        return new SimpleAuthenticationInfo(
                userservice,
                userservice.getPassword(),
                ByteSource.Util.bytes(userservice.getUsername()),
                getName()
        );
    }


    /**
     *  角色身份授权。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        /*
         *因为shiro中可以同时配置多个Realm，所以身份信息就可以有多个;
         * 所以 PrincipalCollection是用来聚合 身份信息的。
         */
        UserService userService =null;
        try {
        userService  = (UserService) principals.getPrimaryPrincipal();
        authorizationInfo.addRole(userService.getRoleName());
        }catch (Exception e){
            log.info("角色注入授权失败");
        }

        //循环这个角色的 所有权限， 并把这个角色的权限添加到     授权权限信息中。
        Long id = userServices.findUserId(userService.getRoleName());
        log.info("获取用户 ID ---" + id);
        List<Module> module =  userServices.findUserModule(id);
                for(Module m :module){
                    //不能添加null到 权限分配中-------------------
                    if(m.getPermission()!=null){
                        authorizationInfo.addStringPermission(m.getPermission());
                        log.info("查看角色的模块儿信息---" +m.getPermission());
                    }
                }
        return authorizationInfo;
    }
}
