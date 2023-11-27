// WordCountTest.java
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;

public class wordcountTest {

    public static void main(String[] args) {

        //Test 1:display the result for a file
        testShowWordCount();

        // Test 2: Valid File
        testValidFileRead();

        // Test 3: check Word Counts
        testcalculateWordCount();

     
    }

    private static void testShowWordCount() {
        try {
            // Provide the file path for testing
            Map<String, Integer> result = wordcount.fileRead("wordchecker.txt");
    
            // Run the calculateWordCount method and capture the result
            String countData = wordcount.calculateWordCount(result);
    
            // Print a message if the test passed
            System.out.println("Test case 1 result ");
            System.out.println(countData);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void testValidFileRead() {
        try {
            Map<String, Integer> result = wordcount.fileRead("wordchecker.txt");
    
            // Check that the result is not null
            assert result != null : "Test failed: fileRead returned null";
    
            // Check for specific words in the result
            if (result.containsKey("tincidunt")) {
                System.out.println("Test case 2 passed");
            }
    
            if (!result.containsKey("lorex")) {
                System.out.println("Test case 2 failed: 'lorex' not found in result");
            }
    
            if (result.containsKey("metus") && result.get("metus") == 2) {
                System.out.println("Test case 2 passed");
            } else {
                System.out.println("Test case 2 failed: Incorrect count for 'metus'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
     private static void testcalculateWordCount() {
            try {
                // Provide the file path for testing
                Map<String, Integer> result = wordcount.fileRead("wordchecker4.txt");
        
                // Run the calculateWordCount method and capture the result
                String countData = wordcount.calculateWordCount(result);
        
                // Define the expected output as per the file used
                String expectedOutput = "apple: 3\nbanana: 2\norange: 1";
        
                // Check that the result matches the expected output
                assert countData.equals(expectedOutput) : "Test failed: Unexpected word count result";
        
                // Print a message if the test passed
                System.out.println("Test case 3 passed! "+ countData);
        
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
      
}
