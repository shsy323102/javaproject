package it.com.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import it.com.domain.LinkMan;
import it.com.service.LinkManService;
import it.com.service.impl.LinkManServicelmp;

@WebServlet("/AddLinkManServlet")
public class AddLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService lms=new LinkManServicelmp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkMan lm = new LinkMan();
		try {
			BeanUtils.populate(lm, request.getParameterMap());
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		lms.save(lm);
		response.sendRedirect(request.getContextPath()+"/ListLinkManServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
