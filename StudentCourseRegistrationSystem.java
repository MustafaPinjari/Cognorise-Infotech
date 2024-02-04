import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Course {
    String title;
    String description;
    int capacity;
    String schedule;
    List<String> studentsRegistered;

    public Course(String title, String description, int capacity, String schedule) {
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.studentsRegistered = new ArrayList<>();
    }
}

class Student {
    List<String> registeredCourses;

    public Student() {
        this.registeredCourses = new ArrayList<>();
    }
}

public class StudentCourseRegistrationSystem {
    Map<String, Course> courseDatabase;
    Map<String, Student> studentDatabase;

    public StudentCourseRegistrationSystem() {
        this.courseDatabase = new HashMap<>();
        this.studentDatabase = new HashMap<>();
    }

    public void addCourse(String courseCode, String title, String description, int capacity, String schedule) {
        courseDatabase.put(courseCode, new Course(title, description, capacity, schedule));
    }

    public void displayCourses() {
        System.out.println("Course Listing:");
        for (Map.Entry<String, Course> entry : courseDatabase.entrySet()) {
            String code = entry.getKey();
            Course details = entry.getValue();

            System.out.println("Course Code: " + code);
            System.out.println("Title: " + details.title);
            System.out.println("Description: " + details.description);
            System.out.println("Capacity: " + details.capacity);
            System.out.println("Schedule: " + details.schedule);
            System.out.println("Available Slots: " + (details.capacity - details.studentsRegistered.size()));
            System.out.println();
        }
    }

    public void registerStudent(String studentId, String courseCode) {
        studentDatabase.putIfAbsent(studentId, new Student());

        if (courseDatabase.containsKey(courseCode)) {
            Course course = courseDatabase.get(courseCode);

            if (course.studentsRegistered.size() < course.capacity) {
                course.studentsRegistered.add(studentId);
                studentDatabase.get(studentId).registeredCourses.add(courseCode);
                System.out.println("Student " + studentId + " successfully registered for " + courseCode + ".");
            } else {
                System.out.println("Course is already full. Cannot register.");
            }
        } else {
            System.out.println("Invalid course code.");
        }
    }

    public void dropCourse(String studentId, String courseCode) {
        if (studentDatabase.containsKey(studentId) && courseDatabase.containsKey(courseCode)) {
            Student student = studentDatabase.get(studentId);
            Course course = courseDatabase.get(courseCode);

            if (student.registeredCourses.contains(courseCode)) {
                course.studentsRegistered.remove(studentId);
                student.registeredCourses.remove(courseCode);
                System.out.println("Student " + studentId + " successfully dropped " + courseCode + ".");
            } else {
                System.out.println("Student is not registered for this course.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    public static void main(String[] args) {
        StudentCourseRegistrationSystem registrationSystem = new StudentCourseRegistrationSystem();

        // Adding courses
        registrationSystem.addCourse("CS101", "Introduction to Computer Science", "Basic concepts of CS", 30, "Mon/Wed 10:00 AM");
        registrationSystem.addCourse("CS202", "Data Structures", "Fundamental data structures", 25, "Tue/Thu 2:00 PM");

        // Displaying available courses
        registrationSystem.displayCourses();

        // Registering students
        registrationSystem.registerStudent("S001", "CS101");
        registrationSystem.registerStudent("S002", "CS101");
        registrationSystem.registerStudent("S003", "CS202");

        // Displaying courses after registration
        registrationSystem.displayCourses();

        // Dropping a course
        registrationSystem.dropCourse("S002", "CS101");

        // Displaying courses after dropping
        registrationSystem.displayCourses();
    }
}
