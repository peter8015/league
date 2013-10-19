package com.base.platform.framework.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.base.platform.framework.dictionary.DictionaryImpl;
import com.base.platform.framework.dictionary.DictionaryProvider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */

public class XmlDictBuilder implements InitializingBean{
	
	
	private static final Log logger = LogFactory.getLog(XmlDictBuilder.class);
	
	private DictionaryProvider dictionaryProvider;
	
	private List<String> filepaths;
	
	private List<Resource> resources = new ArrayList<Resource>();
	
	private ResourcePatternResolver resoucePatternResolver 
		= new PathMatchingResourcePatternResolver();
	
	public void afterPropertiesSet() throws Exception {
		if(this.filepaths==null)
		{
			throw new IllegalStateException("filepaths is requeid.");
		}
		load();
	}
	
	private synchronized void load(){
		for(int i=0;i<this.filepaths.size();i++){
			String filePath = this.filepaths.get(i);
			Resource[] matchResouces = null;
			try {
				matchResouces = this.resoucePatternResolver.getResources(filePath);
			} catch (IOException e) {
				logger.error("Error occurs during load dictionary files.", e);
			}
			this.resources.addAll(Arrays.asList(matchResouces));
		}
		
		for(int i=0;i<this.resources.size();i++){
			Resource resouce = this.resources.get(i);
			load(resouce);
		}
	}
	
private synchronized void load(Resource resouce) {
		
		try {
			File file = resouce.getFile();
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			Element rootNode = (Element) document.getDocumentElement();
			if (!(rootNode.getNodeName().equalsIgnoreCase("dictionary"))) {
				logger.error("XmlDictBuilder : the file is illegal, root must be a <dictionary>.");
				return;
			}

			NodeList list = rootNode.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					//生成每一个dictionary
					DictionaryImpl dict = traversal(node);
					if (dict != null)
						this.dictionaryProvider.register(dict);
				}
			}
			
		} catch (FileNotFoundException e) {
			logger.error("Error occurs during load dictionary file[" + resouce.getFilename()
					+ "]", e);
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			logger.error("Error occurs during load dictionary file[" + resouce.getFilename()
					+ "]", e);
			e.printStackTrace();
		} catch (SAXException e) {
			logger.error("Error occurs during load dictionary file[" + resouce.getFilename()
					+ "]", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Error occurs during load dictionary file[" + resouce.getFilename()
					+ "]", e);
			e.printStackTrace();
		}

		if (logger.isInfoEnabled())
			logger.info("dictionary file["+resouce.getFilename()+"] loaded.");
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private DictionaryImpl traversal(Node node) {
		if (node == null || node.getNodeType() != Node.ELEMENT_NODE)
			return null;
	
		NodeList list = node.getChildNodes();
		if (list.getLength() < 1)
			return null;
	
		DictionaryImpl dict = new DictionaryImpl();
		
		dict.setName(node.getNodeName());
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		for (int i = 0; i < list.getLength(); i++) {
			Node item = list.item(i);
			if (item.getNodeName().equalsIgnoreCase("item")
					&& item.getNodeType() == Node.ELEMENT_NODE)
				parseItem((Element)item,map);
		}
		
		dict.setItems(map);
		
		if(this.logger.isDebugEnabled()){
			logger.debug("dict["+dict.getName()+"]");
			logger.debug(dict.getItems());
			logger.debug("=======================");
		}
		
		return dict;
	}
	
	private void parseItem(Element item,Map<String,String> map){
		String code = item.getAttribute("code");
		String value = item.getTextContent();
		map.put(code, value);
	}
	
	/**
	 * @param dictionaryProvider The dictionaryProvider to set.
	 */
	public void setDictionaryProvider(DictionaryProvider dictionaryProvider) {
		this.dictionaryProvider = dictionaryProvider;
	}
	
	/**
	 * @param filepaths The filepaths to set.
	 */
	public void setFilepaths(List<String> filepaths) {
		this.filepaths = filepaths;
	}
		
	
}
