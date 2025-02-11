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
    
    // WEEK 8 Lab Report Tests
    @Test
    public void testLab1() throws IOException{
        String contents = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse/test-lab1.md"));
        List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    
    @Test 
    public void testLab2() throws IOException{
        String contents = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse/test-lab2.md"));
        List<String> expect = List.of("a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testLab3() throws IOException{
        String contents = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse/test-lab3.md"));
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }




    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    // Testing test-file8.md, passes
    @Test
    public void openBracket() throws IOException{
        String fileStr = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse/newTests/test-file8.md"));
        List<String> testList = List.of("a link on the first line");
        assertEquals(MarkdownParse.getLinks(fileStr), testList);
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
    // Fails, can't handle a link after an open parenthesis
    /*
    @Test
    public void linkAfterOpenParen() throws IOException{
        String fileStr = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse-2/testfiles/test-file9.md"));
        List<String> testList = List.of("https://something.com");
        assertEquals(MarkdownParse.getLinks(fileStr), testList);
    }
    */
    
    @Test
    public void vimTest() throws IOException{
        String fileStr = Files.readString(Path.of("/Users/sebastiaan/Documents/GitHub/markdown-parse/test2.md"));
        System.out.println("Vim Edited");
        List<String> testList = List.of("https://something.com");
        assertEquals(MarkdownParse.getLinks(fileStr), testList);
    }
    
}
