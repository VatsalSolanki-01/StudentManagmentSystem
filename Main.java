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
                    System.out.println("record created");
                    break;
                case 2:
                    read();
                    System.out.println("all the records");
                    break;
                case 3:
                    update();
                    System.out.println("record updated");
                    break;
                case 4:
                    delete();
                    System.out.println("record deleted");
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
        String name=sc.next();
        System.out.print("enter the rollno :- ");
        int rollno=sc.nextInt();         
        while(isRollEqual(rollno)!=false){
            System.out.println("rollno already exists, try different one");
            rollno=sc.nextInt();
        }
        System.out.print("enter the address :- ");
        String address=sc.next();
        StudentList.add(new Student(name,rollno,address));
    }

    public static void read(){
        for(int i=0;i<StudentList.size();i++){
        System.out.println("Record no. :- "+(i+1));
        System.out.println("name :- "+StudentList.get(i).name+" rollno :- "+StudentList.get(i).rollno+" address :- "+StudentList.get(i).address);
        }
    }

    public static void update(){
        System.out.println("enter the medium through which the update is to be made :- ");
        System.out.println("1. name, 2. address ");
        int mediumInput=sc.nextInt();
        switch (mediumInput) {
            case 1:
                System.out.println("enter the name of the student to get it updated :-");
                String nameInput = sc.next();
                for(int i=0;i<StudentList.size();i++){
                    if(nameInput.equals(StudentList.get(i).name)){
                        StudentList.get(i).name=sc.next();
                    }
                }
                break;
            case 2:
                System.out.println("enter the address to get it updated :- ");
                String addressInput =sc.next();
                for(int i=0;i<StudentList.size();i++){
                    if(addressInput.equals(StudentList.get(i).address)){
                        StudentList.get(i).address=sc.next();
                    }
                }
                break;
            default:
                System.out.println("choose appropriate option");
                break;
        } 
    }

    public static void delete(){
        System.out.println("enter the name of the student to be removed :- ");
        String input=sc.next();
        for(int i=0;i<StudentList.size();i++){
            if(input.equals(StudentList.get(i).name)){
                StudentList.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        menu();
    }    
}

