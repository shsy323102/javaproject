package dp.filter;

public class Main {
	
	public static void main(String[] args) {
		String str = "大家好 ,北京尚学堂授课,敏感,马士兵<html>,<script>,就今天星期几";
		Request req = new Request();
		req.setStrequest(str);
		Response res = new Response();
		res.setStresponse("response");
		Filterlist fc = new Filterlist();
		fc.add(new Htmlfilter());
		fc.add(new Sensitivefilter());
		fc.doFilter(req, res,fc);
		System.out.println(req.getStrequest());
		System.out.println(res.getStresponse());
	}

}
