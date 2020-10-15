package com.revature.bankAPI.dao.interfaces;

public interface GenericBankAPIreadDAO<T> {
	public T get(int id);
}
