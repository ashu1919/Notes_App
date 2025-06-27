import java.io.*;
import java.util.Scanner;


public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = 0;

        while (opt != 3) {
            System.out.println("1. Write Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            opt = sc.nextInt();
            sc.nextLine();

            if (opt == 1) {
                System.out.print("Type your note: ");
                String myNote = sc.nextLine();

                try {
                    FileWriter fw = new FileWriter("notes.txt", true);
                    fw.write(myNote + "\n");
                    fw.close();
                    System.out.println("Note saved.");
                } catch (IOException e) {
                    System.out.println("Error writing file.");
                }

            } else if (opt == 2) {
                try {
                    FileReader fr = new FileReader("notes.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    int i = 1;
                    System.out.println("Notes:");
                    while ((line = br.readLine()) != null) {
                        System.out.println(i + ". " + line);
                        i++;
                    }
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    System.out.println("Error reading file or no notes yet.");
                }

            } else if (opt == 3) {
                System.out.println("Bye!");
            } else {
                System.out.println("Wrong option.");
            }
        }

        sc.close();
    }
}
