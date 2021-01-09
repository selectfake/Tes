package cn.edu.jsu.zhangren.service;


import java.util.Vector;

import cn.edu.jsu.zhangren.view.DataOperate;
/**
 * 定义构造方法创建窗体及组件.
 */
public class PageController {
	
	private static Vector<Vector> bigList ; 
	private Vector<Vector> smallList = new Vector<Vector>(); 
	private static int curentPageIndex = 1; // 当前页码
	private static int  countPerpage = 10; // 每页显示条数
	private int pageCount; // 总页数
	private int recordCount; // 总记录条数
	{// 初始化代码块
		if(PageController.bigList==null) {
			PageController.bigList=DataOperate.getSelectAll("select * from datainput");// 调用查询数据库的方法，返回所有的行
		}
		//获取总页数
		if(bigList.size()%countPerpage==0) {
			pageCount=bigList.size()/countPerpage;
		}else {
			pageCount=bigList.size()/countPerpage+1;
		}
	}
	/**
	 * 无参构造方法
	 */
	public PageController() {}

	public PageController(int curentPageIndex) {//构造方法设置当前页
		this.curentPageIndex = curentPageIndex;
	}
	public void setCountPerpage(int countPerpage) {//设置每页显示的记录数
		this.countPerpage=countPerpage;
	}
	public Vector<Vector> getPaegData() {// 根据当前页数，筛选记录
		recordCount = bigList.size();//定义记录数为数据库中表的所有数据
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {//取得当前页数的记录，curentPageIndex当前页数，countPerpage每页显示的记录数
			smallList.add(bigList.get(i));//将记录加入到小集合中
		}
		return smallList;//返回小集合（当前页的数据）
	}
	public Vector<Vector> nextPage(){//下一页
		if(curentPageIndex<pageCount) {
			curentPageIndex++;
		}else {
			curentPageIndex=1;
		}
		return getPaegData();//返回下一页的数据
	}
	public Vector<Vector> prePage(){//上一页
		if(curentPageIndex>1) {
			curentPageIndex--;
		}else {
			curentPageIndex=pageCount;
		}
		return getPaegData();//返回上一页的数据
	}
}
