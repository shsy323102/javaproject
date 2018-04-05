package dp.filter;

public class Htmlfilter implements Filter {


	public void doFilter(Request request, Response response,Filterlist fc) {
		request.strequest=request.strequest.replaceAll("<","[").replaceAll(">","]")+"..html..";
		response.stresponse+="..reponse..";
		fc.doFilter(request, response, fc);
	}
}
