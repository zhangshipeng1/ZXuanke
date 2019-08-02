package com.zsp.student.mapping;

import com.zsp.student.entity.SelectleftTree;
import com.zsp.student.entity.StuRolPopovo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LeftTreeMapping {
    public List<StuRolPopovo> SelectPowerByUsername(StuRolPopovo stuRolPopovo);
}
