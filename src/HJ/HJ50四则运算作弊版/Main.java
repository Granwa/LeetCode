package HJ.HJ50四则运算作弊版;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScriptException {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input = input.replace("[","(");
        input = input.replace("{","(");
        input = input.replace("}",")");
        input = input.replace("]",")");

        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
        System.out.println(nashorn.eval(input));
    }
}
