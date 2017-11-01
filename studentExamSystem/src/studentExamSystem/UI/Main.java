package studentExamSystem.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import studentExamSystem.dao.ExamDao;
import studentExamSystem.dao.ExamDaoInterface;
import studentExamSystem.domain.Student;
import studentExamSystem.excpetion.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ExamDaoInterface edi = new ExamDao();
			while (true) {
				System.out.println("Add Student (a) 	Delete Student(b)	Find Student(c)	UpdateStudent(d)	Exit(exit)");
				System.out.print("please input type of operation:");

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String type = br.readLine();

				if ("a".equals(type)) {
					System.out.print("please input student name:");
					String name = br.readLine();
					System.out.print("please input student SSN:");
					String id = br.readLine();
					System.out.print("please input student examid:");
					String examid = br.readLine();
					System.out.print("please input student location:");
					String location = br.readLine();
					System.out.print("please input student grade:");
					String grade = br.readLine();

					Student student = new Student();
					student.setExamid(examid);
					student.setId(id);
					student.setName(name);
					student.setLocation(location);
					student.setGrade(Integer.parseInt(grade));

					edi.add(student);
					System.out.println("Student added!");
					continue;
				} else if ("b".equals(type)) {
					System.out.print("please input student id you want to delete:");
					String id = br.readLine();

					Student student = new Student();
					student.setId(id);

					edi.delete(student);
					continue;
				} else if ("c".equals(type)) {
					System.out.println(
							"Find student by SSN(a)	" + "Find student by ExamID(b)			Find student by name(c)"
									+ "		Find student by Location(d) 	Find student by Grade(e)		Back(back)");
					System.out.print("please input your operation:");
					String findType = br.readLine();
					if ("a".equals(findType)) {
						System.out.print("please input student SSN:");
						String id = br.readLine();
						Student student = edi.findByID(id);
						System.out.println(student.toString());
						continue;
					} else if ("b".equals(findType)) {
						System.out.print("please input student examID:");
						String id = br.readLine();
						Student student = edi.findByID(id);
						System.out.println(student.toString());
						continue;
					} else if ("c".equals(findType)) {
						System.out.print("please input student name:");
						String name = br.readLine();
						Student[] student_list = edi.findByName(name);
						for (Student student : student_list) {
							System.out.println(student.toString());
						}
						continue;
					} else if ("d".equals(findType)) {
						System.out.print("please input student location:");
						String location = br.readLine();
						Student[] student_list = edi.findByLocation(location);
						for (Student student : student_list) {
							System.out.println(student.toString());
						}
						continue;
					} else if ("e".equals(findType)) {
						System.out.print("please input student grade:");
						String grade = br.readLine();
						Student[] student_list = edi.findByGrade(Integer.parseInt(grade));
						for (Student student : student_list) {
							System.out.println(student.toString());
						}
						continue;
						
					}else if("back".equals(findType)){
						continue;
					} else {
						System.out.println("Input Error!");
						continue;
					}
				} else if ("d".equals(type)) {
					System.out.print("please input student SSN you want to update:");
					String id = br.readLine();

					Student student = new Student();
					student.setId(id);

					System.out.print("please input student name:");
					String name = br.readLine();
					System.out.print("please input student examid:");
					String examid = br.readLine();
					System.out.print("please input student location:");
					String location = br.readLine();
					System.out.print("please input student grade:");
					String grade = br.readLine();

					student.setExamid(examid);
					student.setName(name);
					student.setLocation(location);
					student.setGrade(Integer.parseInt(grade));

					edi.update(student);
					continue;
				} else if("exit".equals(type)){
					break;
				}else {
					System.out.println("Input Error!");
					continue;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StudentNotExistException e) {
			// TODO Auto-generated catch block
			System.out.println("Student not Exist!");
			e.printStackTrace();
		}
	}

}
