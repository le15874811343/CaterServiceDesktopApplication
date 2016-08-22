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
 * Ա��ҵ��ͳ������ͼ
 * @author �ּ���
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
					+ "ҵ����״ͼ", "��", "�������", dataset, PlotOrientation.VERTICAL,
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
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			ChartFrame frame = new ChartFrame("ҵ������ͼ ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList4) {
				String[] month = i.getI_data().split("-");
				dataset.addValue(i.getI_id(),"���", month[0] + "��");

			}
		}
		else{
		if (where.split("-").length == 1) {
			List<Income> incomeList2 = incomeservice.getCountByMonth(in);
			JFreeChart chart = ChartFactory.createLineChart(userService
					.getUserInfo(userInfo).get(0).getU_name()
					+ "ҵ����״ͼ", "�·�", "�������", dataset, PlotOrientation.VERTICAL,
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
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			ChartFrame frame = new ChartFrame("ҵ������ͼ ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList2) {
				String[] month = i.getI_data().split("-");
				dataset.addValue(i.getI_id(), month[0], month[1] + "��");

			}
		}
		if (where.split("-").length == 2) {

			List<Income> incomeList2 = incomeservice.getCountByDay(in);
			JFreeChart chart = ChartFactory.createLineChart(userService
					.getUserInfo(userInfo).get(0).getU_name()
					+ "ҵ����״ͼ", "����", "�������", dataset, PlotOrientation.VERTICAL,
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
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			ChartFrame frame = new ChartFrame("ҵ������ͼ ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList2) {
				String[] day = i.getI_data().split("-");
				String[] _day = day[2].split(" ");
				dataset.addValue(i.getI_id(), day[0] + "��" + day[1] + "��",
						_day[0] + "��");
			}
		}
		if (where.split("-").length == 3) {

			List<Income> incomeList2 = incomeservice.getIncome(in);
			JFreeChart chart = ChartFactory.createLineChart(userService
					.getUserInfo(userInfo).get(0).getU_name()
					+ "ҵ����״ͼ", "ʱ��", "�������", dataset, PlotOrientation.VERTICAL,
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
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			ChartFrame frame = new ChartFrame("ҵ������ͼ ", chart, true);
			frame.pack();
			frame.setVisible(true);
			for (Income i : incomeList2) {
				String[] day = i.getI_data().split("-");
				String[] _day = day[2].split(" ");
				dataset.addValue(1,
						day[0] + "��" + day[1] + "��" + _day[0] + "��", _day[1]
								+ "ʱ��");

			}
		}
		}
	}

}
