package SIngletonWithTwist;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public final class Singleton implements Cloneable, Serializable {
	
	// thread safe counter
	private AtomicInteger counter = new AtomicInteger(1);
	
	public Singleton() {}
	
	public Singleton getInstance() {
		if(counter.getAndIncrement() % 2 == 0)
			return EvenInstance.instance;
		else
			return OddInstance.instance;
	}
	
	private static class OddInstance {
		//not initialized until the class is used in getInstance()
		static Singleton instance = new Singleton();
	}
	
	private static class EvenInstance {
		//not initialized until the class is used in getInstance()
		static Singleton instance = new Singleton();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
