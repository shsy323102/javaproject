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
import it.com.domain.LinkMan;
import it.com.service.LinkManService;
import it.com.service.impl.LinkManServicelmp;
@WebServlet("/ListLinkManServlet")
public class ListLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService LinkManService = new LinkManServicelmp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String lkm_name = request.getParameter("lkm_name");
	DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
	
	if(lkm_name!=null&&!lkm_name.equals("")){
		dc.add(Restrictions.like("lkm_name","%"+lkm_name+"%"));
	
	}
	List<LinkMan> list = LinkManService.ListAll(dc);
	request.setAttribute("list",list);
	request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
