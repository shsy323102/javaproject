package dp.filter;

public class Sensitivefilter implements Filter {

	public void doFilter(Request request, Response response,Filterlist fc) {
		request.strequest=request.strequest.replaceAll("����", "**")+"..sensitive..";
		response.stresponse+="..sensitive";
		fc.doFilter(request, response, fc);
	}

}
