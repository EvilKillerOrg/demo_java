package com.ek.guide.connection.jdbc.mode2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * 一个纯jdbc实现dao的例子
 * execute 返回一个boolean值,表明执行该SQL语句是否返回了ResultSet,我在执行存储过程时使用这个(在不清楚SQL语句的类型时也只好使用execute)
 * executeQuery 用于返回单个结果集的语句(如:select)
 * executeUpdate 用于执行INSERT,UPDATE,DELETE以及SQLDDL语句例如CREATE TABLE,DROP TABLE.返回一个int指受影响的行数
 * 
 */
import com.ek.guide.connection.vo.UserInfoVO;

public class DBTestDAO {

  private Connection conn = null;
  private Statement st = null;
  private ResultSet rst = null;
  private PreparedStatement pst = null;

  /* 查user list 获得所有用户信息 */
  public List<UserInfoVO> findUserList() {
    String sql = "select * from userinfo_dbconn";
    List<UserInfoVO> userList = new ArrayList<UserInfoVO>();

    conn = DBUtil.getConnection();
    try {
      st = conn.createStatement();
      rst = st.executeQuery(sql);
      while (rst.next()) {
        UserInfoVO user = new UserInfoVO();
        user.setUuid(rst.getInt("uuid"));
        user.setUsername(rst.getString("username"));
        user.setPassword(rst.getString("password"));
        userList.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtil.connClose(conn, st, rst);
    }
    return userList;
  }

  /* 查询单条 根据获得单个用户信息 */
  public UserInfoVO findUserById(Integer uuid) {
    String sql = "select * from userinfo_dbconn where uuid =?";
    UserInfoVO user = null;
    conn = DBUtil.getConnection();
    try {
      pst = conn.prepareStatement(sql);
      pst.setInt(1, uuid);
      rst = pst.executeQuery();
      if (rst.next()) {
        user = new UserInfoVO();
        user.setUuid(rst.getInt("uuid"));
        user.setUsername(rst.getString("username"));
        user.setPassword(rst.getString("password"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtil.connClose(conn, pst, rst);
      ;
    }
    return user;
  }

  /* 新增 并获得新增信息的主键 */
  public Integer addUser(UserInfoVO user) {
    String sql = "insert into userinfo_dbconn (username, password) values(?, ?)";
    conn = DBUtil.getConnection();
    Integer pk = null;
    try {
      pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 获取自动生成的主键
      pst.setString(1, user.getUsername());
      pst.setString(2, user.getPassword());
      pst.executeUpdate();

      rst = pst.getGeneratedKeys();// 获得主键
      if (rst.next()) {
        pk = rst.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtil.connClose(conn, pst, rst);
    }
    return pk;
  }

  /* 修改 判断executeUpdate的返回值(受影响的行)是否>0,返回是否有行受到影响(是否修改成功) */
  public boolean updateUser(UserInfoVO user) {
    String sql = "update userinfo_dbconn set username =? , password =? where uuid =?";
    boolean status = false;
    conn = DBUtil.getConnection();
    try {
      pst = conn.prepareStatement(sql);
      pst.setString(1, user.getUsername());
      pst.setString(2, user.getPassword());
      pst.setInt(3, user.getUuid());
      int pstReturn = pst.executeUpdate();
      if (pstReturn > 0) {
        status = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtil.connClose(conn, pst, rst);
    }
    return status;
  }

  /* 删除 判断executeUpdate的返回值(受影响的行)是否>0,返回是否有行受到影响(是否删除成功) */
  public boolean deleteUser(Integer uuid) {
    String sql = "delete from userinfo_dbconn where uuid =?";
    boolean status = false;
    conn = DBUtil.getConnection();
    try {
      pst = conn.prepareStatement(sql);
      pst.setInt(1, uuid);
      int pstReturn = pst.executeUpdate();
      if(pstReturn > 0){
        status = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
      DBUtil.connClose(conn, pst, rst);
    }
    return status;
  }
}