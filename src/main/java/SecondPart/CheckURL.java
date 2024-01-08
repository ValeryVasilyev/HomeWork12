package SecondPart;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Scanner;

public class CheckURL {

    public void readContent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the URL: ");
                URL url = new URL(scanner.nextLine());
                url.getContent();
                System.out.println("Server is reached");
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            } catch (IOException e) {
                System.out.println("Server is unavailable");
            }
        }
    }
}
