package metrowebz.com.quizforyou.Model;

/**
 * Created by Abhilash on 06-11-2016.
 */
public class Question{

    private int ID;
    private String QUESTION;
    private String OPT_A;
    private String OPT_B;
    private String OPT_C;
    private String OPT_D;
    private String ANSWER;
    public Question(){
        ID = 0;
        QUESTION = "";
        OPT_A = "";
        OPT_B = "";
        OPT_C = "";
        OPT_D = "";
        ANSWER = "";
    }

    public Question(String question,String opta,String optb, String optc, String optd, String answer ){
        QUESTION = question;
        OPT_A = opta;
        OPT_B = optb;
        OPT_C = optc;
        OPT_D = optd;
        ANSWER = answer;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOPT_A() {
        return OPT_A;
    }

    public void setOPT_A(String OPT_A) {
        this.OPT_A = OPT_A;
    }

    public String getOPT_B() {
        return OPT_B;
    }

    public void setOPT_B(String OPT_B) {
        this.OPT_B = OPT_B;
    }

    public String getOPT_C() {
        return OPT_C;
    }

    public void setOPT_C(String OPT_C) {
        this.OPT_C = OPT_C;
    }

    public String getOPT_D() {
        return OPT_D;
    }

    public void setOPT_D(String OPT_D) {
        this.OPT_D = OPT_D;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }
}
