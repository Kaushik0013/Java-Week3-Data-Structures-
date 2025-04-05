class StudentNode{
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age=age;
        this.grade=grade;
        this.next = null;
    }
}

class StudentList{
    StudentNode head;

    void addAtEnd(int rollNumber, String name, int age, char grade){
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if(head==null){
            head = newNode;
        }
        else{
            StudentNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next =newNode;
        }
    }

    void deleteByRollNumber(int rollNumber){
        if(head==null) return;

        if(head.rollNumber == rollNumber){
            head = head.next;
            return;
        }

        StudentNode temp= head;
        while(temp.next != null & temp.next.rollNumber != rollNumber){
            temp = temp.next;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
        }
    }

    void searchByRollNumber(int rollNumber){
        StudentNode temp = head;
        while(temp!=null){
            if(temp.rollNumber == rollNumber){
                System.out.println("Found: "+ temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void updateGrade(int rollNumber, char newGrade){
        StudentNode temp = head;

        while(temp!=null){
            if(temp.rollNumber == rollNumber){
                temp.grade = newGrade;
                System.out.println("grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void displayAll(){
        StudentNode temp =head;
        while(temp!= null){
            System.out.println("Roll No: "+temp.rollNumber + ",Name: "+temp.name + ",Age: "+ temp.age+ ",Grade: "+temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentMain {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.addAtEnd(1, "Asha", 20, 'A');
        list.addAtEnd(2, "Kiran", 21, 'B');
        list.displayAll();
        list.updateGrade(2, 'A');
        list.deleteByRollNumber(1);
        list.searchByRollNumber(2);
        list.displayAll();
    }
}
