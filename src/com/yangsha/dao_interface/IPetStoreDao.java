package com.yangsha.dao_interface;

import com.yangsha.entity.PetStore;

public interface IPetStoreDao extends IBaseDao<PetStore> {
   public boolean hasName(String name);

}
