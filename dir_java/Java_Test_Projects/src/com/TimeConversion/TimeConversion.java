
public class TimeConversion {
	
    public static String timeConversion(String s) {
    // Write your code here
        int stringSize = s.length();
        String timeOfDay = s.substring(stringSize - 2, stringSize);
        String hourOfTime = s.substring(0, 2);
        
        System.out.println(timeOfDay);
        System.out.println(hourOfTime);
        
        String convertedTime = "";
        
        if ( timeOfDay.equals("AM") ) { 
            if ( hourOfTime.equals("12") ){ 
                char[] unmodifiedTime = s.toCharArray();
                unmodifiedTime[0] = '0';
                unmodifiedTime[1] = '0';
                convertedTime = String.valueOf(unmodifiedTime);
            }
            
            else { 
            	convertedTime = s;
            }
        } else if ( timeOfDay.equals("PM") ) {
        		if ( hourOfTime.equals("12") ) { 
        			convertedTime = s;
        		}
        		else { 
	                char[] unmodifiedTime = s.toCharArray();
	                int hour = Integer.parseInt(hourOfTime);
	                hour = hour + 12;
	                String hourStr = Integer.toString(hour);
	                unmodifiedTime[0] = hourStr.charAt(0);
	                unmodifiedTime[1] = hourStr.charAt(1);
	                convertedTime = String.valueOf(unmodifiedTime);
        		}
        }
        
        return convertedTime.substring(0 , stringSize - 2);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(timeConversion("12:45:54PM"));
	}

}
