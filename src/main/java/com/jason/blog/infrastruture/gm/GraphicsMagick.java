package com.jason.blog.infrastruture.gm;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

import com.jason.blog.infrastruture.util.CommandLineHelper;

/**
 * GraphicsMagick 图片处理
 * 
 * @author Jason
 * @date 2013-2-8 上午12:57:12
 */
public class GraphicsMagick {
	
	/**
	 * window下 安裝路徑
	 */
	private static final String imageMagickPath = "D:\\Program Files (x86)\\GraphicsMagick-1.3.17-Q16";
	
	/**
	 * IM4JAVA是同时支持ImageMagick和GraphicsMagick的 true 則 GraphicsMagick false 則
	 * ImageMagick
	 */
	private static final boolean isGmOrIM = true;
	
	
	/**
	 * @param srcPath
	 * @param newPath
	 * @param sw src width
	 * @param sh src hight
	 * @param dw target width
	 * @param dh targer hight
	 * @throws Exception
	 */
	public static void cropImage(String srcPath, String newPath, int sw,
		int sh, int dw, int dh) throws Exception {
		if (sw <= 0 || sh <= 0 || dw <= 0 || dh <= 0){
			return;
		}
		IMOperation op = new IMOperation();
		op.addImage();
		if ((sw <= dw) && (sh <= dh)){	// 如果源图宽度和高度都小于目标宽高，则仅仅压缩图片
			op.resize(sw, sh);
		}
		if ((sw <= dw) && (sh > dh)){	// 如果源图宽度小于目标宽度，并且源图高度大于目标高度
			op.resize(sw, sh); // 压缩图片
			/**
			 * sw：裁剪的宽度  sw：裁剪的高度 x：裁剪的横坐标  y：裁剪的挫坐标
			 */
			op.append().crop(sw, sw, 0, (sh - dh) / 2);// 切割图片
		}
		if ((sw > dw) && (sh <= dh)){	// 如果源宽度大于目标宽度，并且源高度小于目标高度
			op.resize(sw, sh);
			op.append().crop(dw, sh, (sw - dw) / 2, 0);// 切割图片
		}
		if (sw > dw && sh > dh) {	// 如果源图宽、高都大于目标宽高
			float ratiow = (float) dw / sw; // 宽度压缩比
			float ratioh = (float) dh / sh; // 高度压缩比
			if (ratiow >= ratioh) {	// 宽度压缩比小（等）于高度压缩比（是宽小于高的图片）
				int ch = (int) (ratiow * sh); // 压缩后的图片高度
				op.resize(dw, ch); // 按目标宽度压缩图片
				op.append().crop(dw, dh, 0, (ch > dh) ? ((ch - dh) / 2) : 0); // 根据高度居中切割压缩后的图片
			} else {	// （宽大于高的图片）
				int cw = (int) (ratioh * sw); // 压缩后的图片宽度
				op.resize(cw, dh); // 按计算的宽度进行压缩
				op.append().crop(dw, dh, (cw > dw) ? ((cw - dw) / 2) : 0, 0); // 根据宽度居中切割压缩后的图片
			}
		}
		op.addImage();
		ConvertCmd convert = new ForWinConvertCmd(true);
		convert.run(op, srcPath, newPath);
	}

	/**
	 * 先缩放，后居中切割图片
	 * @param srcPath 源图路径
	 * @param desPath  目标图保存路径
	 * @param rectw 待切割在宽度
	 * @param recth 待切割在高度
	 * @throws Exception
	 */
	public static void cropImageCenter(String srcPath, String newPath,
		int rectw, int recth) throws Exception {
		IMOperation op = new IMOperation();

		op.addImage();
		op.resize(rectw, recth, '^').gravity("center").extent(rectw, recth);
		//op.resize(rectw, recth).gravity("center").extent(rectw, recth);//以空白補
		op.addImage();

		ConvertCmd convert = new ForWinConvertCmd(isGmOrIM);
		convert.run(op, srcPath, newPath);
	}

	/**
	 * @param srcPath
	 * @param newPath
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @throws Exception
	 */
	public static void cutImage(String srcPath, String newPath, int x, int y, int width, int height) throws Exception {
		ConvertCmd convert = new ForWinConvertCmd(isGmOrIM);
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		/**
		 * width：裁剪的宽度 height：裁剪的高度 x：裁剪的横坐标 y：裁剪的挫坐标
		 */
		op.crop(width, height, x, y);
		op.addImage(newPath);

		convert.run(op);
	}

	/**
	 * 
	 * @param srcPath
	 * @param newPath
	 * @param width
	 * @param height
	 * @throws Exception
	 */
	public static void resize(String srcPath, String newPath, int width, int height) throws Exception {
		ConvertCmd cmd = new ForWinConvertCmd(isGmOrIM);
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		op.resize(width, height);
		op.addImage(newPath);

		cmd.run(op);
	}

	/**
	 * setSearchPath for windows so: ConvertCmd cmd = new ConvertCmd(true);
	 * ConvertCmd cmd = new ForWinConvertCmd(true);
	 * 
	 * @author Jason
	 * @date 2013-2-8 上午12:30:19
	 */
	public static final class ForWinConvertCmd extends ConvertCmd {
		public ForWinConvertCmd() {
			super();
			if (CommandLineHelper.getOS().equals("windows")) {
				super.setSearchPath(imageMagickPath);
			}
		}

		public ForWinConvertCmd(boolean isGmOrIM) {
			super(isGmOrIM);
			if (CommandLineHelper.getOS().equals("windows")) {
				super.setSearchPath(imageMagickPath);
			}
		}
	}
}
