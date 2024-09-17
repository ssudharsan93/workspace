package firstproj;

public class Person {
	private int age;
	private String firstName;
	private String lastName;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void info() {
		System.out.println("My Name is : " + firstName + " " + lastName);
		System.out.println("My Age is: " + age);
	}
	
	public Person(int age, String firstName, String lastName) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static void main(String [] args) {
		Person p = new Person(26, "Bob", "Roberts");
		p.info();
    }
}