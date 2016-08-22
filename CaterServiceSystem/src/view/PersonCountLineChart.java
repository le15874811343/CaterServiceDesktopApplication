package view;

import java.util.List;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import entity.Income;
import entity.UserInfo;

import service.IncomService;
import service.UserService;
/**
 * 员工业绩统计折线图
 * @author 乐家良
 *
 */
public class PersonCountLineChart {
	private String where;
	private String name;
	private UserService userService = new UserService();

	public PersonCountLineChart(String where, String name) {
		this.where = where;
		this.name = name;
		this.createLineChart();
	}

	public void createLineChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Income in = new Income();
		IncomService incomeservice = new IncomService();
		UserInfo userInfo = new UserInfo();
		userInfo.setU_name(this.name);
		in.setI_data("%" + where + "%");
		in.setU_id(userService.getUserInfo(userInfo).get(0).getU_id());
		if (where.equals("")) {
			List<Income> incomeList4= incomeservice.getCountByYear(in);
			JFreeChart chart = ChartFactory.createLineChart(userService
					.getUserInfo(userInfo).get(0).getU_name()
					+ "业绩柱状图", "年", "服务笔数", dataset, PlotOrientation.VERTICAL,
					true, true, true);
			CategoryPlot cp = chart.getCategoryPlot();
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) cp
					.getRenderer();
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBaseShapesFilled(true);
			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			renderer

			.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

			cp.setRenderer(renderer);
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			ChartFrame frame = new ChartFrame("业绩折线图 ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList4) {
				String[] month = i.getI_data().split("-");
				dataset.addValue(i.getI_id(),"年份", month[0] + "年");

			}
		}
		else{
		if (where.split("-").length == 1) {
			List<Income> incomeList2 = incomeservice.getCountByMonth(in);
			JFreeChart chart = ChartFactory.createLineChart(userService
					.getUserInfo(userInfo).get(0).getU_name()
					+ "业绩柱状图", "月份", "服务笔数", dataset, PlotOrientation.VERTICAL,
					true, true, true);
			CategoryPlot cp = chart.getCategoryPlot();
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) cp
					.getRenderer();
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBaseShapesFilled(true);
			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			renderer

			.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

			cp.setRenderer(renderer);
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			ChartFrame frame = new ChartFrame("业绩折线图 ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList2) {
				String[] month = i.getI_data().split("-");
				dataset.addValue(i.getI_id(), month[0], month[1] + "月");

			}
		}
		if (where.split("-").length == 2) {

			List<Income> incomeList2 = incomeservice.getCountByDay(in);
			JFreeChart chart = ChartFactory.createLineChart(userService
					.getUserInfo(userInfo).get(0).getU_name()
					+ "业绩柱状图", "日期", "服务笔数", dataset, PlotOrientation.VERTICAL,
					true, true, true);
			CategoryPlot cp = chart.getCategoryPlot();
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) cp
					.getRenderer();
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBaseShapesFilled(true);
			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			renderer

			.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

			cp.setRenderer(renderer);
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			ChartFrame frame = new ChartFrame("业绩折线图 ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList2) {
				String[] day = i.getI_data().split("-");
				String[] _day = day[2].split(" ");
				dataset.addValue(i.getI_id(), day[0] + "年" + day[1] + "月",
						_day[0] + "号");
			}
		}
		if (where.split("-").length == 3) {

			List<Income> incomeList2 = incomeservice.getIncome(in);
			JFreeChart chart = ChartFactory.createLineChart(userService
					.getUserInfo(userInfo).get(0).getU_name()
					+ "业绩柱状图", "时刻", "服务次数", dataset, PlotOrientation.VERTICAL,
					true, true, true);
			CategoryPlot cp = chart.getCategoryPlot();
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) cp
					.getRenderer();
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBaseShapesFilled(true);
			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			renderer

			.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

			cp.setRenderer(renderer);
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			ChartFrame frame = new ChartFrame("业绩折线图 ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList2) {
				String[] day = i.getI_data().split("-");
				String[] _day = day[2].split(" ");
				dataset.addValue(1,
						day[0] + "年" + day[1] + "月" + _day[0] + "号", _day[1]
								+ "时刻");

			}
		}
		}
	}

}
