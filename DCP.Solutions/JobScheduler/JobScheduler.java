package JobScheduler;

import java.util.Date;
import java.util.concurrent.*;

/**
 * An ExecutorService that can schedule commands to run after a given delay, or to execute periodically.
 * 
 * The schedule methods create tasks with various delays and return a task object that can be used to cancel 
 * or check execution.
 * 
 * The scheduleAtFixedRate and scheduleWithFixedDelay methods create and execute tasks that run periodically 
 * until cancelled.
 * 
 * */

public class JobScheduler {
	
	private final ScheduledExecutorService scheduler;
	
	public JobScheduler() {
		this.scheduler = Executors.newSingleThreadScheduledExecutor();
	}
	
	public void solution(Runnable command, int delay_ms) {
	     ScheduledFuture<?> jobHandle =
	       scheduler.schedule(command, delay_ms, TimeUnit.SECONDS);
	     scheduler.shutdown();
	}

	public static void main(String[] args) {
		System.out.println(new Date());
		Runnable command = () -> System.out.println("executed at " + new Date());
		JobScheduler jobScheduler = new JobScheduler();
		jobScheduler.solution(command, 3);
	}

}
