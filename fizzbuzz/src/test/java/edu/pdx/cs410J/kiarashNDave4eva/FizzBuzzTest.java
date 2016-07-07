package edu.pdx.cs410J.kiarashNDave4eva;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class FizzBuzzTest
{

  @Test
  public void studentNamedPatIsNamedPat() {
    String name = "Pat";
    FizzBuzz pat = new FizzBuzz(name, new ArrayList(), 0.0, "Doesn't matter");
    assertThat(pat.getName(), equalTo(name));
  }

}
