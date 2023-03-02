import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        int count = 1;
        ArrayList<book> bookArrayList = new ArrayList<>();
        while(true){
            System.out.printf("명령) ");
            String qt = sc.next();
            if(qt.equals("등록")){
                System.out.printf("명언 : ");
                String talking = sc.next();
                System.out.printf("작가 : ");
                String author = sc.next();
                book newbook = new book(count, talking, author);
                System.out.println(count + "번 명언이 등록되었습니다.");
                bookArrayList.add(newbook);
                count++;
            }
            else if(qt.equals("목록")){
                System.out.println("번호 / 작가 / 명언 ");
                System.out.println("------------------");
                for(book newbook : bookArrayList){
                    System.out.println(newbook.getId() + " / " + newbook.getAuthor() + " / " + newbook.getTalking());
                }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTalking() {
        return talking;
    }

    public void setTalking(String talking) {
        this.talking = talking;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public book(int id, String talking, String author){
        this.id = id;
        this.talking = talking;
        this.author = author;
    }
}