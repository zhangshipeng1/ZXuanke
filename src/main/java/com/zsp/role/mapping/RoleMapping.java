package com.zsp.role.mapping;

import javax.management.relation.Role;
import java.util.List;

/**
 * @PackageName:com.zsp.role.mapping
 * @ClassName:RoleMapping
 * @Description:
 * @Author 张世朋
 * @Data 2019/8/3 9:45
 */
public interface RoleMapping {
    public List<Role> selectRoleByuserid(String sl);
}
