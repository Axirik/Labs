import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.write;
import static java.util.Locale.filter;

/*Вопрос № 1

        В каких классах пакета java.io можно вызвать метод void write(byte[] buf)?

        Вопрос № 2

        Какие значения элементов и в каком порядке будут находиться в коллекции после выполнения кода?

        List<Integer> list = new ArrayList<>();
        list.add(5); list.add(2); list.add(3); list.add(0, 4); list.add(2); list.remove(1);

        Вопрос № 3

        Что напечатает фрагмент кода, если метод delLast() удаляет последний символ?

        Stream. of("helium", "neon", "argon", "krypton", "xenon", "radon")
        filter(s -> s.length() != 7)
        .map(s -> s.delLast())
        .limit(3)
        .sorted()
        .forEachOrdered(System.out :: print);

        Вопрос № 4

        Какой функциональный интерфейс соответствует лямбда-выражению?

        (String s) -> s.toLowerCase()


 */
public class Main{
    public  static void main(String[] arg){
        List<Integer> list = new ArrayList<>();
        list.add(5); list.add(2); list.add(3); list.add(0, 4); list.add(2); list.remove(1);
        System.out.println(list);
    }
    public static String delLast(String s) {
        return s.substring(0, s.length() - 1);
    }
}