package com.zsp.realms;

import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @PackageName:com.zsp.realms
 * @ClassName:MyRealm
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/21 10:02
 */
@Service
public class MyRealm extends AuthorizingRealm {
    @Resource
    private LoginService loginService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1= (UsernamePasswordToken) token;
        String username=token1.getUsername ();
        AuthenticationInfo info=null;
        TbUserloginpovo tbUserloginpovo=loginService.userLogin (username);
        ByteSource salt=ByteSource.Util.bytes(tbUserloginpovo.getSlUsername ()+tbUserloginpovo.getSlId ());
        SecurityUtils.getSubject ().getSession ().setAttribute ("user",tbUserloginpovo);
        SimpleHash sh=new SimpleHash("MD5", token1.getPassword (), salt, 1024);
        if(tbUserloginpovo!=null && token1.getPassword ()!=null && tbUserloginpovo.getSlPassword ().toString ().equals (sh.toString ())){

         info=new SimpleAuthenticationInfo (tbUserloginpovo.getSlUsername (),tbUserloginpovo.getSlPassword (),salt,getName ());

       }
        return info;
    }
//产生加密的值
    public static void main(String[] args) {

        ByteSource salt=ByteSource.Util.bytes("2"+"1002");

        SimpleHash sh=new SimpleHash("MD5", "1", salt, 1024);
        System.out.println(sh);
    }
}
