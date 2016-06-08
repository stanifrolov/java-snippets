import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TimeConversion {

  public static void main(String[] args) {
    MyTests tests = new MyTests();
    tests.runTests();
  }

  public static String converseTime(String time) {
    String timeString = time.substring(0, 2);
    String restOfTimeString = time.substring(2, 8);
    String frameString = time.substring(8, 10);
    String newTimeString = "";
    switch(frameString) {
      case "AM":
        newTimeString = String.valueOf(Integer.parseInt(timeString));
        if(newTimeString.equals("12"))
          newTimeString = String.valueOf(Integer.parseInt(timeString) - 12);
        newTimeString = 0 + newTimeString;
        break;
      case "PM":
        newTimeString = String.valueOf(Integer.parseInt(timeString));
        if(!newTimeString.equals("12"))
          newTimeString = String.valueOf(Integer.parseInt(timeString) + 12);
        break;
    }
    return (newTimeString + restOfTimeString);
  }

}

class MyTests {

  @Test
  public void runTests() {
    TimeConversion timeConverser = new TimeConversion();
    assertEquals("00:12:12", timeConverser.converseTime("12:12:12AM"));
    assertEquals("23:59:59", timeConverser.converseTime("11:59:59PM"));
    assertEquals("00:00:00", timeConverser.converseTime("12:00:00AM"));
    assertEquals("12:00:00", timeConverser.converseTime("12:00:00PM"));
    assertEquals("08:10:08", timeConverser.converseTime("08:10:08AM"));
    assertEquals("14:02:30", timeConverser.converseTime("02:02:30PM"));
  }
}


