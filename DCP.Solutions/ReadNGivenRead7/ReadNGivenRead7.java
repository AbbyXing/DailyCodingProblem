package ReadNGivenRead7;

public class ReadNGivenRead7 {
	
	private String text;
	private int pointer;
	private int N;
	
	public ReadNGivenRead7(String s) {
		text = s;
		pointer = 0;
		N = text.length();
	}
	
	public String read7() {
		String sub = "";
		if(N - pointer <= 7) {
			sub = text.substring(pointer);
			pointer = N;
		}
		else {
			sub = text.substring(pointer, pointer + 7);
			pointer += 7;
		}
		return sub;
	}
	
	public String readN(int n) {
		String sub = "";
		int readCount = 0;
		while(readCount < n) {
			String subsub = read7();
			int count = subsub.length();
			if(count == 0)
				break;
			for(int i = 0; i < count && readCount < n; i++) {
				sub += subsub.substring(i, i + 1);
				readCount++;
			}
			if(readCount % 7 != 0) {
				for(int i = 0; i < count - readCount % 7; i++) {
					pointer--;
				}
			}
		}
		//System.out.println(pointer);
		
		return sub;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello World";
		ReadNGivenRead7 solution = new ReadNGivenRead7(s);
		System.out.println(solution.read7()); // "Hello W"
		System.out.println(solution.read7()); // "orld"
		System.out.println(solution.read7()); // ""
		
		ReadNGivenRead7 solution2 = new ReadNGivenRead7(s);
		System.out.println(solution2.readN(2)); // "He"
		System.out.println(solution2.readN(5)); // "llo W"
		System.out.println(solution2.readN(2)); // "or"
		System.out.println(solution2.readN(3)); // "ld'
		
		ReadNGivenRead7 solution3 = new ReadNGivenRead7(s);
		System.out.println(solution3.readN(13));
	}

}
