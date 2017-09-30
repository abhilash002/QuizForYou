package metrowebz.com.quizforyou.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import metrowebz.com.quizforyou.Model.Question;


/**
 * Created by Abhilash on 06-11-2016.
 */
public class QuestionDB extends SQLiteOpenHelper {

    private static final String DATABASENAME = "Quiz_Quest";
    private static final int DATABASVERSION = 3;
    private static final String TABLE_QUEST_SCIENCE = "QUEST_SCIENCE";
    private static final String TABLE_QUEST_HISTORY = "QUEST_HISTORY";
    private static final String TABLE_QUEST_GEOGRAPHY = "QUEST_GEOGRAPHY";
    private static final String TABLE_QUEST_MATH = "QUEST_MATH";
    private static final String TABLE_QUEST_RAND = "QUEST_RAND";
    private static final String TABLE_QUEST_SPORTS = "QUEST_SPORTS";
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private static final String KEY_OPTD = "optd"; // option d

    private SQLiteDatabase dbase;
    private String sqlQuery = "CREATE TABLE IF NOT EXISTS "+ TABLE_QUEST_SCIENCE +" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_QUES+" TEXT, "+KEY_OPTA+" TEXT, "+KEY_OPTB+" TEXT, "
            +KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT ,"+KEY_ANSWER+" TEXT) ";
    private String sqlQuery1 = "CREATE TABLE IF NOT EXISTS "+ TABLE_QUEST_HISTORY +" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_QUES+" TEXT, "+KEY_OPTA+" TEXT, "+KEY_OPTB+" TEXT, "
            +KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT ,"+KEY_ANSWER+" TEXT) ";
    private String sqlQuery2 = "CREATE TABLE IF NOT EXISTS "+ TABLE_QUEST_GEOGRAPHY +" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_QUES+" TEXT, "+KEY_OPTA+" TEXT, "+KEY_OPTB+" TEXT, "
            +KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT ,"+KEY_ANSWER+" TEXT) ";
    private String sqlQuery3 = "CREATE TABLE IF NOT EXISTS "+ TABLE_QUEST_MATH +" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_QUES+" TEXT, "+KEY_OPTA+" TEXT, "+KEY_OPTB+" TEXT, "
            +KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT ,"+KEY_ANSWER+" TEXT) ";
    private String sqlQuery4 = "CREATE TABLE IF NOT EXISTS "+ TABLE_QUEST_RAND +" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_QUES+" TEXT, "+KEY_OPTA+" TEXT, "+KEY_OPTB+" TEXT, "
            +KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT ,"+KEY_ANSWER+" TEXT) ";
    private String sqlQuery5 = "CREATE TABLE IF NOT EXISTS "+ TABLE_QUEST_SPORTS +" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_QUES+" TEXT, "+KEY_OPTA+" TEXT, "+KEY_OPTB+" TEXT, "
            +KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT ,"+KEY_ANSWER+" TEXT) ";

    public QuestionDB(Context context) {
        super(context, DATABASENAME, null, DATABASVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;

        db.execSQL(sqlQuery);
        addScienceQuestion();

        db.execSQL(sqlQuery1);
        addHistoryQuestion();

        db.execSQL(sqlQuery2);
        addGeographyQuestion();

        db.execSQL(sqlQuery3);
        addMathQuestion();

        db.execSQL(sqlQuery4);
        addRandomQuestion();

        db.execSQL(sqlQuery5);
        addSportQuestions();

    }

    //Science - 100, Geo- 100, Math- 100, History- 100, Sports- 100,Ran- 25
    private void addSportQuestions() {
        Question q = new Question("Who among the Indian to win the Athletics Gold in 1998 Asian Games?"," Kapil Dev","Jyotirmoyee Sikdar","Sunita Rani","P.T.Usha","Jyotirmoyee Sikdar");
        this.addSportQuestions(q);
        q = new Question("The Olympic museum was opened at which of the following places?","Lausanne","Istanbul","Athens","Rome","Lausanne");
        this.addSportQuestions(q);
        q = new Question("S. Vijayalakshmi and Nisha Mohita are associated with","Badminton","Tennis","Chess","Table Tennis","Chess");
        this.addSportQuestions(q);
        q = new Question("The name of the Mascot for 1996 Olympics held at Atlanta was","Matari","APPU","WHATZ IT","Uncle Sam","WHATZ IT");
        this.addSportQuestions(q);
        q = new Question("The term ‘Tee’ is connected with","Badminton","Golf"," Bridge","Polo","Golf");
        this.addSportQuestions(q);
        q = new Question("Crame Trophy Tennis final held in May 2003 was played between","Leander Paes and David Rickle"," John McEnore and David Rickle"," Boris Becker and John McEnroe"," Boris Becker and Leander Paes"," Boris Becker and John McEnroe");
        this.addSportQuestions(q);
        q = new Question("Major R.S. Brar is associated with"," Boxing"," Golf"," Equestrian","Tennis","Equestrian");
        this.addSportQuestions(q);
        q = new Question("Who among the following was adjudged the Best Athlete of 14th Asian games held in Busan, South Korea?"," Kosuke Kitajima","Taufik Hidayat"," Lee Bong – Ju"," Zaw Min Htwe"," Kosuke Kitajima");
        this.addSportQuestions(q);
        q = new Question("Vishal Uppal and Harsh Mankad won the Doubles of the ITF Men’s Futures Tournament in"," Badminton"," Tennis"," Football"," Volleyball","Tennis");
        this.addSportQuestions(q);
        q = new Question("Prakash Padukone is associated with which games?","Cricket","Table Tennis","Judo","Badminton","Badminton");
        this.addSportQuestions(q);
        q = new Question("Which of the following was the mascot of the Barcelona Olympic Games?","Cobi","Doves","hodori","Panda","Cobi");
        this.addSportQuestions(q);
        q = new Question("The term ‘Butterfly Stroke’ is associated with","Wrestling","Boxing","Kabaddi","Swimming","Swimming");
        this.addSportQuestions(q);
        q = new Question("‘Ashes’ is the term associates with which sports?","Basketball","Cricket","Hockey","Volleyball","B: Cricket");
        this.addSportQuestions(q);
        q = new Question("‘Queens berry Rules’ is the name given to the rules in","Boxing","Football","Tennis","Cricket","Boxing");
        this.addSportQuestions(q);
        q = new Question("Which of the following games is not included in the Olympic Games?","Skiing","Cycling","Cricket","Archery","Cricket");
        this.addSportQuestions(q);
        q = new Question("Shiny Wilson is associated with which of the following games/sports?","Athletics","Hockey","Swimming","Cricket","Athletics");
        this.addSportQuestions(q);
        q = new Question("The ‘Agha Khan Cup’ is associated with which game?","Badminton","Hockey","Football","Cricket","Hockey");
        this.addSportQuestions(q);
        q = new Question("The Golf player Vijay Singh represents","Canada","Fiji","Sri Lanka","India","Fiji");
        this.addSportQuestions(q);
        q = new Question("Which Indian Criketer was given the title ‘Tiger’?","Sunil Gavaskar","Rahul Dravid","B.S. Bedi","Mansur Ali Khan Pataudi","Mansur Ali Khan Pataudi");
        this.addSportQuestions(q);
        q = new Question("Jaspal Rana is in which of the following games?","Shooting","Weight Lifting","Swimming","Archery","Shooting");
        this.addSportQuestions(q);
        q = new Question("What is the another name of ATHLETICS.","Sports","Track &Field","Gymnastics","Decathlon","Track &Field");
        this.addSportQuestions(q);
        q = new Question("Time shall be taken from the-","Sound of Gun","Flash smoke","Whistle","None of these.","Flash smoke");
        this.addSportQuestions(q);
        q = new Question("How many types of tracks are there?","Two type","Three type","Four type","Five type","Two type");
        this.addSportQuestions(q);
        q = new Question("How many lanes are there in a standard track?","6 to 9","8 to 9","10 to 12","11 to 13","6 to 9");
        this.addSportQuestions(q);
        q = new Question("The following are the standard distance of hurdler Race for men.","100 & 400 mts.","110 & 400 mts","80 & 200 mts","All of these.","110 & 400 mts");
        this.addSportQuestions(q);
        q = new Question("Direction of running shall be.","Right hand side","Left hand side","curve- running","none of these.","");
        this.addSportQuestions(q);
        q = new Question("Standard width of the lane shall be.","1.20 mts","1.22 mts","1.22 to 1.25 mts.","110 mts.","1.22 to 1.25 mts.");
        this.addSportQuestions(q);
        q = new Question("The Standard distance of Marathon Race.","26 kms.","42 kms.","42.195 kms","42.123 kms","42.195 kms");
        this.addSportQuestions(q);
        q = new Question("The procedure of doping test is including the collection of.","Sugar sample","Urine sample","stool Sample","Blood Sample","Urine sample");
        this.addSportQuestions(q);
        q = new Question("How many athletes may be used as substitutes in Relays race event","One athlete.","Two athlete","Three athlete","none of these.","One athlete.");
        this.addSportQuestions(q);
        q = new Question("Landing area of High jump event should be.","5×2 mts","5×3 mts","5×4 mts","5×5 mts.","5×3 mts");
        this.addSportQuestions(q);
        //Q-30
        q = new Question("Landing area of Pole vault event should be.","6×4 mts","5×3 mts","5×4 mts","5×5 mts.","5×5 mts.");
        this.addSportQuestions(q);
        q = new Question("Landing area of long jump event should be.","10×2.75 mts","9×3 mts","9×4 mts","9×2.75 mts.","9×2.75 mts.");
        this.addSportQuestions(q);
        q = new Question("In Triple jump distance between the take off board and landing area shall be not more than.","9 mts.","10 mts.","13 mts","11 mts.","13 mts");
        this.addSportQuestions(q);
        q = new Question("For valid throw shot must fall.","In sector area","Within the inner edges of landing sector","Nearest on sector lines.","None of these.","In sector area");
        this.addSportQuestions(q);
        q = new Question("The first Indian woman athlete to win a gold in Asian Games is .","P.T.Usha","Shayni Abhramn","kamaljit Sandhu","Anju B. G.","P.T.Usha");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of shot for acceptance of a record (for men)","7.26 kg.","8 kg","7.25 kg","5 kg","7.26 kg.");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of shot for acceptance of a record (for women)","4 kg.","8 kg","7.25 kg","5 kg","4 kg.");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of discuss for acceptance of a record (for men)","1 kg.","2 kg","3 kg","800 gms.","2 kg");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of Javelin for acceptance of a record (for women)","800 gms","750 gms","600 gms","500 gms.","600 gms");
        this.addSportQuestions(q);
        q = new Question("What is the another name of ATHLETICS.","Sports","Track &Field","Gymnastics","Decathlon","Track &Field");
        this.addSportQuestions(q);
        q = new Question("Time shall be taken from the.","Sound of Gun","Flash smoke"," Whistle "," None of these.","Flash smoke");
        this.addSportQuestions(q);
        q = new Question("How many types of tracks are there?"," Two type"," Three type","Four type ","Five type"," Two type");
        this.addSportQuestions(q);
        q = new Question("How many lanes are there in a standard track?","(a) 6 to 9 ","(b) 8 to 9","(c) 10 to 12 ","(d) 11 to 13","(a) 6 to 9 ");
        this.addSportQuestions(q);
        q = new Question("The following are the standard distance of hurdler Race for men.","(a) 100 & 400 mts. ","(b) 110 & 400 mts.","(c) 80 & 200 mts. ","(d) All of these.","(b) 110 & 400 mts.");
        this.addSportQuestions(q);
        q = new Question("Direction of running shall be.","(a) Right hand side ","(b) Left hand side","(c) curve- running ","(d) none of these.","(b) Left hand side");
        this.addSportQuestions(q);
        q = new Question("Standard width of the lane shall be.","(a) 1.20 mts"," (b) 1.22 mts","(c) 1.22 to 1.25 mts."," (d) 110 mts.","(c) 1.22 to 1.25 mts.");
        this.addSportQuestions(q);
        q = new Question("The Standard distance of Marathon Race.","(a) 26 kms. ","(b) 42 kms.","(c) 42.195 kms ","(d) 42.123 kms","(c) 42.195 kms ");
        this.addSportQuestions(q);
        q = new Question("The procedure of doping test is including the collection of.","(a) Sugar sample ","(b) Urine sample","(c) stool Sample ","(d) Blood Sample","(b) Urine sample");
        this.addSportQuestions(q);
        q = new Question("How many athletes may be used as substitutes in Relays race event","(a) One athlete. ","(b) Two athlete","(c) Three athlete ","(d) none of these.","(a) One athlete. ");
        this.addSportQuestions(q);
        q = new Question("Landing area of High jump event should be.","(a) 5x2 mts"," (b) 5x3 mts","(c) 5x4 mts ","(d) 5x5 mts."," (b) 5x3 mts");
        this.addSportQuestions(q);
        q = new Question("Landing area of Pole vault event should be.","(a) 6x4 mts ","(b) 5x3 mts","(c) 5x4 mts ","(d) 5x5 mts.","(d) 5x5 mts.");
        this.addSportQuestions(q);
        q = new Question("Landing area of long jump event should be.","(a) 10x2.75 mts"," (b) 9x3 mts","(c) 9x4 mts"," (d) 9x2.75 mts."," (d) 9x2.75 mts.");
        this.addSportQuestions(q);
        q = new Question("In Triple jump distance between the take off board and landing area shall be not more than.","(a) 9 mts. ","(b) 10 mts.","(c) 13 mts ","(d) 11 mts.","(c) 13 mts ");
        this.addSportQuestions(q);
        q = new Question("For valid throw shot must fall.","(a) In sector area ","(b) Within the inner edges of landing sector","(c) Nearest on sector lines. ","(d) None of these.","(a) In sector area ");
        this.addSportQuestions(q);
        q = new Question("Inside diameter of shot put circle is.","(a) 45deg"," (b) 34.92deg","(c) 40deg ","(d) 90deg"," (b) 34.92deg");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of shot for acceptance of a record (for men)","(a) 7.26 kg. ","(b) 8 kg","(c) 7.25 kg"," (d) 5 kg","(a) 7.26 kg. ");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of shot for acceptance of a record (for women)","(a) 4 kg. ","(b) 8 kg","(c) 7.25 kg"," (d) 5 kg","(a) 4 kg");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of discuss for acceptance of a record (for men)","(a) 1 kg."," (b) 2 kg","(c) 3 kg"," (d) 800 gms."," (b) 2 kg");
        this.addSportQuestions(q);
        q = new Question("Minimum weight of Javelin for acceptance of a record (for women)","(a) 800 gms ","(b) 750 gms","(c) 600 gms ","(d) 500 gms.","(c) 600 gms ");
        this.addSportQuestions(q);
        //Q-60
        //Added
        q = new Question("Ten event which shall be held on two consecutive days is known as.","(a) Penthalon","(b) Decathlon","(c) Heptathlon","(d) relay race","(b) Decathlon");
        this.addSportQuestions(q);
        q = new Question("How many hurdles are placed in a Hurdle race in one lap?","(a) 12","(b) 15","(c) 7","(d) 10","(d) 10");
        this.addSportQuestions(q);
        q = new Question("The first Commonwealth games were held in","(a) 1930 Hamilton","(b) 1934 Australia","(c) 1935 India","(d) 1940 Pakistan","(a) 1930 Hamilton");
        this.addSportQuestions(q);
        q = new Question("When did the ancient Olympic game start?","(a) 394 B. C.","(b) 493 B.C.","(c) 676 B.C.","(d) 776 B.C.","(d) 776 B.C.");
        this.addSportQuestions(q);
        q = new Question("Till now how many Olympic Games have been organized?","(a) 22","(b) 27","(c) 28","(d) 29","(d) 29");
        this.addSportQuestions(q);
        q = new Question("When did the women get chance to take part in the Olympic Games?","(a) 1896","(b) 1900","(c) 1908","(d) 1920","(a) 1896");
        this.addSportQuestions(q);
        q = new Question("Where and in which year were the first Asian games held?","(a) 1951 New Delhi","(b) 1954 Beijing","(c) 1952 Doha","(d) 1950 Delhi","(a) 1951 New Delhi");
        this.addSportQuestions(q);
        q = new Question("At what place the Asian games have been held four times?","(a) New Delhi","(b) Bangkok","(c) Tehran","(d) Seoul","(b) Bangkok");
        this.addSportQuestions(q);
        q = new Question("Where were the first commonwealth (1930) games held?","(a) New Delhi","(b) Sidney","(c) Hamilton","(d) London","(c) Hamilton");
        this.addSportQuestions(q);
        q = new Question("When and where will Nineteenth Commonwealth games be held?","(a) 2010 Melbourne","(b) 2010 New Delhi","(c) 2010 India","(d) 2010 Pakistan","(b) 2010 New Delhi");
        this.addSportQuestions(q);
        q = new Question("When did first modern Olympic game start?","(a) 1896","(b) 1892","(c) 1900","(d) 1895","(a) 1896");
        this.addSportQuestions(q);
        q = new Question("How many rings are there in an Olympic Flag?","(a) 4","(b) 2","(c) 9","(d) 5","(d) 5");
        this.addSportQuestions(q);
        q = new Question("In which common wealth game did India take part for the first time?","(a) London 1934","(b) Auckland 1950","(c) 1930 Hamilton","(d) 1962 Perth","(a) London 1934");
        this.addSportQuestions(q);//13
        //Add
        q = new Question("Who has won the 2016 Women’s Singles Wimbledon Championship?","(a) Simona Halep","(b) Serena Williams",
                "(c) Angelique Kerber","(d) Andy Murray","(b) Serena Williams");
        this.addSportQuestions(q);
        q = new Question("In 2014 who won the inaugural edition of the Dubai Open Golf Championship?","(a) Arjun Atwal","(b) Wang Jeung-hun"
                ,"(c) Simon Yates","(d) None of these","(a) Arjun Atwal");
        this.addSportQuestions(q);
        q = new Question("Who won the 2014 ATP tennis Championship in Abu Dhabi?","(a) Rafael Nadal","(b) Andy Murray","(c) Novak Djokovic",
                "(d) Roger Federer","(b) Andy Murray");
        this.addSportQuestions(q);
        q = new Question("Stan Wawrinka represents and belongs to which country?","(a) Russia","(b) Switzerland","(c) USA","(d) France","(b) Switzerland");
        this.addSportQuestions(q);
        q = new Question("The 2016 UEFA Championship is being hosted by ____?","(a) Greece","(b) France","(c) Italy","(d) Switzerland","(b) France");
        this.addSportQuestions(q);
        q = new Question("Who was the first person to make three test centuries in his first innings as a captain?","(a) Virat Kohli","(b) Steve Smith","(c) M S Dhoni",
                "(d) Hashim Amla","(a) Virat Kohli");
        this.addSportQuestions(q);
        q = new Question("Who broke the record for the high run chase in T20 International Cricket?","(a) South Africa","(b) West Indies","(c) England","(d) Australia","(b) West Indies");
        this.addSportQuestions(q);
        q = new Question("In 2014 who was the chosen captain of the ICC ODI team?","(a) Mahendra Singh Dhoni","(b) Angelo Mathews",
                "(c) Alastair Cook","(d) Jaron Morgan","(a) Mahendra Singh Dhoni");
        this.addSportQuestions(q);
        q = new Question("The winner of 2013-14 European Golden Boot award is __?","(a) Cristiano Ronaldo","(b) Lionel Messi"
                ,"(c) Franck Ribery","(d) David Villa","(a) Cristiano Ronaldo");
        this.addSportQuestions(q);
        q = new Question("Which country won the Davis Cup title for the first time in 2014?","(a) France","(b) Switzerland",
                "(c) Austria","(d) Denmark","(b) Switzerland");
        this.addSportQuestions(q);
    }

    private void addRandomQuestion() {
        Question q = new Question("Who is the present Union Agriculture Minister?","Raghuvansh Prasad Singh","Manishankar Iyyer","Sharad Pawar","Kamalnath","Sharad Pawar");
        this.addRandomQuestion(q);
        q = new Question("Who is the present union Tourism and Culture Minister?","Ambika Soni","Kapil Sibbal","Renuka Chaudhary","Sushil Kumar Shinde","Ambika Soni");
        this.addRandomQuestion(q);
        q = new Question("Who is the chairman of senior selection committee in BCCI?","(1) Sunil Gavaskar","(2) Dilip Vengasarkar",
                    "(3) Krishnamachari Srikkanth","(4) Chetan Chauhan","(3) Krishnamachari Srikkanth");
        this.addRandomQuestion(q);
        q = new Question("The assembly elections were held recently in two states namely","(1) Gujarat and Andhra Pradesh","(2) Madhya Pradesh and Himachal Pradesh","(3) Himachal Pradesh and Gujarat","(4) Andhra Pradesh and Himachal Pradesh","(3) Himachal Pradesh and Gujarat");
        this.addRandomQuestion(q);
        q = new Question("Thermometer is related to degree in the same way as clock is related to","(1) Wall","(2) Tower","(3) Hour","(4) Cock","(3) Hour");
        this.addRandomQuestion(q);
        q = new Question("The headquarters of the United Nations Union is located at","(1) Geneva","(2) New York","(3) Rome","(4) Washington","(2) New York");
        this.addRandomQuestion(q);
        q = new Question("To work on mobile cell phone which of the following is/are required?","(1) Favourable handset","(2) Sim card","(3) Service provider network","(4) All of the above","(4) All of the above");
        this.addRandomQuestion(q);
        q = new Question("Find the root value of 36.1 / 102.4","(1) 61 / 34","(2) 19 / 31","(3) 19 / 32","(4) 19 / 33","(3) 19 / 32");
        this.addRandomQuestion(q);
        q = new Question("Which of the following keys of personal computer is not available in the key board of traditional typewriters?","(1) Tab","(2) Spacebar","(3) Enter","(4) Backspace","(3) Enter");
        this.addRandomQuestion(q);
        q = new Question("Which of the following words is not related to the functioning of Internet?","(1) www","(2) http","(3) e-mail","(4) MS Word","(4) MS Word");
        this.addRandomQuestion(q);
        q = new Question("2008 Olympic games were held in","(1) China","(2) Greece","(3) Italy","(4) France","(1) China");
        this.addRandomQuestion(q);
        q = new Question("Who among the following has been appointed as the new Captain of Indian Test Cricket Team?","(1) Sachin Tendulkar","(2) Rahul Dravid",
                    "(3) Anil Kumble","(4) Mahender Singh Dhoni","(4) Mahender Singh Dhoni");
        this.addRandomQuestion(q);
        q = new Question("Who among the following is  coach for the Indian Cricket Team?","(1) Vivian Richards","(2) Gary Kirsten","(3) Kapil Dev","(4) Allan Border","(2) Gary Kirsten");
        this.addRandomQuestion(q);
        q = new Question("The mascot for the 34th National Games held in Jharkhand in 2008, is","(1) Sheru","(2) Roopa","(3) Chauva","(4) None of these","(3) Chauva");
        this.addRandomQuestion(q);
        q = new Question("With which game is the Agha Khan Cup associated?","(1) Football","(2) Badminton","(3) Basketball","(4) Hockey","(4) Hockey");
        this.addRandomQuestion(q);
        q = new Question("The term, L.B.W. is associated with which of the following games?","(1) Cricket","(2) Hockey","(3) Football","(4) Polo","(1) Cricket");
        this.addRandomQuestion(q);
        q = new Question("Wankhede stadium is situated in?","(1) Chandigarh","(2) Bangalore","(3) Mumbai","(4) Chennai","(3) Mumbai");
        this.addRandomQuestion(q);
        q = new Question("The Olympic games are normally held at an interval of","(1) 2 years","(2) 3 years","(3) 4 years","(4) 5 years","(3) 4 years");
        this.addRandomQuestion(q);
        q = new Question("Jaspal Rana is the name associated with which of the following games?","(1) Boxing","(2) Shooting","(3) Archery","(4) Weight lifting","(2) Shooting");
        this.addRandomQuestion(q);
        q = new Question("Netaji Subhash National Institute of Sports is located at","(1) Kolkata","(2) New Delhi","(3) Jhansi","(4) Patiala","(4) Patiala");
        this.addRandomQuestion(q);
        q = new Question("A genetically engineered form of brinjal, known as the Bt-brinjal, has been developed. The objective of this is","To make it pest-resistant","To improve its taste and nutritive qualities","To make it drought-resistant","To make its shelf-life longer", "To make it pest-resistant");
        this.addRandomQuestion(q);
        q = new Question(" The most abundant metal in the earth’s crust is",
                "(1) Zinc",
                "(2) Copper",
                "(3) Aluminium",
                "(4) Iron","(3) Aluminium");
        this.addRandomQuestion(q);
        q = new Question(" Which of the following numbers is divisible by 4?",
                "(1) 8675231",
                "(2) 9843212",
                "(3) 1234567",
                "(4) 543123","(2) 9843212");
        this.addRandomQuestion(q);
        q = new Question(" The total number of even prime numbers is",
                "(1) 0",
                "(2) 1",
                "(3) 2",
                "(4) unlimited","(2) 1");
        this.addRandomQuestion(q);
        q = new Question(" Who among the following is known as the Akbar’s biographer?",
                "(1) Raja Birbal",
                "(2) Abul Fazl",
                "(3) Faizi",
                "(4) Abdun Nabi Khan","(2) Abul Fazl");
        this.addRandomQuestion(q);
        q = new Question("The minimum number of rows and columns in MS Word document is","(a) 1 row and 1 column",
                "(b) 1 row and 2 columns","(c) 2 row and 2column","(d) 1 row and 3column","(a) 1 row and 1 column");
        this.addRandomQuestion(q);
        q = new Question("Whose birth anniversary is celebrated as National Youth Day across India on 12 Jan 2015 ?",
                "(a) Swami Vivekanand","(b) Swami Ramananda","(c) Sardar Bhagat Singh","(d) Sardar Vallabhbhai Patel","(a) Swami Vivekanand");
        this.addRandomQuestion(q);
        q = new Question("'.INI' extension refers usually to what kind of file?","(a) Image file","(b) System file",
                "(c) Hypertext related file","(d) Image Color Matching Profile file","(b) System file");
        this.addRandomQuestion(q);
        q = new Question("'DB' computer abbreviation usually means ?","(a) Database","(b) Double Byte","(c) Data Block",
                "(d) Driver Boot","(a) Database");
        this.addRandomQuestion(q);
        q = new Question("In which year was MIDI(dress) introduced?","(a) 1987","(b) 1983","(c) 1977","(d) 1973","(b) 1983");
        this.addRandomQuestion(q);
        q = new Question("A given signal's second harmonic is twice the given signal's __________ frequency...?","(a) Fourier",
                "(b) Foundation","(c) Fundamental","(d) Field","(c) Fundamental");
        this.addRandomQuestion(q);
        q = new Question("Which motor is NOT suitable for use as a DC machine?","(a) Permanent magnet motor",
                "(b) Series motor","(c) Squirrel cage motor","(d) Synchronous motor","(c) Squirrel cage motor");
        this.addRandomQuestion(q);
        q = new Question("Made from a variety of materials, such as carbon, which inhibits the flow of current...?",
                "(a) Choke","(b) Inductor","(c) Resistor","(d) Capacitor","(c) Resistor");
        this.addRandomQuestion(q);
        q = new Question("What is part of a database that holds only one type of information?","(a) Report",
                "(b) Field","(c) Record","(d) File","(b) Field");
        this.addRandomQuestion(q);
        q = new Question("Which of the following companies manufacture Blackberry smartphones?",
                "(a) Samsung","(b) Motorola","(c) Nokia","(d) None of These","(d) None of These");
        this.addRandomQuestion(q);
        q = new Question("Chinese researches have recently discovered the fossils of a flying dinosaur with four wings," +
                " which can be an important missing link in the evolution of dinosaurs. It is named as-",
                "(a) Tyrannosaurus rex","(b) Tyrannosaurus knowlesi","(c) Archeopteryx","(d) Anchiornis huxleyi","(d) Anchiornis huxleyi");
        this.addRandomQuestion(q);
        q = new Question("What is the source of electric energy in an artificial satellite?",
                "(a) A dynamo","(b) A mini nuclear reactor","(c) A thermopile","(d) Solar cells","(d) Solar cells");
        this.addRandomQuestion(q);
        q = new Question("Grantham Prize is constituted to felicitate the journalists working in the area of",
                "(a) Medicine","(b) Environment","(c) Physics","(d) Information Technology","(b) Environment");
        this.addRandomQuestion(q);
        q = new Question("When a green leaf is seen in red light, its colour will be","(a) Green","(b) Black","(c) Red","(d) Brown","(b) Black");
        this.addRandomQuestion(q);
        q = new Question("'Rosatom' is the atomic energy agency of -","(a) France","(b) Britain","(c) Canada","(d) Germany","(d) Germany");
        this.addRandomQuestion(q);
        q = new Question("Which one of the following was to be discovered first in the chromosphere of the sun",
                "(a) Neon","(b) Xenon","(c) Helium","(d) Krypton","(c) Helium");
        this.addRandomQuestion(q);
        q = new Question("Study of life in outer space is","(a) Entrobiology","(b) Endobiology",
                "(c) Exobiology","(d) Neobiology","(c) Exobiology");
        this.addRandomQuestion(q);
        q = new Question("The most commonly used chemicals for the 'artificial rainmaking' or clod seeding are",
                "(a) Silver Iodine (AgI)","(b) Sodium Cloride (NaCl)","(c) Dry Ice (Frozen CO2)","(d) All of the above","(d) All of the above");
        this.addRandomQuestion(q);
        q = new Question("Who had an explosive idea and first patented DYNAMITE?","(a) J. R. Gluber",
                "(b) A. Nobel","(c) G. Fawks","(d) W. Bickford","(b) A. Nobel");
        this.addRandomQuestion(q);
        q = new Question("Who is the English physicist responsible for the 'Big Bang Theory'?",
                "(a) Albert Einstein","(b) Michael Skube","(c) George Gamow","(d) Roger Penrose","(c) George Gamow");
        this.addRandomQuestion(q);
        q = new Question("When was Monopoly created?","(a) 1940s","(b) 1930s","(c) 1920s","(d) 1950s","(b) 1930s");
        this.addRandomQuestion(q);
        q = new Question("In which decade was the telephone invented?","(a) 1850s","(b) 1860s","(c) 1870s","(d) 1880s","(c) 1870s");
        this.addRandomQuestion(q);
        q = new Question("Who invented Jet Engine?","(a) Sir Frank Whittle","(b) Gottlieb Daimler",
                "(c) Roger Bacon","(d) Lewis E. Waterman","(a) Sir Frank Whittle");
        this.addRandomQuestion(q);
        q = new Question("What J. B. Dunlop invented?","(a) Pneumatic rubber tire",
                "(b) Automobile wheel rim","(c) Rubber boot","(d) Model airplanes","(a) Pneumatic rubber tire");
        this.addRandomQuestion(q);
        q = new Question("In which decade was the first solid state integrated circuit demonstrated?","(a) 1950s","(b) 1960s","(c) 1970s","(d) 1980s","(a) 1950s");
        this.addRandomQuestion(q);
        q = new Question("Who invented the BALLPOINT PEN?","(a) Biro Brothers",
                "(b) Waterman Brothers","(c) Bicc Brothers","(d) Write Brothers","(a) Biro Brothers");
        this.addRandomQuestion(q);
        q = new Question("The velocity of light was first measured by","(a) Einstein","(b) Newton","(c) Romer","(d) Galileo","(c) Romer");
        this.addRandomQuestion(q);
        q = new Question("The total number of Judges of the International Court of Justice is","(a) 10","(b) 12","(c) 15","(d) 18","(c) 15");
        this.addRandomQuestion(q);
        q = new Question("The term butterfly is associated with","(a) kabaddi","(b) swimming","(c) boxing","(d) wrestling","(b) swimming");
        this.addRandomQuestion(q);
        q = new Question("The telescope is used for viewing","(a) distant objects","(b) near objects",
                "(c) small objects","(d) living cells","(a) distant objects");
        this.addRandomQuestion(q);
        q = new Question("The term which denotes that each side has made equal point at game point, in Tennis, is referred to as",
                "(a) baseline","(b) deuce","(c) fault","(d) grand slam","(b) deuce");
        this.addRandomQuestion(q);
        q = new Question("Vitamin B12 is most useful for combating","(a) anemia","(b) goitre","(c) night blindness","(d) rickets","(a) anemia");
        this.addRandomQuestion(q);
        q = new Question("Thomas Cup is associated with","(a) badminton","(b) billiards","(c) lawn tennis","(d) table tennis","(a) badminton");
        this.addRandomQuestion(q);
        q = new Question("Yuri Gagarin was","(a) a Russian cosmonaut & became the first man to travel in space.",
                "(b) the first person to fly at great height of about 340 km from the earth","(c) both (a) and (b)",
                "(d) None of the above","(c) both (a) and (b)");
        this.addRandomQuestion(q);
    }

    private void addScienceQuestion(){

        Question q = new Question("Brass gets discoloured in air because of the presence of which of the following gases in air?","Oxygen","Hydrogen sulphide","Carbon dioxide","Nitrogen","Hydrogen sulphide");
        this.addScienceQuestion(q);
        q = new Question("Which of the following metals forms an amalgam with other metals?","Tin","Lead","Iron","Zinc","Zinc");
        this.addScienceQuestion(q);
        q = new Question("Chlorophyll is a naturally occurring chelate compound in which central metal is","copper","magnesium","iron","Calcium","magnesium");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is used as a lubricant?","Graphite","Silica","Iron Oxide","Diamond","Graphite");
        this.addScienceQuestion(q);
        q = new Question("The gas usually filled in the electric bulb is","nitrogen","hydrogen","carbon dioxide","oxygen","nitrogen");
        this.addScienceQuestion(q);
        q = new Question("The variety of coal in which the deposit contains recognisable traces of the original plant material is","bitumen","anthracite","peat","lignite","peat");
        this.addScienceQuestion(q);
        q = new Question("The inert gas which is substituted for nitrogen in the air used by deep sea divers for breathing, is","Helium","Xenon","Krypton","Argon","Helium");
        this.addScienceQuestion(q);
        q = new Question("The hardest substance on earth is","Diamond","Gold","Iron","Platinum","Diamond");
        this.addScienceQuestion(q);
        q = new Question("The chemical (ethyl mercaptan) added to the otherwise odourless LPG cooking gas for imparting a detectable smell to the gas is a compound of","bromine","fluorine","chlorine","sulphur","sulphur");
        this.addScienceQuestion(q);
        q = new Question("The property of a substance to absorb moisture from the air on exposure is called","osmosis","deliquescence","efflorescence","desiccation","deliquescence");
        this.addScienceQuestion(q);
        q = new Question("Biodiversity forms the basis for human existence in the following ways","Prevention of soil erosion","Recycling of waste","Pollination of crops","All of them","All of them");
        this.addScienceQuestion(q);
        q = new Question("In which of the following activities silicon carbide is used?","cutting very hard substances","Making casts for statues","Making cement and glass","Disinfecting water of ponds","cutting very hard substances");
        this.addScienceQuestion(q);
        q = new Question("Among the various allotropes of carbon,","coke is the hardest, graphite is the softest","diamond is the hardest, coke is the softest","diamond is the hardest, graphite is the softest","diamond is the hardest, lamp black is the softest","diamond is the hardest, graphite is the softest");
        this.addScienceQuestion(q);
        q = new Question("Widespread resistance of malarial parasite to drugs like chloroquine has prompted attempts to develop a malarial vaccine to combat malaria. Why is it difficult to develop an effective malaria vaccine?"
                ,"Malaria is caused by several species of Plasmodium."
                ,"Man does not develop immunity to malaria during natural infection"
                ,"Vaccines can be developed only against bacteria."
                ,"Man is only an intermediate host and not the definitive host"
                ,"Malaria is caused by several species of Plasmodium.");
        this.addScienceQuestion(q);
        q = new Question("Carbon, diamond and graphite are together called","allotropes","isomorphs","isomers","isotopes","allotropes");
        this.addScienceQuestion(q);
        q = new Question("A genetically engineered form of brinjal, known as the Bt-brinjal, has been developed. The objective of this is","To make it pest-resistant","To improve its taste and nutritive qualities","To make it drought-resistant","To make its shelf-life longer", "To make it pest-resistant");
        this.addScienceQuestion(q);
        q = new Question("Soda water contains","carbonic acid","sulphuric acid","carbon dioxide","nitrous acid","carbon dioxide");
        this.addScienceQuestion(q);
        q = new Question("The most important ore of aluminium is","bauxite","calamine","galena","calcite","bauxite");
        this.addScienceQuestion(q);
        q = new Question("Liquefied Petroleum gas (LPG) consists of mainly","Methane, Ethane and Hexane","Ethane, Hexane and Nonane","Methane, Butane and Propane","Methane, Hexane and Nonane","Methane, Butane and Propane");
        this.addScienceQuestion(q);
        q = new Question("According to Dalton’s atomic theory the smallest particle which can exist independently is","An atom","A molecule","A cation","An anion","An atom");
        this.addScienceQuestion(q);
        q = new Question("Lightening cause rainfall because","It cause combination of oxygen and nitrogen","Some of the gas molecules become bigger","It activate H2O molecule","Photo-electricity reaction starts","It activate H2O molecule");
        this.addScienceQuestion(q);
        q = new Question("Polythene is industrially prepared by the polymerization of","methane","styrene","acetylene","ethylene","ethylene");
        this.addScienceQuestion(q);
        q = new Question("Nitrification means","Liquefaction of nitrogen","Convert the atmospheric nitrogen to effective nitrogen compound","Production of nitrogen from air","Conversion of nitrogen to nitric acid.","Liquefaction of nitrogen");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is the lightest metal ?","1. Mercury","2. Silver","3. Lithium","4. Lead","3. Lithium");
        this.addScienceQuestion(q);//24
        q = new Question("The element present in the largest amount in rocks and minerals is",
                "(1) Carbon",
                "(2) Silicon",
                "(3) Iron",
                "(4) Aluminium","(2) Silicon");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is the lightest metal ?",
                "1. Mercury",
                "2. Silver",
                "3. Lithium",
                "4. Gold","3. Lithium"
        );
        this.addScienceQuestion(q);
        q = new Question("The most important ore of Aluminium is",
                "1. Bauxite",
                "2. Calamine",
                "3. Calcite",
                "4. Galena","1. Bauxite"
        );
        this.addScienceQuestion(q);
        q = new Question("The element present in the largest amount in rocks and minerals is",
                "1. Chloroethane",
                "2. Carbamide",
                "3. Silicon",
                "4. carbon","3. Silicon"
        );
        this.addScienceQuestion(q);
        q = new Question("Permanent hardness of water can be removed by adding",
                "1. Potassium Permanganate",
                "2. Chlorine",
                "3. Bleaching Powder",
                "4. Washing Soda","4. Washing Soda");
        this.addScienceQuestion(q);
        q = new Question("The formula of Plaster of Paris is",
                "1. CaSO 4",
                "2. CaSO 4 , 2H 2 O",
                "3. 2CaSO 4 , 4H 2 O",
                "4. 2CaSO 4 , H 2 O","4. 2CaSO 4 , H 2 O");
        this.addScienceQuestion(q);
        q = new Question("Liquefied Petroleum gas (LPG) consists of mainly",
                "1. Methane, Ethane and Hexane",
                "2. Ethane, Hexane and Nonane",
                "3. Methane, Butane and Propane",
                "4. Methane, Hexane and Nonane","3. Methane, Butane and Propane");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is the lightest metal ?",
                "1. Mercury",
                "2. Silver",
                "3. Lithium",
                "4. Lead","3. Lithium");
        this.addScienceQuestion(q);
        q = new Question("The most important ore of Aluminium is",
                "1. Bauxite",
                "2. Calamine",
                "3. Calcite",
                "4. Galena","1. Bauxite");
        this.addScienceQuestion(q);
        q = new Question("The metal that is present in Photo Films is",
                "1. Mercury",
                "2. Platinium",
                "3. Magnesium",
                "4. Silver","4. Silver");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is in liquid form at room temperature ?",
                "1. Cerium",
                "2. Sodium",
                "3. Francium",
                "4. Lithium","3. Francium");
        this.addScienceQuestion(q);
        q = new Question("The property of a substance to absorb moisture from the air on exposure is called",
                "1. Osmosis",
                "2. Desiccation",
                "3. Efflorescence",
                "4. Deliquescence","4. Deliquescence");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is the lightest metal ?",
                "1.Mercury",
                "2.Silver",
                "3. Lithium",
                "4. Lead","3. Lithium");
        this.addScienceQuestion(q);
        q = new Question("The most important ore of Aluminium is",
                "1. Bauxite",
                "2. Calamine",
                "3. Calcite",
                "4. Galen","1. Bauxite");
        this.addScienceQuestion(q);
        q = new Question("The element present in the largest amount in rocks and minerals is",
                "1. Hydrogen Sulphide",
                "2. Nitrogen",
                "3. Silicon ","4. Hydrogen","3. Silicon");
        this.addScienceQuestion(q);
        q = new Question("Quartz crystals normally used in quartz clocks etc. is chemically",
                "1. Sodium Silicate",
                "2. Silicon dioxide",
                "3. Germanium dioxide",
                "4. A mixture of (B) and (C)","2. Silicon dioxide");
        this.addScienceQuestion(q);
        q = new Question("Which of the following elements is nonradioactive?",
                "1. Uranium",
                "2. Thorium",
                "3. Plutonium",
                "4. Zirconium","4. Zirconium");
        this.addScienceQuestion(q);
        q = new Question("According to Dalton’s atomic theory the smallest particle which can exist independently is",
                "1. An atom",
                "2. A molecule",
                "3. A cation",
                "4. An anion","1. An atom");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is the lightest metal ?",
                "1. Mercury",
                "2. Silver",
                "3. Lithium",
                "4. Lead","3. Lithium");
        this.addScienceQuestion(q);
        q = new Question("The most important ore of Aluminium is",
                "1. Bauxite",
                "2. Calamine",
                "3. Calcite",
                "4. Galena","1. Bauxite");
        this.addScienceQuestion(q);
        q = new Question("The recent atomic weight scale is based on",
                "1. 1H1",
                "2. 1H2",
                "3. 6C12",
                "4. 8O16","3. 6C12");
        this.addScienceQuestion(q);
        q = new Question("The major ingredient of leather is",
                "1. Carbohydrate",
                "2. Collagen",
                "3. Polymer",
                "4. Nucleic acid","2. Collagen");
        this.addScienceQuestion(q);
        q = new Question("Glass is made from the mixture of",
                "1. Quartz and mica",
                "2. Sand and salt",
                "3. Sand and silicates",
                "4. None of these","3. Sand and silicates");
        this.addScienceQuestion(q);
        q = new Question("The fastest acting enzyme in the biological kingdom is",
                "1. lipase",
                "2. amylase",
                "3. carboxypeptidase",
                "4. carbonic anhydrase","4. carbonic anhydrase");
        this.addScienceQuestion(q);
        q = new Question("The first synthetic fibre made by man was",
                "1. Rayon",
                "2. Nylon",
                "3. Polyester",
                "4. Terycott","2. Nylon");
        this.addScienceQuestion(q);
        q = new Question("Polythene is industrially prepared by the polymerization of",
                "1. Methane",
                "2. Styrene",
                "3. Acetylene",
                "4. Ethylene","4. Ethylene");
        this.addScienceQuestion(q);
        q = new Question("Ethylalcohol is mixed completely with water. How ethyl alcohol is separated from the mixture",
                "1. by separation flannel",
                "2. by evaporation",
                "3. partial distillation",
                "4. evaporation of water","3. partial distillation");
        this.addScienceQuestion(q);
        q = new Question("White vitriol is",
                "1. FeSO 4 , 7H 2 O",
                "2. ZnSO 4 , 7H 2 O",
                "3. MgSO 4 , 7H 2 O",
                "4. CuSO 4 , 7H 2 O","2. ZnSO 4 , 7H 2 O");
        this.addScienceQuestion(q);
        q = new Question("The most abundant metal in the earth’s crust is",
                "1. Zinc",
                "2. Copper",
                "3. Aluminium",
                "4. Iron","3. Aluminium");
        this.addScienceQuestion(q);
        q = new Question("The gas used to extinguish fire is",
                "1. Neon",
                "2. Nitrogen",
                "3. Carbon dioxide",
                "4. Carbon Monoxide","3. Carbon dioxide");
        this.addScienceQuestion(q);
        q = new Question("In which of the following activities Silicon Carbide is used ?",
                "1. Making cement and glass",
                "2. Disinfecting water and ponds",
                "3. Making castes for statues",
                "4. Cutting very hard substances","4. Cutting very hard substances");
        this.addScienceQuestion(q);
        q = new Question("Which of the following gas is not known as greenhouse gas ?",
                "1. Methane",
                "2. Carbon dioxide",
                "3. Nitrous oxide",
                "4. CFC","3. Nitrous oxide");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is not a neutral oxide ?",
                "1. Carbon Monoxide",
                "2. Sulphur Dioxide",
                "3. Water",
                "4. Nitric Oxide","2. Sulphur Dioxide");
        this.addScienceQuestion(q);
        q = new Question("Potassium Permanganate is used for purifying drinking water, because",
                "1. It dissolves the impurities of water",
                "2. It is a sterilizing agent",
                "3. It is an oxidizing agent","4. None of these","3. It is an oxidizing agent");
        this.addScienceQuestion(q);
        q = new Question("The presence of which of the following salts in water causes corrosion in steam boilers?",
                "1. Sodium Chloride",
                "2. Magnesium Chloride",
                "3. Calcium bicarbonate",
                "4. Potassium bicarbonate","2. Magnesium Chloride");
        this.addScienceQuestion(q);
        q = new Question("Water is a good solvent of ionic salts because",
                "1. It has no colour",
                "2. It has a boiling point",
                "3. It has a high dipole moment",
                "4. It has a high specific heat","3. It has a high dipole moment");
        this.addScienceQuestion(q);
        q = new Question("Nuclear fission is caused by the impact of",
                "1. Proton",
                "2. Electron",
                "3. Neutron",
                "4. (A) and (b)","3. Neutron");
        this.addScienceQuestion(q);
        q = new Question("Long distance photography is facilitated by",
                "1. Visible light",
                "2. Xrays",
                "3. Infra Red rays",
                "4. Ultra violet rays","3. Infra Red rays");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is used in making artificial sweetener saccharine ?",
                "1. Benzene",
                "2. Toluene",
                "3. Phenol",
                "4. Aniline","2. Toluene");
        this.addScienceQuestion(q);
        q = new Question("Saponification involves the hydrolysis of fats and oils by",
                "1. water ",
                "2. washing soda",
                "3. stearic acid ",
                "4.caustic soda ","4.caustic soda ");
        this.addScienceQuestion(q);
        q = new Question("Photosynthesis is a/ an",
                "1. exothermic process",
                "2. endothermic process",
                "3. a neutral process",
                "4. a thermostatic process","2. endothermic process");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is a physical change ?",
                "4. oxidation",
                "1. reduction",
                "2. sublimation",
                "3. decomposition","2. sublimation");
        this.addScienceQuestion(q);
        q = new Question("The process by which an organic compound breaks down into simpler compounds on heating to high temperature is known as",
                "1. Aromatisation",
                "2. Polymerisation",
                "3. Pyrolysis","4. Synchronisation","3. Pyrolysis");
        this.addScienceQuestion(q);
        q = new Question("The element common to all acids is",
                "1. Oxygen",
                "2. Hydrogen",
                "3. Nitrogen",
                "4. Sulphur","2. Hydrogen");
        this.addScienceQuestion(q);
        q = new Question("Gobar gas contains mainly",
                "1. Methane",
                "2. Carbon dioxide",
                "3. Butane",
                "4. Carbon Monoxide","1. Methane");
        this.addScienceQuestion(q);
        q = new Question("The most malleable metal is",
                "1. Silver",
                "2. Gold",
                "3. Aluminium",
                "4. Sodium","2. Gold");
        this.addScienceQuestion(q);
        q = new Question("Chemical formula of Water glass is",
                "1. Na 2 SiO 3",
                "2. Al 2 O 3",
                "3. NaAlO 2",
                "4. CaSiO 3","1. Na 2 SiO 3");
        this.addScienceQuestion(q);
        q = new Question("The ratio of pure gold in 18 carat gold is",
                "1. 60%",
                "2. 75%",
                "3. 80%",
                "4. 100%","2. 75%");
        this.addScienceQuestion(q);//48
        //add here
        q = new Question("Which one of the following is a water soluble vitamin?","1. Vitamin A","2. Vitamin C",
                "3. Vitamin D","4. Vitamin K","2. Vitamin C");
        this.addScienceQuestion(q);
        q = new Question("Which one of the following gases is predominant in the atmosphere?","1. Argon","2. Nitrogen",
                "3. Carbon Dioxide","4. Oxygen","2. Nitrogen");
        this.addScienceQuestion(q);
        q = new Question("Which one among the following has the highest energy?","1. Yellow light","2. Red light",
                "3. Violet light","4. White light","3. Violet light");
        this.addScienceQuestion(q);
        q = new Question("Which of these is not a mosquito borne disease?","1. Dengue fever","2. Malaria",
                "3. Filariasis","4. Goitre","4. Goitre");
        this.addScienceQuestion(q);
        q = new Question("Which of the following uses non-conventional Source of Energy?","1. Kerosene lamp","2. Wax candle",
                "3. Solar lantern","4. Torch","3. Solar lantern");
        this.addScienceQuestion(q);
        q = new Question("Which of the following plant diseases is caused by a virus?","1. Aster yellows","2. Barley yellow dwarf",
                "3. Curly top of sugar beets","4. All of the above","4. All of the above");
        this.addScienceQuestion(q);
        q = new Question("Which of the following planets rotates clock wise?","1. Pluto","2. Jupiter","3. Venus","4. Mercury","4. Mercury");
        this.addScienceQuestion(q);
        q = new Question("Which of the following order is given to the planets of solar system on the basis of their sizes?",
                "1. Jupiter, Saturn, Earth, Mercury","2. Saturn, Jupiter, Mercury, Earth",
                "3. Mercury, Earth, Jupiter, Saturn","4. Earth, Mercury, Saturn, Jupiter","1. Jupiter, Saturn, Earth, Mercury");
        this.addScienceQuestion(q);
        q = new Question("Which of the following is not a natural fibre","1. Silk","2. Jute","3. Coir","4. Rayon","4. Rayon");
        this.addScienceQuestion(q);
        q = new Question("When a gas turns into a liquid, the process is called","1. condensation","2. evaporation",
                "3. deposition","4. sublimation","1. condensation");
        this.addScienceQuestion(q);
        q = new Question("Oranges are rich source of","1. Carbohydrates","2. Fats","3. Proteins","4.  Vitamins","4.  Vitamins");
        this.addScienceQuestion(q);
        q = new Question("Most plant and animal cells are similar in some respects since they both have in common",
                "1. Cytoplasm and cellulose","2. Cytoplasm and contractile vacuole","3. Cytoplasm and nucleus","4. Membrane and cell wall",
                "3. Cytoplasm and nucleus");
        this.addScienceQuestion(q);
        q = new Question("Lamarck’s theory of inheritance of acquired characters was challenged by","1. August Weismann",
                "2. Hugo De Vries","3. Herbert Spencer","4. Carl Linnaeus","1. August Weismann");
        this.addScienceQuestion(q);
        q = new Question("Iodised salt is useful for men because it","1. Improves digestion","2. Increases resistance to diseases",
                "3. Controls the thyroid gland","4.  Slows down ageing process","1. Improves digestion");
        this.addScienceQuestion(q);
        q = new Question("In which layer of the atmosphere do most weather phenomena occur?","1. Exosphere",
                "2. Stratosphere","3. Ionosphere","4. Troposphere","4. Troposphere");
        this.addScienceQuestion(q);
        q = new Question("In the HINI Virus what does the alphabet H and N stands for: I H stands for haemagglutinin II N stands for neuraminidase",
                "1. Only I is correct","2. Only II is correct","3.  Both are correct","4.  Both are incorrect","3.  Both are correct");
        this.addScienceQuestion(q);
        q = new Question("In the context of alternative sources of energy, ethanol as a viable bio-fuel can be obtained from",
                "1. Potato","2. Rice","3. Sugarcane","4. Wheat","3. Sugarcane");
        this.addScienceQuestion(q);
        q = new Question("In making the saffron spice, which one of the following parts of the plant is used?",
                    "1. Leaf","2. Petal","3. Sepal","4. Stigma","4. Stigma");
        this.addScienceQuestion(q);
        q = new Question("In an atom no two electrons have all the four quantum numbers identical. This is known as",
                "1. Paulis Exclusion principle","2. Hunds Rule","3. Aufbau Principle","4. Avogadros Law","1. Paulis Exclusion principle");
        this.addScienceQuestion(q);
        q = new Question("Galvanised Iron sheets have a coating of","1. Tin","2. Lead","3. Zinc","4. Chromium","3. Zinc");
        this.addScienceQuestion(q);
        q = new Question("Fruit most suitable for making jelly is________.","1. Papaya","2. Karunda","3. Mango","4. Banana","3. Mango");
        this.addScienceQuestion(q);
        q = new Question("Epicenter of an earthquake is a point associated with the","1. place where earthquake is felt",
                "2. place of origin of earthquake in the interior of earth",
                "3. point on the earth's surface just above seismic focus",
                "4. point over the earth's surface where first shock is felt","3. point on the earth's surface just above seismic focus");
        this.addScienceQuestion(q);
        q = new Question("Electric current is measured by","1. Voltmeter","2. Anemometer","3. Commutator","4. Ammeter","4. Ammeter");
        this.addScienceQuestion(q);
        q = new Question("Dim-vision in the evening and night results from the deficiency of which one of the following?",
                "1. Vitamin A","2. Vitamin E","3. Vitamin B12","4. Vitamin C","1. Vitamin A");
        this.addScienceQuestion(q);
        q = new Question("Diffusion of light in the atmosphere takes place due to","1. Carbon dioxide","2. Dust particles",
                "3. Helium","4. Water vapours","2. Dust particles");
        this.addScienceQuestion(q);
        q = new Question("Dental caries are due to","1. Viral infection","2. Contaminated water","3. Bacterial infection",
                "4. Hereditary causes","3. Bacterial infection");
        this.addScienceQuestion(q);
        q = new Question("What is the pH of pure water ?","1. 1","2. 7","3. 5","4. 12","2. 7");
        this.addScienceQuestion(q);
        q = new Question("Bronze is an alloy of ?","1. Copper and Zinc","2. Copper and tin","3. Tin and Zinc",
                "4. Iron and Zinc","2. Copper and tin");
        this.addScienceQuestion(q);

    }

    private void addHistoryQuestion(){
        Question q = new Question("  Agricultural Revolution took place in",
                "a.    Paleolithic Age",
                "b.    Mesolithic Age",
                "c.    Neolithic Age",
                "d.    Iron Age","c.    Neolithic Age");
        this.addHistoryQuestion(q);
        q = new Question("  The most common motif found on the seals of Indus Valley Civilisation is",
                "a.    Elephant",
                "b.    Bull",
                "c.    Unicorn",
                "d.    Rhinoceros","c.    Unicorn");
        this.addHistoryQuestion(q);
        q = new Question(" Which of the following deity was not worshipped in Indus valley civilization?",
                "a.    Vishnu",
                "b.    Peepal tree",
                "c.    Pashupati",
                "d.    Mother goddess","a.    Vishnu");
        this.addHistoryQuestion(q);
        q = new Question("6.    Which of the following is correct about Indus Valley Civilisation?"+
         "       1.    The cities were planned"+
        "2.    Non- standardized weights were used"+
        "3.    There was elaborate water drainage system"+
        "Select using following codes:",
        "a. 1 only",
        "b. 2 only",
        "c. 1 and 3 only",
        "d. 3 only","c. 1 and 3 only");
        this.addHistoryQuestion(q);
        q = new Question("   At which of the following Indus Valley Civilization yarns of spun cotton have been found?",
                "a.    Harappa",
                "b.    Mohenjodaro",
                "c.    Lothal",
                "d.    Kalibangan","b.    Mohenjodaro");
        this.addHistoryQuestion(q);
        q = new Question("  Which of the following is also known as Microlithic period?",
                "a.    Paleolithic",
                "b.    Mesolithic",
                "c.    Neolithic",
                "d.    Chalcolithic","b.    Mesolithic");
        this.addHistoryQuestion(q);
        q = new Question("  Chirand in Bihar is a",
                "a.    Lower Paleolithic  site",
                "b.    Mesolithic site",
                "c.    Middle Paleolithic site",
                "d.    Neolithic site","d.    Neolithic site");
        this.addHistoryQuestion(q);
        q = new Question(" Mature phase of Harappan civilisation is dated between",
                "a.    3000 BC to 2000 BC",
                "b.    4000 BC to 3000 BC",
                "c.    1500 BC to 1000 BC",
                "d.    2600 BC to 1900 BC","d.    2600 BC to 1900 BC");
        this.addHistoryQuestion(q);
        q = new Question(" Chalcolithic Age is also known as",
                "a.    Iron Age",
                "b.    Stone Age",
                "c.    Copper Age",
                "d.    Neolithic Age","c.    Copper Age");
        this.addHistoryQuestion(q);
        q = new Question(" Handaxe and cleavers were characteristic tools of",
                "a.    Lower Paleolithic Age",
                "b.    Middle Paleolithic Age",
                "c.    Upper Paleolithic Age",
                "d.    Iron Age","a.    Lower Paleolithic Age");
        this.addHistoryQuestion(q);
        q = new Question(" Who among the followings was/were the grantees of madad-i-maash?",
                "a.    Qazi",
                "b.    Hakims",
                "c.    Historians",
                "d.    All of the above","d.    All of the above");
        this.addHistoryQuestion(q);
        q = new Question(" Who among the followings was the judicial department head during the Mughal period?",
                "a.    Qazi",
                "b.    Mir Bakhshi",
                "c.    Mir Saman",
                "d.    Diwan","a.    Qazi");
        this.addHistoryQuestion(q);
        q = new Question(" Who among the following is known as the Akbar’s biographer?",
                "a. Raja Birbal",
                "b. Abul Fazl",
                "c. Faizi",
                "d. Abdun Nabi Khan","b. Abul Fazl");
        this.addHistoryQuestion(q);
        q = new Question(" In which of the following year the hall of Ibadat Khana was built?",
                "a. 1575",
                "b. 1580",
                "c. 1585",
                "d. 1590","a. 1575");
        this.addHistoryQuestion(q);
        q = new Question(" In which of the following year, the religious debates in Ibadat Khana were discontinued by Akbar?",
                "a. 1575",
                "b. 1582",
                "c. 1586",
                "d. 1588","b. 1582");
        this.addHistoryQuestion(q);
        q = new Question(" From which of the following Neolithic sites the oldest evidence of rice in the world has been found?",
                "a. Chopani Mando",
                "b. Mahgara",
                "c. Koldihwa",
                "d. Burzahom","c. Koldihwa");
        this.addHistoryQuestion(q);
        q = new Question(" From which of the following regions of India the small polished Neolithic stone axes have been found?",
                "a. Cochar hills",
                "b. Garo hills",
                "c. Naga hills",
                "d. All of the above","d. All of the above");
        this.addHistoryQuestion(q);
        q = new Question(" Which of the following Neolithic sites are now in the state of Uttar Pradesh?",
                "a. Mahgara",
                "b. Chopani Mando",
                "c. Koldihwa",
                "d. All of the above","d. All of the above");
        this.addHistoryQuestion(q);
        q = new Question(" Which of the following is correct about Indus Valley Civilisation?"+
                "1. The cities were planned"+
                "2. Non- standardized weights were used"+
                "3. There was elaborate water drainage system"+
                "Select using following codes:",
                "a. 1 only0",
                "b. 2 only",
                "c. 1 and 3 only",
                "d. 3 only","c. 1 and 3 only");
        this.addHistoryQuestion(q);
        q = new Question(" At which of the following Indus Valley Civilization yarns of spun cotton have been found?",
                "a. Harappa",
                "b. Mohenjodaro",
                "c. Lothal",
                "d. Kalibangan","b. Mohenjodaro");
        this.addHistoryQuestion(q);
        q = new Question(" Which of the following deity was not worshipped in Indus valley civilization?",
                "a. Vishnu",
                "b. Peepal tree",
                "c. Pashupati",
                "d. Mother goddess","a. Vishnu");
        this.addHistoryQuestion(q);//22
        q = new Question("Who among the following was propounder of the Madhyamika Philosophy?","A. Bhadrabahu","B. Parshwanath","C. Sheelbhadra","D. Nagarjuna","D. Nagarjuna");
        this.addHistoryQuestion(q);
        q = new Question("Which of the following Rigvedic deities represented Storm?", "A. Indra","B. Maruts","C. Varun", "D. Apas","B. Maruts");
        this.addHistoryQuestion(q);
        q = new Question("The place Dharanikota in South India is related to which ancient dynasty?", "A. Chola","B. Satavahana","C. Pandya", "D. Chera","B. Satavahana");
        this.addHistoryQuestion(q);
        q = new Question("Pushkalavati was capital of which of the following acient Kingdoms?", "A. Gandhara","B. Kosal","C. Magadh", "D. Kashi","A. Gandhara");
        this.addHistoryQuestion(q);
        q = new Question("“_______is believed to mark the main site of Hastinapur, " +
                "which was capital of  Kauravas and Pandava The imperial gazetteer of India quotes about which of the following places?",
                "A. Delhi","B. Ghaziabad","C. Meerut", "D. Faridabad","C. Meerut");
        this.addHistoryQuestion(q);
        q = new Question("“Revere all the Buddhas, revere the dharma, revere the sangha” Which among the following quotes this _________?",
                "A. Allahabad Pillar Inscription","B. Asoka Edict XII","C. Asoka Edict X", "D. Mathura Lion capital", "D. Mathura Lion capital");
        this.addHistoryQuestion(q);
        q = new Question("What was the capital of Surasena Mahajanpada?", "A. Viratnagar","B. Mathura","C. Taxila", "D. Kashi" ,"B. Mathura");
        this.addHistoryQuestion(q);
        q = new Question("In which of the following Russo-Persian wars Russia was defeated?", "A. First","B. Second","C. Third", "D. None", "D. None");
        this.addHistoryQuestion(q);
        q = new Question("World’s first oil paintings have been found in which of the following countries? ", "A. India","B. Pakistan",
                "C. Afghanistan", "D. Iran","C. Afghanistan");
        this.addHistoryQuestion(q);
        q = new Question("Begram in Afghanistan was a capital of which of the following kings? ", "A. Kaniska",
                "B. Ashoka","C. Chandra Gupt Maurya", "D. Samudragupt", "A. Kaniska");
        this.addHistoryQuestion(q);// added here
        q = new Question("When did the atomic bombings of Hiroshima and Nagasaki happen?", "A. 1941","B. 1942","C. 1945", "D. 1940","C. 1945");
        this.addHistoryQuestion(q);
        q = new Question("When was NATO signed?", "A. 1949","B. 1990","C. 1948", "D. 1950", "A. 1949");
        this.addHistoryQuestion(q);
        q = new Question("When did the Chinese Civil War begin?", "A. 1927","B. 1948","C. 1950", "D 1937", "A. 1927");
        this.addHistoryQuestion(q);
        q = new Question("When did the Korean war end?", "A. 1937","B. 1948","C. 1950", "D. 1953", "D. 1953");
        this.addHistoryQuestion(q);
        q = new Question("When did the Vietnam war occur?", "A. 1937","B. 1948","C. 1950", "D. 1955", "D. 1955");
        this.addHistoryQuestion(q);
        q = new Question("When did Able Archer 83 start?", "A. 1959","B. 1962","C. 1973", "D. 1983","D. 1983");
        this.addHistoryQuestion(q);
        q = new Question("When did the Soviet Union collapse?", "A. 1970","B. 1980","C. 1990", "D. 1991","D. 1991" );
        this.addHistoryQuestion(q);
        q = new Question("When was Operation 'Condor' implemented?", "A. 1970","B. 1975","C. 1980", "D. 1990","B. 1975");
        this.addHistoryQuestion(q);
        q = new Question("When was Sputnik 1 launched?", "A. 1970","B. 1957","C. 1980", "D. 1990","B. 1957");
        this.addHistoryQuestion(q);
        q = new Question("When did the Space Age bring the first human spaceflight?", "A. 1961","B. 1970","C. 1980", "D. 1985", "A. 1961");
        this.addHistoryQuestion(q);
        q = new Question("When did the British establish colonies in Australia?", "A. 1788","B. 1840","C. 1872", "D. 1814","A. 1788");
        this.addHistoryQuestion(q);
        q = new Question("When did the British establish colonies in New Zealand?", "A. 1814","B. 1840",
                "C. 1872", "D. 1830","B. 1840");
        this.addHistoryQuestion(q);
        q = new Question("Who wrote \"On the Geneology of Morals\"?", "A. Friedrich Nietzsche",
                "B. Immanual Kant","C. Karl Marx", "D. Sigmund Freud", "A. Friedrich Nietzsche");
        this.addHistoryQuestion(q);
        q = new Question("When did Xinhai Revolution occur?", "A. 1872","B. 1900","C. 1911", "D. 1912","C. 1911");
        this.addHistoryQuestion(q);
        q = new Question("Who coined the phrase \"survival of the fittest\"?",
                "A. Auguste Comte","B. Charles Darwin","C. Emile Durkheim", "D. Herbert Spencer","D. Herbert Spencer");
        this.addHistoryQuestion(q);
        q = new Question("Who wrote the article \"The Gospel of Wealth\"?", "A. Andrew Carnegie",
                  "B. Cornelius Vanderbilt","C. Dale Carnegie", "D. Napoleon Hill", "A. Andrew Carnegie");
        this.addHistoryQuestion(q);
        q = new Question("When was \"The Communist Manifesto\" written?", "A. 1848","B. 1872","C. 1890", "D. 1882", "A. 1848");
        this.addHistoryQuestion(q);
        q = new Question("How did Europeans use the term 'middle ages'?", "A. The crisis of Western Europe",
                  "B. The medieval era of European history","C. fact that Europe became mature from 500 to 1500",
                  "D.  time between the fall of Rome and the emergence of Christianity","B. The medieval era of European history");
        this.addHistoryQuestion(q);
        q = new Question("Where can the finest examples of medieval architecture be seen?", "A. Cathedrals",
                "B. Castles","C. Homes of townspeople", "D. Universities", "A. Cathedrals");
        this.addHistoryQuestion(q);
        q = new Question("When was the Trans- Siberian Railway completed?", "A. 1972","B. 1882","C. 1890", "D. 1916", "D. 1916");
        this.addHistoryQuestion(q);//30
        q = new Question("When did the Constitution of Australia come into force?", "A. 1901","B. 1906","C. 1909", "D. 1910","A. 1901");
        this.addHistoryQuestion(q);
        q = new Question("Who was the first president of the Republic of China?", "A. Chiang Kai-shek",
                  "B. Mao Zedong","C. Sun Yat-sen", "D. Yuan Shikai","C. Sun Yat-sen");
        this.addHistoryQuestion(q);
        q = new Question("When was Anglo-Russian Entente signed?", "A. 1906","B. 1907","C. 1910", "D. 1911","B. 1907");
        this.addHistoryQuestion(q);
        q = new Question("When did July Crisis happen?", "A. 1906","B. 1907","C. 1910", "D. 1914", "D. 1914");
        this.addHistoryQuestion(q);
        q = new Question("When did the October Revolution occur?", "A. 1917","B. 1918","C. 1920", "D. 1923", "A. 1917");
        this.addHistoryQuestion(q);//25 added--58
        q = new Question("When was the Treaty of Versailles signed?", "A. 1918","B. 1919","C. 1920", "D. 1921","B. 1919");
        this.addHistoryQuestion(q);
        q = new Question("When was the Communist Party of China founded?", "A. 1918","B. 1920","C. 1921", "D. 1923","C. 1921");
        this.addHistoryQuestion(q);
        q = new Question("When did Japanese invasion of Manchuria begin?", "A. 1931","B. 1936","C. 1937", "D. 1939","A. 1931");
        this.addHistoryQuestion(q);
        q = new Question("When did the invasion of Poland begin?", "A. 1935","B. 1936","C. 1937", "D. 1939","D. 1939");
        this.addHistoryQuestion(q);
        q = new Question("When did the USS 'Panay' incident happen?", "A. 1935","B. 1936","C. 1937", "D. 1939","C. 1937");
        this.addHistoryQuestion(q);
        q = new Question("When did the Nanking Massacre start?", "A. 1935","B. 1936","C. 1937", "D. 1939","C. 1937");
        this.addHistoryQuestion(q);
        q = new Question("When was the Tripartite Pact signed?", "A. 1939","B. 1940","C. 1941", "D. 1945","B. 1940");
        this.addHistoryQuestion(q);
        q = new Question("When did the Battle of France take place?", "A. 1940","B. 1941","C. 1945", "D. 1942", "A. 1940");
        this.addHistoryQuestion(q);
        q = new Question("Who was the original inventor of roller spinning?", "A. John Kay","B. Lewis Paul","C. Richard Arkwright", "D. Samuel Crompton","B. Lewis Paul");
        this.addHistoryQuestion(q);
        q = new Question("Who switched on the world's first large-scale electrical supply network?", "A. Albert Einstein","B. Alexander Graham Bell","C. Benjamin Franklin", "D. Thomas Edison", "D. Thomas Edison");
        this.addHistoryQuestion(q);
        q = new Question("When was Russia proclaimed as an Empire?", "A. 1682","B. 1721","C. 1725", "D. 1766","B. 1721");
        this.addHistoryQuestion(q);
        q = new Question("Who founded Saint Petersburg?", "A. Alexis of Russia","B. Ivan the Terrible","C. Peter the Great", "D. Peter III of Russia","C. Peter the Great");
        this.addHistoryQuestion(q);
        q = new Question("Who advanced Russia's boundary to the Black Sea?", "A. Catherine the Great",
                      "B. Catherine the Great","C. Peter the Great", "D. Peter III of Russia", "A. Catherine the Great");
        this.addHistoryQuestion(q);
        q = new Question("Who defined the \"Long Nineteenth Century\"?", "A. Benedict Anderson","B. Ernest Gallner","C. Eric Hobsbawm", "D. Karl Marx","C. Eric Hobsbawm");
        this.addHistoryQuestion(q);
        q = new Question("When did the Germans establish colonies in New Guinea?", "A. 1884","B. 1898","C. 1899", "D. 1900", "A. 1884");
        this.addHistoryQuestion(q);
        q = new Question("When did the Germans establish colonies in Samoa?", "A. 1898","B. 1899","C. 1900", "D. 1901","C. 1900");
        this.addHistoryQuestion(q);
        q = new Question("When was Anglo-Zulu War fought?", "A. 1879","B. 1898","C. 1899", "D. 1900", "A. 1879");
        this.addHistoryQuestion(q);
        q = new Question("When was the All Red Line inaugurated?", "A. 1901","B. 1902","C. 1922", "D. 1872","B. 1902");
        this.addHistoryQuestion(q);//18 added--76
        q = new Question("When did Alexander the Great die?", "A. 399 BC","B. 385 BC","C. 335 BC", "D. 323 BC", "D. 323 BC");
        this.addHistoryQuestion(q);
        q = new Question("Who founded the philosophy of Stoicism in Athens?", "A. Chrysippus","B. Cleanthes","C. Epictetus", "D. Zeno of Citium","D. Zeno of Citium");
        this.addHistoryQuestion(q);
        q = new Question("When was the construction of Great Wall of China started?", "A. 294 BC","B. 252 BC","C. 249 BC", "D. 221 BC", "D. 221 BC");
        this.addHistoryQuestion(q);
        q = new Question("Who was the founder of the Satavahana dynasty?", "A. Gautamiputra Satakarni","B. Deimachus","C. Nahapana", "D. Simuka", "D. Simuka");
        this.addHistoryQuestion(q);
        q = new Question("When was Han Dynasty established?", "A. 220 BC","B. 209 BC","C. 208 BC", "D. 206 BC", "D. 206 BC");
        this.addHistoryQuestion(q);
        q = new Question("Who defeated Hannibal at Battle of Zama?", "A. Cato the Elder","B. Scipio Aemilianus","C. Scipio Africanus", "D. Hasdrubal","C. Scipio Africanus");
        this.addHistoryQuestion(q);
        q = new Question("Who officially instituted the first system of imperial examinations in China?", "A. Han Wu Di","B. Huo Qubing","C. Wei Qing", "D. None", "A. Han Wu Di");
        this.addHistoryQuestion(q);//30
        q = new Question("Who murdered Julius Caesar?", "A. Augustus","B. Marcus Brutus","C. Mark Antony", "D. Pompey","B. Marcus Brutus");
        this.addHistoryQuestion(q);
        q = new Question("When did the Three Kingdoms period begin in China?", "A. 220","B. 222","C. 216", "D. 232", "A. 220");
        this.addHistoryQuestion(q);
        q = new Question("When did the Sasanian Empire rise?", "A. 226","B. 238","C. 276", "D. 233", "A. 226");
        this.addHistoryQuestion(q);
        q = new Question("When was Jin Dynasty established?", "A. 238","B. 280","C. 285","D. 313","B. 280");
        this.addHistoryQuestion(q);//11 added -- 87
        q = new Question("In which battle did the defeat of Muslims stop their invasions?", "A. Battle of Fontenoy","B. Battle of Lechfeld",
                  "C. Battle of Verdun", "D. Battle of Vouille","C. Battle of Verdun");
        this.addHistoryQuestion(q);
        q = new Question("What is Chivalry?", "A. The code Charlemagne implemented","B. The code by which a Christian family lived",
                  "C. The code by which knights lived", "D.The code by which young men lived","C. The code by which knights lived");
        this.addHistoryQuestion(q);
        q = new Question("Till when did the Hundred Years' War last?", "A. 1327","B. 1377","C. 1376", "D. 1453", "D. 1453");
        this.addHistoryQuestion(q);
        q = new Question("Who was the first to distill petroleum?", "A. Benjamin Silliman","B. Cathryn J. Prince","C. Edward Hitchcock", "D. James Dwight Dana", "A. Benjamin Silliman");
        this.addHistoryQuestion(q);
        q = new Question("Who invented kerosene?", "A. Abraham Pineo Gesner","B. Benjamin Silliman","C. Edwin Drake", "D. John William Dawson","A. Abraham Pineo Gesner");
        this.addHistoryQuestion(q);
        q = new Question("When was the modern petroleum industry started?", "A. 1808","B. 1829","C. 1846", "D. 1898","C. 1846");
        this.addHistoryQuestion(q);
        q = new Question("When was Seville incorporated into the Christian Kingdom of Castile?", "A. 1200","B. 1248","C. 1203", "D. 1261","B. 1248");
        this.addHistoryQuestion(q);
        q = new Question("When was the Bill of Rights sanctioned?", "A. 1775","B. 1776","C. 1783", "D. 1791", "D. 1791");
        this.addHistoryQuestion(q);
        q = new Question("Who was the principal author of the United States Declaration of Independence?", "A. Benjamin Franklin",
                "B. George Washington","C. Thomas Edison", "D. Thomas Jefferson", "D. Thomas Jefferson");
        this.addHistoryQuestion(q);
        q = new Question("When did Europe capture Jerusalem?", "A. 1081","B. 1088","C. 1095", "D. 1099", "D. 1099");
        this.addHistoryQuestion(q);
        q = new Question("When was Government of India Act passed?", "A. 1818","B. 1819","C. 1858", "D. 1948","C. 1858");
        this.addHistoryQuestion(q);
        q = new Question("Who founded the city of Singapore?", "A. Francis Light","B. Herman Willem Daendels",
                "C. Lee Kuan Yew", "D. Stamford Raffles", "D. Stamford Raffles");
        this.addHistoryQuestion(q);
        q = new Question("Who was \"The First American\"?", "A. Benjamin Franklin","B. James Madison",
                "C. John Adams", "D. George Washington","A. Benjamin Franklin");
        this.addHistoryQuestion(q);//13 added--- 100//17
        q = new Question("How many times did Mahatma Gandhi nominated for Nobel Peace prize?","A. 4 times","B. 5 times"
                ,"C. 3 times","D. 4 times","B. 5 times");
        this.addHistoryQuestion(q);
        q = new Question("The discovery of sea-route from Europe to India was made by","A. Columbus","B. Vasco-da-Gama",
                "C. Marco Polo","D. Magellan","B. Vasco-da-Gama");
        this.addHistoryQuestion(q);
    }

    private void addGeographyQuestion(){
        Question q = new Question(" Which of the following longitudes is the standard meridian of India?",
                "A. 69°30'E",
                "B. 75°30'E",
                "C. 82°30'E",
                "D. 90°30'E","C. 82°30'E");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following places receives the highest rainfall in the world?",
                "A. Silchar",
                "B. Cherrapunji",
                "C. Mawsynram",
                "D. Guwahati","C. Mawsynram");
        this.addGeographyQuestion(q);
        q = new Question(" What is the local name of the wind blowing in the northern plains during summers ?",
                "A. Kaal Baisakhi",
                "B. Trade Winds",
                "C. Loo",
                "D. None of the above","C. Loo");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following reason of rainfall during winters in north-western part of India?",
                "A. Cyclonic depression",
                "B. Western disturbances",
                "C. Retreating monsoon",
                "D. Southwest monsoon","B. Western disturbances");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following factor is  characterises by  the cold weather season in India?",
                "A. Warm days and warm nights",
                "B. Warm days and cold nights",
                "C. Cool days and cold nights",
                "D. Cold days and warm nights","C. Cool days and cold nights");
        this.addGeographyQuestion(q);
        q = new Question("  The highest peak in the Eastern Ghats is-",
                "A. Anai Mudi",
                "B. Mahendragiri",
                "C. Kanchenjunga",
                "D. Khasi","B. Mahendragiri");
        this.addGeographyQuestion(q);
        q = new Question("  The Western Coastal strip, south of Goa is referred to as",
                "A. Coromandal",
                "B. Kannad",
                "C. Konkan",
                "D. Northern Circar","B. Kannad");
        this.addGeographyQuestion(q);
        q = new Question("  Mountain ranges in the eastern part of India forming its boundary with Myanmar are collectively called as",
                "A. Himachal",
                "B. Purvanchal",
                "C. Uttaranchal",
                "D. None of the above","B. Purvanchal");
        this.addGeographyQuestion(q);
        q = new Question( "A landmass bounded by sea on three sides is referred to as",
                "A. Coast",
                "B. Peninsula",
                "C. Island",
                "D. None of the above","B. Peninsula");
        this.addGeographyQuestion(q);
        q = new Question("  Which one amongst the following rivers flows through a rift valley?",
                "A. Damodar",
                "B. Tapi",
                "C. Tungabhadra",
                "D. Both A & B","B. Tapi");
        this.addGeographyQuestion(q);
        q = new Question("  Which one of the following is the longest river of the Peninsular India?",
                "A. Narmada",
                "B. Godavari",
                "C. Krishma",
                "D. Mahanadi","D. Mahanadi");
        this.addGeographyQuestion(q);
        q = new Question("  Which one of the following lakes is a salt water lake?",
                "A. Sambhar",
                "B. Wular",
                "C. Dal",
                "D. Gobind Sagar","B. Wular");
        this.addGeographyQuestion(q);
        q = new Question(" The river Narmada is originate from.....",
                "A. Satpura",
                "B. Amarkantak",
                "C. Brahmagiri",
                "D. Slopes of the Western Ghats","A. Satpura");
        this.addGeographyQuestion(q);
        q = new Question(" In which of the following states is the Wular Lake located?",
                "A. Rajasthan",
                "B. Punjab",
                "C. Uttar Pradesh",
                "D. Jammu and Kashmir","D. Jammu and Kashmir");
        this.addGeographyQuestion(q);
        q = new Question(" Which one of the following describes the drainage patterns resembling the branches of a tree?",
                "A. Radial",
                "B. Centrifugal",
                "C. Dendritic",
                "D. Trellis","D. Trellis");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following is the oldest mountain range in India?",
                "A. Aravali Mountains",
                "B. Western Ghats",
                "C. Himalayas",
                "D. Both A & C","A. Aravali Mountains");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following is popular name of  the Indian islands in the Arabian Sea? ",
                "A. Andaman and Nicobar Islands",
                "B. Lakshadweep Islands",
                "C. Maldives",
                "D. Both A & D","B. Lakshadweep Islands");
        this.addGeographyQuestion(q);
        q = new Question(" Where does the Palk Strait lies?",
                "A. Sri Lanka and Maldives",
                "B. India and Sri Lanka",
                "C. India and Maldives",
                "D. Both A & B","B. India and Sri Lanka");
        this.addGeographyQuestion(q);
        q = new Question(" What is the another name of Sahyadris? ",
                "A. Aravali",
                "B. Western Ghats",
                "C. Himadri",
                "D. None of the above","B. Western Ghats");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following is called the Southernmost Himalayas?",
                "A. Siwaliks",
                "B. Himadri",
                "C. Himachal",
                "D. None of the above","A. Siwaliks");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following the country does not share land boundary with India?",
                "A. Bhutan",
                "B. Bangladesh",
                "C. Tajikistan",
                "D. Nepal","C. Tajikistan");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following Union Territories of India will best suited for summer vacation, if you choose Kavarati to visit?",
                "A. Pondicherry",
                "B. Andaman and Nicobar",
                "C. Lakshadweep",
                "D. Diu and Daman","C. Lakshadweep");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following country have common frontier with the Indian State like Uttarakhand, Uttar Pradesh, Bihar, West Bengal and Sikkim?",
                "A. China",
                "B. Nepal",
                "C. Bhutan",
                "D. Myanmar","B. Nepal");
        this.addGeographyQuestion(q);
        q = new Question(" Which is the easternmost longitude of India? ",
                "A. 97° 25' E",
                "B. 77° 6' E",
                "C. 68° 7' E",
                "D. 82° 32' E","C. 68° 7' E");
        this.addGeographyQuestion(q);
        q = new Question(" Which of the following state is not crossed by the Tropic of Cancer?",
                "A. Rajasthan",
                "B. Chhattisgarh",
                "C. Odisha",
                "D. Tripura","C. Odisha");
        this.addGeographyQuestion(q);
        q = new Question("Study of the Universe is known as ?","A. Sociology","B. Cosmology", "C. Universology","D. Petology","B. Cosmology");
        this.addGeographyQuestion(q);
        q = new Question("Approximately how many Galaxies are there ?","A. 10 Billion Galaxies","B. 100 Billion Galaxies","C. 1000 Billion Galaxies",
                "D. 10000 Billion Galaxies","B. 100 Billion Galaxies");
        this.addGeographyQuestion(q);
        q = new Question("Big Bang theory explains ?","A. Origin of Universe.","B. Origin of Sun.",
                "C. Laws of physics.","D. None of above.","A. Origin of Universe.");
        this.addGeographyQuestion(q);
        q = new Question("Big Bang was an explosion that occurred ?","A. 10 Billion years ago","B. 15 Billion years ago",
                "C. 20 Billion years ago","D. 25 Billion years ago","B. 15 Billion years ago");
        this.addGeographyQuestion(q);
        q = new Question("Which Planet is dwarf planet","A. Mercury","B. Pluto","C. Mars","D. Uranus","B. Pluto");
        this.addGeographyQuestion(q);
        q = new Question("Diameter of Sun is ?","A. 12 Lakh kms","B. 13 Lakh kms","C. 14 Lakh kms","D. 15 Lakh kms","B. 13 Lakh kms");
        this.addGeographyQuestion(q);
        q = new Question("Which are the main gases present in Sun ?","A. Hydrogen and Helium","B. Hydrogen and Argon","C. Argon and Helium",
                "D. Hydrogen and Carbon Diaoxide","A. Hydrogen and Helium");
        this.addGeographyQuestion(q);
        q = new Question("Surface temperature of Sun is about ?","A. 5000 degree celsius","B. 5500 degree celsius","C. 6000 degree celsius",
                "D. 6500 degree celsius","B. 5500 degree celsius");
        this.addGeographyQuestion(q);
        q = new Question("Which planet is biggest in size in solar system ?","A. Mercury", "B. Venus","C. Neptune", "D. Jupiter","D. Jupiter");
        this.addGeographyQuestion(q);
        q = new Question("Which planet is smallest in size in solar system ?","A. Mercury","B. Venus","C. Mars", "D. Saturn","A. Mercury");
        this.addGeographyQuestion(q);
        q = new Question("Which planet is brightest ?","A. Mercury","B. Venus","C. Mars", "D. Saturn","B. Venus");
        this.addGeographyQuestion(q);
        q = new Question("Diameter of moon is ?","A. 3375 km","B. 3415 km","C. 3425 km","D. 3475 km","D. 3475 km");
        this.addGeographyQuestion(q);
        q = new Question("\"Titan\" is satellite of ?","A. Mercury","B. Earth","C. Venus","D. Saturn","D. Saturn");
        this.addGeographyQuestion(q);
        q = new Question("\"Saptarishi\" is the Indian name of which COnstellation ?","A. Ursa Major","B. Ursa Minor","C. Orion","D. Draco","A. Ursa Major");
        this.addGeographyQuestion(q);
        q = new Question("There are total __ Continents ?","A. 4","B. 5","C. 6","D. 7","D. 7");
        this.addGeographyQuestion(q);
        q = new Question("\"Stanovoi\" mountain is in ?","A. Asia","B. Africa","C. Australia","D. Europe","A. Asia");
        this.addGeographyQuestion(q);
        q = new Question("Sahara desert is in which Continent ?","A. Asia","B. Africa","C. Australia","D. Europe","B. Africa");
        this.addGeographyQuestion(q);
        q = new Question("Sonoran is a desert of ?","A. Europe","B. Africa","C. North America", "D. South America","C. North America");
        this.addGeographyQuestion(q);
        q = new Question("Atlas mountain is in which continent ?","A. Africa","B. Asia","C. Europe","D. Australia","A. Africa");
        this.addGeographyQuestion(q);
        q = new Question("Rockies mountain is in which continent ?","A. Asia","B. Africa","C. North America","D. South America","C. North America");
        this.addGeographyQuestion(q);
        q = new Question("Pyrenes Mountain is in which continent ?","A. North America","B. South America","C. Europe","D. Australia","C. Europe");
        this.addGeographyQuestion(q);
        q = new Question("Black sea is a sea in ?","A. South Eastern America","B. Australia","C. North America","D. South Eastern Europe","D. South Eastern Europe");
        this.addGeographyQuestion(q);
        q = new Question("Great Dividing Range mountain is in ?","A. Asia","B. Atlantica","C. Europe","D. Australia","D. Australia");
        this.addGeographyQuestion(q);
        q = new Question("What is the depth of Mariana Trench ?","A. 11,011 metres","B. 11,022 metres","C. 10,994 metres","D. 11,044 metres","C. 10,994 metres");
        this.addGeographyQuestion(q);
        q = new Question("Vernal Equinox occurs on ?","A. Feb 15","B. Feb 21","C. March 15","D. March 20","D. March 20");
        this.addGeographyQuestion(q);
        q = new Question("Among following which gas availability is more in atmosphere ?","A. Oxygen","B. Argon","C. Carbon dioxide","D. Nitrogen","D. Nitrogen");
        this.addGeographyQuestion(q);
        q = new Question("Atmosphere has how many distinct layers ?","A. 3","B. 4","C. 5","D. 6","C. 5");
        this.addGeographyQuestion(q);
        q = new Question("Ozone is present in which of the following layers ?","A. Mesosphere","B. Stratosphere","C. Atmosphere","D. Thermospher","B. Stratosphere");
        this.addGeographyQuestion(q);
        q = new Question("The proportion of Hydrogen to Helium in the Sun is ?","A. 3:2","B. 3:1","C. 1:1","D. 3:4","B. 3:1");
        this.addGeographyQuestion(q);
        q = new Question("The thickness of earth Crust is about ?","A. 25 kms","B. 30 kms","C. 35 kms","D. 40 kms","B. 30 kms");
        this.addGeographyQuestion(q);
        q = new Question("Thickness of Mantle Layer is about ?","A. 2900 kms","B. 3100 kms","C. 3300 kms","D. 3500 kms","A. 2900 kms");
        this.addGeographyQuestion(q);
        q = new Question("Which is not a type of rock ?","A. Igneous","B. Sedimentary","C. Metamorphic","D. Sedomorphic","D. Sedomorphic");
        this.addGeographyQuestion(q);
        q = new Question("What is height of Tibetan Plateau ?","A. 15000 ft","B. 16000 ft","C. 17000 ft","D. 18000 ft","B. 16000 ft");
        this.addGeographyQuestion(q);
        q = new Question("How many types of Pastures is there ?","A. two","B. three","C. four","D. five","A. two");
        this.addGeographyQuestion(q);
        q = new Question("In terms of area India is ____ largest area in the world ?","A. Fifth","B. Sixth","C. Seventh","D. Eighth","C. Seventh");
        this.addGeographyQuestion(q);
        q = new Question("Where do you find day and night equal ?","A. at the equator","B. at the north pole","C. at the tropics","D. at the south pole","A. at the equator");
        this.addGeographyQuestion(q);
        q = new Question("Kalahari desert is in ?","A. Chile","B. Saudi Arabia","C. India","D. South Africa","D. South Africa");
        this.addGeographyQuestion(q);
        q = new Question("Which is the longest continental mountain range in the world ","A. The Andes","B. The Alps","C. The Rockies","D. The Himalayas","A. The Andes");
        this.addGeographyQuestion(q);
        q = new Question("Rice is produced more in ?","A. Tamil Nadu","B. Kerela","C. West Bengal","D. Maharashtra","C. West Bengal");
        this.addGeographyQuestion(q);
        q = new Question("Corbett National Park is in ?","A. Punjab","B. Maharashtra","C. Uttarakhand","D. Madhya Pradesh","C. Uttarakhand");
        this.addGeographyQuestion(q);
        q = new Question("Which river is also known as Yellow River ?","A. Hwang–Ho","B. Amazon","C. Damodar","D. Cauvery","A. Hwang–Ho");
        this.addGeographyQuestion(q);
        q = new Question("The Salal Project is on the river ?","A. Jhelum","B. Chenab","C. Sutlej","D. Ravi","B. Chenab");
        this.addGeographyQuestion(q);
        q = new Question("The Yarlung Zangbo river, in India, is known as ?","A. Ganga","B. Mahanadi","C. Brahmaputra","D. Indus","C. Brahmaputra");
        this.addGeographyQuestion(q);
        q = new Question("The Radcliffe line is a boundary between ?","A. India and Pakistan","B. India and Afghanistan",
                "C. India and China","D. India and Myanmar","A. India and Pakistan");
        this.addGeographyQuestion(q);
        q = new Question("The oldest rocks in India are reported from ?","A. Shivalik range, Punjab","B. Dharwar region, Karnataka",
                "C. Aravalli range, Rajasthan","D. Vindhyan range, Madhya Pradesh","B. Dharwar region, Karnataka");
        this.addGeographyQuestion(q);
        q = new Question("The oldest rocks in India are reported from ?","A. Shivalik range, Punjab",
                "B. Dharwar region, Karnataka","C. Aravalli range, Rajasthan",
                "D. Vindhyan range, Madhya Pradesh","B. Dharwar region, Karnataka");
        this.addGeographyQuestion(q);
        q = new Question("The Shimla Convention is an agreement that sets ?","A. boundary between India and Tibet",
                "B. boundary between India and Pakistan",
                "C. Shimla as the capital of Himachal Pradesh",
                "D. None of Above",
                "A. boundary between India and Tibet");
        this.addGeographyQuestion(q);
        q = new Question("The oldest oil refinery in India is at ?","A. Haldia","B. Koyali","C. Digboi","D. Noonmati","C. Digboi");
        this.addGeographyQuestion(q);
        q = new Question("The watershed between India and Myanmar is formed by ?","A. the Naga hills","B. the Jaintia hills","C. Khasi hills",
                "D. the Garo hills","A. the Naga hills");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following crops is regarded as a plantation crop ?","A. Cotton","B. Sugarcane","C. Coconut",
                "D. Rice","C. Coconut");
        this.addGeographyQuestion(q);
        q = new Question("Which is most fertile region of India ?","A. Indo-Gangetic plain","B. Peninsular plateau",
                "C. The Himalayas","D. The Central Highlands","A. Indo-Gangetic plain");
        this.addGeographyQuestion(q);
        q = new Question("Which country has the largest coast line ?","A. USA","B. Brazil","C. Australia","D. Canada","D. Canada");
        this.addGeographyQuestion(q);
        q = new Question("Which national highway joins Agra to Mumbai ?","A. NH 1","B. NH 2","C. NH 3","D. NH 4","C. NH 3");
        this.addGeographyQuestion(q);
        q = new Question("Which National highway joins Delhi to Lucknow ?","A. NH 22","B. NH 24","C. NH 47","D. NH 48","B. NH 24");
        this.addGeographyQuestion(q);
        q = new Question("Which Indian state has maximum lengths of Roads ?","A. Punjab","B. Harayana","C. Himachal Pradesh",
                "D. Maharashtra","D. Maharashtra");
        this.addGeographyQuestion(q);
        q = new Question("The central water Tribunal was established in India in ?","A. 1887","B. 1888","C. 1889","D. 1890","A. 1887");
        this.addGeographyQuestion(q);
        q = new Question("Which is the largest port of India ?","A. Paradip Port","B. Kandla Port","C. Jawaharlal Nehru Port",
                "D. Ennore Port","C. Jawaharlal Nehru Port");
        this.addGeographyQuestion(q);
        q = new Question("\"Ajanta\" is in ?","A. Maharashtra","B. Agra","C. Kashmir","D. Punjab","A. Maharashtra");
        this.addGeographyQuestion(q);
        q = new Question("\"Gol Gumbaj\" is in ?","A. Maharashtra","B. Karnataka","C. Kashmir","D. Bihar","B. Karnataka");
        this.addGeographyQuestion(q);//-------
        q = new Question("Where is Dal lake?","(a) New York","(b) Beijing","(c) Jammu & Kashmir","(d) Dhaka","(c) Jammu & Kashmir");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following was a part of the green revolution strategy?","(a) High yielding variety seeds",
                "(b) Chemical fertilizers and pesticides","(c) Irrigation","(d) All the above","(d) All the above");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following is the largest lake in India?","(a) Nainital Lake","(b) Sambhar Lake",
                "(c) Sishram Lake","(d) Chilka Lake","(d) Chilka Lake");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following is the highest point in India?","(a) Mt. Everest","(b) Dodabeta",
                "(c) Kangchenjunga","(d) George Everest","(c) Kangchenjunga");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following is the largest Archipelago in the world?","(a) Andaman & Nicobar Island",
                "(b) Malaysia","(c) Indonesia","(d) Maldives","(c) Indonesia");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following is the world’s largest peninsula?","(a) India","(b) South Africa",
                "(c) Arabia","(d) Both A & B","(c) Arabia");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following imaginary line almost divides India into two equal parts?","(a) Equator",
                "(b) Tropic of Cancer","(c) Tropic of Capricorn","(d) Arctic Circle","(b) Tropic of Cancer");
        this.addGeographyQuestion(q);
        q = new Question("Which of the following river is called as the ‘Sorrow of Bengal’?","(a) The Gandak",
                "(b) The Kosi","(c) The Son","(d) The Damodar","(b) The Kosi");
        this.addGeographyQuestion(q);
        q = new Question("What are parallel lines drawn north and south of the Equator known as?","(a) Great Circles",
                "(b) Latitudes","(c) Longitudes","(d) Tropics","(b) Latitudes");
        this.addGeographyQuestion(q);
        q = new Question("What join places of equal height above sea level on a map?","(a) Meridians","(b) Tropics",
                "(c) Contour lines","(d) Map projection","(c) Contour lines");
        this.addGeographyQuestion(q);
        q = new Question("Which among the following is the method by which the curved surface of the Earth is depicted on a flat surface of plane?",
                "(a) Conical projection","(b) Cylindrical projection","(c) Mercator projection","(d) Zenithal projection","(d) Zenithal projection");
        this.addGeographyQuestion(q);
        q = new Question("Which among the following is fixed in relation to mean time of a certain meridian which generally passes through it?",
                "(a) Greenwich Mean Time","(b) Indian Standard Time","(c) Standard Time","(d) Local Time","(c) Standard Time");
        this.addGeographyQuestion(q);
        q = new Question("Who was the first person to use the word “geography”?","(a) Eratosthenes","(b) Strabo","(c) Ptolemy",
                "(d) William Morris Davis","(a) Eratosthenes");
        this.addGeographyQuestion(q);
        q = new Question("The Earth is comprised of how many continental and oceanic tectonic plates?","(a) 10","(b) 13",
                "(c) 20","(d) 14","(d) 14");
        this.addGeographyQuestion(q);
        q = new Question("Mantle layer is situated between _____________","(a) Crust and Lithosphere",
                "(b) Crust and Core","(c) Core and Lithosphere","(d) Inner Core and Outer Core","(b) Crust and Core");
        this.addGeographyQuestion(q);
        q = new Question("Mantle is composed of _____________","(a) Silicon and Magnesium","(b) Silicon",
                "(c) Magnesium","(d) None of the above","(a) Silicon and Magnesium");
        this.addGeographyQuestion(q);
    }

    private void addMathQuestion(){
        Question q = new Question(" Number of faces in a cubical shape table is _____",
                "(a) 12",
                "(b) 6",
                "(c) 8",
                "(d) 10","(b) 6");
        this.addMathQuestion(q);
        q = new Question(" Find the missing number in the series: 7, 15, 31, 63, ______",
                "(a) 124",
                "(b) 125",
                "(c) 127",
                "(d) 131","(c) 127");
        this.addMathQuestion(q);
        q = new Question(" The difference of x and y added to their product is _________",
        "(a) x - y + xy",
                "(b) x - (y + xy)",
        "(c) xy - x - y",
                "(d) xy - (x - y)","(a) x - y + xy");
        this.addMathQuestion(q);
        q = new Question(" Which figure has no line of symmetry?",
                "(a) A circle",
                "(b) A scalene triangle",
                "(c) An isosceles",
                "(d) An equilateral triangle","(b) A scalene triangle");
        this.addMathQuestion(q);
        q = new Question(" A man travels 230 km in 6 hours in which he took break for an hour. How much distance he will cover if he travels for 8 hrs non stop.",
                "(a) 307 km",
                "(b) 360 km",
                "(c) 336 km",
                "(d) 368 km","(d) 368 km");
        this.addMathQuestion(q);
        q = new Question(" Number of radii a circle can have is/are:",
                "(a) 1",
                "(b) 2",
                "(c) 4",
                "(d) infinite","(d) infinite");
        this.addMathQuestion(q);
        q = new Question(" Compute 5555 + 6666 - 8888 - 2222",
                "(a) 1001",
                "(b) 1221",
                "(c) 1111",
                "(d) 1011","(c) 1111");
        this.addMathQuestion(q);
        q = new Question(" A wire in the shape of an equilateral triangle of side 12 cm is reshaped to form a square. The side of square (in cm) is:",
                "(a) 18 cm",
                "(b) 12 cm",
                "(c) 16 cm",
                "(d) 9 cm","(d) 9 cm");
        this.addMathQuestion(q);
        q = new Question(" What will come in the place of star mark (✸) in the following number series,615 + (222 + 38) = (615 + ✸) + 38",
        "(a) 615",
                "(b) 222",
                "(c) 38",
                "(d) None of these","(b) 222");
        this.addMathQuestion(q);
        q = new Question(" In a room there are 4 chairs. The 1st chair is towards north, the IIIrd chair is towards south, the IInd chair is towards east"+
                "and the IVth chair is towards west. If the distance between any two consecutive chairs is equal and all interior angles are"+
        "90deg; each then which of the following shape is formed?",
        "(a) Square",
                "(b) Rectangle",
                "(c) Trapezium",
                "(d) Circle","(a) Square"
        );
        this.addMathQuestion(q);
        q = new Question(" Two successive numbers which are prime?",
                "(a) 3 and 5",
                "(b) 2 and 3",
                "(c) 5 and 7",
                "(d) 17 and 19","(b) 2 and 3");
        this.addMathQuestion(q);
        q = new Question(" A ladder is leaning against a wall such that it reaches the top of the wall. What shape of polygon it will form here?",
                "(a) Quadrilateral",
                "(b) Pentagon",
                "(c) Triangle",
                "(d) Hexagon","(c) Triangle");
        this.addMathQuestion(q);
        q = new Question(" In the morning assembly of a school, there are two parallel rows of boys and girls. Where will the two rows meet each"
                +"other?",
                "(a) In the beginning of rows",
                "(b) At the end of rows",
                "(c) In the middle of rows",
                "(d) Never meet","(d) Never meet");
        this.addMathQuestion(q);
        q = new Question(" Mohini is taller than Roma but shorter than Riya. Who is shorter among them?",
                "(a) Mohini",
                "(b) Roma",
                "(c) Riya",
                "(d) None of these","(b) Roma");
        this.addMathQuestion(q);
        q = new Question(" Kirti had seven tenth of the pizza and her younger brother had two tenth of pizza. How much pizza is still left?",
                "(a) 1/5",
                "(b) 3/5",
                "(c) 1/10",
                "(d) none of these","(c) 1/10");
        this.addMathQuestion(q);
        q = new Question(" The difference between the place value and face value of 8 in 65874 is",
                "(i) 0",
                "(ii) 792",
                "(iii) 735",
                "(iv) 693","(ii) 792");
        this.addMathQuestion(q);
        q = new Question(" The total number of 4 digit number is",
                "(i) 8999",
                "(ii) 9000",
                "(iii) 8000",
                "(iv) 9999","(ii) 9000");
        this.addMathQuestion(q);
        q = new Question(" In the international place value system, we write one million for",
                "(i) 1 lakh",
                "(ii) 10 lakh",
                "(iii) 100 lakh",
                "(iv) 1 crore","(ii) 10 lakh");
        this.addMathQuestion(q);
        q = new Question(" The smallest counting number is",
                "(i) 0",
                "(ii) 1",
                "(iii) 10",
                "(iv) None of these","(ii) 1");
        this.addMathQuestion(q);
        q = new Question(" Total number of numbers which when rounded off to nearest ten give us 200 is",
                "(i) 9",
                "(ii) 10",
                "(iii) 8",
                "(iv) 7","(i) 9");
        this.addMathQuestion(q);
        q = new Question(" The predecessor of 1 in natural numbers is",
                "(i) 0",
                "(ii) 2",
                "(iii) –1",
                "(iv) None of these","(iv) None of these");
        this.addMathQuestion(q);
        q = new Question(" The predecessor of 1 in whole numbers is",
                "(i) 0",
                "(ii) –1",
                "(iii) 2",
                "(iv) None of these","(i) 0");
        this.addMathQuestion(q);
        q = new Question(" The product of the predecessor and successor of an odd number is always divisible by",
                "(i) 2",
                "(ii) 4",
                "(iii) 6",
                "(iv) 8","(i) 2");
        this.addMathQuestion(q);
        q = new Question(" The product of the successor and predecessor of 99 is",
                "(i) 9800",
                "(ii) 9900",
                "(iii) 1099",
                "(iv) 9700","(i) 9800");
        this.addMathQuestion(q);
        q = new Question(" If any number is divided by zero, the Quotient is",
                "(i) the number itself",
                "(ii) zero",
                "(iii) not defined",
                "(iv) none of these","(iii) not defined");
        this.addMathQuestion(q);
        q = new Question(" The total number of even prime numbers is",
                "(i) 0",
                "(ii) 1",
                "(iii) 2",
                "(iv) unlimited","(ii) 1");
        this.addMathQuestion(q);
        q = new Question(" Which of the following numbers is divisible by 4?",
                "(i) 8675231",
                "(ii) 9843212",
                "(iii) 1234567",
                "(iv) 543123","(ii) 9843212");
        this.addMathQuestion(q);
        q = new Question(" What least value should be given to * so that the number 653 * 47 is divisible by 11?",
                "(i) 1",
                "(ii) 2",
                "(iii) 6",
                "(iv) 9","(i) 1");
        this.addMathQuestion(q);
        q = new Question(" If X and Y are co primes, then their LCM is",
                "(i) XY",
                "(ii) X+Y",
                "(iii) X/Y",
                "(iv) 1","(i) XY");
        this.addMathQuestion(q);
        q = new Question(" The HCF of two consecutive even numbers is",
                "(i) 1",
                "(ii) 2",
                "(iii) 0",
                "(iv) None of these","(ii) 2");
        this.addMathQuestion(q);
        q = new Question(" Which of the following statements is false",
                "(i) Point has a size because we can see it as a thick dot on paper",
                "(ii) By lines in geometry, are mean only straight lines",
                "(iii) Unlimited number of lines can be drawn through a given point.",
                "(iv) If two lines intersect at a point P, then P is called the point of intersection of the two lines","(ii) By lines in geometry, are mean only straight lines");
        this.addMathQuestion(q);
        q = new Question(" If two lines are drawn in a plane, they will",
                "(i) always intersect",
                "(ii) are always parallel",
                "(iii) either intersect or are parallel",
                "(iv) None of these","(ii) are always parallel");
        this.addMathQuestion(q);
        q = new Question(" If three points are collinear, then",
                "(i) at least two will lie on the same line",
                "(ii) all three will lie on the same line",
                "(iii) at least two will not lie on the same line",
                "(iv) None of these","(ii) all three will lie on the same line");
        this.addMathQuestion(q);
        q = new Question(" The region enclosed by an arc and two radii of a circle is called",
                "(i) Segment",
                "(ii) Sector",
                "(iii) Curve",
                "(iv) Ray","(ii) Sector");
        this.addMathQuestion(q);
        q = new Question(" The shortest distance between two points is called",
                "(i) Line",
                "(ii) Line segment",
                "(iii) Ray",
                "(iv) Arc","(ii) Line segment");
        this.addMathQuestion(q);
        q = new Question(" Negative of a negative integer is",
                "(i) less than zero",
                "(ii) greater than zero",
                "(iii) zero",
                "(iv) none of these","(ii) greater than zero");
        this.addMathQuestion(q);
        q = new Question(" Which of the following statements are false",
                "(i) The opposite of zero is zero",
                "(ii) 0 is larger than every negative integer",
                "(iii) A positive integer is greater than its opposite",
                "(iv) zero is not an integer","(iv) zero is not an integer");
        this.addMathQuestion(q);
        q = new Question(" Which of the following is represented by negative sign",
                "(i) A deposite of Rs. 2500",
                "(ii) A profit of Rs. 800",
                "(iii) 5 degree below zero",
                "(iv) 3 km above sea level","(iii) 5 below zero");
        this.addMathQuestion(q);
        q = new Question(" The additive inverse of 0 is",
                "(i) greater than zero",
                "(ii) less than zero",
                "(iii) zero",
                "(iv) none of these","(iii) zero");
        this.addMathQuestion(q);
        q = new Question(" Largest negative integer is ____________",
                "(i) 1",
                "(ii) –1",
                "(iii) –1000000",
                "(iv) None of these","(ii) –1");
        this.addMathQuestion(q);
        q = new Question(" Total number of faces of a cuboid is",
                "(i) 4",
                "(ii) 6",
                "(iii) 8",
                "(iv) 12","(ii) 6");
        this.addMathQuestion(q);
        q = new Question(" A brick is an example of a",
                "(i) cube",
                "(ii) cuboid",
                "(iii) prim",
                "(iv) cylinder","(ii) cuboid");
        this.addMathQuestion(q);
        q = new Question(" A tetrahedron is a pyramid whose base is a",
                "(i) triangle",
                "(ii) square",
                "(iii) rectangle",
                "(iv) Quadrilateral","(ii) square");
        this.addMathQuestion(q);
        q = new Question(" The number of faces of a triangular pyramid is",
                "(i) 3",
                "(ii) 4",
                "(iii) 6",
                "(iv) 8","(ii) 4");
        this.addMathQuestion(q);
        q = new Question(" A gas pipe is an example of",
                "(i) cone",
                "(ii) a cylinder",
                "(iii) cube",
                "(iv) sphere","(ii) a cylinder");
        this.addMathQuestion(q);
        q = new Question(" The simplest form of 96/144 fraction is",
                "(i)8/12",
                "(ii)2/3",
                "(iii)4/3",
                "(iv) None of these","(ii)2/3");
        this.addMathQuestion(q);
        q = new Question(" If 11/4 =77/x , then x=?",
                "(i) 28",
                "(ii)77/28",
                "(iii) 44",
                "(iv) 308","(i) 28");
        this.addMathQuestion(q);
        q = new Question(" A fraction equivalent to 3/5 is",
                "(i)(3+2)/(5+2)",
                "(ii)(3-2)/(5-2)",
                "(iii)(3x2)/(5x2)",
                "(iv) None of these","(ii)(3-2)/(5-2)");
        this.addMathQuestion(q);
        q = new Question(" Which of the following fractions is the greatest of all?"+
                "7/8, 6/7, 4/5, 5/6",
                "(i) 6/7",
                "(ii) 4/5",
                "(iii) 5/6",
                "(iv) 7/8","(iv) 7/8");
        this.addMathQuestion(q);
        q = new Question(" 8 + _________= 8+(1/3)",
                "(i) 1/3",
                "(ii) 0",
                "(iii) 3/1",
                "(iv) None of these","(i) 1/3");
        this.addMathQuestion(q);
        q = new Question(" Collection of observations gathered initially is called",
                "(i) frequency",
                "(ii) raw data",
                "(iii) range",
                "(iv) array","(ii) raw data");
        this.addMathQuestion(q);
        q = new Question(" The number of times an observation occurs in the given data, is called",
                "(i) tally marks",
                "(ii) range",
                "(iii) frequency",
                "(iv) array","(iii) frequency");
        this.addMathQuestion(q);
        q = new Question("The raw data when put in ascending or descending order of magnitude is called",
                "(i) array",
                "(ii) tally marks",
                "(iii) frequency",
                "(iv) range","(i) array");
        this.addMathQuestion(q);
        q = new Question(" Pictorial representation of numerical data is called",
                "(i) pie chart",
                "(ii) bar graph",
                "(iii) pictograph",
                "(iv) histogram", "(iii) pictograph");
        this.addMathQuestion(q);
        q = new Question(" The value of 37/10000 is",
                "(i) 0.0370",
                "(ii) 0.0037",
                "(iii) 0.00037",
                "(iv) 0.000037","(ii) 0.0037");
        this.addMathQuestion(q);
        q = new Question(" 2+3/10 +5/100 is equal to",
                "(i) 2.305",
                "(ii) 2.3",
                "(iii) 2.35",
                "(iv) 0.235","(iii) 2.35");
        this.addMathQuestion(q);
        q = new Question(" Which is greater among 2.3, 2.03, 2.33, 2.05?",
                "(i) 2.3",
                "(ii) 2.03",
                "(iii) 2.33",
                "(iv) 2.05","(iii) 2.33");
        this.addMathQuestion(q);
        q = new Question(" The value of 3/25 is",
                "(i) 1.2",
                "(ii) 0.12",
                "(iii) 0.012",
                "(iv) None of these.","(ii) 0.12");
        this.addMathQuestion(q);
        q = new Question(" 15 litres and 15 ml is equal to",
                "(i) 15.15 Litres",
                "(ii) 15.105 Litres",
                "(iii) 15.0015 Litres",
                "(iv) 15.015 Litres","(iv) 15.015 Litres");
        this.addMathQuestion(q);
        q = new Question(" Two lines perpendicular to each other, intersect at an angle of",
                "(i) 60°",
                "(ii) 180°",
                "(iii) 90°",
                "(iv) 45°","(iii) 90°");
        this.addMathQuestion(q);
        q = new Question("A line segment can have the following number of perpendicular bisector",
                "(i) 1",
                "(ii) 2",
                "(iii) 3",
                "(iv) 0","(i) 1");
        this.addMathQuestion(q);
        q = new Question(" How many perpendiculars can be drawn to a given line segment?",
                "(i) 2",
                "(ii) 3",
                "(iii) infinite",
                "(iv) 0","(iii) infinite");
        this.addMathQuestion(q);
        q = new Question(" Circles having the same centre are called",
                "(i) concentric circles",
                "(ii) congruent circles",
                "(iii) similar circles",
                "(iv) none of these","(i) concentric circles");
        this.addMathQuestion(q);
        q = new Question(" An angle is formed when two rays have",
                "(i) the same length",
                "(ii) the same initial point",
                "(iii) different starting point",
                "(iv) none of these","(ii) the same initial point");
        this.addMathQuestion(q);
        q = new Question(" A polygon with all sides and all angles equal is called _____________ polygon.",
                "(i) Irregular",
                "(ii) Regular",
                "(iii) Congruent",
                "(iv) Closed","(ii) Regular");
        this.addMathQuestion(q);
        q = new Question(" Side of a square, when perimeter is given is",
                "(i) 4/Perimeter",
                "(ii) 4 × Perimeter",
                "(iii) Perimeter/4",
                "(iv) Perimeter + 4","(iii) Perimeter/4");
        this.addMathQuestion(q);
        q = new Question(" If the sides of a square are halved, then its area",
                "(i) remains same",
                "(ii) becomes half",
                "(iii) becomes one fourth",
                "(iv) becomes double","(iii) becomes one fourth");
        this.addMathQuestion(q);
        q = new Question(" The perimeter of 6 sided regular polygon with side 6 units is",
                "(i) 6+6",
                "(ii) 6/6",
                "(iii) 6–6",
                "(iv) 6x6","(iv) 6x6");
        this.addMathQuestion(q);
        q = new Question(" Cost of fencing any field is given by",
                "(i) Area of field multiplied by rate of fencing",
                "(ii) Area of field added to rate of fencing",
                "(iii) Perimeter of field added to rate of fencing",
                "(iv) Perimeter of field multiplied to rate of fencing","(iv) Perimeter of field multiplied to rate of fencing");
        this.addMathQuestion(q);
        q = new Question(" The quotient of x by y added to the product of x and y is written as",
                "(i) x/y+xy",
                "(ii) y/x+ xy",
                "(iii) xy+x/ y",
                "(iv)xy+y/ x","(i) x/y+xy");
        this.addMathQuestion(q);
        q = new Question(" The quotient of x by 3 is multiplied by y is written as",
                "(i) x/3y",
                "(ii) 3x/y",
                "(iii) 3y/x",
                "(iv) xy/3","(iii) 3y/x");
        this.addMathQuestion(q);
        q = new Question(" 9 taken away from the sum of x and y is",
                "(i) (x+y)–9",
                "(ii) 9–(x+y)",
                "(iii) x+y/ 9",
                "(iv) 9/x+y","(i) (x+y)–9");
        this.addMathQuestion(q);
        q = new Question(" Literal numbers are called",
                "(i) Constants",
                "(ii) Variables",
                "(iii) Expressions",
                "(iv) Terms","(ii) Variables");
        this.addMathQuestion(q);
        q = new Question(" In a room there are y rows of chairs and each row contains 2x chairs. The total number of chairs in the room is",
                "(i) 2x sqr of 3",
                "(ii) 2x sqr of 4",
                "(iii) 2xy",
                "(iv) 2x sqr of 2","(iii) 2xy");
        this.addMathQuestion(q);
        q = new Question(" In a ratio the first term is known as",
                "(i) Consequent",
                "(ii) Antecedent",
                "(iii) Means",
                "(iv) None of them","(ii) Antecedent");
        this.addMathQuestion(q);
        q = new Question(" If a, b, c, d are in proportion, then",
                "(i) ab=cd",
                "(ii) ac=bd",
                "(iii) ad=bc",
                "(iv) None of them","(iii) ad=bc");
        this.addMathQuestion(q);
        q = new Question(" If a, b, c are in proportion, then",
                "(i) a2=bc",
                "(ii) b2=ac",
                "(iii) c2=ab",
                "(iv) None of them","(ii) b2=ac");
        this.addMathQuestion(q);
        q = new Question(" Ratio of Rs 2 to 50 paise in lowest term is",
                "(i) 2 : 1",
                "(ii) 20 :5",
                "(iii) 1 : 2",
                "(iv) 4 : 1","(iv) 4 : 1");
        this.addMathQuestion(q);
        q = new Question(" Equivalent ratio of 5:7",
                "(i) 40 : 56",
                "(ii) 25 : 45",
                "(iii) 7 : 5",
                "(iv) NOT","(i) 40 : 56");
        this.addMathQuestion(q);
        q = new Question(" Which of the following Roman symbol is never repeated?",
                "(i) I",
                "(ii) V",
                "(iii) X",
                "(iv) C","(ii) V");
        this.addMathQuestion(q);
        q = new Question(" Which of the following Roman symbol is never repeated?",
                "(i) I",
                "(ii) V",
                "(iii) X",
                "(iv) C","(ii) V");
        this.addMathQuestion(q);
        q = new Question(" How many whole numbers are not natural numbers?",
                "(i) 1",
                "(ii) 2",
                "(iii) 3",
                "(iv) None of these","(i) 1");
        this.addMathQuestion(q);
        q = new Question("  H.C.F of two consecutive numbers is always-",
                "(i) 1",
                "(ii) 2",
                "(iii) 0",
                "(iv) 4","(i) 1");
        this.addMathQuestion(q);
        q = new Question(" A triangle having one angle 90º is called ",
                "(i) Acute angled triangle",
                "(ii) Right angled triangle",
                "(iii) Obtuse angled triangle",
                "(iv) None of these.","(ii) Right angled triangle");
        this.addMathQuestion(q);
        q = new Question(" The greatest natural number is-",
                "(i) 1 crore",
                "(ii) 10 crore",
                "(iii) 10 Arabs",
                "(iv) None of these","(iv) None of these");
        this.addMathQuestion(q);
        q = new Question(" The prime factorization of 48 is-",
                "(i) 2 × 2 × 2 × 2 × 3",
                "(ii) 3 × 3 × 3 ×q 2 × 2",
                "(iii) 2 × 4 × 3",
                "(iv) 8 × 3 × 3","(i) 2 × 2 × 2 × 2 × 3");
        this.addMathQuestion(q);
        q = new Question(" The distance covered along the boundary forming a closed figure when you go round the"+
                "figure once is called __________ .",
                "(a) Area"," (b) Perimeter",
                "(c) circle ","(d) None of these"," (b) Perimeter"
                );
        this.addMathQuestion(q);
        q = new Question(" Select a variable from the given options :",
                "(a) 53 ","(b) -7",
                "(c) r ","(d) All of these","(c) r ");
        this.addMathQuestion(q);
        q = new Question(" (square of P) -1 is",
                "(a) Twice of P minus 1.",
                "(b) P multiplied by itself subtracted from 1.",
                "(c) 1 subtracted from square of P.",
                "(d) None of these","(c) 1 subtracted from square of P.");
        this.addMathQuestion(q);
        q = new Question(" In collection of toys 1/4 of 1200 toys are only balls. The number of balls are :",
                "(a) 800 ","(b) 4800",
                "(c) 300 ","(d) None of these","(c) 300 ");
        this.addMathQuestion(q);
        q = new Question(" Ratio which is not equivalent to 6:4",
                "(a) 48:32 ","(b) 3:2",
                "(c) 600:400 ","(d) 24:64","(d) 24:64");
        this.addMathQuestion(q);
        q = new Question(" If we move 4 numbers to the left of 1 on the number line, where will we reach?",
                "(a) - 5 ","(b) 5",
                "(c) - 3 ","(d) - 4","(c) - 3 ");
        this.addMathQuestion(q);
        q = new Question(" Regular pentagon has each side x units, then its perimeter is :",
                "(a) 5x units ","(b) 6x units",
                "(c) 5 + x units ","(d) 6 + x units","(a) 5x units ");
        this.addMathQuestion(q);
        q = new Question(" Write 65 subtracted from sum of x and y‟ as an algebraic expression.",
                "(a) (x – y) + 65 ","(b) (x + y) – 65","(c) (65 + x) – y ","(d) (y + 65) - x","(b) (x + y) – 65");
        this.addMathQuestion(q);
        q = new Question("10 men can construct a building in 40 days. How long will it take 20 men to do this work?",
                "(a) 20 days","(b) 30 days","(c) 40 days","(d) 50 days","(a) 20 days");
        this.addMathQuestion(q);
        q = new Question("Which is the greatest number?","(a) 1/4 of 236","(b) 1/16 of 1028","(c) 1/9 of 504","(d) 1/3 of 741","(d) 1/3 of 741");
        this.addMathQuestion(q);
        q = new Question("16 men build a house in 10 days. How much time will it take 8 men to do this work?",
                "(a) 25 days","(b) 20 days","(c) 30 days","(d) 32 days","(b) 20 days");
        this.addMathQuestion(q);
        q = new Question("If 100 cats kill 100 mice in 100 day, then 4 cats would kill 4 mice in how many days ?","(a) 1","(b) 4",
                "(c) 40","(d) 100","(d) 100");
        this.addMathQuestion(q);
        q = new Question("Of the following, which is greater than 1/2 ?","(a) 2/5","(b) 4/7","(c) 4/9","(d) 5/11","(b) 4/7");
        this.addMathQuestion(q);
        q = new Question("If an object travels at five feet per second, how many feet does it travel in one hour?",
                "(a) 300","(b) 720","(c) 1800","(d) 18000","(d) 18000");
        this.addMathQuestion(q);

    }

    private void addRandomQuestion(Question q1) {
        ContentValues value = new ContentValues();
        value.put(KEY_QUES,q1.getQUESTION());
        value.put(KEY_ANSWER,q1.getANSWER());
        value.put(KEY_OPTA,q1.getOPT_A());
        value.put(KEY_OPTB,q1.getOPT_B());
        value.put(KEY_OPTC,q1.getOPT_C());
        value.put(KEY_OPTD,q1.getOPT_D());

        dbase.insert(TABLE_QUEST_RAND,null, value);
    }
//
    private void addGeographyQuestion(Question q1) {
        ContentValues value = new ContentValues();
        value.put(KEY_QUES,q1.getQUESTION());
        value.put(KEY_ANSWER,q1.getANSWER());
        value.put(KEY_OPTA,q1.getOPT_A());
        value.put(KEY_OPTB,q1.getOPT_B());
        value.put(KEY_OPTC,q1.getOPT_C());
        value.put(KEY_OPTD,q1.getOPT_D());

        dbase.insert(TABLE_QUEST_GEOGRAPHY,null, value);
    }

    private void addMathQuestion(Question q1) {
        ContentValues value = new ContentValues();
        value.put(KEY_QUES,q1.getQUESTION());
        value.put(KEY_ANSWER,q1.getANSWER());
        value.put(KEY_OPTA,q1.getOPT_A());
        value.put(KEY_OPTB,q1.getOPT_B());
        value.put(KEY_OPTC,q1.getOPT_C());
        value.put(KEY_OPTD,q1.getOPT_D());

        dbase.insert(TABLE_QUEST_MATH,null, value);
    }

    private void addScienceQuestion(Question q1) {
        ContentValues value = new ContentValues();
        value.put(KEY_QUES,q1.getQUESTION());
        value.put(KEY_OPTA,q1.getOPT_A());
        value.put(KEY_OPTB,q1.getOPT_B());
        value.put(KEY_OPTC,q1.getOPT_C());
        value.put(KEY_OPTD,q1.getOPT_D());
        value.put(KEY_ANSWER,q1.getANSWER());
        dbase.insert(TABLE_QUEST_SCIENCE,null, value);
    }

    private void addHistoryQuestion(Question q1) {
        ContentValues value = new ContentValues();
        value.put(KEY_QUES,q1.getQUESTION());
        value.put(KEY_ANSWER,q1.getANSWER());
        value.put(KEY_OPTA,q1.getOPT_A());
        value.put(KEY_OPTB,q1.getOPT_B());
        value.put(KEY_OPTC,q1.getOPT_C());
        value.put(KEY_OPTD,q1.getOPT_D());

        dbase.insert(TABLE_QUEST_HISTORY,null, value);
    }

    private void addSportQuestions(Question q1) {
        ContentValues value = new ContentValues();
        value.put(KEY_QUES,q1.getQUESTION());
        value.put(KEY_ANSWER,q1.getANSWER());
        value.put(KEY_OPTA,q1.getOPT_A());
        value.put(KEY_OPTB,q1.getOPT_B());
        value.put(KEY_OPTC,q1.getOPT_C());
        value.put(KEY_OPTD,q1.getOPT_D());

        dbase.insert(TABLE_QUEST_SPORTS,null, value);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_RAND);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_GEOGRAPHY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_SCIENCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_HISTORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_MATH);
        // Create tables again
        onCreate(db);
    }

    public Cursor getTenRandomRow(int table_number,SQLiteDatabase dbase){
        Cursor c = dbase.query(true, getTableName(table_number), null, null,null,null,null,"random()","1");
        if (c != null){
            c.moveToFirst();

        }
        return c;
    }

    public List<Question> getAllRandomQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST_RAND+ " order by random() Limit 10";
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPT_A(cursor.getString(2));
                quest.setOPT_B(cursor.getString(3));
                quest.setOPT_C(cursor.getString(4));
                quest.setOPT_D(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return quest list
        return quesList;
    }
    public List<Question> getAllMathQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST_MATH+ " order by random() Limit 10";
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPT_A(cursor.getString(2));
                quest.setOPT_B(cursor.getString(3));
                quest.setOPT_C(cursor.getString(4));
                quest.setOPT_D(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return quest list
        return quesList;
    }
    public List<Question> getAllScienceQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST_SCIENCE+ " order by random() Limit 10";
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPT_A(cursor.getString(2));
                quest.setOPT_B(cursor.getString(3));
                quest.setOPT_C(cursor.getString(4));
                quest.setOPT_D(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return quest list
        return quesList;
    }
    public List<Question> getAllGeographyQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST_GEOGRAPHY+ " order by random() Limit 10";;
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPT_A(cursor.getString(2));
                quest.setOPT_B(cursor.getString(3));
                quest.setOPT_C(cursor.getString(4));
                quest.setOPT_D(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return quest list
        return quesList;
    }
    public List<Question> getAllHistoryQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST_HISTORY+ " order by random() Limit 10";
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPT_A(cursor.getString(2));
                quest.setOPT_B(cursor.getString(3));
                quest.setOPT_C(cursor.getString(4));
                quest.setOPT_D(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return quest list
        return quesList;
    }

    public List<Question> getAllSportQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST_SPORTS+ " order by random() Limit 10";
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPT_A(cursor.getString(2));
                quest.setOPT_B(cursor.getString(3));
                quest.setOPT_C(cursor.getString(4));
                quest.setOPT_D(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return quest list
        return quesList;
    }

    public int getRowCount(String table){
        String countQuery = "SELECT  * FROM " + table;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public String getTableName(int i){
        switch(i){
            case 1:                return TABLE_QUEST_SCIENCE;
            case 2:                return TABLE_QUEST_RAND;
            case 3:                return TABLE_QUEST_MATH;
            case 4:                return TABLE_QUEST_HISTORY;
            case 5:                return TABLE_QUEST_GEOGRAPHY;
            case 6:                return TABLE_QUEST_SPORTS;
            default:               return TABLE_QUEST_RAND;
        }
    }
}
