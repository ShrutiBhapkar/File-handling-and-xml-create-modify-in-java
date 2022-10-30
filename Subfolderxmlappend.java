
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

 class Subfolderxmlappend
{
public static void mainxmlsub()throws Exception
{
	
		Path root=Paths.get("G:\\tsi\\site.xml");
		String location=root.toString();
		subfoldercountdir(location);
		updatesubxml(location);
	}
	public static void updatesubxml(String location)	
	{
	try {
	File xmlFile = new File(location);
	String[] files = xmlFile.list();
	
	int limit=subfoldercountdir(location);

	String Length=Integer.toString(limit);
	String Fileentry="zip_assembly_archive_"+Length;
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	Document document = documentBuilder.parse(xmlFile);
	Element documentElement = document.getDocumentElement();
	Element textNode = document.createElement("File");
	textNode.setAttribute("id", String.valueOf(Length));
	Element textNode1 = document.createElement("name");
	textNode1.setTextContent(Fileentry);
	Element nodeElement = document.createElement("File");
	nodeElement.appendChild(textNode);
	nodeElement.appendChild(textNode1);
	documentElement.appendChild(nodeElement);
	document.replaceChild(documentElement, documentElement);
	Transformer tFormer =
	TransformerFactory.newInstance().newTransformer();
	tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
	Source source = new DOMSource(document);
	Result result = new StreamResult(xmlFile);
	tFormer.transform(source, result);
	} catch (Exception ex) {
	System.out.println(ex);
	}
		}
	public static int subfoldercountdir(String location)
	{
			
			//String path=root.toString();
		 String  path = location;
		  int length=0;
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      try (InputStream is = new FileInputStream(path)) {

	          DocumentBuilder db = dbf.newDocumentBuilder();

	          Document doc = db.parse(is);

	          // get all elements known as "staff"
	          NodeList list = doc.getElementsByTagName("name");
	         length = list.getLength();
	          length = length -2; //1=subfolderxml 2nd for main archive
	          System.out.println("Number of files are : " + length);

	      } catch (ParserConfigurationException | SAXException | IOException e) {
	          e.printStackTrace();
	      }
	     
		return length;
	}

	}

