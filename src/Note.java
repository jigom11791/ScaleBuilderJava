public class Note {

    private char value, accidental;

    public Note() {
        value = ' ';
        accidental = ' ';
    }

    public Note(char value) {
        this.value = value;
        accidental = ' ';
    }

    /************************************
     * Getters and Setters
     ***********************************/
    public void setValue(char value) {
        this.value = value;
    }

    public void setAccidental(char accidental) {
        this.accidental = accidental;
    }

    public char getValue() {
        return value;
    }

    public char getAccidental() {
        return accidental;
    }

    private int noteToInt() {
        int num = 0;

        switch(value) {
            case 'C': num = 0; break; //C is 0 keys away from the C string
            case 'D': num = 2; break;
            case 'E': num = 4; break;
            case 'F': num = 5; break;
            case 'G': num = 7; break;
            case 'A': num = 9; break;
            case 'B': num = 11; break;
        }
        switch(accidental) {
            case '#': num+=1; break;
            case 's': num+=2; break; //s is for double sharp
            case 'b': num-=1; break;
            case 'f': num-=2; break; //f is for double flat
        }

        return num;
    }

    public static int calculateInterval(Note n1, Note n2) {
        return n2.noteToInt()%12 - n1.noteToInt()%12;
    }
}
