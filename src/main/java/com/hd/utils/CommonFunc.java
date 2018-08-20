package com.hd.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonFunc {
	/**
	 * 比较该日期与当前时间的相差天数
	 * 
	 * @param date
	 * @return
	 */
	public static long compareDays(java.util.Date date) {
		long datetime = date.getTime();
		long nowdatetime = new Date().getTime();
		return (nowdatetime - datetime) / 1000 / 60 / 60 / 24;
	}
	
	/**
	 * 比较日期与当前时间的相差分钟数
	 * 
	 * @param date
	 * @return int
	 */
	private static int compareMinutes(java.util.Date date) {
		long datetime = date.getTime();
		long nowdatetime = new Date().getTime();
		return (int) (nowdatetime - datetime) / 1000 / 60;
	}
	
	/**
	 * 将字符型日期转换为日期型
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;
		String datePattern = "yyyy-MM-dd hh:mm:ss";
		try {
			SimpleDateFormat df = new SimpleDateFormat(datePattern);
			aDate = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
		return aDate;
	}
	
	/**
	 * 将inputStr 中的regex 字符替换为repl字符
	 * @param inputStr
	 * @param regex
	 * @param repl
	 * @return
	 */
	public static String replaceCharacter(String inputStr, String regex,
			String repl) {
		String res = "";
		if (inputStr == null) {
			return res;
		} else if (inputStr != null && inputStr.length() > 0 && regex != null
				&& repl != null) {
			int index = inputStr.indexOf(regex);
			if (index >= 0) {
				res = inputStr.replaceAll(regex, repl);
			} else {
				res = inputStr;
			}

		} else {
			res = inputStr;
		}
		return res;
	}
	
	/**
	 * @function 取得当前时间的字符串，yyyy-MM-dd hh:mm:ss
	 * @return
	 * @throws Exception
	 */
	public static String getCurTime() {
		String sDate = "";
		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		sDate = formatter.format(oExcuteTime);
		return sDate;
	}
	
	private static long startVaue = 0;
	
	/**
	 * 产生一个唯一ID值
	 * 
	 * @return
	 */
	public static synchronized String getID() {
		java.text.SimpleDateFormat oFormat;
		startVaue++;
		startVaue = startVaue % 1000;
		java.text.DecimalFormat format = new java.text.DecimalFormat("000");
		String sStartVaue = format.format(startVaue);
		Date oToday = new Date();
		oFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
		String sDate = oFormat.format(oToday);
		String id = sDate + sStartVaue;
		return id;
	}
	
	public static String replacePolice(String value){
		value = value.replaceAll("'", "");
		return value;
	}
	
	/**
	 * 保留小数点后两位
	 * @param db
	 * @return
	 */
	public static String getFormatDoubleTwo(double db){
		DecimalFormat def = new DecimalFormat("#.##");
		String forDB = def.format(db);
		return forDB;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static double getEmptyString(String value){
		if("".equals(value)||value == null){
			value = "0";
		}
		double res = Double.valueOf(value).doubleValue();
		return res;
	}
	
	/**
	 * 将条件中的旧查询原因转换成新的查询原因提交给鹏元社保
	 * @param newReason
	 * @return
	 */
	public static String getNewReasonID(String oldReason){
		String newReasonID = "999";
		if("01".equals(oldReason)){
			newReasonID = "101";
		}else if("02".equals(oldReason)){
			newReasonID = "102";
		}else if("03".equals(oldReason)){
			newReasonID = "201";
		}else if("04".equals(oldReason)){
			newReasonID = "202";
		}else if("07".equals(oldReason)){
			newReasonID = "401";
		}else if("08".equals(oldReason)){
			newReasonID = "402";
		}else if("09".equals(oldReason)){
			newReasonID = "303";
		}else if("10".equals(oldReason)){
			newReasonID = "203";
		}else if("11".equals(oldReason)){
			newReasonID = "501";
		}else if("12".equals(oldReason)){
			newReasonID = "502";
		}else if("13".equals(oldReason)){
			newReasonID = "901";
		}else if("14".equals(oldReason)){
			newReasonID = "101";
		}else if("15".equals(oldReason)){
			newReasonID = "101";
		}else if("16".equals(oldReason)){
			newReasonID = "104";
		}else if("17".equals(oldReason)){
			newReasonID = "304";
		}else if("18".equals(oldReason)){
			newReasonID = "301";
		}else if("19".equals(oldReason)){
			newReasonID = "101";
		}else if("20".equals(oldReason)){
			newReasonID = "102";
		}else if("21".equals(oldReason)){
			newReasonID = "901";
		}else if("22".equals(oldReason)){
			newReasonID = "302";
		}else if("23".equals(oldReason)){
			newReasonID = "101";
		}else if("24".equals(oldReason)){
			newReasonID = "305";
		}else if("25".equals(oldReason)){
			newReasonID = "105";
		}else if("26".equals(oldReason)){
			newReasonID = "101";
		}else if("27".equals(oldReason)){
			newReasonID = "306";
		}else if("28".equals(oldReason)){
			newReasonID = "103";
		}else if("99".equals(oldReason)){
			newReasonID = "999";
		}
		
		return newReasonID;
	}
	
	/**
	 * 获取流水号
	 * @return
	 */
	public static String createSystemID(){
		  int s = 0;
		  String systemID = String.valueOf(Calendar.getInstance().get(Calendar.YEAR))+
		  getRequieString(String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1),2)+
		  getRequieString(String.valueOf(Calendar.getInstance().get(Calendar.DATE)),2)+
		  getRequieString(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)),2)+
		  getRequieString(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)),2)+
		  getRequieString(String.valueOf(Calendar.getInstance().get(Calendar.SECOND)),2)+
		  getRequieString(String.valueOf(Calendar.getInstance().get(Calendar.MILLISECOND)),3);
    	  s++;
		  if(s>9){
			s =0;
		  }
		return systemID.substring(2,17)+s;
	}
	
	private static String getRequieString(String from,int wei){
		int size = wei - from.length();
		if(size < 0 || size == 0){
			return from;
		}else{
			for(int i = 0; i < size; i++){
				from = "0"+from;
			}
			return from;
		}
	}	
	
	/**
	 * @function 取得当前时间的字符串，HH:mm
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentTime() {
		String sDate = "";
		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HHmmss");
		sDate = formatter.format(oExcuteTime);
		return sDate;
	}
	
	/**
	 * @function 取得当前时间的字符串，yyyyMMdd
	 * @return
	 * @throws Exception
	 */
	public static String getCurDate() {
		String sDate = "";
		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
		sDate = formatter.format(oExcuteTime);
		return sDate;
	}
	
	/**
	 * 半角转全角
	 * 全角空格为12288，半角空格为32
	 * ASCII码半角(33-126)与全角(65281-65374)均相差65248
	 * ASCII码1-31为控制字符，不可转换
	**/
	public static String toSBC(String input) {
		char[] c = input.toCharArray();
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] == 32) {
				c[i] = (char)12288;
			}
			else if (c[i]>32 && c[i] < 127) {
				c[i] = (char)(c[i] + 65248);
			}
		}
		return new String(c);
	}
	
	/**
	 * 全角转半角
	 * 全角空格为12288，半角空格为32
	 * 其他字符半角(33-126)与全角(65281-65374)均相差65248
	 * ASCII码1-31为控制字符，不可转换
	**/
	public static String toDBC(String input) {
		char[] c = input.toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			if(c[i] == 12288) {
				c[i] = (char)32;
			}
			else if(c[i] > 65280 && c[i] < 65375) {
				c[i] = (char)(c[i] - 65248);
			}
		}
		return new String(c);
	}
}
