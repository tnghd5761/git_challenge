package Jan2nd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class cuttree {
	
	static int n;
	static long m;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String b = br.readLine();
		String[] StrB = b.split(" ");
		n = Integer.parseInt(StrB[0]);
		m = Long.parseLong(StrB[1]);
		
		String a = br.readLine();
		String[] StrA = a.split(" ");
		
		long[] tree = new long[n];
		long max = 0; long min = 0;
		for(int i=0; i<n; i++) {
			tree[i] = Long.parseLong(StrA[i]);
			max = Math.max(max, tree[i]);
		}
		int count = 0;
		while(true) {
			if(min+1 == max) count++;
			long h = (max+min)/2;
			long sum = 0;
			for(int i=0; i<n; i++) {
				if(tree[i]>h) sum += tree[i]-h;
				if(sum>m) break;
			}
			if(sum == m || (max == min && sum>=m) || count==2) {
				bw.write(String.valueOf(h)); 
				break;
			}
			else if(sum > m) min = h;
			else if(sum < m) max = h;
		}
		bw.flush();
		bw.close();
	}
}