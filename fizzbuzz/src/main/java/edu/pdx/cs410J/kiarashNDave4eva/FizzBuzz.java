package edu.pdx.cs410J.kiarashNDave4eva;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
                                                                                    
/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class FizzBuzz extends Human {
                                                                                    
  /**                                                                               
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The fizzbuzz's name                                                      
   * @param classes                                                                 
   *        The names of the classes the fizzbuzz is taking.  A fizzbuzz              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The fizzbuzz's grade point average                                       
   * @param gender                                                                  
   *        The fizzbuzz's gender ("male" or "female", case insensitive)             
   */                                                                               
  public FizzBuzz(String name, ArrayList classes, double gpa, String gender) {
    super(name);
  }

  /**                                                                               
   * All students say "This class is too much work"
   */
  @Override
  public String says() {                                                            
    throw new UnsupportedOperationException("Not implemented yet");
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the fizzbuzz to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }
}