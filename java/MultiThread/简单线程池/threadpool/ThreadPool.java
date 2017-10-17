package threadpool;

public class ThreadPool {
	
	private static ThreadPool instance = null;
	
	//���е��̶߳���
	private List<PThread> idleThreads;
	//���е��߳�����
	private int threadCounter;
	private boolean isShutDown = false;
	
	private ThreadPool() {
		this.idleThreads = new Vector(5);
		threadCounter = 0;
	}
	
	public int getCreatedThreadsCount() {
		return threadCounter;
	}
	
	//ȡ���̳߳�ʵ��
	public synchronized static ThreadPool getInstance() {
		if(instance == null) {
			instance = new ThreadPool();
		}
		return instance;
	}
	
	//���̷߳������
	protected synchronized void repool(PThread repoolingThread) {
		if(!isShutDown) {
			idleThreads.add(repoolingThread);
		}else {
			repoolingThread.shutDown();
		}
	}
	
	//ֹͣ���������߳�
	public synchronized void shutdown() {
		isShutDown = true;
		for(int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++) {
			PThread idleThread = (PThread)idleTreads.get(threadIndex);
			idleThread.shutdown();
		}
	}
	
	//ִ������
	public synchronized void start(Runnable target) {
		PTHread thread = null;
		//����п����̣߳���ֱ��ʹ��
		if(idleThreads.size() > 0) {
			int lastIndex = idleThreads.size() - 1;
			thread = (PTHread) idleThreads.get(lastIndex);
			idleTreads.remove(lastIndex);
			//����ִ���������
			thread.setTarget(target);
		}else {
			threadCounter++;
			//�������߳�
			thread = new PTHread(target, "PThread #" + threadCounter.this);
		}
		//��������߳�
		thread.start();
	}
}