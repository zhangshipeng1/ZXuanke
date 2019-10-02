package com.zsp.student.mapping;

import com.zsp.student.entity.SelectleftTree;
import com.zsp.student.entity.UserRolPopovo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LeftTreeMapping {
    public List<UserRolPopovo> SelectPowerByUsername(UserRolPopovo userRolPopovo);
}
