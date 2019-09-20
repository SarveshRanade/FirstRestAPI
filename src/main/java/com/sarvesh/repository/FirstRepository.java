package com.sarvesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sarvesh.domain.FirstDomain;

public interface FirstRepository extends JpaRepository<FirstDomain, Integer> {

	@Query("from FirstDomain where id=?1")
	public FirstDomain findbyid(int id);

}
