package cn.itcast.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Customer findById(Long id) {
		
		return this.getHibernateTemplate().get(Customer.class, id);
	}

}
