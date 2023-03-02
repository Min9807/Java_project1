import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        int count = 1;
        while(true){
            System.out.printf("명령) ");
            String qt = sc.next();
            if(qt.equals("등록")){
                System.out.printf("명언 : ");
                String talking = sc.next();
                System.out.printf("작가 : ");
                String author = sc.next();
                new book(count, talking, author);
                System.out.println(count + "번 명언이 등록되었습니다.");
                count++;
            }
            else if (qt.equals("종료")) {
                break;
            }


        }
        sc.close();
    }
}
class book{
    private int id;
    private String talking;
    private String author;

    public book(int id, String talking, String author){
        this.id = id;
        this.talking = talking;
        this.author = author;
    }
}