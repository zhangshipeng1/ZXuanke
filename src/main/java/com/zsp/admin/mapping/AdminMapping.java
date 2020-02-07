package com.zsp.admin.mapping;

import com.zsp.admin.entity.TbAdministrator;

public interface AdminMapping {
    public TbAdministrator selectAdminByUsername(String alUsername);
}
