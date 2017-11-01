package studentExamSystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import studentExamSystem.domain.Student;
import studentExamSystem.excpetion.StudentNotExistException;
import studentExamSystem.utils.XMLUtils;

public class ExamDao implements ExamDaoInterface{

	@Override
	public Student findByID(String id) throws StudentNotExistException {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		NodeList list = document.getElementsByTagName("id");
		Student student = null;
		for(int i = 0; i < list.getLength(); i++){
			if(list.item(i).getTextContent().equals(id)){
				Element element= (Element)list.item(i).getParentNode();
				student = new Student();
				student.setExamid(element.getElementsByTagName("examid").item(0).getTextContent());
				student.setId(element.getElementsByTagName("id").item(0).getTextContent());
				student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());
				student.setGrade(Integer.valueOf(element.getElementsByTagName("grade").item(0).getTextContent()));
				student.setName(element.getElementsByTagName("name").item(0).getTextContent());
				return student;
			}
		}
		throw new StudentNotExistException( "Student ID: "+id+" not Exist!");
	}

	@Override
	public Student findByExamID(String examID) throws StudentNotExistException {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		NodeList list = document.getElementsByTagName("examid");
		Student student = null;
		for(int i = 0; i < list.getLength(); i++){
			if(list.item(i).getTextContent().equals(examID)){
				Element element= (Element)list.item(i).getParentNode();
				student = new Student();
				student.setExamid(element.getElementsByTagName("examid").item(0).getTextContent());
				student.setId(element.getElementsByTagName("id").item(0).getTextContent());
				student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());
				student.setGrade(Integer.valueOf(element.getElementsByTagName("grade").item(0).getTextContent()));
				student.setName(element.getElementsByTagName("name").item(0).getTextContent());
				return student;
			}
		}
		throw new StudentNotExistException( "Student ExamID: "+examID+" not Exist!");
	}

	@Override
	public Student[] findByName(String name) throws StudentNotExistException {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		NodeList list = document.getElementsByTagName("name");
		List<Student> student_list = new ArrayList();
		for(int i = 0; i < list.getLength(); i++){
			if(list.item(i).getTextContent().equals(name)){
				Element element= (Element)list.item(i).getParentNode();
				Student student = new Student();
				student.setExamid(element.getElementsByTagName("examid").item(0).getTextContent());
				student.setId(element.getElementsByTagName("id").item(0).getTextContent());
				student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());
				student.setGrade(Integer.valueOf(element.getElementsByTagName("grade").item(0).getTextContent()));
				student.setName(element.getElementsByTagName("name").item(0).getTextContent());
				student_list.add(student);
			}
		}
		if(student_list.size() == 0){
			throw new StudentNotExistException( "Student name: "+name+" not Exist!");
		}
		return (Student[])student_list.toArray();
	}

	@Override
	public Student[] findByLocation(String location) throws StudentNotExistException {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		NodeList list = document.getElementsByTagName("location");
		List<Student> student_list = new ArrayList();
		for(int i = 0; i < list.getLength(); i++){
			if(list.item(i).getTextContent().equals(location)){
				Element element= (Element)list.item(i).getParentNode();
				Student student = new Student();
				student.setExamid(element.getElementsByTagName("examid").item(0).getTextContent());
				student.setId(element.getElementsByTagName("id").item(0).getTextContent());
				student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());
				student.setGrade(Integer.valueOf(element.getElementsByTagName("grade").item(0).getTextContent()));
				student.setName(element.getElementsByTagName("name").item(0).getTextContent());
				student_list.add(student);
			}
		}
		if(student_list.size() == 0){
			throw new StudentNotExistException( "Student at this location: "+location+" not Exist!");
		}
		return (Student[])student_list.toArray();
	}

	@Override
	public Student[] findByGrade(int grade) {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		NodeList list = document.getElementsByTagName("grade");
		List<Student> student_list = new ArrayList();
		for(int i = 0; i < list.getLength(); i++){
			if(list.item(i).getTextContent().equals(grade)){
				Element element= (Element)list.item(i).getParentNode();
				Student student = new Student();
				student.setExamid(element.getElementsByTagName("examid").item(0).getTextContent());
				student.setId(element.getElementsByTagName("id").item(0).getTextContent());
				student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());
				student.setGrade(Integer.valueOf(element.getElementsByTagName("grade").item(0).getTextContent()));
				student.setName(element.getElementsByTagName("name").item(0).getTextContent());
				student_list.add(student);
			}
		}
		return (Student[])student_list.toArray();
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		
		Element exam = (Element)document.getElementsByTagName("Exam").item(0);
		
		Element student_tag = document.createElement("Student");
		
		Element name = document.createElement("name");
		Element id = document.createElement("id");
		Element examid = document.createElement("examid");
		Element location = document.createElement("location");
		Element grade = document.createElement("grade");
		
		name.setTextContent(student.getName());
		id.setTextContent(student.getId());
		examid.setTextContent(student.getExamid());
		location.setTextContent(student.getLocation());
		grade.setTextContent(String.valueOf(student.getGrade()));
		
		student_tag.appendChild(name);
		student_tag.appendChild(id);
		student_tag.appendChild(examid);
		student_tag.appendChild(location);
		student_tag.appendChild(grade);
		
		exam.appendChild(student_tag);
		
		XMLUtils.write2Document(document);
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		
		Element exam_tag = (Element)document.getElementsByTagName("Exam").item(0);
		
		NodeList student_list = document.getElementsByTagName("Student");
		
		for(int i = 0 ; i < student_list.getLength();i++){
			Element student_tag = (Element)student_list.item(i);
			Element id = (Element)student_tag.getElementsByTagName("id").item(0);
			if(student.getId().equals(id.getTextContent())){
				exam_tag.removeChild(student_tag);
				break;
			}
		}
		XMLUtils.write2Document(document);
	}

	@Override
	public void update(Student student) throws StudentNotExistException {
		// TODO Auto-generated method stub
		Document document = XMLUtils.getDocument();
		NodeList student_list = document.getElementsByTagName("Student");
		
		for(int i = 0; i < student_list.getLength(); i++){
			Element student_tag = (Element)student_list.item(i);
			String id = student_tag.getElementsByTagName("id").item(0).getTextContent();
			if(id.equals(student.getId())){
				student_tag.getElementsByTagName("name").item(0).setTextContent(student.getName());
				student_tag.getElementsByTagName("examid").item(0).setTextContent(student.getExamid());
				student_tag.getElementsByTagName("location").item(0).setTextContent(student.getLocation());
				student_tag.getElementsByTagName("grade").item(0).setTextContent(String.valueOf(student.getGrade()));
				XMLUtils.write2Document(document);
				return;
			}
		}
		
		throw new StudentNotExistException( "Student ID: "+student.getId()+" not Exist!");
		
	}
	
}
