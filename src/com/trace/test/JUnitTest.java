package com.trace.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sql.DataSource;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
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
import com.thoughtworks.xstream.XStream;
import com.trace.controller.GenerateCode;
import com.trace.dao.AdminMapper;
import com.trace.dao.ProductMapper;
import com.trace.interceptor.ExceptionProcessAspect;
import com.trace.model.Admin;
import com.trace.model.Product;
import com.trace.model.User;
import com.trace.model.wechat.AccessToken;
import com.trace.model.wechat.Menu;
import com.trace.service.AdminProductService;
import com.trace.service.AdminService;
import com.trace.service.ProductService;
import com.trace.util.wechat.MenuUtil;
import com.trace.util.wechat.WechatConfig;
import com.trace.util.wechat.WechatUtil;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:com/trace/config/spring*.xml"}) 
public class JUnitTest {
	
	@Autowired
	private GenerateCode generateQrCode;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminProductService adminProductService;
	
	@Autowired
	private ExceptionProcessAspect exceptionProcessAspect;
	
	@Test
	public void test19() throws IOException{
//		System.out.println(WechatConfig.class.getResource("/"));
//		InputStream is = WechatConfig.class.getClassLoader().getResourceAsStream("com/trace/config/wechat.properties");
//		System.out.println(is);
//		Properties properties = new Properties();
//		properties.load(is);
//		System.out.println(properties.getProperty("wechat.token"));
//		InputStream inputStream = new FileInputStream("E:/workspace/trace/build/classes/com/trace/config/wechat.properties");
//		System.out.println(inputStream);
		System.out.println(WechatConfig.getAppid());
		
//		System.out.println(System.getProperty("user.dir"));
//		File file = new File("");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.getCanonicalPath());
	}
	
	@Test
	public void test18(){
		User user = new User();
		user.setId(2);
		user.setNickname("xiaoming");
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		String xml = xStream.toXML(user);
		System.out.println(xml);
		xml="<user><id>2</id><aa>3</aa><nickname>xiaoming</nickname></user>";
		System.out.println(xStream.fromXML(xml));
	}
	
	@Test
	public void test17(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 2);
		jsonObject.put("openid", "ahifapd");
		jsonObject.put("nickname", "sdnai");
		jsonObject.put("sex", "djaia");
		jsonObject.put("nimen", "sss");
		System.out.println(jsonObject);
		System.out.println(JSON.parseObject(jsonObject.toJSONString(),User.class));
	}
	
	@Test
	public void test16(){
//		AccessToken token = WechatUtil.getAccessToken();
		JSONObject jsonObject = WechatUtil.queryMenu(AccessToken.getToken()); 
		System.out.println(jsonObject);
		System.out.println(WechatUtil.deleteMenu(AccessToken.getToken()));
	}
	
	@Test
	public void test15(){
//		AccessToken token = WechatUtil.getAccessToken();
		JSONObject jsonObject = WechatUtil.queryMenu(AccessToken.getToken()); 
		System.out.println(jsonObject);
		System.out.println(JSON.parseObject(jsonObject.get("menu").toString(), Menu.class));
	}
	
	@Test
	public void test14(){
//		AccessToken accessToken = WechatUtil.getAccessToken();
		System.out.println(WechatUtil.queryMenu(AccessToken.getToken()));
	}
	
	@Test
	public void test13(){
//		AccessToken accessToken = WechatUtil.getAccessToken();
		System.out.println(WechatUtil.createMenu(JSON.toJSONString(MenuUtil.initMenu()), AccessToken.getToken()));
	}
	
	@Test
	public void test12(){
//		AccessToken accessToken = WechatUtil.getAccessToken();
		System.out.println("token:"+AccessToken.getToken());
		System.out.println("expiresIn:"+AccessToken.getExpresired());
	}
	
	@Test
	public void test11() throws ClientProtocolException, IOException{
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type="
				+ "client_credential&appid=wxce49c8131032f030&secret=12612db5a9dd102127fde3ade133e6b8");
		HttpResponse httpResponse = httpClient.execute(httpGet);
		System.out.println(EntityUtils.toString(httpResponse.getEntity()));
		EntityUtils.consume(httpResponse.getEntity());
	}
	
	@Test
	public void test10(){
		System.out.println(exceptionProcessAspect);
	}
	
	@Test
	public void test9(){
		List<Product> products=new ArrayList<>();
		for(int i=0;i<5;i++){ 
			Product product=new Product();
			products.add(product);
		}
		productService.insert(products,"aa");
		System.out.println(products);
	}
	
	@Test
	public void test8(){
		Product product=new Product();
		product.setName("ddd");
		List<Product> products=new ArrayList<>();
		products.add(product);
		product=new Product();
		product.setName("eee");
		products.add(product);
		productService.insert(products, "zzz");
		System.out.println(products);
	}
	
	@Test
	public void testEnCode() throws WriterException, IOException{
		JSONObject json=new JSONObject();
		json.put("url","www.baidu.com");
		String content=json.toJSONString();
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
	
	@Test
	public void testDeCode() throws IOException, NotFoundException{
		File file=new File("e://test/a.png");
		BufferedImage image=ImageIO.read(file);
		BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
				image)));
		Map<DecodeHintType, Object> hints=new HashMap<>();
		hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
		Result result=new MultiFormatReader().decode(bitmap, hints);
		System.out.println(result.getText());
	}
	
	@Test
	public void test7(){
		Object record=adminProductService.getByProductId(2);
		System.out.println(record);
//		record=adminService.get("aa","123");
//		System.out.println(record);
//		record.setAccount("cc");
//		record.setPassword("222");
//		adminService.insert(record);
//		System.out.println(record);
	}
	
	@Test
	public void test6(){
		Admin record=adminMapper.get(2,null,null);
		System.out.println(record);
		record=adminService.get("aa","123");
		System.out.println(record);
		record.setAccount("cc");
		record.setPassword("222");
		adminService.insert(record);
		System.out.println(record);
	}
	
	@Test
	public void test5(){
		Product record=new Product();
		record.setOrigin("222");
		System.out.println(productMapper.insert(record));	
		System.out.println(record);
	}
	
	@Test
	public void test4(){
		List<Product> list=new ArrayList<>();
		Product record=new Product();
		record.setOrigin("123");
		list.add(record);
		record=new Product();
		record.setOrigin("321");
		list.add(record);
		System.out.println(list);
		System.out.println(productMapper.insertList(list));	
		System.out.println(list);
	}
	
	@Test
	public void test3(){
		System.out.println(productMapper);
		System.out.println(productMapper.get(2));
	}
	
	@Test
	public void test2(){
		System.out.println(productService);
		System.out.println(dataSource);
	}
	
	@Test
	public void test1(){
		System.out.println(generateQrCode);
	}
}
