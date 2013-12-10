package com.sarath.gkquiz;

import java.util.Random;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;

public class BarGraph {
  private final Context context;
  private final QuizEntry quizEntry;
  private Random randomObject = new Random();
  private int[] optionPercentage;
  private int balance0, balance1, balance2, balance3;

  public BarGraph(Context context, QuizEntry quizEntry) {
    optionPercentage = new int[4];
    this.context = context;
    this.quizEntry = quizEntry;
  }

  public Intent getIntent() {
    int id = 0;
    for (String option : quizEntry.getOptions()) {
      if(option.equals(quizEntry.getAnswer())) {
        switch (id) {
        case 0:
          percentageCalculation();
          graphInitialization(balance0, balance1, balance2, balance3);
          break;
        case 1:
          percentageCalculation();
          graphInitialization(balance1, balance0, balance2, balance3);
          break;
        case 2:
          percentageCalculation();
          graphInitialization(balance2, balance1, balance0, balance3);
          break;
        case 3:
          percentageCalculation();
          graphInitialization(balance3, balance1, balance2, balance0);
          break;
        default:
          break;
        }
      } else {
        id++;
      }
    }
    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
    XYSeries optionA = new XYSeries("OptionA");
    XYSeries optionB = new XYSeries("OptionB");
    XYSeries optionC = new XYSeries("OptionC");
    XYSeries optionD = new XYSeries("OptionD");
    optionA.add(1, optionPercentage[0]);
    optionB.add(2, optionPercentage[1]);
    optionC.add(3, optionPercentage[2]);
    optionD.add(4, optionPercentage[3]);
    dataset.addSeries(optionA);
    dataset.addSeries(optionB);
    dataset.addSeries(optionC);
    dataset.addSeries(optionD);
    XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
    mRenderer.setChartTitle("Audiance Poll");
    mRenderer.setAxesColor(Color.BLACK);
    mRenderer.setApplyBackgroundColor(true);
    mRenderer.setBackgroundColor(Color.WHITE);
    mRenderer.setMarginsColor(Color.WHITE);
    mRenderer.setZoomEnabled(true);
    mRenderer.setBarSpacing(-.5);
    mRenderer.setBarWidth(50);
    mRenderer.setMargins(new int[] {20, 30, 15, 0});
    mRenderer.setShowLegend(false);
    mRenderer.setAxisTitleTextSize(16);
    mRenderer.setChartTitleTextSize(40);
    mRenderer.setLabelsTextSize(15);
    mRenderer.setLegendTextSize(15);
    mRenderer.addXTextLabel(1, "Option A");
    mRenderer.addXTextLabel(2, "Option B");
    mRenderer.addXTextLabel(3, "Option C");
    mRenderer.addXTextLabel(4, "Option D");
    mRenderer.setXAxisMin(0);
    mRenderer.setXAxisMax(5);
    mRenderer.setYAxisMin(0);
    mRenderer.setYAxisMax(100);
    mRenderer.setYLabelsAlign(Align.CENTER);
    mRenderer.setXLabels(0);
    XYSeriesRenderer renderer = new XYSeriesRenderer();
    renderer.setColor(Color.RED);
    renderer.setDisplayChartValues(true);
    renderer.setChartValuesSpacing((float) 0);
    renderer.setChartValuesTextSize(30);
    renderer.setChartValuesSpacing(10);
    mRenderer.setXLabelsColor(Color.GREEN);
    mRenderer.addSeriesRenderer(renderer);
    XYSeriesRenderer renderer2 = new XYSeriesRenderer();
    renderer2.setColor(Color.GREEN);
    renderer2.setDisplayChartValues(true);
    renderer2.setChartValuesSpacing((float) 0);
    renderer2.setChartValuesTextSize(30);
    mRenderer.addSeriesRenderer(renderer2);
    XYSeriesRenderer renderer3 = new XYSeriesRenderer();
    renderer3.setColor(Color.YELLOW);
    renderer3.setDisplayChartValues(true);
    renderer3.setChartValuesSpacing((float) 0);
    renderer3.setChartValuesTextSize(30);
    mRenderer.setXLabelsColor(Color.RED);
    mRenderer.addSeriesRenderer(renderer3);
    XYSeriesRenderer renderer4 = new XYSeriesRenderer();
    renderer4.setColor(Color.MAGENTA);
    renderer4.setDisplayChartValues(true);
    renderer4.setChartValuesSpacing((float) 0);
    renderer4.setChartValuesTextSize(30);
    mRenderer.addSeriesRenderer(renderer4);
    Intent intent = ChartFactory.getBarChartIntent(context, dataset,mRenderer, Type.DEFAULT);
    return intent;
  }

  private void graphInitialization(int first, int second, int third, int fourth) {
    optionPercentage[0] = first;
    optionPercentage[1] = second;
    optionPercentage[2] = third;
    optionPercentage[3] = fourth;
  }

  private void percentageCalculation() {
    balance0 = (50 + randomObject.nextInt(10));
    balance1 = (100-balance0)/4;
    int temp1 = (100-(balance1+balance0))/3;
    balance2 = temp1*2;
    balance3 = temp1;
  }
}
