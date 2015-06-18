package com.ccloomi.core.util;
/**
 * 类名：StringUtil
 * 描述：字符串工具类
 * 作者： Chenxj
 * 日期：2015年6月18日 - 下午4:40:44
 */
public class StringUtil {

	/**
	 * 方法描述：字符串格式化
	 * 作者：Chenxj
	 * 日期：2015年6月18日 - 下午4:50:07
	 * @param f
	 * @param obj
	 * @return StringBuilder
	 */
	public static StringBuilder format(StringBuilder f,Object...objs){
		StringBuilder sb=new StringBuilder();
		int count=0;
		int flag=0;
		char a="?".charAt(0);
		String b="";
		for(int i=0;i<f.length();i++){
			if(a==f.charAt(i)){
				String s=objs[count].toString();
				f.replace(i,i+1,b);
				sb.append(f.substring(flag, i)).append(s);
				flag=i;
				count++;
			}
		}
		sb.append(f.substring(flag, f.length()));
		return sb;
	}
	/**
	 * 方法描述：字符串格式化
	 * 作者：Chenxj
	 * 日期：2015年6月18日 - 下午4:58:56
	 * @param string
	 * @param objs
	 * @return String
	 */
	public static String format(String string,Object...objs){
		return format(new StringBuilder(string), objs).toString();
	}
	/**
	 * 方法描述：字符串连接
	 * 作者：Chenxj
	 * 日期：2015年6月18日 - 下午5:20:32
	 * @param s
	 * @param objs
	 * @return StringBuilder
	 */
	public static StringBuilder join(String s,Object...objs){
		StringBuilder sb=new StringBuilder();
		int l=objs.length;
		if(l>0){
			sb.append(objs[0]);
			for(int i=1;i<l;i++){
				sb.append(s).append(objs[i]);
			}
			return sb;
		}else{
			return sb;
		}
	}
	/**
	 * 方法描述：连接字符串数组
	 * 作者：Chenxj
	 * 日期：2015年6月18日 - 下午5:22:01
	 * @param s
	 * @param objs
	 * @return String
	 */
	public static String joinString(String s,Object...objs){
		return join(s, objs).toString();
	}
}
