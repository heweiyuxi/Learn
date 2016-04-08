package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		testDate();
		
		
	}
	
	private static void testDate(){

		List<String> str = new ArrayList<String>();
		System.out.println(formatDateTime(System.currentTimeMillis()));
		for(int i=0;i<10000;i++){
			str.add(String.valueOf(i));
		}
		System.out.println(formatDateTime(System.currentTimeMillis()));
		
	}
	private static String formatDateTime(long dateTime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
		return sdf.format(dateTime);
	}

}
