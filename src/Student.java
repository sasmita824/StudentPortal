
public class Student {


	    private int id;
	    private String name;
	    private String email;
	    private String course;

	    // Constructor
	    public Student(int id, String name, String email, String course) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.course = course;
	    }

	    // Getters
	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getCourse() {
	        return course;
	    }

	    // Setters
	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setCourse(String course) {
	        this.course = course;
	    }

	    // Display method
	    public void displayStudent() {
	        System.out.println(
	            "ID: " + id +
	            " | Name: " + name +
	            " | Email: " + email +
	            " | Course: " + course
	        );
	    }
	}

