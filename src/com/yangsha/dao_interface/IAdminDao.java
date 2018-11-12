package com.yangsha.dao_interface;

import com.yangsha.entity.Admin;

public interface IAdminDao extends IBaseDao<Admin> {
   Admin getEntityByName(String name);
}
