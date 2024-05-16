package kir.lab.client;

import kir.lab.common.util.Request;
import kir.lab.common.util.Response;

import java.io.IOException;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
    }


    static CompareCommand compare = new CompareCommand();


    public static void start() throws IOException, ClassNotFoundException {

        Dialog dialog = new Dialog();
        while (true) {
            try {
                System.out.println("Введите команду: ");
                String read = SystemIn.readLine();
                if (read == null) {
                    SystemIn.printLine("Неверный ввод");
                } else {
                    if (read.trim().isEmpty()) {
                        SystemIn.printLine("Неверный ввод");
                    } else {
                        Request request = compare.checkCommand(read);
                        if (request != null) {
                            dialog.send(request);
                            Response response = dialog.read();
                            SystemIn.printLine(response.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
