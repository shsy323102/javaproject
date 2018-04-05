package dp.filter;
import java.util.ArrayList;
import java.util.List;

public class Filterlist implements Filter {
	int index = 0;
   List<Filter> filters = new ArrayList<Filter>();
   public void add(Filter f){
	   filters.add(f);
   }
	public void doFilter(Request request, Response response,Filterlist fc) {
		if(index==filters.size()) 
			return;
		Filter f = filters.get(index);
		index++;
		f.doFilter(request, response, fc);
	}

}
