import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor {
		public static void main(String[] args){
			
			int totalTestCases1 = 4;
			int testCasesLeft1 = 4;
			
			int totalTestCases2 = 10;
			int testCasesLeft2 = 10;
			
			int totalTestCases3 = 90;
			int testCasesLeft3 = 90;
			
			String [] input1 = { "<h1>Nayeem loves counseling</h1>\r\n", 
					"<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>\r\n",
					"<Amee>safat codes like a ninja</amee>\r\n",
					"<SA premium>Imtiaz has a secret crush</SA premium>\r\n",
			};
			
			String [] input2 = {
					"<h1>some</h1>\r\n",
					"<h1>had<h1>public</h1></h1>\r\n",
					"<h1>had<h1>public</h1515></h1>\r\n",
					"<h1><h1></h1></h1>\r\n",
					"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\r\n",
					">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\r\n",
					"<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>\r\n",
					"<>hello</>\r\n",
					"<>hello</><h>dim</h>\r\n",
					"<>hello</><h>dim</h>>>>>\r\n"
			};
			
			ArrayList<String> fileContents = readFile("./tagContentExtractorInput.txt");
	        String [] input3 = fileContents.toArray(new String[fileContents.size()]);

			
			String [] input = null;
			int totalTestCases = totalTestCases3;
			int testCasesLeft = testCasesLeft3;
			input = input3;
			
			while(testCasesLeft>0){
				String line = input[totalTestCases - testCasesLeft];
	            processLine(line);
				testCasesLeft--;
			}
		}
	     
	    public static void processLine(String line) {
	        Stack<String> tagStack = new Stack<String>();
	        String text = "";
	        String currText = "";
	    	
	        int tagBegin = line.indexOf("<");
	    	int tagEnd = line.indexOf(">", tagBegin);
			
			if ( tagBegin < 0 || tagEnd < 0 ) { 
				System.out.println("None");
				return;
			}
			 

	    	while ( tagBegin >= 0 ) {
		    	tagEnd = line.indexOf(">", tagBegin);
		    	if ( tagEnd < 0 ) { break; }
		    	
		    	String tag = line.substring(tagBegin, tagEnd + 1);
		    	String tagName;

		    	boolean tagIsClosing = isClosingTag(tag);
		    	tagName = getTagName(tag, tagIsClosing);
		    	
		    	// Next open angle bracket
		    	tagBegin = line.indexOf("<", tagEnd + 1);
		    	
		    	if ( tagName.isEmpty() ) {
		    		continue;
		    	}

		    	if ( !tagIsClosing ) {
		    		tagStack.push(tagName);
			    	
			    	// Get Text Content in Between Tags
			    	if (tagBegin != -1) { // If not at end of string
			    						  // i.e. if last "<" not found.
			    		currText = line.substring(tagEnd + 1, tagBegin);
		    			
			    	}
		    	} else {
		    		if ( !tagStack.empty() ) { 
			    		String topOfStack = tagStack.peek();
			    		if ( topOfStack.equals(tagName) ) { 
			    			tagStack.pop();

					    	
				    		if ( !text.isEmpty() && !currText.isEmpty() ) { 
				    			text = new StringBuilder()
				    					.append(text)
				    					.append("\r\n")
				    					.append(currText)
				    					.toString();
				    		} else { 
				    			text = new StringBuilder()
				    					.append(text)
				    					.append(currText)
				    					.toString();
				    		}
				    		
				    		currText = "";

			    		} else {
			    			tagStack.clear();
			    			continue;
			    		}
			    		
		    		}
		    	}
	        }
	    	
	    	if ( !text.isEmpty() ) { 
	    		System.out.println(text);
	    		return;
	    	}
	    	
	    	System.out.println("None");
	    }
	    
	    public static String getTagName(String tag, boolean isClosingTag) {
	    	if ( isClosingTag ) {
	    		return tag.substring(2, tag.length() - 1);
	    	} 
	    	
	    	return tag.substring(1, tag.length() - 1);
	    }
	    
	    public static boolean isClosingTag(String tag){
	    	return tag.startsWith("</") && tag.endsWith(">");
	    }
	    
	    public static void printDebug() {
	    	System.out.println("\n#### Debug ####");
	    }
	    
	    public static ArrayList<String> readFile(String filename) {
	    	
	    	ArrayList<String> fileContents = new ArrayList<String>(); 
	    	
	    	try {  
		    	FileInputStream fis=new FileInputStream(filename);       
		    	Scanner sc=new Scanner(fis);  
		    	int i = 0;
		    	while(sc.hasNextLine())  {
		    		String line = sc.nextLine();
		    		fileContents.add(line);
		    	}  
		    	sc.close();     //closes the scanner
	    	
	    	}

	    	catch(IOException e) {  
	    		e.printStackTrace();  
	    	}
	    	
	    	return fileContents;
	    }

}