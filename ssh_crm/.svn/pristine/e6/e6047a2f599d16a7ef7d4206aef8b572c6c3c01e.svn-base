package it.com.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import it.com.dao.BaseDictDao;
import it.com.domain.BaseDict;
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao  {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);	
		return list;
	}

}
