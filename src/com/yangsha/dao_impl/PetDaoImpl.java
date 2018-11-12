package com.yangsha.dao_impl;

import java.util.List;
import java.util.Map;

import com.yangsha.dao_interface.IPetDao;
import com.yangsha.entity.Pet;
import com.yangsha.util.JdbcHelper;

public class PetDaoImpl implements IPetDao{

	@Override
	public int add(Pet t) {
		
		String sql = "insert into pet(name,typeName,health,love,birthday,owner_Id,store_Id,price,photo) values(?,?,?,?,?,?,?,?,?)";
		int i = JdbcHelper.executeUpdate(sql, t.getName(),t.getTypeName(),t.getHealth(),t.getLove(),t.getBirthday(),t.getOwner_Id(),t.getStore_Id(),t.getPrice(),t.getPhoto());
		return i;
	}

	@Override
	public int delete(int id) {

        String sql = "delete from pet where id=?";
        int i =JdbcHelper.executeUpdate(sql, id);
		return i;
	}

	@Override
	public int update(Pet t) {
       
        String sql = "update pet set name=?,health=?,love=?,owner_Id=?,store_Id=?,price=?,photo=? where id=?";
        int i =JdbcHelper.executeUpdate(sql,t.getName(),t.getHealth(),t.getLove(),t.getOwner_Id(),t.getStore_Id(),t.getPrice(),t.getPhoto(),t.getId());
		return i;
	}

	@Override
	public List<Pet> getAll() {
		String sql = "select * from pet";
		List<Pet> list = JdbcHelper.executeQuery(sql, Pet.class);
		return list;
	}

	@Override
	public Pet getEntityById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from pet where id=?";
    	List<Pet> list = JdbcHelper.executeQuery(sql, Pet.class,id);
		return list.get(0)==null?null:list.get(0);
	}

	@Override
	public List<Pet> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		String sql="select * from pet limit ?,?";
		Object[] param= {map.get("pageOffset"),map.get("pageSize")};
		List<Pet> list = JdbcHelper.executeQuery(sql, Pet.class,param);
		return list;
	}

	@Override
	public List<Pet> getPetByStoreId(int storeId) {
		String sql="select * from pet where store_Id=?";
		Object[] param= {storeId};
		List<Pet> list = JdbcHelper.executeQuery(sql, Pet.class,param);
		return list;
	}

	@Override
	public int updateByPrimaryKeySelective(Pet t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
