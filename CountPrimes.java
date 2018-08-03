/*Description：#204
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
	/*超时
	 * 
	 */
	 public int countPrimes(int n) {
		 if(n == 0 || n == 1 || n==2) return 0;//1不是质数
	     if(n == 3) return 1;
	     int count = 1;
	     for(int i = 3; i < n;i += 2)
	    	 	if(isPrime(i))
	    	 		count++;
	     
	     return count;
	        
	    }
	 private boolean isPrime(int n) {
	     for(int i = 3;i < n/2;i +=2)//注意corner case
	    	 	if(n%i == 0) return false;
	     
	     return true;
	 }
	 
	 public int countPrimes2(int n) {
		 if(n == 0 || n == 1 || n==2) return 0;//1不是质数
		 int count = 0;
		 boolean[] notPrime = new boolean[n];  //未定义则初始值为false
		 for(int i = 2; i < n;i++) {  //变成i < sqrt(n)的话n=3会出问题
			 if(!notPrime[i])
				 count++;
			 for(int j = 2 ; i*j < n;j++)
				 notPrime[i*j] = true;
		 }
		  return count;
	    }
	
}
