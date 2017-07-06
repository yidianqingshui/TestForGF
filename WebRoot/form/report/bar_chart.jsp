<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page
	import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory
,org.jfree.chart.StandardChartTheme, org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.labels.StandardCategoryItemLabelGenerator,org.jfree.chart.labels.StandardPieSectionLabelGenerator,java.text.DecimalFormat,java.text.NumberFormat,org.jfree.chart.plot.PiePlot,java.util.Set,java.util.Map,java.util.HashMap,HibernateDao.Itemgeneral,java.util.ArrayList,java.util.Iterator, java.awt.Font,java.util.List,org.jfree.chart.JFreeChart,org.jfree.chart.StandardChartTheme,org.jfree.chart.JFreeChart,org.jfree.data.category.DefaultCategoryDataset,org.jfree.chart.renderer.category.BarRenderer,org.jfree.chart.plot.PlotOrientation,org.jfree.chart.plot.CategoryPlot,org.jfree.chart.axis.CategoryAxis,org.jfree.chart.StandardChartTheme.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bar_chart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%  
  /*   java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("MM-dd");
     java.util.Date currentTime = new java.util.Date();//得到当前系统时间
     String str_date1 = formatter.format(currentTime); //将日期时间格式化 
     String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式 
    System.out.println("时间的字符串形式："+str_date1); */
    
    Calendar calendar=Calendar.getInstance();
    int month=calendar.get(Calendar.MONTH)+1;
    int day =calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println("当前月份"+month);
    System.out.println("当前日期"+day);
    //显示柱状图  
    DefaultCategoryDataset mDataset = new DefaultCategoryDataset();  
    
    //获取数据库数据
    	HibernateDao.ItemgeneralDAO D_ITEM = new HibernateDao.ItemgeneralDAO();
		List MyDao = D_ITEM.findAll();
		Iterator Temp = MyDao.iterator();
		//创建一个存储对象
		ArrayList Item_Number_List = new ArrayList();
		int a = 0;//库存大于最大库存的时候
		int b =0;//库存低于安全库存的种类
		int c=0;//正常值
		int d=0;//用于循环
		while (Temp.hasNext()) {

			Itemgeneral ins = (Itemgeneral) MyDao.get(d);
		    int Item_Number=	ins.getNumber();
		    int Maxstroage= ins.getMaxstroage();
		    int Safestroage=  ins.getSafestroage();
		    System.out.println("物料库存："+Item_Number+"物料最大库存："+Maxstroage+"物料安全库存："+Safestroage);
		    if(Item_Number>Maxstroage){
		    a++;
		    }
		    else if(Item_Number<Safestroage){
		    b++;
		    }
		    else{
		    c++;
		    }
			Temp.next();//进行下一次取值，不然进入死循环
		    d++;
		}
		
		System.out.println("低于安全库存有："+b+"高于安全库存："+a+"正常库存："+c);
		
    mDataset.addValue(b, "低于安全库存", "日期");  
    mDataset.addValue(a, "高于安全库存", "日期");
    mDataset.addValue(c, "正常库存", "日期");
      
    //创建主题样式  
    StandardChartTheme mChartTheme = new StandardChartTheme("CN");  
    //设置图表标题  
    mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));  
    //设置轴向字体  
    mChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 15));  
    //设置图例字体  
    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));  
    //应用主题  
    ChartFactory.setChartTheme(mChartTheme);  
      
    JFreeChart mChart = ChartFactory.createBarChart3D(  
                "库存情况",   
                "类型",   
                "数量",  
                mDataset,   
                PlotOrientation.VERTICAL,   
                true,   
                true,true);  
    //设置内部属性  
    CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();  
    CategoryAxis mDomainAxis = mPlot.getDomainAxis();  
    mPlot.setOutlinePaint(null);
    mChart.setBorderVisible(false);
    mChart.setBackgroundPaint(null);
	mChart.setBackgroundImageAlpha(0.0f);
	mPlot.setBackgroundAlpha(0.0f);
    //设置柱状图距离x轴最左端（即y轴）的距离百分比10%  
    //mDomainAxis.setLowerMargin(0.1);  
    mDomainAxis.setUpperMargin(0.1);  
    //柱体显示数值  
    BarRenderer mRenderer = new BarRenderer();  
    mRenderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
    mRenderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 15));  
    mRenderer.setItemLabelsVisible(true);  
    mPlot.setRenderer(mRenderer);  
      
    //500是图片长度，300是图片高度  
    String filenamebar = ServletUtilities.saveChartAsPNG(mChart, 800, 500, session);  
    String graphURLbar = request.getContextPath() + "/DisplayChart?filename=" + filenamebar;    
 
 %>  
 
 <img src="<%=graphURLbar%>" width="500" height="400">
  </body>
</html>
