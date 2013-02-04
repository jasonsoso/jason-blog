package com.jason.blog.infrastruture.util;

public class FilesHelper {
	
	/**
	 * 后缀名称前插入字符串 拼装字符
	 * eg:123.jpg -> 123_${insertString}.jpg
	 * @param fileName
	 * @param insertString
	 * @return
	 */
	public static String insertStringBeforeExtension(String fileName, String insertString) {
		String fileNameWithoutExtension = getFileNameWithoutExtension(fileName);
		String extension = getFileExtensionWithDot(fileName);
		return String.format("%s%s%s", fileNameWithoutExtension, insertString, extension);
	}
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileNameWithoutExtension(String fileName) {
		if (fileName.indexOf(".") != -1) {
			return fileName.substring(0, fileName.lastIndexOf("."));
		}
		return fileName;
	}
	/**
	 * .后缀名
	 * @param fileName
	 * @return
	 */
	public static String getFileExtensionWithDot(String fileName) {
		if (fileName.indexOf(".") != -1) {
			return fileName.substring(fileName.lastIndexOf("."));
		}
		return fileName;
	}
}
