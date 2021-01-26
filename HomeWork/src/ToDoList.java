import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public ToDoList(){

    }

    ArrayList<String> todoList = new ArrayList<>();

    public void add(String task){
        todoList.add(task);
    }

    public void print(){
        for (int i = 1; i < todoList.size()+1; i++){
            System.out.println(i + ": " + todoList.get(i-1));
        }
    }

    public void remove(int number){
        todoList.remove(number-1);
    }


    public static void main(String[] args) {

        UserInterface uI = new UserInterface();
        uI.start();
    }
}

class UserInterface{

    boolean UI;
    String command;
    ToDoList list;
    Scanner scanner;

    UserInterface(){
        list = new ToDoList();
        scanner = new Scanner(System.in);
    }

    public void start(){
        UI = true;
        while (UI){
            System.out.println("Command: ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("stop")){
                UI = false;
            }
            if (command.equalsIgnoreCase("add")){
                System.out.println("To add: ");
                command = scanner.nextLine();
                list.add(command);
            }
            if (command.equalsIgnoreCase("list")){
                list.print();
            }
            if (command.equalsIgnoreCase("remove")){
                System.out.println("Which one is removed?");
                command = scanner.nextLine();
                list.remove(Integer.valueOf(command));
            }
        }
        scanner.close();
    }
}
