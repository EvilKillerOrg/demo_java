package com.ek.guide.zqiming.designpattern.factory.mode1;

public class DAOFactory {

	
	// 降低了耦合 service只对接口和DAOFactory依赖  要换别的实现 直接在DAOFactory中 换接口的实现就行了
	// 工厂模式由3个元素组成 的作用就是 1.接口 2.接口的实现 3.工厂类
	// 工厂模式的目的就是为了降低耦合,提升内聚
	
	// 自己的理解: 工厂方法就是 对构造过程(构造哪一个实例)来进行选择的逻辑
	//(可以通过传递参数选择来构造具体哪一个实现,不传参直接改返回 new哪一个也行)
	public static IUserInfoDAO getUserInfoDAO(int type){
		switch(type){
		case 1:
			return new UserInfoDAOImpl();
		case 2:
			return new UserInfoDAO2Impl();
			
			default:
				break;
		}
		return null;
		
	}
	
	public static IDeportmentDAO getDeportmentDAO(){
		return new DeportmentDAOImpl();
	}
	
}