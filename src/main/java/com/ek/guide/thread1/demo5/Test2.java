package com.ek.guide.thread1.demo5;

/**
 * 多线程下的单例模式
 * 
 * @author EK
 * @date 2017年8月5日
 */
public class Test2 {

	/*单例模式getInstance方法如果线程不安全就会产生两个实例*/	
	public static void main(String[] args) {
		JvmThread thread1 = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);
		
		thread1.start(); 
		thread2.start(); 
	}
}


/**
 * 单例类 
 */
class Jvm{
	private static Jvm instance = null;

	private Jvm() {
	}
	
	
	/*不同步 会产生两个实例*/
	public static Jvm getInstance0(long time) {
		if (null == instance) {
			try {
				Thread.sleep(time);//延时,放大错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			instance = new Jvm();
		}
		return instance;
	}
	
	
	/*同步方法 访问效率低*/
	public static synchronized Jvm getInstance1(long time) {
		if (null == instance) {
			try {
				Thread.sleep(time);//延时,放大错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			instance = new Jvm();
		}
		return instance;
	}
	
	
	/*同步块 访问效率低*/
	public static Jvm getInstance2(long time) {
			synchronized(Jvm.class){ //锁定静态对象 静态方法不能用this锁定类  所以锁定Jvm.class 类的字节码 
				if (null == instance) {
					try {
						Thread.sleep(time); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					instance = new Jvm();
				}
			}
			return instance;
	}
	
	
	/*同步块 这是一个双重检查模式 效率较高 但是据说有可能出问题*/
	public static Jvm getInstance3(long time) {
		if(instance == null){ //第一个线程进来 创建了 别的线程来 对象已经存在了 就不用在往里走了,直接获得,这样可以提高访问已经存在对象的时候效率
			synchronized(Jvm.class){  
				if (null == instance) {
					try {
						Thread.sleep(time); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					instance = new Jvm();
				}
			}
		}
			return instance;
	}
	
}


/**
 * 创建一个线程获得实力对象
 */
class JvmThread extends Thread{
	private long time;
	
	public JvmThread() {
	}

	public JvmThread(long time) {
		this.time = time;
	}

	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName()+"-->"+Jvm.getInstance0(time));
		//System.out.println(Thread.currentThread().getName()+"-->"+Jvm.getInstance1(time));
		System.out.println(Thread.currentThread().getName()+"-->"+Jvm.getInstance2(time));
	  //System.out.println(Thread.currentThread().getName()+"-->"+Jvm.getInstance3(time));
	}
}