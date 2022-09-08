package com.skillstorm.hook.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.hook.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
	
	@Query("from Users u where u.username like CONCAT('%',:username,'%') AND u.password like CONCAT ('%',:password,'%')")
	public Users findByUsernameAndPassword(@Param(value="username") String username,@Param(value="password") String password);
	

	
	@Query("from Users u where u.username =[:username]")
	public Users findByUsername(@Param(value="username") String username);
	
	
}
