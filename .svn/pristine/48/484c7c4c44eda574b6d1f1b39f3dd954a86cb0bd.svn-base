package com.blibli.academy.project.service.impl;



import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.mapper.TeacherDao;
import com.blibli.academy.project.service.UserServiceLast;
import com.blibli.academy.project.mapper.UserDaoLast;
import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.Role;
import com.blibli.academy.project.Business.pojo.RoleModule;
import com.blibli.academy.project.tools.LoginName;
import com.blibli.academy.project.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 *
 * @author baich
 */
@Service("secondService")
public class UserServiceLastImpl implements UserServiceLast {
    @Autowired
    UserDaoLast userDaoLast;
    @Autowired
    TeacherDao teacherDao;
    @Resource
    LoginName loginName;

    /**
     *角色列表
     */
@Override
public List<Role> findRoleList(){ return userDaoLast.findRoleList(); }

    /**
     *更新角色数据
     */
@Override
public List<Role> findRoleData(Long roleId){
    return userDaoLast.findRoleData(roleId);
}



    /**
     *删除 角色
     */
@Override
    public Boolean deleteRoleModuleId(Long roleId){ return userDaoLast.deleteRoleModuleId(roleId);}
@Override
    public Boolean deleteRole(Long roleId){
    return userDaoLast.deleteRole(roleId);
}


    /**
     *新增 角色  ------赋予角色权限
     */
@Override
    public ResponseVO insertRole(Role role){
    try {
        role.setRoleName(role.getRoleName());
        role.setCreateBy(loginName.loginName());
        role.setUpdateBy(loginName.loginName());
        role.setCreateAt(loginName.newDate());
        role.setUpdateAt(loginName.newDate());
        userDaoLast.insertRole(role);

        Long roleId = userDaoLast.getInsertRoleId(role.getRoleName());
        for(int i =0;i<role.getIntArray().length;i++){
            System.out.println("输出数组-----"+ role.getIntArray()[i]);
            RoleModule roleModule = new RoleModule();
            roleModule.setRoleId(roleId);
            roleModule.setModuleId((long) role.getIntArray()[i]);
            userDaoLast.insertRoleModule(roleModule);
        }
        return ResultUtil.success("成功");
    }catch (Exception e){
        return ResultUtil.error("插入数据错误" + e);
    } }
//@Override
//    public Long getInsertRoleId(String roleName){return userDaoLast.getInsertRoleId(roleName);}
@Override
    public ResponseVO insertRoleModule(Role role) {
    try {
        userDaoLast.updateRoleId(role);
        userDaoLast.deleteRoleModuleId(role.getRoleId());
        for (int i = 0; i < role.getIntArray().length; i++) {
            System.out.println("输出数组-----" + role.getIntArray()[i]);
            //重新写入角色权限数据
            RoleModule roleModule = new RoleModule();
            roleModule.setRoleId(role.getRoleId());
            roleModule.setModuleId((long) role.getIntArray()[i]);
            userDaoLast.insertRoleModule(roleModule);
        }
        return ResultUtil.success("角色更新成功");
    } catch (Exception e) {
        return ResultUtil.error("更新数据出错");
    }
}


    /**
     * 模块儿 列表
     */
@Override
    public List<Module> findModuleList(){
    return userDaoLast.findModuleList();
}


    /**
     * 编辑模块儿详情
     */
@Override
    public Module findModuleId(Long id){
    return userDaoLast.findModuleId(id);
}

    /**
     * 更新模块儿数据
     */
@Override
    public ResponseVO updateModule(Module module){
    try {
        module.setUpdateBy(loginName.loginName());
        module.setUpdateAt(loginName.newDate());
        userDaoLast.updateModule(module);
        return ResultUtil.success("更新成功");
    }catch (Exception e){
        return ResultUtil.error("更新数据失败" +e);
    }
}

    /**
     * 插入新的模块儿
     */
@Override
    public ResponseVO insertModule(Module module){
    try {
        module.setCreateBy(loginName.loginName());
        module.setUpdateBy(loginName.loginName());
        module.setCreateAt(loginName.newDate());
        module.setUpdateAt(loginName.newDate());
        userDaoLast.insertModule(module);
        return ResultUtil.success("模块儿添加成功");
    }catch (Exception e){
        return ResultUtil.error("插入数据失败"+e);
    }
}


    /**
     *模块儿删除
     */
@Override
    public Boolean deleteModuleId(Long id) { return userDaoLast.deleteModuleId(id); }

}
