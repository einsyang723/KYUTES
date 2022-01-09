package AB;

public class student_information {
	private String stuID;
	private String name; 
	private String sex; 
	private String age; 
	private String callnumber; 
	private String password; 
	private String identityID; 

	public student_information() {

	}

	
	public student_information(String stuID, String name, String sex, String age, String callnumber, String home_place,
			String identityID) {
		super();
		this.stuID = stuID;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.callnumber = callnumber;
		this.password = home_place;
		this.identityID = identityID;
	}

	public String getStuID() {
		return this.stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCallnumber() {
		return this.callnumber;
	}

	public void setCallnummber(String callnumber) {
		this.callnumber = callnumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setHome_place(String password) {
		this.password = password;
	}

	public String getIdentityID() {
		return this.identityID;
	}

	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}

	
	public String fileString() {
		return stuID + " " + name + " " + sex + " " + age + "  " + callnumber + "  " + password + "  " + identityID;
	}

}