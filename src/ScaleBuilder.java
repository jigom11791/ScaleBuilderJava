public class ScaleBuilder {

    public static void main(String[] args) {
        Note n1 = new Note('A');
        Note n2 = new Note('B');

        System.out.println(Note.calculateInterval(n1,n2));

        Scale scale = new Scale('D');

        System.out.println(scale);

    }
}
