package com.ek.guide.designpattern.factory.demo2;
/**
 * 2.工厂方法模式
 * 建一个 工厂接口
 * 给每一个类建立一个工厂类
 * 要增加新的品牌(类) 就直接 再加一个 新的类的工厂类
 * 就可以直接扩展出来 不用改修代码 符合开闭原则
 * 弊端就是类会变多
 * 各类就调用自己的工厂就行了
 * 项目开发中通常还是使用简单工厂
 * @author EK
 * @date 2017年7月27日
 */
public interface ICarFactory {
	Car getCar();
}