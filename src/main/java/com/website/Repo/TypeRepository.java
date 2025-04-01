package com.website.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.entity.TypeEntity;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {

}
