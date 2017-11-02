# XMLStudentExamSys

This System only used to demonstrate how to use JAXP DOM read information from or write to a XML file with a specific construction that we have already decided.

This system based on JAXP DOM (Document Object Model). A DOM is a standard tree structure, where each node contains one of the components from an XML structure. The two most common types of nodes are element nodes and text nodes. Using DOM functions lets you create nodes, remove nodes, change their contents, and traverse the node hierarchy.

Step 1. Construted A XML file to store student information.

<img width="464" alt="xmlfileformat" src="https://user-images.githubusercontent.com/22246345/32303733-6016b0fc-bf38-11e7-84a0-c7df8de78f61.png">

Step 2. Build a JavaBean for Student.

```
public class Student {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:"+ getName()+"\n"+"ExamID:"+getExamid()+"\n"+"SSN:"
				+getId()+"\n"+"Location:"+getLocation()+"\n"+"Grade:"+getGrade()+"\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	private String name;
	private String id;
	private String examid;
	private String location;
	private int grade;
}
```


Step 3. Prapera your XMLUtils which is used to Read and Write XML file.



```
private static String filepath = "Data/Exam.xml";
```

Write method to get Document from directory.
```
public static Document getDocument(){
    //static method used to get a DocumentBuilderFactory;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    
		DocumentBuilder db;
		Document document = null;
		try {
			db = dbf.newDocumentBuilder();
			document = db.parse(filepath);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
  ```
  
  
  Write method to write your document from RAW to your file.
  ```
  public static void write2Document(Document document){
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tran;
		try {
			tran = tf.newTransformer();
			tran.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filepath)));
			DOMSource source = new DOMSource(document);
			tran.transform(source, new StreamResult(new FileOutputStream(filepath)));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
  ```
  
