package com.example.springsecuritytelugu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityTeluguApplicationTests {

  @Test
  void contextLoads() {
  }


  /**
   * This example for how write create test cases
   */
/*

// StudentServiceTest.java
  @RunWith(MockitoJUnitRunner.class)
  public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void getAllStudents_ReturnsListOfStudents() {
      List<Student> students = new ArrayList<>();
      students.add(new Student(1L, "Alice", 20));
      students.add(new Student(2L, "Bob", 21));
      students.add(new Student(3L, "Charlie", 22));

      Mockito.when(studentRepository.findAll()).thenReturn(students);

      List<Student> result = studentService.getAllStudents();

      assertEquals(3, result.size());
      assertEquals("Alice", result.get(0).getName());
      assertEquals("Bob", result.get(1).getName());
      assertEquals("Charlie", result.get(2).getName());
    }

    @Test
    public void createStudent_ReturnsCreatedStudent() {
      Student studentToCreate = new Student(null, "David", 23);
      Student createdStudent = new Student(4L, "David", 23);

      Mockito.when(studentRepository.save(studentToCreate)).thenReturn(createdStudent);

      Student result = studentService.createStudent(studentToCreate);

      assertNotNull(result.getId());
      assertEquals("David", result.getName());
      assertEquals(23, result.getAge());
    }

    @Test
    public void getStudentById_ReturnsStudentIfExists() {
      Student student = new Student(1L, "Alice", 20);

      Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

      Optional<Student> result = studentService.getStudentById(1L);

      assertTrue(result.isPresent());
      assertEquals("Alice", result.get().getName());
      assertEquals(20, result.get().getAge());
    }

    @Test
    public void updateStudent_UpdatesExistingStudentIfExists() {
      Student existingStudent = new Student(1L, "Alice", 20);
      Student updatedStudent = new Student(1L, "Alice Smith", 21);

      Mockito.when(studentRepository.existsById(1L)).thenReturn(true);
      Mockito.when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);

      Student result = studentService.updateStudent(1L, updatedStudent);

      assertEquals("Alice Smith", result.getName());
      assertEquals(21, result.getAge());
    }

    @Test(expected = NoSuchElementException.class)
    public void updateStudent_ThrowsExceptionIfStudentNotFound() {
      Student nonExistingStudent = new Student(99L, "Non Existing", 25);

      Mockito.when(studentRepository.existsById(99L)).thenReturn(false);

      studentService.updateStudent(99L, nonExistingStudent);
    }

    @Test
    public void deleteStudent_RemovesStudentIfExists() {
      Mockito.when(studentRepository.existsById(1L)).thenReturn(true);

      studentService.deleteStudent(1L);

      Mockito.verify(studentRepository).deleteById(1L);
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteStudent_ThrowsExceptionIfStudentNotFound() {
      Mockito.when(studentRepository.existsById(99L)).thenReturn(false);

      studentService.deleteStudent(99L);
    }
  }
*/


  /**
   * This is StudentService For your reference
   */
/*


// Student.java
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    // constructors, getters, setters
}



// StudentService.java
  @Service
  public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
      return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
      return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
      return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student student) {
      if (studentRepository.existsById(id)) {
        student.setId(id);
        return studentRepository.save(student);
      } else {
        throw new NoSuchElementException("Student not found with id: " + id);
      }
    }

    public void deleteStudent(Long id) {
      if (studentRepository.existsById(id)) {
        studentRepository.deleteById(id);
      } else {
        throw new NoSuchElementException("Student not found with id: " + id);
      }
    }
  }
*/


}
