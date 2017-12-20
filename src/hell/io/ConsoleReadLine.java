package hell.io;

import hell.interfaces.InputReader;

import java.util.Scanner;

public class ConsoleReadLine implements InputReader{
    private Scanner scanner;

    public ConsoleReadLine() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return this.scanner.nextLine();
    }
}
