package com.ek.guide.socket.demo5.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的Util
 */
public class CloseStreamUtil {
  public static void closeAll(Closeable... ios) {
    for (Closeable io : ios) {
      if (null != io) {
        try {
          io.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
