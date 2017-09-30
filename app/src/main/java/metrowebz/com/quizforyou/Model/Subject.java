package metrowebz.com.quizforyou.Model;

/**
 * Created by Abhilash on 20-03-2017.
 */

public class Subject {
    private String subject;
    private String completed;
    private String progress;
    private String subjectImage;

    public Subject(){

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getSubjectImage() {
        return subjectImage;
    }

    public void setSubjectImage(String subjectImage) {
        this.subjectImage = subjectImage;
    }
}
