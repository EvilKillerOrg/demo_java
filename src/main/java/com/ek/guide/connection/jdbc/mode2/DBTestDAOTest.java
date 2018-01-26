package com.ek.guide.connection.jdbc.mode2;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.ek.guide.connection.vo.UserInfoVO;

public class DBTestDAOTest {
  private static Logger logger = Logger.getLogger(DBTestDAOTest.class);

  @Test
  public void testFindUserList() {
    DBTestDAO dao = new DBTestDAO();
    List<UserInfoVO> list = dao.findUserList();
    for (UserInfoVO userInfoVO : list) {
      logger.debug("username: "+userInfoVO.getUsername()+", password: "+userInfoVO.getPassword());
    }
  }

  
  
  @Test
  public void testFindUserById() {
    DBTestDAO dao = new DBTestDAO();
    UserInfoVO userInfoVO = dao.findUserById(1);
    logger.debug("username: "+userInfoVO.getUsername()+", password: "+userInfoVO.getPassword());
  }

  
  
  @Test
  public void testAddUser() {
    UserInfoVO userInfoVO = new UserInfoVO();
    DBTestDAO dao = new DBTestDAO();
    userInfoVO.setUsername("ggg");
    userInfoVO.setPassword("888");
    Integer pk = dao.addUser(userInfoVO);
    logger.debug(pk);
  }
  
  
  
  @Test
  public void testUpdateUser(){
    UserInfoVO userInfoVO = new UserInfoVO();
    DBTestDAO dao = new DBTestDAO();
    userInfoVO.setUuid(1);
    userInfoVO.setUsername("rrr");
    userInfoVO.setPassword("222");
    boolean status = dao.updateUser(userInfoVO);
    logger.debug(status);
  }
  
  
  
  @Test
  public void testDeleteUser(){
    DBTestDAO dao = new DBTestDAO();
    boolean status = dao.deleteUser(8);
    logger.debug(status);
  }
  

}
