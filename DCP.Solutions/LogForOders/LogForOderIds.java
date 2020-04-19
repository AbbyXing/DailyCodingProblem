package LogForOders;

/**
 * cyclically store/overwrite oderId in the array.
 * */

public class LogForOderIds {
	
	private int MAX_SIZE;
	private int[] oderIdsArray;
	private int current;
	
	public LogForOderIds(int N) {
		this.MAX_SIZE = N;
		this.oderIdsArray = new int[MAX_SIZE];
		this.current = 0;
	}
	
	public void record(int oderId) {
		oderIdsArray[current] = oderId;
		current = (current + 1) % MAX_SIZE;
	}
	
	public int get_last(int i) throws Exception {
		if(i > MAX_SIZE)
			throw new Exception("Invalid index!");
		return oderIdsArray[(current - i + MAX_SIZE) % MAX_SIZE];
	}

	public static void main(String[] args) throws Exception {
		LogForOderIds logForOderIds = new LogForOderIds(3);
		for(int i = 1; i <= 10; i++) {
			logForOderIds.record(i);
		}
		System.out.println(logForOderIds.get_last(3));
	}

}
