package test.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 *
 * 生成MD5散列的工具类
 * @author kevin
 *
 * Create at: 2016年5月18日
 */
public class MD5_Util {
	
	public static void main(String[] args) {
		System.out.println(MD5("1111"));
	}
	
	/**
	 * 
	 * Description: 默认生成32位的 MD5
	     * Copyright:   Copyright (c)2016  
	     * Company:     光宝联合   
	     * @author:     Kevin    
	     * Create at:   2016年5月18日
		 * @param sourceStr
		 * @return
	 */
	public static String MD5(String sourceStr) {
        
        return MD5(sourceStr,32);
    }
	
	/**
	 * 
	 * Description: 可指定生成16位或32位的MD5  
	     * Copyright:   Copyright (c)2016  
	     * Company:     光宝联合   
	     * @author:     Kevin    
	     * Create at:   2016年5月18日
		 * @param sourceStr
		 * @param length
		 * @return
	 */
	public static String MD5(String sourceStr, int length) {
        String result = sourceStr;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes(Charset.forName("utf-8")));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            
            if (length==16) {
            	result = buf.toString().substring(8, 24);
			}else if (length==32) {
				result = buf.toString();
			}
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        
        return result;
    }

}
