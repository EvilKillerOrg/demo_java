package com.ek.guide.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Set List 接口都继承了collection接口
 * List中可以有重复的
 * Set中不可以有重复的
 * List用索引号取值
 * Set用Iterator遍历取值
 */
public class ListTest {
  private static Logger logger = Logger.getLogger(ListTest.class);
  
  
  /* Vector和ArrayList 使用数组方式存储数据,此数组元素数大于实际存储的数据,以便增加和插入元素
   * 但插入元素涉及数组元素移动等内存操作,所以索引快插入慢
   * Vector 由于使用了synchronized方法（线程安全）所以性能上比ArrayList要差
   * Vector可以设置增长的空间大小,ArrayList不能
   * Vector缺省情况下自动增长原来一倍的数组长度，ArrayList是原来的50%*/
  @Test
  public void testArrayList(){
    List<String> list = new ArrayList<String>();
    list.add("2");
    list.add("1");
    list.add("3");
    logger.debug(list.get(0));
  }
  
  
  
  /* Vector和ArrayList 使用数组方式存储数据,此数组元素数大于实际存储的数据,以便增加和插入元素
   * 但插入元素涉及数组元素移动等内存操作,所以索引快插入慢
   * Vector 由于使用了synchronized方法（线程安全）所以性能上比ArrayList要差
   * Vector可以设置增长的空间大小,ArrayList不能
   * Vector缺省情况下自动增长原来一倍的数组长度，ArrayList是原来的50%*/
  @Test
  public void testVector(){
    List<String> list = new Vector<String>();
    list.add("2");
    list.add("1");
    list.add("3");
    logger.debug(list.get(0));
  }
  
  
  
  /* LinkedList 使用双向链表实现存储，按序号索引数据需要进行向前或向后遍历，
   * 但是插入数据时只需要记录本项的前后项即可，所以插入数度较快！*/
  @Test
  public void testLinkedList(){
    List<String> list = new LinkedList<String>();
    list.add("2");
    list.add("1");
    list.add("3");
    logger.debug(list.get(0));
  }
}