package com.blibli.academy.project.service;





import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.Role;
import com.blibli.academy.project.Business.pojo.RoleModule;
import com.blibli.academy.project.codeconst.ResponseVO;

import java.util.List;

/**
 * 后台管理的 后两个模块儿接口-------------角色管理 和 模块儿管理------------
 * @author baich
 */
public interface UserServiceLast {
    /**
     *角色列表
     */
    List<Role> findRoleList();

    /**
     *更新角色数据
     */
   List<Role> findRoleData(Long roleId);



    /**
     *删除 角色
     */
    Boolean deleteRoleModuleId(Long roleId);
    Boolean deleteRole(Long roleId);

    /**
     *新增 角色  ------赋予角色权限
     */
    ResponseVO insertRole(Role role);

//    Long getInsertRoleId(String RoleName);
//
    ResponseVO insertRoleModule(Role role);


    /**
     * 模块儿 列表
     */
   List<Module> findModuleList();

    /**
     * 编辑模块儿详情
     */
    Module findModuleId(Long id);

    /**
     * 更新模块儿数据
     */

    ResponseVO updateModule(Module module);

    /**
     * 插入新的模块儿
     */
    ResponseVO insertModule(Module module);

    /**
     *模块儿删除
     */
    Boolean deleteModuleId(Long id);

}
