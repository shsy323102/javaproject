package dp.strategy;

public class DateSorter {
	public static void sort(Comparable[] o){
		for(int i=1;i<o.length;i++){
			for(int j=0;j<o.length-1;j++){
				if(o[j].compareto(o[j+1])==1){
					Comparable Comparable = o[j];
					o[j]=o[j+1];
					o[j+1]=Comparable;
				}
			}
		}
	}
	public static void print(Object[] o){
		for(int i=0;i<o.length;i++){
			System.out.print(o[i]);
		}
	}
}
