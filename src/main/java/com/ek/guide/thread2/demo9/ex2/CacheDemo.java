package com.ek.guide.thread2.demo9.ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 自己写一个缓存系统
 * 
 * @ClassName: CacheDemo
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月21日 下午10:56:13
 */
public class CacheDemo {

  private Map<String, Object> cache = new HashMap<String, Object>();
  private ReadWriteLock rwl = new ReentrantReadWriteLock();

  public Object getData(String key) {
    rwl.readLock().lock(); // 情形1: 进来先加上读锁
    Object value = null;
    try {
      value = cache.get(key); // 情形1: 读到数据
      if (value == null) { // 如果map里没有数据就进去 形成情形2
        rwl.readLock().unlock(); // 情形2: 先释放读锁
        rwl.writeLock().lock(); // 情形2: 再加上写锁
        try {
          if (value == null) { // 情形2: 防止第二个,第三个进程...进去写
            value = "aaa"; // 实际是数据库取数据
          }
        } finally {
          rwl.writeLock().unlock(); // 情形2: 写完了释放写锁
        }
        rwl.readLock().lock(); // 情形2:释放完写锁后 再加上读锁
      }
    } finally {
      rwl.readLock().unlock(); // 情形1: 读完了释放读锁
    }
    return value;
  }
}
