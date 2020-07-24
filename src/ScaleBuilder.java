public class ScaleBuilder {

    public static void main(String[] args) {
        Note n1 = new Note('A');
        Note n2 = new Note('B');

        Scale scale = new Scale(new Note('E','b'));
        Scale fdorian = new Scale(new Note('F'), "DORIAN");

        System.out.println(scale);
        System.out.println(fdorian);

    }
}
