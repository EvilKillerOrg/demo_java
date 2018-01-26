package com.ek.guide.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * Set List 接口都继承了collection接口
 * List中可以有重复的
 * Set中不可以有重复的
 * List用索引号取值
 * Set用Iterator遍历取值
 */
public class SetTest {
  private static Logger logger = Logger.getLogger(ListTest.class);
  
  
  /* HashSet 不能保证元素的排列顺序，顺序有可能发生变化 
   * 不是同步的 集合元素可以是null,但只能放入一个null */
  @Test
  public void testHashSet() {
     Set<String> set = new HashSet<String>();
     set.add("1");
     set.add("1");
     set.add("2");
     
      
     
     Iterator<String> it = set.iterator();
     while(it.hasNext()){
       logger.debug(it.next());
     }
  }
  
  
  
  /* LinkedHashSet 使用链表维护元素的次序 这样使得元素看起 来像是以插入顺序保存的 
   * 当遍历该集合时候将会以元素的添加顺序访问集合的元素。
   * 在迭代访问Set中的全部元素时，性能比HashSet好，但是插入时性能稍微逊色于HashSet.*/
  @Test
  public void testLinkedHashSet(){
    Set<String> set = new LinkedHashSet<String>();
    set.add("4");
    set.add("3");
    set.add("3");
    
    Iterator<String> it = set.iterator();
    while(it.hasNext()){
      logger.debug(it.next());
    }
  }
  
  
  
  /* TreeSet 是SortedSet接口的唯一实现类，TreeSet可以确保集合元素处于排序状态.
   * TreeSet支持两种排序方式，自然排序 和定制排序，其中自然排序为默认的排序方式.*/
  @Test
  public void testTreeSet(){
    Set<String> set = new TreeSet<String>();
    set.add("5");
    set.add("7");
    set.add("6");
    
    Iterator<String> it = set.iterator();
    while(it.hasNext()){
      logger.debug(it.next());
    }
  }

}