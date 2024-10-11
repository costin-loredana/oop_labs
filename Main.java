class Student{
	private String name;
	private int age;
	public String getName() {
        return name;
    }
	public void setName(String name) {
        this.name = name;
    }
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}

public class Main {
	 public static void main(String[] args){
		
		Student Elev = new Student();

		Elev.setName("Betty");
		Elev.setAge(19);

		System.out.println("Student Name: " + Elev.getName());
        System.out.println("Student Age: " + Elev.getAge());

	 }
}