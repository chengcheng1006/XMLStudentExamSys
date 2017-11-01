package test;

import org.junit.Test;

import studentExamSystem.dao.ExamDao;
import studentExamSystem.dao.ExamDaoInterface;
import studentExamSystem.domain.Student;
import studentExamSystem.excpetion.StudentNotExistException;

public class Test1 {
	
//	@Test
	public void test1(){
		ExamDaoInterface ed = new ExamDao();
		Student student = null;
		try {
			student = ed.findByID("222");
		} catch (StudentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println(student.toString());
	}
//	@Test
	public void test2(){
		Student student = new Student();
		student.setExamid("555");
		student.setId("666");
		student.setName("MT");
		student.setLocation("河北");
		student.setGrade(101);
		
		ExamDaoInterface edInterface = new ExamDao();
		edInterface.add(student);
	}
//	@Test
	public void test3(){
		Student student = new Student();
		student.setId("666");
		ExamDaoInterface ed = new ExamDao();
		try {
			ed.delete(student);
		} catch (StudentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
//	@Test
	public void test4() {
		ExamDaoInterface ed = new ExamDao();
		Student student = null;
		try {
			student = ed.findByID("222");
		} catch (StudentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		student.setGrade(180);
		student.setLocation("上海");
		student.setExamid("777");
		try {
			ed.update(student);
		} catch (StudentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Information update success!");
	}
	@Test
	public void test5() throws StudentNotExistException{
		ExamDaoInterface ed = new ExamDao();
		Student student = null;
		ed.findByExamID("");
		System.out.println(student.toString());
	}
}
