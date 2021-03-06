
package com.jason.blog.infrastruture.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 命令行
 * @author Jason
 * @date 2013-2-7 下午11:59:25
 */
public class CommandLineHelper {
	private static final Logger logger = LoggerFactory.getLogger(CommandLineHelper.class);
	/**
	 * 当前应用系统
	 */
	private static String OS;

	static {
		OS = System.getProperty("os.name").toLowerCase()
			.startsWith("windows")?"windows":"linux";
	}

	public static String getOS() {
		return OS;
	}
	/**
	 * @param cmd
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static boolean Exec(String cmd) throws IOException,InterruptedException {
		String[] cmds;
		if (OS.equals("windows")) {
			cmds = new String[] { "cmd.exe", "/c", cmd };
		} else {
			cmds = new String[] { "/bin/sh", "-c", cmd };
		}
		if (logger.isDebugEnabled()) {
			logger.debug("执行" + OS + "系统命令: " + cmd);
		}
		return Exec(cmds);
	}

	private static boolean Exec(String[] cmds) throws IOException,InterruptedException {
		Process ps = Runtime.getRuntime().exec(cmds);
		String err = loadStream(ps.getErrorStream());
		int r = ps.waitFor();
		if (!err.equalsIgnoreCase("")) {
			throw new IOException(err);
		}
		return (r == 0);
	}

	public static Process Execing(String cmd) throws IOException {

		String[] cmds;
		if (OS.equals("windows")) {
			cmds = new String[] { "cmd.exe", "/c", cmd };
		} else {
			cmds = new String[] { "/bin/sh", "-c", cmd };
		}
		return Execing(cmds);
	}

	private static Process Execing(String[] cmds) throws IOException {
		Process ps = Runtime.getRuntime().exec(cmds);
		return ps;
	}

	/**
	 * read an input-stream into a String
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String loadStream(InputStream in) throws IOException {
		int ptr = 0;
		in = new BufferedInputStream(in);
		StringBuffer buffer = new StringBuffer();
		try {
			while ((ptr = in.read()) != -1) {
				buffer.append((char) ptr);
			}
		} finally {
			in.close();
		}
		return buffer.toString();
	}

}
