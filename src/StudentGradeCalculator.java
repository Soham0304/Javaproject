import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int marks[]=new int[7];
        float total=0;
        for (int i=0;i<7;i++) {
            System.out.println("Enter marks of subject"+(i+1)+":");
            //String subject = sc.nextLine();
            marks[i] = sc.nextInt();
            total=total+marks[i];
        }
        sc.close();
        float avg;
        avg=total/7;
        System.out.println("Student grade is:");
        if(avg>90){
            System.out.println("A+");
        }
        else if (avg>=81 && avg<=90) {
            System.out.println("A");
        }
        else if (avg>=71 && avg<=80) {
            System.out.println("B+");
        }
        else if (avg>=61 && avg<=70) {
            System.out.println("B");
        }
        else if (avg>= 51 && avg <=60) {
            System.out.println("C+");
        } else if (avg>=41 && avg<=50) {
            System.out.println("C");
        }
        else {
            System.out.println("D");
        }
        System.out.println(avg);
        System.out.println((avg/4));
    }
}
