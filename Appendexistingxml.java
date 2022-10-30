
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class Appendexistingxml {

public static void main(String[] args)
{

//
Path root=Paths.get("C:\\Users\\smohanra\\Documents\\zip_trial\\zip_assembly_archive_2\\site.xml");
String location=root.toString();
subfoldercount(location);
appendxml(location);
}


	public static void appendxml(String location) 
	{
try {
File xmlFile = new File(location);
String[] files = xmlFile.list();
int  limit=subfoldercount(location)+1;
//limit=limi;
String Length=Integer.toString(limit);
String Fileentry="product_tibco_tbs_product_p2_repo_4.19.0.303.zip";
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

	 public static int subfoldercount(String location)
	 {
	 	 String path = location;
	       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	       int length = 0;
	       try (InputStream is = new FileInputStream(path)) {

	           DocumentBuilder db = dbf.newDocumentBuilder();

	           Document doc = db.parse(is);

	           // get all elements known as "staff"
	           NodeList list = doc.getElementsByTagName("name");
	           length = list.getLength();
	           length= length-1;
	            //1=subfolderxml 2nd for main archive
	           System.out.println("Number of subfolders are : " + length);

	       } catch (ParserConfigurationException | SAXException | IOException e) {
	           e.printStackTrace();
	       }
	       
	       return length;
	 }
}
//logic for call
	if(filecount >=limit)//check whether need of new folder or not
		{
			source = f.createfolder(root, subfolderc,str);
			System.out.println("New Source:"+ source);
			if(xmlfile.exists())
			{
			Subfolderxmlappend.mainxmlsub();
			}
			else
			{
				//String s = source.toString();
				//File fi = new File(s);
				//String[] files = fi.list();
				 XMLCr.mainxml();
			}
		}
		else
		{
			System.out.println("File Count not breached to Maximum File limit ,No need to create new directory ");
		}
if(filecount == 0)
		{
			System.err.println("Cant create or update XML as directory is null");
		}
		else
		{
			String s = source.toString();
			File fi = new File(s);
			String[] files = fi.list();
			
			File temp = new File(s+ "\\site.xml");
			if(temp.exists())
			{
				Testone.updatexmlmain();
				System.out.println("updated for"+files);
			}
			else {
				
				createxml(files,s); 
			System.out.println("Created/Updated XML for: "+files.length +" files");
			}
		}
		
	

		String s = source.toString();
		String path;
		for(int i=1;i<subfolderc;i++)
		{
			
			path = s +"_"+i;
			File fi = new File(path);
			String[] files = fi.list();
			Arrays.sort(files);
			 File temp = new File(path+ "\\site.xml");
			//System.out.println("Inside SubFolder:"+path);
			if(temp.exists())
			{
				Testone.updatexmlmain();
			
			
			}
			else {
				
				createxml(files,s); 
			
			}	
			
			readxml(path);	
		}
