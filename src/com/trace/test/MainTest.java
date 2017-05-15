package com.trace.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class MainTest {
	
	private static int n = 0;
	static{
		System.out.println("加载静态快"+n++);
	}

	public static void main(String[] args) throws Exception {
		test2();
	}
	
	public static void  test2(){
//		System.out.println(WechatUtil.token);
	}
	
	public static void test1(){
//		WechatUtil.getAccessToken();
	}
	
	public static void testEnCode() throws WriterException, IOException{
		JSONObject json=new JSONObject();
		json.put("baidu","www.baidu.com");
		String content=json.toJSONString();
		//content="http://www.baidu.com";
		int width=200;
		int height=200;
		String format="png";
		Map<EncodeHintType, Object> hints=new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix=new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,
				width, height,hints);
		File file=new File("e://test/a.png");
		if(!file.exists()) file.createNewFile();
		Path path=file.toPath();
		MatrixToImageWriter.writeToPath(bitMatrix, format, path);
	}
	
	public static void testDeCode() throws IOException, NotFoundException{
		File file=new File("e://test/a.png");
		BufferedImage image=ImageIO.read(file);
		BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
				image)));
		Map<DecodeHintType, Object> hints=new HashMap<>();
		hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
		Result result=new MultiFormatReader().decode(bitmap, hints);
		System.out.println(result.getText());
	}
}
