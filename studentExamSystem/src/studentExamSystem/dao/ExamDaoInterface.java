package studentExamSystem.dao;

import studentExamSystem.domain.Student;
import studentExamSystem.excpetion.StudentNotExistException;

public interface ExamDaoInterface {
	public Student findByID(String id)throws StudentNotExistException;
	
	public Student findByExamID(String examID)throws StudentNotExistException;
	
	public Student[] findByName(String name)throws StudentNotExistException;
	
	public Student[] findByLocation(String location)throws StudentNotExistException;
	
	public Student[] findByGrade(int grade);
	
	public void add(Student student);
	
	public void delete(Student student)throws StudentNotExistException;
	
	public void update(Student student) throws StudentNotExistException;
}
