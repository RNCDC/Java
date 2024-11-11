package ACT6;

public class cls_Student {
    String studNum, studName, course;
    int year, section;

    public cls_Student(String sno, String sna) {
        this.studNum = sno;
        this.studName = sna;
    }

    public String getStudNum() {
        return studNum;
    }

    public String getStudName() {
        return studName;
    }

    public cls_Student(String crs, int yr, int sec) {
        this.course = crs;
        this.year = yr;
        this.section = sec;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    public int getSection() {
        return section;
    }
}
