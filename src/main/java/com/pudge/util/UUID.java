package com.pudge.util;

public class UUID {
	
	  /**
     * 获取32位唯一ID.
     * 
     * @return the uUID
     */
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    public static void main(String[] args) {
		System.out.println(getUUID());
	}
   
}
