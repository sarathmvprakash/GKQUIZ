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
    quizEntries.add(getQuizEntry("Penicillin, an antibiotic is obtained from a", "Fungus",
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
    quizEntries.add(getQuizEntry("TIf a cloth is coated with a resin then the angle of contact between the cloth and water"
        , "Increases","Decreases", "Remains same", "Becomes zero", "Increases"));
    quizEntries.add(getQuizEntry("When a magnetic needle is placed at a neutral point, it turns"
        , "Vertical","Horizontal", "At an angle greater than 90", "At an angle smaller than 90", "Vertical"));
    quizEntries.add(getQuizEntry("Which one of the following was to be discovered first in the chromosphere of the sun"
        , "Helium","Neon", "Xenon", "Krypton", "Helium"));
    quizEntries.add(getQuizEntry("Study of life in outer space is"
        , "Endobiology","Entrobiology", "Neobiology", "Exobiology", "Exobiology"));
    quizEntries.add(getQuizEntry("When a green leaf is seen in red light, its colour will be"
        , "Green","Red", "Black", "Brown", "Black"));
    quizEntries.add(getQuizEntry("The branch of physiology and medicine concerned with heart is known as"
        , "Cytogenetics","Geriatrics", "Haematology", "Cardiology", "Cardiology"));
    quizEntries.add(getQuizEntry("The Multi-Lingual Natural Disaster Information System (NDIS) has been developed by"
        , "GSTL","Infosys", "Wipro", "Microsoft", "GSTL"));
    quizEntries.add(getQuizEntry("Solar-B satellite to study the sun has been launched by"
        , "Japan","China", "Russia", "America", "Japan"));
    quizEntries.add(getQuizEntry("'Rosatom' is the atomic energy agency of -"
        , "Canada","France", "Britain", "Germany", "Germany"));
    quizEntries.add(getQuizEntry("Who of the following won the Nobel Prize for his work on Photoelectric effect"
        , "Albert Einstein","Werner Heisenberg", "Steven Weinberg", "Max Planck", "Albert Einstein"));
    quizEntries.add(getQuizEntry("In which city is the International Advanced Research Centre for Powder Metallurgy and "
        + "New Materials (ARCI) located ?", "Mumbai","Bengaluru", "Chennai", "Hyderabad", "Hyderabad"));
    quizEntries.add(getQuizEntry("In which district of Uttar Pradesh has solar energy plant been started?"
        , "Agra","Aligarh", "Mathura", "Etah", "Aligarh"));
    quizEntries.add(getQuizEntry("What is the source of electric energy in an artificial satellite?"
        , "mini nuclear reactor","dynamo", "thermopile", "Solar cells", "Solar cells"));
    quizEntries.add(getQuizEntry("International Renewable Energy Agency (IRENA) is presently headed by"
        , "Helene Pelosse","G. Vishwanathan", "Lars Rasmussen", "Peter Roebuck", "Helene Pelosse"));
    quizEntries.add(getQuizEntry("The most commonly used chemicals for the 'artificial rainmaking' or clod seeding are"
        , "AgI","NaCl", "Frozen CO2", "All of the above", "All of the above"));
    quizEntries.add(getQuizEntry("Which of the following subtype of Ultraviolet (UV) rays is 100% penetrable through the Ozone Layer?"
        , "UV-A","UV-B", "UV-C", "None of the above", "UV-A"));
    quizEntries.add(getQuizEntry("PSLV-C14 in its latest space quest had carried Oceasat-2 with how many foreign nano satellites"
        , "2","7", "6", "8", "6"));
    quizEntries.add(getQuizEntry("Which of the following falls in the category of endangered species under the Red Data list of IUCN?"
        , "Albatross","Crowned solitary eagle", "Snow Leopard", "All of the above", "All of the above"));
    quizEntries.add(getQuizEntry("Grantham Prize is constituted to felicitate the journalists working in the area of"
        , "Physics","Chemistry", "Medicine", "Environment", "Environment"));
    quizEntries.add(getQuizEntry("Which of the following diseases is caused by the consumption of nitrate contaminated food and water?"
        , "Minamata disease","Osteoporosis", "Asbestosis", "Blue baby syndrome", "Blue baby syndrome"));
    quizEntries.add(getQuizEntry("The scientific name of Indian Tiger is -"
        , "Panthera tigris","Panthera pardus", "Felis tigris", "Felis chaus", "Panthera tigris"));
    quizEntries.add(getQuizEntry("Ozone hole was first been discovered in 1980s, by the British scientist over -"
        , "Artic region","Polar region", "Antarctica", "Tropical region", "Antarctica"));
    quizEntries.add(getQuizEntry("The smallest functional and structural unit of kidney is called as -"
        , "Neuron","Nephron", "Granulocyte", "Reticulocyte", "Nephron"));
    quizEntries.add(getQuizEntry("Pokharan II took place on"
        , "9-5-1998","10-5-1998", "11-5-1998", "12-5-1998", "11-5-1998"));
    quizEntries.add(getQuizEntry("The resources which can be used continuously, year-after-year are called"
        , "Biotic","Abiotic", "Non-renewable", "renewable", "renewable"));
    quizEntries.add(getQuizEntry("Who Gave the First Evidence of the Big-Bang Theory?"
        , "Edwin Hubble","Albert Einstein", "S. Chandrashekhar", "Stephen Hawking", "Edwin Hubble"));
    quizEntries.add(getQuizEntry("Which of the following is not a missile tested in Indian Missile Programme?"
        , "Agni","Trishul", "Prithvi", "Arjun", "Arjun"));
    quizEntries.add(getQuizEntry("Humidity is measured by which of the following instrument?"
        , "Barometer","Thermometer", "Hygrometer", "Hydrometer", "Hygrometer"));
    quizEntries.add(getQuizEntry("The magnetic effect of electric current was first observed by"
        , "Henry","Oersted", "Faraday", "Volta", "Oersted"));
    quizEntries.add(getQuizEntry("Acupuncture is widely practised in"
        , "India","America", "China", "Germany", "China"));
    quizEntries.add(getQuizEntry("The study which deals with secret writing is known as"
        , "Cryptography","Secretology", "Cytography", "Cryptology", "Cryptology"));
    quizEntries.add(getQuizEntry(" which was in news in recent past is the name of a newly developed- "
        , "Air-to-air Missile","Battle Tank", "Spy Rocket", "Submarine", "Air-to-air Missile"));
    quizEntries.add(getQuizEntry("Radioactive element which has been found to have large reserves in India is"
        , "Uranium","Thorium", "Radium", "Plutonium", "Thorium"));
    quizEntries.add(getQuizEntry("Television broadcast for rural development programmes in India started in-"
        , "1947","1957", "1967", "1977", "1977"));
    quizEntries.add(getQuizEntry("The resources which can be used continuously, year-after-year are called"
        , "Biotic","Abiotic", "Non-renewable", "Renewable", "Renewable"));
    quizEntries.add(getQuizEntry("Uranium Corporation of India is located in"
        , "Mumbai","Delhi", "Jadugoda", "Chennai", "Mumbai"));
    quizEntries.add(getQuizEntry("Theorphrastus is called the father of"
        , "Botany","Zoology", "Anatomy", "Astrology", "Botany"));
    quizEntries.add(getQuizEntry("India's first remote sensing satellite (IRS 1A) was launched from"
        , "Baikonour","Cape Kennedy", "French Guiana", "Sri Harikota", "Baikonour"));
    quizEntries.add(getQuizEntry("Nobel Alfred Bernhard after whom Nobe prizes are given was"
        , "Engineer","Chemist", "Both A & B", "Doctor", "Both A & B"));
    quizEntries.add(getQuizEntry("In July 2010' ISRO used the vehicle for Launching 5 Satellites-"
        , "GSLV","PSLV", "ESLV", "SLV", "PSLV"));
    quizEntries.add(getQuizEntry("The branch of study dealing with old age and aging is called-"
        , "Oncology","Gerentology", "Teratology", "Ornithology", "Gerentology"));
    quizEntries.add(getQuizEntry("TIf a cloth is coated with a resin then the angle of contact between the cloth and water"
        , "Gerentology","Decreases", "Remains", "Becomes", "Increases"));
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
