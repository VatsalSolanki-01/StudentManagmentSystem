import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> StudentList = new ArrayList<>();

    public static void sortRollno(){
        Collections.sort(StudentList,(o1,o2) -> o1.getRollno().compareTo(o2.getRollno()));
    }
    
    public static void menu(){
        loop: while(true){
            System.out.println("****************************************");
            System.out.println("1 - CREATE A NEW STUDENT RECORD :- ");
            System.out.println("2 - READ ALL THE STUDENTS RECORDS :- ");
            System.out.println("3 - UPDATE ANY RECORD :- ");
            System.out.println("4 - DELETE ANY RECORD :-  ");
            System.out.println("5 - SEARCH RECORD WITH NAME :-  ");
            System.out.println("6 - SEARCH RECORD WITH THE LIMIT OF ROLLNO :- ");
            System.out.println("7 - EXIT ");
            System.out.println("****************************************");
           
            int input = sc.nextInt();
           
            switch(input){
                case 1:
                    create();
                    System.out.println("A new record got created");
                    break;
                case 2:
                    if(StudentList.isEmpty()){
                        System.out.println("no records found, create new records");
                    }
                    read();
                    break;
                case 3:
                    if(StudentList.isEmpty()){
                        System.out.println("no records found, create new records");
                    }
                    else{
                    update();
                    System.out.println("record got updated");
                    }
                    break;
                case 4:
                    if(StudentList.isEmpty()){
                        System.out.println("no records found, create new records");
                    }
                    delete();
                    System.out.println("record got deleted");
                    break;
                case 5:
                    if(StudentList.isEmpty()){
                        System.out.println("no records found, create new records");
                    }
                    else{
                        readByName();
                    }
                    break;
                case 6:
                    if(StudentList.isEmpty()){
                        System.out.println("no records found, create new records");
                    }
                    else{
                        System.out.println("enter the rollno to get records till that rollno :- ");
                        int rollno=sc.nextInt();
                        readByRoll(rollno);
                    }
                    break;
                case 7:
                    break loop;
                default:
                    System.out.println("no other options choose any one from above given");
                    break;
            }
        }
    }

    public static boolean doesRollExists(int rollno){
        boolean result=false;
        if(StudentList.isEmpty()){
            result=false;
        }
        for(int i=0;i<StudentList.size();i++){
            if(rollno==StudentList.get(i).rollno){
                result = true;
                break;
            }
            result =false;
        }
        return result;
    }
    
    public static void create(){
        System.out.print("enter the name of the student :- ");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.print("enter the rollno :- ");
        int rollno=sc.nextInt();         
        while(doesRollExists(rollno)!=false){
            System.out.println("rollno already exists, try different one");
            rollno=sc.nextInt();
        }
        sc.nextLine();
        System.out.print("enter address :- ");
        String address=sc.nextLine();
        StudentList.add(new Student(name,rollno,address));
        sortRollno();
    }

    public static void read(){ 
        for(int i=0;i<StudentList.size();i++){
        System.out.println("Record no. :- "+(i+1));
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("                   | Name :- "+StudentList.get(i).name+", Rollno :- "+StudentList.get(i).rollno+", Address :- "+StudentList.get(i).address+"|");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
        }
    }

    public static void readByRoll(int rollno){
        if(rollno<=StudentList.size()){
            for(int i=0;i<rollno;i++){
                System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
                System.out.println("                   | Name :- "+StudentList.get(i).name+", Rollno :- "+StudentList.get(i).rollno+", Address :- "+StudentList.get(i).address+"|");
                System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            }
        }else{
            read();
        }
    }

    public static void readByName(){
        sc.nextLine();
            System.out.println("enter the name of student to be searched :- ");
            String name=sc.nextLine();
        for(int i=0;i< StudentList.size();i++){
            if(name.equals(StudentList.get(i).name)){
                System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
                System.out.println("                   | Name :- "+StudentList.get(i).name+", Rollno :- "+StudentList.get(i).rollno+", Address :- "+StudentList.get(i).address+"|");
                System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            }
        }
    }

    public static void update(){     
       System.out.println("enter the rollno of the student to update his/her information :- ");
       Integer input = sc.nextInt();
       for(int i =0;i<StudentList.size();i++){
        if(input.equals(StudentList.get(i).rollno)){
            System.out.println("enter 1 if name updation and 2 for address updation :- ");
            int selection =sc.nextInt();
            switch(selection){
                case 1: 
                sc.nextLine();
                System.out.println("enter new name :- ");
                String newName =sc.nextLine();
                StudentList.get(i).name=newName;
                break;

                case 2:
                sc.nextLine();
                System.out.println("enter new address :- ");
                String newAddress = sc.nextLine();
                StudentList.get(i).address=newAddress;
                break;

                default :
                    System.out.println("enter valid input");
                    break;
            }
            
        }
       } 
    }

    public static void delete(){ 
        System.out.println("enter the rollno of the student to be removed :- ");
        Integer input=sc.nextInt();
        for(int i=0;i<StudentList.size();i++){
            if(input.equals(StudentList.get(i).rollno)){
                StudentList.remove(i);
            }
        }
    }
   
    public static void main(String[] args) {
        menu();
    }    
}

