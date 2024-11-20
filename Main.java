import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> StudentList = new ArrayList<>();

    public static void menu(){
        loop: while(true){
            System.out.println("****************************************");
            System.out.println("1 - Create new Student record :- ");
            System.out.println("2 - Read student record :- ");
            System.out.println("3 - Update the record :- ");
            System.out.println("4 - Delete the record :-  ");
            System.out.println("5 - Exit");
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
                    break loop;
                default:
                    System.out.println("no other options choose any one from above given");
                    break;
            }
        }
    }

    public static boolean isRollEqual(int rollno){
        boolean result=false;
        for(int i=0;i<StudentList.size();i++){
            if(rollno==StudentList.get(i).rollno){
                result = true;
            }
            else{
                result = false;
            }
        }
        return result;
    }
    
    public static void create(){
        System.out.print("enter the name of the student :- ");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.print("enter the rollno :- ");
        int rollno=sc.nextInt();         
        while(isRollEqual(rollno)!=false){
            System.out.println("rollno already exists, try different one");
            rollno=sc.nextInt();
        }
        sc.nextLine();
        System.out.print("enter address :- ");
        String address=sc.nextLine();
        StudentList.add(new Student(name,rollno,address));
    }

    public static void read(){ // with searching algorithm and implementing where clause 
        for(int i=0;i<StudentList.size();i++){
        System.out.println("Record no. :- "+(i+1));
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("                   | Name :- "+StudentList.get(i).name+", Rollno :- "+StudentList.get(i).rollno+", Address :- "+StudentList.get(i).address+"|");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
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

