package com.jason.blog.infrastruture.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

/**
 * java:photo Watermark and Thumbnail
 * @author Jason
 * @date 2013-2-4 下午11:34:41
 */
public class PhotoHelperTest {

	@Test
	public void testcreateThumbnail() throws Exception {
		String imgurl="C:\\Users\\tanjianna\\Desktop\\jason-blog\\tao\\3.jpg";
		File file =  new File(imgurl);
		InputStream in = new FileInputStream(file);
		//按最少比例 生成缩略图
		PhotoHelper.createThumbnail(in, FilesHelper.insertString(file.getCanonicalPath(),"thumb"), 300, 200);
	}
	
	@Test
	public void testwatermark() throws Exception {
		String imgurl="C:\\Users\\tanjianna\\Desktop\\jason-blog\\tao\\2.jpg";
		String waterurl="C:\\Users\\tanjianna\\Desktop\\jason-blog\\tao\\logo_wm.png";
		PhotoHelper.watermark(imgurl, waterurl);
	}
	
}
