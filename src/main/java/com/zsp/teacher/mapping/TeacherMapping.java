package com.zsp.teacher.mapping;

import com.zsp.teacher.entity.TbTeachetloginpovo;

/**
 * @PackageName:com.zsp.teacher.mapping
 * @ClassName:AdminMapping
 * @Description:
 * @Author 张世朋
 * @Data 2019/8/3 18:43
 */
public interface TeacherMapping {
    public TbTeachetloginpovo selectTeacherByUserName(String tlUsername);

}
