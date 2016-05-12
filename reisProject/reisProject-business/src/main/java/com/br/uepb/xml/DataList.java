package com.br.uepb.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class DataList {
	
	private List<Entry> entries =  new ArrayList<Entry>();
	private Map<String, Entry> entries_map = new HashMap<String, Entry>();
	
	public DataList(String pathXML) throws Exception {
		File docXML = new File(pathXML);
		SAXBuilder sBuilder = new SAXBuilder();
		
		Document document = null;
		try {
			document = sBuilder.build(docXML);
		} catch (JDOMException e) {
			//TODO tratar este erro
			throw new Exception(e.getMessage());
		} catch (IOException e) {
			throw new Exception(e.getMessage());
		}
		
		//recupera o primeiro elemento "root"  
		Element rootElement = document.getRootElement();
		
		//lê todos os filhos do XML
		List<Element> filhos = rootElement.getChildren();		
		for (Element element : filhos) {
			//Cria um novo Elemento aqui 
			Entry entry = new Entry(element);
			entries.add(entry); //Adiciona as entidades
			entries_map.put(element.getName(), entry); //adiciona um mapa de entidades
		}
	}
	
	public List<Entry> getEntries() 
	{			
	    return entries;
	}
	
	public Map<String, Entry> getEntries_Map() 
	{			
	    return entries_map;
	}	
}
