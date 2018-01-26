package com.ek.guide.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestMap {
  private static Logger logger = Logger.getLogger(TestMap.class);
  
  
  /* Hashtable 是同步的
   * HashMap 允许null key value Hashtable不允许*/
  @Test
  public void testHashtable() {
    Map<String,String> map = new Hashtable<String,String>();
    map.put("k1", "1");
    map.put("k2", "2");
    //map.put(null,null); 报空指针异常
    logger.debug(map.get("k1"));
    logger.debug(map.get("k2"));
  }
  
  
  
  /* HashMap 是Hashtable的轻量级实现(非线程安全)，它中的键值是无序的。
   * HashMap 允许null key value Hashtable不允许*/
  @Test
  public void testHashMap() {
    Map<String,String> map = new HashMap<String,String>();
    map.put("k1", "1");
    map.put("k2", "2");
    map.put(null,null);
    logger.debug(map.get("k1"));
    logger.debug(map.get("k2"));
  }
  
  
  
  
  /* LinkedHashMap 保留了插入的顺序 也可以有null 键值*/
  @Test
  public void testLinkedHashMap() {
    Map<String,String> map = new LinkedHashMap<String,String>();
    map.put("k1", "2");
    map.put("k2", "1");
    map.put(null,null);
    logger.debug(map.get("k1"));
    logger.debug(map.get("k2"));
  }
  
  
  
  /* TreeMap 是基于红黑树结构的一个实现，它是根据key来排序的 不能有null键值*/
  @Test
  public void testTreeMap() {
    Map<String,String> map = new TreeMap<String,String>();
    map.put("k2", "2");
    map.put("k1", "1");
    logger.debug(map.get("k1"));
    logger.debug(map.get("k2"));
  }
}