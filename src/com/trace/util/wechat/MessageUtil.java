package com.trace.util.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.trace.model.message.News;
import com.trace.model.message.NewsMessage;
import com.trace.model.message.TextMessage;


/** 
 * @author sunweijie 
 * @since 2017年3月6日 下午10:43:45
 */
public class MessageUtil {
	
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<>();
		SAXReader saxReader = new SAXReader();
		InputStream in =request.getInputStream();
		Document doc = saxReader.read(in);
		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		for(Element element : list){
			map.put(element.getName(), element.getText());
		}
		in.close();
		return map;
	}
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", TextMessage.class);
		return xstream.toXML(textMessage);
	}
	
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", NewsMessage.class);
		xstream.alias("item", News.class);
		return xstream.toXML(newsMessage);
	}
}
