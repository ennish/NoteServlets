package com.enn.service;

/**
 * Created by enn on 2018/4/10.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.util.Arrays;

public class BasicService {

    /**
     *
     *signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     *timestamp	时间戳
     *nonce	随机数
     *将三个参数按字典序排序拼接为一个字符串，然后进行sha1加密
     * 与signature对比是否一致，是则证明是微信消息
     * echostr	随机字符串
     *
     */
    public boolean validate(HttpServletRequest request, HttpServletResponse response) {

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        if (signature == null || timestamp == null || nonce == null) return false;

        String[] arr = {signature, timestamp, nonce};
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<arr.length;i++){
        	sb.append(arr[i]);
        }
        
        try{
        	MessageDigest md = MessageDigest.getInstance("SHA-1");
        	byte[] temSign = md.digest(sb.toString().getBytes());
        	String content = byteToStr(temSign);
        	if(signature.equals(content)){
        		return true;
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
//        try {
//            String tempSign = SHA1.getSHA1(WXPublicConfig.token, timestamp, nonce, sb.toString());
//            if (tempSign.equals(signature))
//                return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return false;
    }
    
    /**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray)
	{
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++)
		{
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	
	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte)
	{
		char[] Digit =
		{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);
		return s;
	}

}
