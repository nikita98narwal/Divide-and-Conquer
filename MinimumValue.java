import java.util.*;
  import java.io.*;
  
  public class Main {
      static int check(String s, int K) 
        { 
            for (int ch = 0; ch < 26; ch++) { 
                char c = (char)( 'a' + ch); 
          
                int last = -1; 
          
                boolean found = true; 
                for (int i = 0; i < K; i++) 
                    if (s.charAt(i) == c) 
                        last = i; 
                if (last == -1) 
                    continue; 
      
                for (int i = K; i < s.length(); i++) { 
                    if (s.charAt(i) == c) 
                        last = i; 
                    if (last <= (i - K)) { 
                        found = false; 
                        break; 
                    } 
                } 
                if (found) 
                    return 1; 
            } 
            return 0; 
        } 
 
        static int binarySearch(String s) 
        { 
            int low = 1, high = s.length(); 
            int ans=0; 
            while (low <= high) { 
                int mid = (high + low) >> 1; 
          
             
                if (check(s, mid)==1) { 
                    ans = mid; 
                    high = mid - 1; 
                } 
                else
                    low = mid + 1; 
            } 
            return ans; 
        } 
          
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	while(t-->0) {
      String s = sc.next(); 
            System.out.println(binarySearch(s)); 
	}
    }
  }
