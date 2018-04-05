package com.it;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
public class GetMusicName {

	/**
	 * @param ars
	 * @throws IOException 
	 */
	public static void main(String[] ars) throws IOException {

		File f = new File("D:/Music");
		FileWriter fw = new FileWriter("D:/1.txt");
	    BufferedWriter bw = new BufferedWriter(fw);
		String[] list = f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(!dir.isHidden()&&name.contains(".")){
					return true;
				}
				return false;
			}
		});
		for (String s : list) {
			int a=s.indexOf('-');
			if(a==-1){
				a=0;
			}else {
				a+=2;
			}
			int b=s.lastIndexOf('.');
			s=s.substring(a,b);
			System.out.println(s);
			bw.append(s);
			bw.newLine();
		}
		bw.close();
		fw.close();
	}

}
