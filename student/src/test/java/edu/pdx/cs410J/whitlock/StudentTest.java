package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class StudentTest
{

  static final String DEFAULT_GENDER = "female";

  @Test
  public void studentNamedPatIsNamedPat() {
    String name = "Pat";
    Student pat = createStudentWithName(name);
    assertThat(pat.getName(), equalTo(name));
  }

  @Test
  public void studentDescriptionContainsName() {
    String name = "Pat";
    Student student = createStudentWithName(name);
    assertThat(student.toString(), containsString(name));
  }

  private Student createStudentWithName(String name) {
    return createStudentWithNameAndGpa(name, 0.0);
  }

  @Test
  public void studentDescriptionContainsGPA() {
    double gpa = 1.23;
    Student student = createStudentWithGPA(gpa);
    assertThat(student.toString(), containsString(String.valueOf(gpa)));
  }

  private Student createStudentWithGPA(double gpa) {
    return createStudentWithNameAndGpa("Name", gpa);
  }

  private Student createStudentWithNameAndGpa(String name, double gpa) {
    return new Student(name, new ArrayList<>(), gpa, DEFAULT_GENDER);
  }

  @Test
  public void studentWithZeroClasses() {
    ArrayList<String> classes = new ArrayList<>();
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("0 classes."));
  }

  @Test
  public void studentWithOneClass() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Java");
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("1 class:"));
  }

  @Test
  public void studentWithThreeClasses() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Algorithms");
    classes.add("Operating Systems");
    classes.add("Java");
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("3 classes:"));
  }

  @Test
  public void toStringContainsNameOfOneClass() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Java");
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("1 class: Java."));
  }

  @Test
  public void toStringContainsNamesOfTwoClasses() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Algorithms");
    classes.add("Java");
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("2 classes: Algorithms and Java."));
  }

  @Test
  public void toStringContainsNamesOfThreeClasses() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Algorithms");
    classes.add("Operating Systems");
    classes.add("Java");
    Student student = createStudentWithClasses(classes);
    assertThat(student.toString(), containsString("3 classes: Algorithms, Operating Systems, and Java."));
  }

  private Student createStudentWithClasses(ArrayList<String> classes) {
    return new Student("Name", classes, 3.64, DEFAULT_GENDER);
  }

  @Test
  public void nicelyFormatFirstSentenceOfToString() {
    Student dave = getDaveStudent();

    String firstSentence = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating " +
      "Systems, and Java.";
    assertThat(dave.toString(), startsWith(firstSentence));
  }

  private Student getDaveStudent() {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Algorithms");
    classes.add("Operating Systems");
    classes.add("Java");
    return new Student("Dave", classes, 3.64, "male");
  }

  @Test
  public void maleStudentHasMalePronounInToString() {
    Student male = createStudentWithGender("male");
    assertThat(male.toString(), containsString("He"));
  }

  @Test
  public void femaleStudentHasFemalePronounInToString() {
    Student male = createStudentWithGender("female");
    assertThat(male.toString(), containsString("She"));
  }

  @Test
  public void allCapsMaleStudentHasMalePronounInToString() {
    Student male = createStudentWithGender("MALE");
    assertThat(male.toString(), containsString("He"));
  }

  @Test
  public void allCapsFemaleStudentHasFemalePronounInToString() {
    Student male = createStudentWithGender("FEMALE");
    assertThat(male.toString(), containsString("She"));
  }

  private Student createStudentWithGender(String gender) {
    return new Student("", new ArrayList<>(), 1.23, gender);
  }

  @Test
  public void allStudentsSayThisClassIsTooMuchWork() {
    Student dave = getDaveStudent();
    assertThat(dave.toString(), endsWith("\"This class is too much work\"."));
  }

  @Test(expected = InvalidGenderException.class)
  public void whenGenderIsNeitherMaleNorFemaleAnInvalidGenderExceptionIsThrown() {
    createStudentWithGender("asdhfjlsa");
  }

  @Test
  public void allStudentAttributesAreIncludedInToString() {
    Student dave = getDaveStudent();

    String expected = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating " +
      "Systems, and Java. He says \"This class is too much work\".";
    assertThat(dave.toString(), equalTo(expected));
  }

}
