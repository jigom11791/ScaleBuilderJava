public class Scale {

    private Note notes[] = new Note[8];
    private int scalePattern[] = {2,2,1,2,2,2,1};

    public Scale(char root) {
        for(int i = 0, n = (int) root; i < 8; i++, n++) {
            notes[i] = new Note((char) ((n-65)%7 + 65));
        }
    }
    


    public String toString() {
        String scaleStr = "";
        for (int i= 0; i < 8; i++) {
            scaleStr+= notes[i].getValue();
            scaleStr+= notes[i].getAccidental();
            scaleStr+= " ";
        }
        return scaleStr;
    }
}
