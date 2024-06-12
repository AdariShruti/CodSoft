import java.util.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int registered;
    private List<String> schedule;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.registered = 0;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRegistered() {
        return registered;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void register() {
        if (registered < capacity) {
            registered++;
        }
    }

    public void drop() {
        if (registered > 0) {
            registered--;
        }
    }
}

class Student {
    private String id;
    private String name;
    private List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.getRegistered() < course.getCapacity()) {
            course.register();
            registeredCourses.add(course);
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("Course is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.drop();
            registeredCourses.remove(course);
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("You are not registered for this course.");
        }
    }
}

public class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listCourses() {
        for (Course course : courses) {
            System.out.println("Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Registered: " + course.getRegistered());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println();
        }
    }

    public void registerStudentForCourse(Student student, Course course) {
        student.registerCourse(course);
    }

    public void dropStudentFromCourse(Student student, Course course) {
        student.dropCourse(course);
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        Course course1 = new Course("CS101", "Introduction to Computer Science", "Introduction to computer science", 30, Arrays.asList("Monday 9:00 AM", "Wednesday 2:00 PM"));
        Course course2 = new Course("CS202", "Data Structures", "Data structures and algorithms", 25, Arrays.asList("Tuesday 10:00 AM", "Thursday 3:00 PM"));

        system.addCourse(course1);
        system.addCourse(course2);

        Student student1 = new Student("S101", "John Doe");
        Student student2 = new Student("S102", "Jane Doe");

        system.addStudent(student1);
        system.addStudent(student2);

        system.listCourses();

        system.registerStudentForCourse(student1, course1);
        system.registerStudentForCourse(student2, course2);

        system.dropStudentFromCourse(student1, course1);
    }
}
