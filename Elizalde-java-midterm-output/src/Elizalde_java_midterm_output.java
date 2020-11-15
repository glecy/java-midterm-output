import java.util.Scanner;
import java.util.ArrayList;
public class Elizalde_java_midterm_output {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<ArrayList<String>> entryList = new ArrayList();
    static String enterName(){
        boolean inList=true;
        do{
            System.out.print("Name: ");
            String name = input.nextLine();
            if(entryList.get(0).contains(name)){
                System.out.println(name+" is already in the list.");
            }
            else return name;           
        }
        while(inList);
        return null;
    }
    static String enterAge(){
        boolean isValidInteger = false;
        do{
            System.out.print("Age: ");
            String age = input.nextLine();
            try{
                Integer.parseInt(age);
                return age;
            }
            catch (NumberFormatException ex){
                System.out.println("Not a Number!");
            }
        }
        while(!isValidInteger);
        return null;
    }
    static void delEntry(){
        System.out.println("======Delete Entry======");
        System.out.print("Enter Name to Delete: ");
        String toDel = input.nextLine();
        boolean inList = entryList.get(0).contains(toDel);
        if(inList){
                int i = entryList.get(0).indexOf(toDel);
                entryList.get(0).remove(i);
                entryList.get(1).remove(i);
                System.out.println(toDel+" has been deleted!");
        }
        if(!inList)System.out.println("No "+toDel+" in the list");
    }
    static void allEntries(){
        System.out.println("=======View all Entries======");
        for(int i=0; i<entryList.get(0).size(); i++){
            System.out.println(entryList.get(0).get(i)+" is "+entryList.get(1).get(i));
        }
        if(entryList.get(0).isEmpty())System.out.println("List is Empty.");
    }
    static void updEntry(){
        System.out.println("======Update an Entry======");
        System.out.print("Enter Name to Update: ");
        String toRep = input.nextLine();
        boolean inList=entryList.get(0).contains(toRep);
        if(inList){
            int i = entryList.get(0).indexOf(toRep);
            entryList.get(0).set(i, " ");
            System.out.println("Enter New Info:");
            entryList.get(0).set(i, enterName());
            entryList.get(1).set(i, enterAge());
        }
        if(!inList)System.out.println("No "+toRep+" in the list");
    }
    public static void main(String[] args){
        ArrayList<String> nameList = new ArrayList();
        ArrayList<String> ageList = new ArrayList();
        entryList.add(nameList);
        entryList.add(ageList);
        boolean loop=true;
        do{
            System.out.println("=======Options========");
            System.out.println("1 - Add entry");
            System.out.println("2 - Delete entry");
            System.out.println("3 - View all entries");
            System.out.println("4 - Update an entry");
            System.out.println("0 - Exit");
            System.out.print("Select an Option: ");
            String option = input.nextLine();
            try{
                switch(Integer.parseInt(option)){
                case 1:
                    System.out.println("=======Add Entry========");
                    System.out.println("Enter Info:");
                    entryList.get(0).add(enterName());
                    entryList.get(1).add(enterAge());
                    break;
                case 2:
                    delEntry();
                    break;
                case 3:
                    allEntries();
                    break;
                case 4:
                    updEntry();
                    break;
                case 0:
                    loop=false;
                    break;
                default:
                    System.out.println("Not an Option!");
                    break;
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Not a Option!");
            }
        }
        while(loop);
    }
}
