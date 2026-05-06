package com.guidewire.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

//import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import org.apache.poi.hslf.record.Document;
//import org.w3c.css.sac.InputSource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

public class Xml_Reader {

	private static String role1 = null;
	private static String role2 = null;
	private static String role3 = null;
	private static String role4 = null;
	private ArrayList<String> rolev;
	
	public static void ReadFromXML(String XmlLocation, String XML_FileName) throws ParserConfigurationException, SAXException, IOException, Exception {
		
		String NodeName = "";
		String NodeTextContent = "";
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(XmlLocation+XML_FileName));
		Element rootElement = document.getDocumentElement();
		
		NodeList nodelist = rootElement.getElementsByTagName("*");
//		System.out.println("Total nodes in the node list: "+nodelist.getLength());
		if (nodelist != null && nodelist.getLength() > 0) {
			for(int i = 0; i<nodelist.getLength(); i++) {
				
				NodeName = nodelist.item(i).getNodeName();
				NodeTextContent = nodelist.item(i).getTextContent();
				if(!NodeTextContent.contains("\n")) {
					System.out.println("Node"+(i+1)+" Name: "+nodelist.item(i).getNodeName()+"   Node value: "+nodelist.item(i).getTextContent());
				}
				
				
				NodeList Node_subList = nodelist.item(i).getChildNodes();
				if (Node_subList != null && Node_subList.getLength() > 1) {
//					System.out.println("Number of sub nodes for the current node: "+Node_subList.getLength());
				}
//	            if (Node_subList != null && Node_subList.getLength() > 0) {
//	            	for(int j=0; j<Node_subList.getLength(); j++) {
//	            		//System.out.println(nodelist.item(j).getNodeName()+" "+Node_subList.item(j).getNodeValue());
//	            		System.out.println("Sub list item: "+Node_subList.item(j).getNodeValue());
//	            	}
//	            }
			}
        }

		System.out.println("Tag Name of the root element: "+rootElement.getTagName());
	}
	
	
	public static void Read_xmlChildNodes(String XmlLocation, String XML_FileName) throws Exception{
		
		//Declaration
		String EmailID = "";
		String InstanceID = "";
		String MsgName = "";
		
		
		/*
		 * Declaration to access the root element
		 */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(XmlLocation+XML_FileName));
		Element rootElement = document.getDocumentElement();
		
		NodeList nList = rootElement.getChildNodes();
		//Check if the nList has nodes or not
		if(nList!=null) {
			for(int i=0; i<nList.getLength(); i++) {
				Element el =  (Element) nList.item(i);
				if(el.getNodeName().equalsIgnoreCase("validateEmail")) {
					EmailID = el.getElementsByTagName("emailid").item(i).getTextContent();
					InstanceID = el.getElementsByTagName("instanceid").item(i).getTextContent();
					MsgName = el.getElementsByTagName("msgname").item(i).getTextContent();
				}
			}
		}
		
		System.out.println("EmailID: "+EmailID);
		
//		NodeList nodelist = rootElement.getElementsByTagName("validateEmail");
//		NodeList Node_SubList = nodelist.item(0).getChildNodes();
//		
//		int ChildNodes_Count = nodelist.item(0).getChildNodes().getLength();
//		for(int i=0;i<ChildNodes_Count;i++) {
//			System.out.println(Node_SubList.item(i).getNodeName());
//		}
		
	}
	
	public static void saveToXML(String xml) {
	    Document dom;
	    Element e = null;

	    // instance of a DocumentBuilderFactory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        // use factory to get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // create instance of DOM
	        dom = db.newDocument();

	        // create the root element
	        Element rootEle = dom.createElement("roles");

	        // create data elements and place them under root
	        e = dom.createElement("role1");
	        e.appendChild(dom.createTextNode(role1));
	        rootEle.appendChild(e);

	        e = dom.createElement("role2");
	        e.appendChild(dom.createTextNode(role2));
	        rootEle.appendChild(e);

	        e = dom.createElement("role3");
	        e.appendChild(dom.createTextNode(role3));
	        rootEle.appendChild(e);

	        e = dom.createElement("role4");
	        e.appendChild(dom.createTextNode(role4));
	        rootEle.appendChild(e);

	        dom.appendChild(rootEle);

	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            // send DOM to file
	            tr.transform(new DOMSource(dom), 
	                                 new StreamResult(new FileOutputStream(xml)));

	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	}

}
