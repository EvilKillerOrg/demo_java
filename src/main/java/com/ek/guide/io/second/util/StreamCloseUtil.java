package com.ek.guide.io.second.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的工具
 */
public class StreamCloseUtil {

  /**---------<br>
   * @Title: close
   * @Description: 使用Closeable... 关闭流
   * @param io
   * @return: void
   */
  public static void close(Closeable... io) { // 可变长参数 必须放在形参列表的最后位置,与数组操作一致
    for (Closeable stream : io) {
      if (null != stream) {
        try {
          stream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**---------<br>
   * @Title: closeAll
   * @Description: 使用泛型 关闭流
   * @param io
   * @return: void
   */
  public static <T extends Closeable> void closeAll(T... io) {
    for (Closeable stream : io) {
      if (null != stream) {
        try {
          stream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
