package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.util.List;

/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  private final double gpa;
  private List<String> classes;
  private Gender gender;

  private enum Gender {
    FEMALE, MALE

  }

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male" or "female", case insensitive)             
   */                                                                               
  public Student(String name, List<String> classes, double gpa, String gender) {
    super(name);

    this.gpa = gpa;
    this.classes = classes;
    this.gender = getGenderForString(gender);
  }

  private Gender getGenderForString(String gender) {
    if (gender.equalsIgnoreCase("male")) {
      return Gender.MALE;

    } else if (gender.equalsIgnoreCase("female")) {
      return Gender.FEMALE;

    } else {
      throw new IllegalArgumentException("I don't about the " + gender + " gender");
    }
  }

  /**                                                                               
   * All students say "This class is too much work"
   */
  @Override
  public String says() {                                                            
    return "This class is too much work";
  }

  /**
   * Returns a <code>String</code> that describes this
   * <code>Student</code>.
   */
  public String toString() {
    return getName() + " has a GPA of " + gpa + " and is taking " +
      formatNumberOfClasses() + formatClassNames() + " " + getGenderPronoun() +
      " says \"" + says() + "\".";
  }

  private String getGenderPronoun() {
    return (this.gender.equals(Gender.FEMALE) ? "She" : "He");
  }

  private String formatClassNames() {
    String s = "";
    int numberOfClasses = this.classes.size();
    for (int i = 0; i < numberOfClasses; i++) {
      String className = this.classes.get(i);
      s += className;

      if (i != numberOfClasses - 1) {
        if (numberOfClasses > 2) {
          s += ",";
        }
        s += " ";
      }

      if (i == numberOfClasses - 2) {
        s += "and ";
      }
    }
    return s + '.';
  }

  private String formatNumberOfClasses() {
    int numberOfClasses = classes.size();

    switch (numberOfClasses) {
      case 0:
        return "0 classes";

      case 1:
        return "1 class: ";

      default:
        return numberOfClasses + " classes: ";
    }
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

}