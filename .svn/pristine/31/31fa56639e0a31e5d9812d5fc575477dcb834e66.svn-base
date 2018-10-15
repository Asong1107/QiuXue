package com.blibli.academy.project.mapper;


import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.Role;
import com.blibli.academy.project.Business.pojo.RoleModule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author baich
 * 后台角色和老师的DAO
 */
@Repository
public interface UserDaoLast {

    /**
     *角色列表
     */
    List<Role> findRoleList();

    /**
     *更新角色数据
     */
    List<Role> findRoleData(Long roleId);
    void updateRoleId(Role role);

    /**
     *删除 角色
     */
    Boolean deleteRoleModuleId(Long roleId);
    Boolean deleteRole(Long roleId);

    /**
     *新增 角色  ------赋予角色权限
     */
    void insertRole(Role role);
    Long getInsertRoleId(String RoleName);
    void insertRoleModule(RoleModule roleModule);

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
    void updateModule(Module module);

    /**
     * 插入新的模块儿
     */
    void insertModule(Module module);

    /**
     *模块儿删除
     */
    Boolean deleteModuleId(Long id);



}
