package com.sanqing.bll;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import HibernateDao.Itemgeneral;

public class JFreeChartTest {
	 public static void main(String[] args)
	    {
		 HibernateDao.ItemgeneralDAO D_ITEM = new HibernateDao.ItemgeneralDAO();
		List MyDao = D_ITEM.findAll();
		Iterator Temp = MyDao.iterator();
		//创建一个存储对象
		List ProdDescList=new ArrayList();
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

	        DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
	        Iterator TempProdDesc=ProdDescList.iterator();
	        int b=0;
         	int c=0;
         	int d=0;
	        while(TempProdDesc.hasNext())
			{        	
	        String ProdDesc=	(String) ProdDescList.get(b);
	        System.out.println(ProdDesc);
	        if (ProdDesc.equals("11")) {
	        	c++;
			}
	        if (ProdDesc.equals("22")) {
				d++;
			}
	            b++;
	            TempProdDesc.next();
			}
	        dpd.setValue("什么类", c);
	        dpd.setValue("x类", d);
	       
	        JFreeChart chart=ChartFactory.createPieChart("某公司仓库入库数据图",dpd,true,true,false);
	        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
	        
	        ChartFrame chartFrame=new ChartFrame("某公司仓库入库数据图",chart);
	        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
	        chartFrame.pack(); //以合适的大小展现图形
	        chartFrame.setVisible(true);//图形是否可见
	        
	    }
}
