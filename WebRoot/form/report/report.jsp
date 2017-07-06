<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page
	import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory
,org.jfree.chart.StandardChartTheme, org.jfree.chart.labels.StandardCategoryItemLabelGenerator,org.jfree.chart.labels.StandardPieSectionLabelGenerator,java.text.DecimalFormat,java.text.NumberFormat,org.jfree.chart.plot.PiePlot,java.util.Set,java.util.Map,java.util.HashMap,HibernateDao.Itemgeneral,java.util.ArrayList,java.util.Iterator, java.awt.Font,java.util.List,org.jfree.chart.JFreeChart,org.jfree.chart.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		DefaultPieDataset dpd = new DefaultPieDataset(); //建立一个默认的饼图
		//创建主题样式  
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		//设置标题字体  
		mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 50));
		//设置轴向字体  
		mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 30));
		//设置图例字体  
		mChartTheme
				.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 30));
		//应用主题样式  
		ChartFactory.setChartTheme(mChartTheme);

		HibernateDao.ItemgeneralDAO D_ITEM = new HibernateDao.ItemgeneralDAO();
		List MyDao = D_ITEM.findAll();
		Iterator Temp = MyDao.iterator();
		//创建一个存储对象
		ArrayList ProdDescList = new ArrayList();
		int a = 0;
		while (Temp.hasNext()) {

			Itemgeneral ins = (Itemgeneral) MyDao.get(a);
			String ProdDesc = ins.getClasscode().getProdDesc();
			//System.out.println(ProdDesc);
			ProdDescList.add(ProdDesc);
			a++;
			Temp.next();//进行下一次取值，不然进入死循环
		}
		Iterator TempProdDesc = ProdDescList.iterator();
		int b = 0;//存储类型数组的序号

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < ProdDescList.size(); i++) {//循环数组

			if (map.containsKey(ProdDescList.get(i))) {//判断如果key中已存在该字符串

				map.put(String.valueOf(ProdDescList.get(i)),
						map.get(ProdDescList.get(i)) + 1);//value值 加一次（多出现一次）

			} else {

				map.put(String.valueOf(ProdDescList.get(i)), 1);//如果该字符串没有出现 map新保存一组数据  出现次数为1次

			}

		}

		//循环结束

		Set<String> set = map.keySet();

		Iterator<String> it = set.iterator();//iterator迭代器

		while (it.hasNext()) {

			String key = (String) it.next();

			System.out.println(key + "出现的次数为" + "   " + map.get(key) + "次");
			dpd.setValue(key, map.get(key));

		}
		JFreeChart chart = ChartFactory.createPieChart3D("某公司仓库物料类型图", dpd);
		chart.setBorderVisible(false);
		chart.setBackgroundPaint(null);
		chart.setBackgroundImageAlpha(0.0f);
		//JFreeChart chart = ChartFactory.createBarChart3D("某公司仓库物料类型图",dpd, true,  false, false);
		PiePlot pieplot = (PiePlot) chart.getPlot(); //通过JFreeChart 对象获得 
		//设置背景透明度（0~1）  
		pieplot.setBackgroundAlpha(0.0f);
		//设置前景色透明度（0~1）  
		pieplot.setForegroundAlpha(0.5f);
		pieplot.setOutlinePaint(null);
		DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题,表示小数点后保留两位。  
		NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
		StandardPieSectionLabelGenerator sp = new StandardPieSectionLabelGenerator(
				"{0}:{2}", nf, df);//获得StandardPieSectionLabelGenerator对象,生成的格式，{0}表示section名，{1}表示section的值，{2}表示百分比。可以自定义  
		pieplot.setLabelGenerator(sp);

		//JFreeChart chart = ChartFactory.createPieChart("某公司仓库物料类型图",dpd, true, false, false);

		String fileName = ServletUtilities.saveChartAsPNG(chart, 800, 600,
				session);
		//ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）

		String url = request.getContextPath() + "/DisplayChart?filename="
				+ fileName;
		//根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
	%>

	<img src="<%=url%>" width="300" height="200">

     
</body>
</html>