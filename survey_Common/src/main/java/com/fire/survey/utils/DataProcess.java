package com.fire.survey.utils;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;

@SuppressWarnings("restriction")
public class DataProcess {
	public static String resizeImages(InputStream inputStream, String realPath, String type) {

		OutputStream out = null;

		try {
			// 1.构造原始图片对应的Image对象
			BufferedImage sourceImage = ImageIO.read(inputStream);

			// 2.获取原始图片的宽高值
			int sourceWidth = sourceImage.getWidth();
			int sourceHeight = sourceImage.getHeight();

			// 3.计算目标图片的宽高值
			int targetWidth = sourceWidth;
			int targetHeight = sourceHeight;

			if (sourceWidth > 100) {
				// 按比例压缩目标图片的尺寸
				targetWidth = 100;
				targetHeight = sourceHeight / (sourceWidth / 100);

			}

			// 4.创建压缩后的目标图片对应的Image对象
			BufferedImage targetImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

			// 5.绘制目标图片
			targetImage.getGraphics().drawImage(sourceImage, 0, 0, targetWidth, targetHeight, null);

			// 6.构造目标图片文件名
			String targetFileName = UUID.randomUUID().toString().substring(0, 8) + type;

			// 7.创建目标图片对应的输出流
			out = new FileOutputStream(realPath + "/" + targetFileName);

			// 8.获取JPEG图片编码器
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

			// 9.JPEG编码
			encoder.encode(targetImage);

			// 10.返回文件名
			return "pics/" + targetFileName;

		} catch (Exception e) {

			e.printStackTrace();

			return null;
		} finally {
			// 10.关闭流
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static String md5(String source) {
		if (source == null || source.length() == 0) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		byte[] sourceBytes = source.getBytes();
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");

			byte[] bytes = digest.digest(sourceBytes);
			char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

			for (byte b : bytes) {
				int hi = (b >> 4) & 15;
				int lo = b & 15;
				buffer.append(ch[hi]).append(ch[lo]);
			}

		} catch (NoSuchAlgorithmException e) {
			System.out.println("不可能有异常");
		}
		return buffer.toString();
	}

	public static String pathHandler(String path) {
		String regex = "/\\d.*$";
		return path.replaceAll(regex, "");
	}
}
