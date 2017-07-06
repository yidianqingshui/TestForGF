package com.sanqing.bll;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import HibernateDao.Itemgeneral;

public class Test {
	public static void main(String[] args) {
		
		   DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
		 //创建主题样式  
	    StandardChartTheme mChartTheme = new StandardChartTheme("CN");  
	    //设置标题字体  
	    mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));  
	    //设置轴向字体  
	    mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
	    //设置图例字体  
	    mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
	    //应用主题样式  
	    ChartFactory.setChartTheme(mChartTheme);  
	    
	    //输入数据
	    HibernateDao.ItemgeneralDAO D_ITEM = new HibernateDao.ItemgeneralDAO();
		List MyDao = D_ITEM.findAll();//MyDao是存储所有物料对象
		Iterator Temp = MyDao.iterator();
		//创建一个存储对象来存储每个物料的种类
		ArrayList ProdDescList=new ArrayList();
		int a=0;
		while(Temp.hasNext())
		{
		  Itemgeneral  ins=	(Itemgeneral) MyDao.get(a);
		   String  ProdDesc  =	ins.getClasscode().getProdDesc();
		   //System.out.println(ProdDesc);
		   ProdDescList.add(ProdDesc);
		   a++;
		    Temp.next();//进行下一次取值，不然进入死循环
		}
		//通过
		 Map<String,Integer> map = new HashMap<String, Integer>();

			for (int i = 0; i < ProdDescList.size(); i++) {//循环数组

			if(map.containsKey(ProdDescList.get(i))){//判断如果key中已存在该字符串

			map.put(String.valueOf(ProdDescList.get(i)), map.get(ProdDescList.get(i))+1);//value值 加一次（多出现一次）

			}else{

			map.put(String.valueOf(ProdDescList.get(i)), 1);//如果该字符串没有出现 map新保存一组数据  出现次数为1次

			}

			}

			//循环结束
			
			Set<String> set = map.keySet();

			Iterator<String>  it = set.iterator();//iterator迭代器

			while (it.hasNext()) {

			String key = (String) it.next();

			System.out.println(key+"出现的次数为"+"   "+map.get(key)+"次");
			 dpd.setValue(key, map.get(key));

			}
			 
			ChartFactory.createPieChart3D("某公司仓库物料类型图", dpd);
		JFreeChart chart = ChartFactory.createPieChart("某公司仓库物料类型图",dpd, true, false, false);
		PiePlot pieplot = (PiePlot) chart.getPlot(); //通过JFreeChart 对象获得 
		//设置背景透明度（0~1）  
		pieplot.setBackgroundAlpha(0.9f);  
        //设置前景色透明度（0~1）  
		pieplot.setForegroundAlpha(0.5f);  
		DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题,表示小数点后保留两位。  
		NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
		StandardPieSectionLabelGenerator sp = new StandardPieSectionLabelGenerator(  
		        "{0}:{2}", nf, df);//获得StandardPieSectionLabelGenerator对象,生成的格式，{0}表示section名，{1}表示section的值，{2}表示百分比。可以自定义  
	  
	
	}

}