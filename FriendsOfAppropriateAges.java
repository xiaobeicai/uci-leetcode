/*#825
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output: 
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 

Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.
 */
public class FriendsOfAppropriateAges {
	//T~N S~1
	public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for(int age : ages)
        		 count[age]++;
        int[] sumInteger = new int[121];
        for(int i = 2;i < 121;i++)
        		sumInteger[i]= count[i] + sumInteger[i - 1];
        
        int sum = 0;
        
        for(int i = 15;i < 121;i++) 
        if(count[i] != 0){ 
        		int left = i / 2 + 7;
        		int right = i;
        		sum += count[i] * (sumInteger[right] - 1 - sumInteger[left]);
        }

        return sum;
    }
}
