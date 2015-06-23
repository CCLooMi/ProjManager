package com.ccloomi.core.util;

import com.ccloomi.core.constant.Constant;
/**
 * 类名：PathUtil
 * 描述：文件路径本地标准化工具类
 * 作者： Chenxj
 * 日期：2015年6月23日 - 上午9:38:15
 */
public class PathUtil {
	/**
	 * 标准化路径（所有路径分隔都用"/"）
	 * @param filePath 路径
	 * @return 标准后的路径
	 */
	public static String pathCalibration(String filePath) {
		filePath=filePath.replaceAll("\\\\", "/");
		return filePath;
	}
	/**
	 * 本地化路径(windows系统"\",其他系统"/")
	 * @param filePath 路径
	 * @return 本地化后的路径
	 */
	public static String pathLocal(String filePath) {
		if(Constant.FILE_SEPARATOR.equals("\\")){
			filePath=filePath.replaceAll("/", "\\\\");
		}else{
			filePath=filePath.replaceAll("\\\\", "/");
		}
		return filePath;
	}
	/**
	 * 测试主函数
	 * @param args
	 */
	public static void main(String[] args) {
		String a="/hello/test\\bj\\jj/aaa";
		a=PathUtil.pathCalibration(a);
		System.out.println(a);
		a=pathLocal(a);
		System.out.println(a);
	}
}
