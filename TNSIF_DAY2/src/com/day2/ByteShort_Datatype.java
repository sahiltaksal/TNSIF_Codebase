package com.day2;



public class ByteShort_Datatype {

	public static void main(String[] args) {
		/*
		 * 
		 * byte takes----- 1 byte 
		 * 
		 * 1byte = 8 bits   // 2^8
		 * 256/2
		 * 128
          
		 */
		byte bytemax=127;
		byte bytemin= -127;
		System.out.println("min range of byte is:"+bytemin+ "   "+"max values of byte is :"+ bytemax);
		
         //int -------4 byte
		
		int Maxint =2147483647;
		int minint =-2147483648;
		System.out.println("min range of int is:"+minint+ "   "+"max values of byte is :"+ Maxint);
		
		//long -------8 byte
		long maxLong = 9223372036854775807L;
        long minLong = -9223372036854775808L;
        System.out.println("Min range of long is: " + minLong + "   Max value of long is: " + maxLong);

        
        boolean flag = true;
        boolean flag2 = false;
        System.out.println("flag :" + flag + "   flag2 :" + flag2);
	}

}
