package com.yangsha.biz_interface;

import com.yangsha.entity.Admin;

public interface IAdminBizable extends IBaseBizable<Admin> {
	Admin getEntityByName(String name);
	Admin login(String name,String password);
}
