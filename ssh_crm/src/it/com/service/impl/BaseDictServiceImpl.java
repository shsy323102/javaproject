package it.com.service.impl;

import java.util.List;

import it.com.dao.BaseDictDao;
import it.com.domain.BaseDict;
import it.com.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return baseDictDao.getListByTypeCode(dict_type_code);
	}

}
