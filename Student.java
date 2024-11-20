public class Student{
    String name;
    int rollno;
    String address;

    Student(String name,int rollno,String address){
        this.name=name;
        this.rollno=rollno;
        this.address=address;
    }
    void getInfo(){
        System.out.println(this.name);
        System.out.println(this.rollno);
        System.out.println(this.address);
    }
}