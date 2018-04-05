<%@page import="com.zhj.shopping.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%		
		CaryList carylist = (CaryList)session.getAttribute("carylist");
		if(carylist==null){
			carylist = new CaryList();
			session.setAttribute("carylist",carylist);
		}	
		String strid=request.getParameter("id");
		if(strid!=null&&!strid.trim().equals("")){
			int id =Integer.parseInt(strid);
			Product p = ProductMgr.getinstance().productLoadById(id);
			Cary c = new Cary();
			c.setId(id);
			c.setName(p.getName());
			c.setCount(1);
			c.setPrice(p.getNormalprice());
			carylist.add(c);
		}
		response.sendRedirect("carylist.jsp");
%>
