<%@page import="com.zhj.shopping.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%		
		CaryList carylist = (CaryList)session.getAttribute("carylist");
		List<Cary> caries = new ArrayList<Cary>();
		if(carylist==null)
		{
		out.println("carylist is empty!");
			return;
		}
		caries = carylist.getCaries();	
		for(Cary c:caries)
		{
			String strcount = request.getParameter("p"+c.getId());
			if(strcount!=null&&!strcount.trim().equals(""))
			{
				int count = Integer.parseInt(strcount);
				c.setCount(count);
			}
		}	
%>
	<center>carylist already update!</center>
	5秒后到购物车
	<div id="num"></div>
<script type="text/javascript">
		var time = 5000;	
		setInterval(function() {
			document.getElementById("num").innerHTML = time;
		time-=1000;
		if(time<=0)
		document.location.href="carylist.jsp";
		}, 1000);
</script>

