package assignment.stock.utils;

public class CommonUtils {

	 public static boolean isNullOrEmptyArray(double [] arr){
	    	return arr==null || arr.length <= 0 ;
    }
	 
	 public static boolean isNullOrEmptyStr(String str){
		 return str == null || str.trim().length() <= 0 ;
	 }
}
