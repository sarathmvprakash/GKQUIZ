package com.sarath.gkquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is used for adding questions, 4 options and answers.
 *
 * @author sarath prakash.
 */
public class QuestionGenerator {
  private final List<QuizEntry> quizEntries;

  public QuestionGenerator() {
    quizEntries = new ArrayList<QuizEntry>();
    addQuestionEntries();
  }

  private void addQuestionEntries() {
    quizEntries.add(getQuizEntry("Zoological Survey of India has it headquarter at -", "Kolkata",
        "Chennai", "Delhi", "Dehradun", "Kolkata"));
    quizEntries.add(getQuizEntry("Name the process of production of energy in the Sun", "Radioactivity",
        "Nuclear fission", "Ionization", "Nuclear fusion", "Nuclear fusion"));
    quizEntries.add(getQuizEntry("Which of the following in automobile exhaust can cause cancer?", "Carbon monoxide",
        "Oxides of nitrogen", "Polyclinic hydrocarbons", "Lead", "Carbon monoxide"));
    quizEntries.add(getQuizEntry("Who invented chloroform as anaesthetic?", "Edward Jenner",
        "James Simpson", "Alexander Fleming", "Christian Barnard", "James Simpson"));
    quizEntries.add(getQuizEntry("Which of the following is biodegradable", "D.D.T.",
        "Paper", "Plastic", "Aluminium", "Paper"));
    quizEntries.add(getQuizEntry("Which of the following countries has become first to pass Climate Act?", "China",
        "USA", "Canada", "Germany", "Canada"));
    quizEntries.add(getQuizEntry("Who invented the ball-point pen:", "Lazzlo Biro",
        "Curie", "Newton", "Baird", "Lazzlo Biro"));
    quizEntries.add(getQuizEntry("Penicillin, an, antibiotic, is obtained from a", "Fungus",
        "Virus", "Flowering plant", "Bacterium", "Fungus"));
    quizEntries.add(getQuizEntry("Which among the following elements (metals) pollutes the air of a city having large "
        +"number of automobiles?", "Lead", "Nickel", "Chromium", "Cadmium", "Cadmium"));
    quizEntries.add(getQuizEntry("Supersonic Jet causes pollution by thinning of", "CO2 layer",
        "O2 layer", "O3 layer", "SO2 layer", "O3 layer"));
    quizEntries.add(getQuizEntry("Who invented penicillin?", "Louis Pasteur",
        "Alexander Fleming", "Dreser", "Dehradun", "Alexander Fleming"));
    quizEntries.add(getQuizEntry("The name of the white revolution is associated with-", "Kurien Verghese",
        "C.Rangarajan", "M.S.Swaminathan", "J.V.Narlikar", "Kurien Verghese"));
    quizEntries.add(getQuizEntry("Scientists at the Tomato Genome Consortium (TGC) successfully sequenced the genomes "
        + "of which of the following vegetables?", "Brinjal","Onion", "Potato", "Tomato", "Tomato"));     
  }

  private QuizEntry getQuizEntry(String question, String option1,
    String option2, String option3, String option4, String answer) {
      List<String> options = new ArrayList<String>(Arrays.asList(option1, option2, option3, option4));
      return new QuizEntry(question, options, answer);
  }

  public List<QuizEntry> getQuizEntries() {
    Collections.shuffle(quizEntries);
    return quizEntries;
  }
}
