package com.sarvesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarvesh.domain.FirstDomain;
import com.sarvesh.repository.FirstRepository;

@Service
public class FirstServiceImpl implements FirstService {

	@Autowired
	FirstRepository firstRepository;

	public FirstDomain create(FirstDomain firstDomain) {
		return firstRepository.save(firstDomain);
	}

	public FirstDomain update(FirstDomain firstDomain) {
		// TODO Auto-generated method stub
		return null;
	}

	public FirstDomain delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public FirstDomain findbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FirstDomain> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
