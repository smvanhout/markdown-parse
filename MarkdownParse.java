
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {

        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            // If any of above variables are -1, end the loop
            if(nextOpenBracket == -1 || nextCloseBracket == -1 ||openParen == -1 ||closeParen == -1){
                currentIndex = closeParen + 1;
                break;
            }

            if(nextOpenBracket > 0){
                char character = markdown.charAt(nextOpenBracket-1);
                char imageChar = '!';
                // Checking for an "!" to not include Images
                if(character != imageChar){
                    // Checking if the closeBracket and openParent are directly next to eachother
                    if(openParen - nextCloseBracket == 1){
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                        currentIndex = closeParen + 1;
                    }
                    else{
                        currentIndex = closeParen + 1;
                    }
                }else{
                    currentIndex = closeParen + 1;
                }
            }
            if(nextOpenBracket == 0){
                if(openParen - nextCloseBracket == 1){
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                }
                else{
                   currentIndex = closeParen + 1; 
                }
            }         
        }
        return toReturn;
        
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);

        
    }

    
}
