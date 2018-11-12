package com.yangsha.dao_interface;

import java.util.List;

import com.yangsha.entity.Pet;

public interface IPetDao extends IBaseDao<Pet> {
   public List<Pet> getPetByStoreId(int storeId);
}
