package dp.filter;

public class Sensitivefilter implements Filter {

	public void doFilter(Request request, Response response,Filterlist fc) {
		request.strequest=request.strequest.replaceAll("√Ù∏–", "**")+"..sensitive..";
		response.stresponse+="..sensitive";
		fc.doFilter(request, response, fc);
	}

}
