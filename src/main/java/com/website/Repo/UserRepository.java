package com.website.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.website.entity.UserEntity;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM leakage_db.users WHERE username LIKE CONCAT(:username, '%')", nativeQuery = true)
	List<UserEntity> findByUsernameSearch(@Param("username") String username);


}
