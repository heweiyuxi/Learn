package com.green.he.nio.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteFile {

	
	
	public static void main(String[] args) {
		/*byte [] message = {'a','b','c'};
		
		try {
			FileOutputStream fos =  new FileOutputStream("E:/test.txt");
			FileChannel fc = fos.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate( 1024 );

			for (int i=0; i<message.length; ++i) {
			     buffer.put( message[i] );
			}
			buffer.flip();
			fc.write(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		byte a ='a';
		System.out.println(a);
		
	}

}
