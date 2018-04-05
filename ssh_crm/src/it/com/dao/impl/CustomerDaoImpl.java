package it.com.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import it.com.dao.CustomerDao;
import it.com.domain.Customer;
@SuppressWarnings("all")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	public List<Object[]> indutryCount() {
		String sql ="   SELECT  bd.`dict_item_name`,COUNT(*) total"+
					"	FROM cst_customer c,base_dict bd          "+
					"	WHERE c.`cust_industry` = bd.`dict_id`    "+
					"	GROUP BY c.`cust_industry`";
                                                              
		List<Object[]> list=getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		return list;
	}	
}
