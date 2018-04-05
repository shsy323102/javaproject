package cn.itcast.crm.dao;

import cn.itcast.crm.entity.Customer;

public interface CustomerDao {
	/**
	 * 根据ID获取客户信息
	 * @param id
	 * @return
	 */
	public Customer findById(Long id);

}
