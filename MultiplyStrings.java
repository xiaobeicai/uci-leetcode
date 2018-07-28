
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        int m = num1.length(),n = num2.length();
            int[] mul = new int[m+n];
            for(int i = 0;i < num1.length();i++)
                for(int j = 0;j < num2.length();j++){
                    int product1 = num1.charAt(m - i - 1) - '0';
                    int product2 = num2.charAt(n - j - 1) - '0';
                    int temp = product1 * product2;
                    int carry = (mul[i+j] + temp)/10;
                     mul[i+j] = (mul[i+j] + temp) % 10;
                    int count = 0;
                    while(carry != 0) {
                        count++;
                        temp = carry;
                        carry = (mul[i+j+count] + carry) / 10;
                        mul[i+j+count] = (mul[i+j+count] + temp) % 10;
                    }
                }

            int sum = 0;
            StringBuilder sb = new StringBuilder();
            //corner case:first set of nums are 0s
            int i = mul.length - 1;
            for(;i>=1;i--)
                if(mul[i] != 0)
                    break;
            for(;i>=0;i--)
                sb.append(mul[i]);
               

            return sb.toString();
    }
}
