package	threadpool;

public class PTHread extends Thread {
	
	//线程池
	private ThreadPool pool;
	//任务
	private Runnable target;
	private boolean isShutDown = false;
	private boolean isIdle = false;
	
	//构造函数
	public PTHread(Runnable target, String name, ThreadPool pool) {
		super(name);
		this.pool = pool;
		this.target = target;
	}
	
	public Runnable getTarget() {
		return target;
	}
	
	public boolean isIdle() {
		return isIdle;
	}
	
	public void run() {
		//只要没有关闭，则一直不结束该线程
		while(!isShutDown) {
			isIdle = false;
			if(target != null) {
				//运行任务
				target.run();
			}
			//任务结束了，到闲置状态
			isIdle = true;
			try {
				//该任务结束了，不关闭线程，而是放入线程池空闲状态
				pool.repool(this);
				synchronzed (this) {
					//线程空闲，等待新的任务到来
					wait();
				}
			}catch(InterruptedException e) {
			}
			isIdle = false;
		}
	}
	
	public synchronzed void setTarget(java.lang.Runnable newTarget) {
		target = newTarget;
		//设置了任务以后，通知run()方法，开始执行这个任务
		notifyAll();
	}
	
	//关闭线程
	public synchronzed void shutDown() {
		isShutDown = true;
		notifyAll();
	}
}