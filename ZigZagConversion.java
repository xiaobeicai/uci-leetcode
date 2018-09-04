/*Description#6
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */
public class ZigZagConversion {
	/* first-between-last
	 * test:
	 * numRows = 1; s = 0 or s.length < numrows
	 * AB,1; "";"ABC",4;
	 * ABCDE,4
	 * 
	 * 较为暴力、不美观的做法
	 */
	public String convert(String s, int numRows) {
		int size = s.length();
		if(numRows == 1 ||size <= numRows) return s;
		StringBuilder sb = new StringBuilder();
		int move = 2*numRows - 2;
		//first row
		for(int i = 0;i < size; i += move)
			sb.append(Character.toString(s.charAt(i)));
		//between
        for(int row = 1;row < numRows-1;row++) {
        		int i = row;
        		while(i < size) {
        		sb.append(Character.toString(s.charAt(i)));
        		if(i + move -2*row < size) //ABCDE,4
        		sb.append(Character.toString(s.charAt(i+move-2*row)));
        	    i += move;
        		}
        }
        //last row
        for(int i = numRows - 1;i < size; i += move)
			sb.append(Character.toString(s.charAt(i)));
        
        return sb.toString();
        	
    }
	public String convertBeautiful(String s, int numRows) {
		
		int size = s.length();
		if(numRows == 1 ||size <= numRows) return s;
		StringBuilder sb = new StringBuilder();
		int move = 2*numRows - 2;
		
        for(int row = 0;row < numRows-1;row++) {
        		int i =  row;
        		while(i < size) {
        		sb.append(s.charAt(i));
        		if(row != 0 && row != numRows-1) { //except for the first and last row
        			int index = i + move - 2* row;
        			if(index < size) //corner case!!:ABCDE,4
        				sb.append(s.charAt(index));
        		}
        	    i += move;
        		}
        }
 
        return sb.toString();
        	
    }
	
	//vertical-obliquely
	public String convertVertical(String s, int numRows) {
		int size = s.length();
		if(numRows == 1 ||size <= numRows) return s;
		
		StringBuilder[] sRow = new StringBuilder[numRows];
		for(int i = 0;i < numRows;i++) sRow[i] = new StringBuilder();
		int index = 0;
        while(index < size) {
        		for(int i = 0; i < numRows && index < size; i++) //vertical
        			sRow[i].append(s.charAt(index++));
        		for(int i = numRows - 2;i > 0 && index < size ;i--)   //oblique
        			sRow[i].append(s.charAt(index++));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < numRows;i++)
        		sb.append(sRow[i]);
        
        return sb.toString();
        	
    }
}
