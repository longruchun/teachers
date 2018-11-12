package com.yangsha.biz_interface;

import java.util.List;

import com.yangsha.entity.Pet;

public interface IpetBiz extends IBaseBizable<Pet> {
	public List<Pet> getPetByStoreId(int storeId);
}
