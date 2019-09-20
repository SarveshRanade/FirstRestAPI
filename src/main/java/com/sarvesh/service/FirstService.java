package com.sarvesh.service;

import java.util.List;

import com.sarvesh.domain.FirstDomain;

public interface FirstService {
	public FirstDomain create(FirstDomain firstDomain);

	public FirstDomain update(FirstDomain firstDomain);

	public FirstDomain delete(int id);

	public FirstDomain findbyid(int id);

	public List<FirstDomain> getAll();

}
