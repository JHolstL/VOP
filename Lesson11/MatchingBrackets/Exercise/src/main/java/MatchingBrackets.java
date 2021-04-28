import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author erso
 */
public class MatchingBrackets {

    // Elements of code are commented out because they belong to the stack method. New implementation is with ArrayList and method i created myself
    public boolean ckeckBrackets(String expression) {
        //Stack<Character> brackets = new Stack<>();

        List<Character> brackets = new ArrayList<>();

        char character;
        for(int i = 0; i<expression.length(); i++){
            character = expression.charAt(i);

            if(character == '{')
                //brackets.push(character);
                push(character, brackets);

            if(character == '(')
                //brackets.push(character);
                push(character, brackets);

            if(character == '[')
                //brackets.push(character);
                push(character, brackets);

            if(character == '}'){
                if(brackets.isEmpty())
                    return false;
                //else if(brackets.peek() == '{')
                else if(brackets.contains('{'))
                    //brackets.pop();
                    pop(brackets);
            }else if(character == ')'){
                if(brackets.isEmpty())
                    return false;
                //else if(brackets.peek() == '(')
                else if(brackets.contains('('))
                    //brackets.pop();
                    pop(brackets);
            }else if(character == ']') {
                if (brackets.isEmpty())
                    return false;
                    //else if(brackets.peek() == '[')
                else if (brackets.contains('['))
                    //brackets.pop();
                    pop(brackets);
            }
            System.out.println(brackets);
        }

        return brackets.isEmpty();
    }

    public void push(Character item, List<Character> list){
        if(list.size()==0){
            list.add(0, item);
        } else{
            list.add(list.size(), item);
        }

    }

    public Character pop(List<Character> list){
        char value;

        value = list.get(list.size()-1);
        list.remove(list.size()-1);

        return value;
    }

    public Character peek(List<Character> list){
        char value;
        if(list.size()==0){
            value = list.get(list.size());
        } else{
            value = list.get(list.size()-1);
        }

        return value;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchingBrackets pc = new MatchingBrackets();

        Scanner scanner = null;
        File file = new File("C:\\Users\\Holst\\OneDrive\\Documents\\Diplomingeniør i softwareteknologi\\2. Semester\\VOP programmering\\OpgaverOgForberedelse\\exercises\\Lesson11\\MatchingBrackets\\Exercise\\src\\main\\java\\test.txt");

        try{
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String result = scanner.nextLine();
                boolean b = pc.ckeckBrackets(result);
                System.out.println(result + " has balanced brackets: " + b);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        /*do {
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            expression = in.nextLine();
            if (!expression.equalsIgnoreCase("q")) {
                boolean b = pc.ckeckBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        } while (!expression.equalsIgnoreCase("q")); */
    }
}
