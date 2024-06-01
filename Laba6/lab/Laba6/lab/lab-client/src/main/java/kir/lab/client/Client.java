package kir.lab.client;

import kir.lab.client.data.DataManager;
import kir.lab.common.util.Request;
import kir.lab.common.util.Response;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }



    static CompareCommand compare = new CompareCommand();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Selector selector = Selector.open();
        Dialog dialog = new Dialog(selector);
        ExecuteScript executeScript = new ExecuteScript();
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
                        if (request.getMessage().equals("execute_script")) {
                            executeScript.execute(DataManager.LoadScript(request.getId()));
                        }else if (request != null){
                            dialog.send(request);
                            Response response = dialog.connect(selector);
                            SystemIn.printLine(response.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
                System.out.println("Some problems with IO");
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }

}
