package dp.filter;

public class Main {
	
	public static void main(String[] args) {
		String str = "��Һ� ,������ѧ���ڿ�,����,��ʿ��<html>,<script>,�ͽ������ڼ�";
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
