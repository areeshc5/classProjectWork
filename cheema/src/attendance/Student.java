package attendance;

public class Student implements Attendee{
	
	private String firstName;
	private String lastName;
	private boolean present;
	
	public Student(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.present = false;
	}
	
	public boolean isPresent() {
		
		return present;
	}
	
	public void setPresent(boolean present) {
		
		this.present = present;
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	 public String getLastName() {
		 
		 return lastName;
	 }
	
	 public boolean mathces(String first, String last) {
		 
		 if(first.toLowerCase().equals(firstName.toLowerCase())&& last.toLowerCase().equals(lastName.toLowerCase())) {
			 
			 return true;
		 }
			
		 else {
			 return false;
		 
		 }
	 }
	 
	 public boolean matches(String last) {
		 
		 if(last.toLowerCase().equals(lastName.toLowerCase())) {
			 return true;
		 }
		  return false;
		 
	 }
	 
	 public String getReportString() {
		 
		 String rs = lastName;
		 
		 rs = space(rs, 20);
		 
		 rs += firstName;
		
		 rs = space(rs, 40);
			if (present == true) {
				rs += "Present";
			}
				
			else {
				rs += "Absent";
			}
		 
		return rs;
	 }

	 public String space(String s, int length) {
		 
		 while(s.length() < length) {
			 s += " ";
		 }
		 
		 return s;
	 }
}
	 
