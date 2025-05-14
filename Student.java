public class Student {
    private int marks;

    public Student(int marks) {
        this.marks=marks;
        // TODO: Assign 'marks' to the instance variable 'this.marks'
    }

    public char assignGrade() {
       if(marks<0||marks>100)
         return 'X';
       else if(marks>=90)
         return 'A';
       else if(marks>=80)
         return 'B';
       else if(marks>=70)
         return 'C';
       else if(marks>=60)
         return 'D';
       else if(marks>=50)
         return 'E';
       else
         return 'F';
    }
}