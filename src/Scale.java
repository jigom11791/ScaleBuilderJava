public class Scale {

    private Note notes[] = new Note[8];
    final private int ionianPattern[] = {2,2,1,2,2,2,1};
    private int scalePattern[] = new int[7];

    public Scale(char root) {
        for(int i = 0, n = (int) root; i < 8; i++, n++) {
            notes[i] = new Note((char) ((n-65)%7 + 65));
        }
        //scalePattern = ionianPattern;
        generateScalePattern("IONIAN");
        accidentalGenerator();
    }

    public Scale(Note root) {
        notes[0] = root;
        for(int i = 1, n = (int) (root.getValue()+1); i < 8; i++, n++ ) {
            notes[i] = new Note((char) ((n-65)%7 + 65));
        }
        scalePattern = ionianPattern;
        generateScalePattern("IONIAN");
        accidentalGenerator();
    }

    public Scale(Note root, String type) {
        this(root);
        generateScalePattern(type);
        accidentalGenerator();
    }
    
    private void accidentalGenerator() {
        Note previousNote = notes[0];
        for(int i = 1; i < 8; i++) {
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
    private void generateScalePattern(String type) {
        int startingIndex = 0;
        switch(type.toUpperCase()) {
            case "IONIAN": startingIndex = 0; break;
            case "DORIAN": startingIndex = 1; break;
            case "PHRYGIAN": startingIndex = 2; break;
            case "LYDIAN": startingIndex = 3; break;
            case "MIXOLYDIAN": startingIndex = 4; break;
            case "AOLIAN": startingIndex = 5; break;
            case "LOCRIAN": startingIndex = 6; break;
        }
        for(int i=0, n=startingIndex; i<7; i++,n++) {
            n=n%7;
            scalePattern[i] = ionianPattern[n];
            //System.out.print(scalePattern[i]);
        }

    }
}
