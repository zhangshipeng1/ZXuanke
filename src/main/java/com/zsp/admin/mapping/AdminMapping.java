package com.zsp.admin.mapping;

import com.zsp.admin.entity.TbAdministratorloginpovo;

public interface AdminMapping {
    public TbAdministratorloginpovo selectAdminByUsername(String alUsername);
}
