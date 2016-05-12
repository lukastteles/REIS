package com.br.uepb.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Element;

public class Entry {
	
	private List<Entry> entries =  new ArrayList<Entry>();
	private Map<String, Entry> entries_map = new HashMap<String, Entry>();	
	private Map<String, String> meta; 
	private Pair<Boolean, Element> node; //se true -> compound, se false -> basic
	private String name, dtype, value;
	private Boolean compound;
	
	public Entry(Element entry) throws Exception {
		 meta = parse_meta(entry);		 				 
		 node = detect_type(entry);
		 name = parse_name(node.getSecond());
		 
		 //Se a tag for do tipo "compound"		 
		 if(node.getFirst()){ 
			 Pair<List<Entry>,Map<String, Entry> > sub_entries = parse_children(node.getSecond());
		     entries = sub_entries.getFirst();
		     entries_map = sub_entries.getSecond();
		     compound = true;
		 }
		 else { //Se a tag for do tipo "simple"
			 Pair<String,String> simple = parse_simple(node.getSecond());
		     dtype = simple.getFirst();
		     value = simple.getSecond();		     
		     compound = false;
		 }
	}
	
	private Map<String, String> parse_meta(Element node) throws Exception {		
		Map<String,String> m = new HashMap<String, String>();		
		
		if(node.getChildren("meta-data").size() > 1) {
			throw new Exception("Existe mais de um meta-data");
		}
			
		if (node.getChildren("meta-data").isEmpty()) {
			return m;
		}
		
		//Como só tem 1 filho "meta-data" ele recupera o primeiro filho do tipo "meta-data"
		Element meta = node.getChild("meta-data");
		List<Element> metas = meta.getChildren("meta");
		for (Element element : metas) {
			Pair<String, String> nameValue = parse_metadata(element);
			m.put(nameValue.getFirst(), nameValue.getSecond());			
		}
		
		return m;
	}
	
	private Pair<String, String> parse_metadata(Element meta) throws Exception {
		Pair<String, String> nameValue = new Pair<String, String>(null, null);	
		
		if(meta.getAttributes().isEmpty()) {
			throw new Exception("Nenhum atributo no meta data");
		}

		nameValue.setFirst(meta.getAttributeValue("name"));
		nameValue.setSecond(meta.getText());
		return nameValue;		
	}
	
	private Pair<Boolean, Element> detect_type(Element node) throws Exception {
		Pair<Boolean, Element> fragment = new Pair<Boolean, Element>(null, null);
	    
	    if(( node.getChildren("simple").size() > 1) || (node.getChildren("compound").size() > 1) ){
	    	throw new Exception("existe mais de de um simple ou compound");
	    }

	    Element simpleElement = node.getChild("simple");
	    Element compoundElement = node.getChild("compound");
	    
	    //metodo para verificar se tem elementos compound ou simple
	    fragment.setFirst(!(compoundElement == null));
	    if(fragment.getFirst())
	        fragment.setSecond(compoundElement);
	    else
	    	fragment.setSecond(simpleElement);

	    return fragment;	
	}
	
	private String parse_name(Element node) throws Exception
	{
	    Element name = node.getChild("name");
	    if(name == null){
	    	throw new Exception("Não existe nenhum nome");
	    }
	    return name.getText();
	}
	
	private Pair<List<Entry>,Map<String,Entry> > parse_children(Element node) throws Exception
	{
		//Apenas cria estes objetos para instanciar
		List<Entry> entries_empty =  new ArrayList<Entry>();
		Map<String, Entry> entries_map_empty = new HashMap<String, Entry>();	
		
	    Pair<List<Entry>,Map<String,Entry> > sub_entries = new Pair<List<Entry>, Map<String,Entry>>(entries_empty, entries_map_empty);

	    if( node.getChildren("entries").size() > 1 ){
	    	throw new Exception("Compound com numero de entradas de tag errada");
	    }

	    Element entry_compound = node.getChild("entries");
	    
	    List<Element> entryList = entry_compound.getChildren();
	    for (Element element : entryList) {
	    	Entry currentEntry = new Entry(element);	    	
	    	sub_entries.getFirst().add(currentEntry);
	    	sub_entries.getSecond().put(currentEntry.name, currentEntry);
	    }
	    return sub_entries;
	}
	
	private Pair<String,String> parse_simple(Element node) throws Exception
	{
	    Element type = node.getChild("type");
	    Element value = node.getChild("value");

	    if (type == null){
	    	throw new Exception("Erro: type");
	    }
	    if (value == null){
	    	throw new Exception("Erro: value");
	    }
	    
	    Pair<String,String> simple = new Pair<String, String>(null, null);
	    simple.setFirst(type.getText());
	    simple.setSecond(value.getText());
	    
	    return simple;
	}
	
	public String getName()
	{
	    return name;
	}

	public List<Entry> getEntries()
	{
	    return entries;
	}

	public String getValue() 
	{
	    return value;
	}
	
	public Map<String, String> getMeta()
	{
	    return meta;
	}

	public Map<String, Entry> getEntries_map()
	{
	    return entries_map;
	}
}
