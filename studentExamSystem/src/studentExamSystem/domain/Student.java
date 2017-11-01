package studentExamSystem.domain;
//javabean of student
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
