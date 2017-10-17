package threadpool;

public class TestThreadPool implements Runnable {
	
	protected String name;
	
	public TestThreadPool() {
	}
	
	public TestThreadPool(String name) {
		this.name = name;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String name) {
		for(int i = 0; i < 1000; i++) {
			ThreadPool.getInstance().start(new TestThreadPool("testThreadPool" + Integer.toString(i)));
		}
	}
}