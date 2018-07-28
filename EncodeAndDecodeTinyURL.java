import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*Description#535
 * TinyURL is a URL shortening service where you enter a URL 
 * such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service. 
 * There is no restriction on how your encode/decode algorithm should work. 
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeAndDecodeTinyURL {
	private int key = 0;
	Map<Integer,String> map1 = new HashMap<Integer,String>();
	Map<String,String> map2 = new HashMap<String,String>();
	String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; //10+26+26 = 62
	Random r = new Random();
	int ran = r.nextInt(Integer.MAX_VALUE);
	String str = getRandom();
	
	//Map<String,String> map3 = new HashMap<String,Integer>();
	  // Encodes a URL to a shortened URL.
	/*using simple counter
	 * url的范围被int的范围所限制
	 * 如果输入的url过多，超出int范围将会溢出，然后重写之前的url编码，peromrance degradation
	 * 编码过后的url不一定比原url短，长短取决于输入的先后顺序
	 * 这种编码方式过于简单，容易被识破
	 */
    public String encode1(String longUrl) {
        map1.put(key, longUrl);
        return "http://tinyurl.com/" + key++; 
    }

    //1.Decodes a shortened URL to its original URL.
    public String decode1(String shortUrl) {
        return map1.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
    
    /*2.Variable-length encode
     * url的范围被int的范围所限制
     * encode长度和输入顺序有间接关系，1（62次），2（62次）
     * 表现好，只有当超过int限制时会出现重复code
     * 编码方法通过一定的计算可以被识破
     */
    private String getString() {
    	 StringBuilder sb = new StringBuilder();
         int count = this.key;
         while(count > 0) { 
        	 	count--; // why need --;
      	   	sb.append(alphabet.charAt(count%62));
      	   	count /= 62;
         }
         return sb.toString();
    }
    
    public String encode2(String longUrl) {
      String str = getString();
      map2.put(str,longUrl);
      key++;
      return "http://tinyurl.com/" + str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode2(String shortUrl) {
        return map2.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
    
    /*3.using hashcode
     * url的范围被int的范围所限制因为hashcode用int计算
     * 平均长度与原url长度无关
     * hashcode可能为两个不同的url生成相同的code，数量越多概率越大，被称作collision，birthday paradox同理
     * 预测encode不是很容易
     */
    
    public String encode3(String longUrl) {
        map1.put(longUrl.hashCode(),longUrl);
        key++;
        return "http://tinyurl.com/" + longUrl.hashCode() ;
      }

      // Decodes a shortened URL to its original URL.
      public String decode3(String shortUrl) {
          return map1.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
      }
    /*4.using random num
     * url的范围被int的范围所限制因为hashcode用int计算
     * 平均长度与原url长度无关
     * collision数量越多概率越大
     * 确定encode是不可能的，因为用了random
     */
      public String encode4(String longUrl) {
    	  	  while(map1.containsKey(ran))
    	  		  ran = r.nextInt(Integer.MAX_VALUE);
          map1.put(ran,longUrl);
          return "http://tinyurl.com/" + ran ;
        }

        // Decodes a shortened URL to its original URL.
        public String decode4(String shortUrl) {
            return map1.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }
    
    /*5.random fixed-length encoding
     * 
     */
       private String getRandom() {
    	   	StringBuilder sb = new StringBuilder();
    	   	
    	   	for(int i =  0; i< 6;i++) 
    	   		sb.append(alphabet.charAt(r.nextInt(62)));
    	 
    	   		return sb.toString();
       }
        public String encode5(String longUrl) {
        	
  	  	  while(map2.containsKey(str))
  	  		  str = getRandom();
        map2.put(str,longUrl);
        return "http://tinyurl.com/" + str ;
      }

      // Decodes a shortened URL to its original URL.
      public String decode5(String shortUrl) {
          return map2.get(shortUrl.replace("http://tinyurl.com/", ""));
      }
}
