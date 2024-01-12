package Chapter10.SecureCoding.bPreventInjection;

import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InvalidInput {
    public static void readName() throws Exception{
        Console console = System.console();
        String dirName = console.readLine();
        Path path = Paths.get("c:/data/diets/" + dirName);
        try (Stream<Path> stream = Files.walk(path)) {
            stream.filter(p -> p.toString().endsWith(".txt"))
                    .forEach(System.out::println);
        }
    }

    //use whitelist
    public static void readName2() throws Exception{
        Console console = System.console();
        String dirName = console.readLine();
        if (dirName.equals("mammal") || dirName.equals("birds")) {
            Path path = Paths.get("c:/data/diets/" + dirName);
            try (Stream<Path> stream = Files.walk(path)) {
                stream.filter(p -> p.toString().endsWith(".txt"))
                        .forEach(System.out::println);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //dirName = mammals
        readName(); //output> c:/data/diets/mammals/Platypus.txt

        //dirName = .. => hacker
        readName();
        //output> c:/data/diets/../secrets/giraffeDueDate.txt
    }

    /**
     * A blacklist is a list of things that aren't allowed
     * The whitelist is specifying what is allowed
     * Whitelisting is preferable to blacklisting for security because a whitelist doesn't need to foresee every
     * possible problem.
     * */
}
