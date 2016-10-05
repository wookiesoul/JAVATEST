import java.security.MessageDigest;
import java.util.StringTokenizer;

import org.apache.commons.codec.binary.Base64;


public class Sha256Base64 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte[] erpid = "1".getBytes();
		
		//System.out.println(new String(Base64.encodeBase64(erpid)));
		//String test = "MIGlAoGAFfR9vHJ5ZxmcV3hqkHbrL69yuei15%2bWuwM%2fHPOtuZ0iYsTYDRQYklLtQJR7bvbW3%2br8nqelrKSRq4r%2fVZJ5FzC7MafocJx4laYxzsc6Wq8xMfO4cGzQXySqeV5lACOIMuok5e9uc3bVj9EwKnitV0e6QXPwQOxdae76vPBRzVOoEIJNWtc1C9Eac2FTiqt1TcqrtHkWYN8%2f99I47Zx5hkQbs==";
		//System.out.println(new String(Base64.decodeBase64(test)));
		
		
		
		System.out.println(encryptPassword("Honam_5164"));
		
		System.out.println(encryptSha("kb1915!@"));
		
		//String tmp2 = encryptPassword("1");
		
		//byte[] tmp3 = String2byte(tmp2);
		//System.out.println(new String(Base64.encodeBase64("".getBytes())));
		//System.out.println(byte2String(Base64.decodeBase64("1bQuC9WIc9YKkOPfLG/hlA==")));
		
		//System.out.println(Base64.decodeBase64("VU5JTkVUVA==").toString());
		
		
		
		//System.out.println(decrypt(""));
	}
	
	public static String decrypt(String data) {
		
		byte[] ciphertext = null;
		
		ciphertext = data.getBytes();
		
		return new String(Base64.decodeBase64(ciphertext));
		//return byte2String(Base64.decodeBase64(ciphertext));
	}
	
	public static void execepttest(String e){
		System.out.println("aaa"+e);
		
	}
	
	public static String encryptSha(String text) {
		String encrypted = null;

		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(text.getBytes("UTF-8"));
			
			byte[] digested = md.digest();
			
			//encrypted =  new String(digested);
			//encrypted =  new String(Base64.encodeBase64(digested));
			encrypted = new String(StringConverter.byteToHex(digested));
		} catch (Exception e) {
			//throw new IKEP4ApplicationException("", e);
		}

		return encrypted;
	}
 

	
    public static String encryptPassword(String data) throws Exception {

	if (data == null) {
	    return "";
	}

	byte[] plainText = null; // 평문
	byte[] hashValue = null; // 해쉬값
	plainText = data.getBytes("UTF-8");
	
	try{
	
		MessageDigest md = MessageDigest.getInstance("MD5");
		//MessageDigest md = MessageDigest.getInstance("SHA1");
		
		try{	
			//md.update(text.getBytes("UTF-8"));
	hashValue = md.digest(plainText);}
	catch(Exception ex){
		execepttest(ex.toString());
		
	}
	}catch(Exception e){}
	/*
	BASE64Encoder encoder = new BASE64Encoder();
	return encoder.encode(hashValue);
	*/
	//return new String(hashValue);
	//return hashValue.toString();
	String a= hashValue.toString().trim();
	System.out.println();
	System.out.println(a.length());
	//System.out.println(hashValue.length);
	return new String(Base64.encodeBase64(hashValue));
	//return byte2String(hashValue);
	//return new String(Base64.encodeBase64(plainText));
	
	//return byte2String(hashValue);
    }
    private static byte[] String2byte(String src){
    	   byte[] tmp = new byte[16];
    	   int loop = 0;
    				
    	   StringTokenizer str1 = new StringTokenizer(src,",") ;
    				
    	   while(str1.hasMoreTokens()) {
    	         //String str2 =  str1.nextToken() ;
    		   String str2 =  (String)str1.nextElement();
    		   System.out.println(str2.substring(2,4));
    		   Integer iii =   Integer.valueOf(str2.substring(2,4),16);
    					   
    	       tmp[loop++] = (byte)iii.byteValue();
    	   }           
    	   return tmp;
    				
    	  }
    
	  private static String byte2String(byte [] b){
	    	
			char   HEXCHAR[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f' };
			
			int  len = b.length;
			StringBuffer s = new StringBuffer();

			for (int i = 0; i < len; i++) {
				int c = ((int) b[i]) & 0xff;
		
				s.append(HEXCHAR[c >> 4 & 0xf]);
				s.append(HEXCHAR[c & 0xf]);
			}

			return s.toString();
	    }

}
