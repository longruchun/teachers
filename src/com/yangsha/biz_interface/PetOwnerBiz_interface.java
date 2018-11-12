package com.yangsha.biz_interface;

import java.util.List;

import com.yangsha.entity.PetOwner;

public interface PetOwnerBiz_interface extends Sellable, Buyable,IBaseBizable<PetOwner> {

	boolean login();
	
	List<PetOwner> getAll();
}
