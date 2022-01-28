import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
To run Junit Tests, compile with this command:
"javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java"

Run with this command:
"java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest"
 */

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest() throws IOException{
        // Line below reads file data from path specified into a string
        String fileInfo = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse/test-file.md"));
        // Line below makes a list of strings 
        List<String> testList = List.of("https://something.com","some-page.html");
        assertEquals(MarkdownParse.getLinks(fileInfo), testList);

    }

    // Tests file that contains an open paren and an image to make sure they're not included
    @Test
    public void testOpenParen() throws IOException{
        String fileStr = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse/test2.md"));
        List<String> testList = List.of("https://something.com");
        assertEquals(MarkdownParse.getLinks(fileStr), testList);
    }
    
}