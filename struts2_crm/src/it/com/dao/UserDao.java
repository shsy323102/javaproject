package it.com.dao;

import it.com.domain.User;

public interface UserDao {

	User getByUserCode(String user_code);

}
