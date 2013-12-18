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
/**
 * This class contain the bar graph.
 *
 * @author sarath prakash
 */

public class BarGraph {
  private final Context context;
  private final QuizEntry quizEntry;
  private int fiftyGraphCurrectoption;
  private int fiftyGraphWrongoption;
  private Random randomObject;
  private int[] optionPercentage;
  private int balance0;
  private int balance1;
  private int balance2;
  private int balance3;
  private Intent intent;

  public BarGraph(Context context, QuizEntry quizEntry, int fiftyGraphCurrectoption, int fiftyGraphWrongoption) {
    this.context = context;
    this.quizEntry = quizEntry;
    this.fiftyGraphCurrectoption = fiftyGraphCurrectoption;
    this.fiftyGraphWrongoption = fiftyGraphWrongoption;
    optionPercentage = new int[4];
    randomObject = new Random();
  }

  public Intent getIntent() {
    if (fiftyGraphCurrectoption == 0) {
      int id = 0;
      for (String option : quizEntry.getOptions()) {
        if (option.equals(quizEntry.getAnswer())) {
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
      intent = ChartFactory.getBarChartIntent(context, dataset,mRenderer, Type.DEFAULT);
      return intent;
    } else {
      if (fiftyGraphCurrectoption == 1 && fiftyGraphWrongoption == 2) {
        fiftyFiftyGraph("OptionA", "OptionB", 60, 40);
      } else if (fiftyGraphCurrectoption == 1 && fiftyGraphWrongoption == 3) {
        fiftyFiftyGraph("OptionA", "OptionC", 60, 40);
      } else if (fiftyGraphCurrectoption == 1 && fiftyGraphWrongoption == 4) {
        fiftyFiftyGraph("OptionA", "OptionD", 60, 40);
      } else if (fiftyGraphCurrectoption == 2 && fiftyGraphWrongoption == 1) {
        fiftyFiftyGraph("OptionA", "OptionB", 40, 60);
      } else if (fiftyGraphCurrectoption == 2 && fiftyGraphWrongoption == 3) {
        fiftyFiftyGraph("OptionB", "OptionC", 60, 40);
      } else if (fiftyGraphCurrectoption == 2 && fiftyGraphWrongoption == 4) {
        fiftyFiftyGraph("OptionB", "OptionD", 60, 40);
      } else if (fiftyGraphCurrectoption == 3 && fiftyGraphWrongoption == 1) {
        fiftyFiftyGraph("OptionC", "OptionA", 60, 40);
        fiftyFiftyGraph("OptionA", "OptionC", 40, 60);
      } else if (fiftyGraphCurrectoption == 3 && fiftyGraphWrongoption == 2) {
        fiftyFiftyGraph("OptionB", "OptionC", 40, 60);
      } else if (fiftyGraphCurrectoption == 3 && fiftyGraphWrongoption == 4) {
        fiftyFiftyGraph("OptionC", "OptionD", 60, 40);
      } else if (fiftyGraphCurrectoption == 4 && fiftyGraphWrongoption == 1) {
        fiftyFiftyGraph("OptionA", "OptionD", 40, 60);
      } else if (fiftyGraphCurrectoption == 4 && fiftyGraphWrongoption == 2) {
        fiftyFiftyGraph("OptionB", "OptionD", 40, 60);
      } else if (fiftyGraphCurrectoption == 4 && fiftyGraphWrongoption == 3) {
        fiftyFiftyGraph("OptionC", "OptionD", 40, 60);
      }
      return intent;
    }
  }

  private void fiftyFiftyGraph(String option1, String option2, int opt1Percetage, int opt2Percetage) {
    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
    XYSeries optionA = new XYSeries(option1);
    XYSeries optionB = new XYSeries(option2);
    optionA.add(1, opt1Percetage);
    optionB.add(2, opt2Percetage);
    dataset.addSeries(optionA);
    dataset.addSeries(optionB);
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
    mRenderer.addXTextLabel(1, option1);
    mRenderer.addXTextLabel(2, option2);
    mRenderer.setXAxisMin(0);
    mRenderer.setXAxisMax(5);
    mRenderer.setYAxisMin(0);
    mRenderer.setYAxisMax(100);
    mRenderer.setYLabelsAlign(Align.CENTER);
    mRenderer.setXLabels(0);
    XYSeriesRenderer renderer = new XYSeriesRenderer();
    renderer.setColor(Color.GREEN);
    renderer.setDisplayChartValues(true);
    renderer.setChartValuesSpacing((float) 0);
    renderer.setChartValuesTextSize(30);
    renderer.setChartValuesSpacing(10);
    mRenderer.setXLabelsColor(Color.GREEN);
    mRenderer.addSeriesRenderer(renderer);
    XYSeriesRenderer renderer2 = new XYSeriesRenderer();
    renderer2.setColor(Color.RED);
    renderer2.setDisplayChartValues(true);
    renderer2.setChartValuesSpacing((float) 0);
    renderer2.setChartValuesTextSize(30);
    mRenderer.addSeriesRenderer(renderer2);
    intent = ChartFactory.getBarChartIntent(context, dataset, mRenderer, Type.DEFAULT);
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
