package IO;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//    public class AsciiValue {
//    public static void main(String[] args) {
//
//        char ch = 'a';
//        int ascii = ch;
//        // You can also cast char to int
//        int castAscii = (int) ch;
//
//        System.out.println("The ASCII value of " + ch + " is: " + ascii);
//        System.out.println("The ASCII value of " + ch + " is: " + castAscii);
//    }
//}
// Output : The ASCII value of a is: 97
//          The ASCII value of a is: 97

public class SzyfrCezaraIO {
    String text;
    String textPoZmianie;

    public SzyfrCezaraIO() throws FileNotFoundException {

        File file = new File("C://Users//Piotr//Desktop//Dokument.txt");
        String text = "";
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            text+=scanner.nextLine();
        }
        this.text = text;
        scanner.close();

        szyfrujemy();

        File output = new File("C://Users//Piotr//Desktop//DokumentOut.txt");
        PrintWriter printWriter = new PrintWriter(output);
        printWriter.println(this.textPoZmianie);
        printWriter.close();



    }
    public void szyfrujemy(){
        String text = "";
        char [] tab = this.text.toCharArray();
        int ascii;
        for (int i =0; i<tab.length; i++){
            ascii = (int) tab[i];

            if (ascii>= 65 && ascii<= 87){
                ascii+=3;
                text+= (char) ascii;

            } else if (ascii>=88 && ascii<=90) {
                ascii-=23;
                text += (char) ascii;
            }else if (ascii>=97 && ascii<= 119){
                ascii+=3;
                text+= (char) ascii;
            } else if (ascii>=120 && ascii<=122) {
                ascii-=23;
                text += (char) ascii;
            }
        }
        this.textPoZmianie = text;

    }

    public static void main(String[] args) throws FileNotFoundException {
        SzyfrCezaraIO kod = new SzyfrCezaraIO();
    }
}

