public class Student{
    String name;
    Integer rollno;
    String address;

    Student(String name,Integer rollno,String address){
        this.name=name;
        this.rollno=rollno;
        this.address=address;
    }

    public Integer getRollno(){
        return this.rollno;
    }
    void getInfo(){
        System.out.println(this.name);
        System.out.println(this.rollno);
        System.out.println(this.address);
    }
}