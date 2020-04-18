package BaseCourse.JavaIO.Third;

public class IndexRecord {
    private int startByte;
    private int lengths;

    public IndexRecord(int startByte, int lengths) {
        this.startByte = startByte;
        this.lengths = lengths;
    }

    public int getStartByte() {
        return startByte;
    }

    public void setStartByte(int startByte) {
        this.startByte = startByte;
    }

    public int getLengths() {
        return lengths;
    }

    public void setLengths(int lengths) {
        this.lengths = lengths;
    }
}
