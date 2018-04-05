package it.com.web.action;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import it.com.domain.Customer;
import it.com.domain.SaleVisit;
import it.com.domain.User;
import it.com.service.SaleVisitService;
import it.com.utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{

	private Integer currentPage;
	private Integer pageSize;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	private SaleVisitService saleVisitService;
	private SaleVisit saleVisit = new SaleVisit();
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}

	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
		}
		
		PageBean pb = saleVisitService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}

	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		saleVisitService.save(saleVisit);
		return "toList";
	}

	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	
	public String toEdit()throws Exception{
		SaleVisit s = saleVisitService.getById(saleVisit.getVisit_id());
		ActionContext.getContext().put("saleVisit",s);
		return "toEdit";
	}
}
