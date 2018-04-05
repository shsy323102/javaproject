package it.com.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import it.com.domain.Customer;
import it.com.service.CustomerService;
import it.com.service.impl.CustomerServiceImp;

@WebServlet("/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String cust_name = request.getParameter("cust_name");
	DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
	
	if(cust_name!=null&&!cust_name.equals("")){
		dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
	
	}
	List<Customer> list = customerService.ListAll(dc);
	request.setAttribute("list",list);
	request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
