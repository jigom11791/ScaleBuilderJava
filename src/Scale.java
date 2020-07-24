public class Scale {

    private Note notes[] = new Note[8];
    private int scalePattern[] = {2,2,1,2,2,2,1};

    public Scale(char root) {
        for(int i = 0, n = (int) root; i < 8; i++, n++) {
            notes[i] = new Note((char) ((n-65)%7 + 65));
        }
        accidentalGenerator();
    }
    
    private void accidentalGenerator() {
        Note previousNote = notes[0];
        for(int i = 1; i < 7; i++) {
            int interval = Note.calculateInterval(previousNote, notes[i]);
            int diff = scalePattern[i-1] - interval;
            switch(diff) {
                case -2:
                    notes[i].setAccidental('f');
                    break;
                case -1:
                    notes[i].setAccidental('b');
                    break;
                case 1:
                    notes[i].setAccidental('#');
                    break;
                case 2:
                    notes[i].setAccidental('s');
                    break;
            }

            previousNote = notes[i];
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
