import java.util.ArrayList;
import java.util.Arrays;
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

            // 명언 등록
            if(qt.equals("등록")){
                System.out.print("명언 : ");
                String talking = sc.next().trim();
                System.out.print("작가 : ");
                String author = sc.next().trim();
                book newbook = new book(count, talking, author);
                System.out.println(count + "번 명언이 등록되었습니다.");
                bookArrayList.add(newbook);
                count++;
            }

            // 목록 출력
            else if(qt.equals("목록")){
                System.out.println("번호 / 작가 / 명언 ");
                System.out.println("------------------");
                for(book newbook : bookArrayList){
                    System.out.println(newbook.getId() + " / " + newbook.getAuthor() + " / " + newbook.getTalking());
                }
            }

            // 삭제
            else if(qt.contains("삭제")){
                String findId = qt.split("=")[1];
                int deleteId = Integer.parseInt(findId);
                int[] findInt = new int[bookArrayList.size()];
                int countnewbook = 0;
                for(book newbook : bookArrayList){
                    findInt[countnewbook] = newbook.getId();
                    countnewbook++;
                }
                int a = 0;

                for(int id : findInt){
                    if(id == deleteId){
                        a++;
                    }
                    if(a==0){
                        System.out.println(deleteId +"번 명언은 존재하지 않습니다.");
                    }
                }

                for(book newbook : bookArrayList){
                    if(newbook.getId() == deleteId){
                        bookArrayList.remove(newbook);
                        System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                    }
                }
            }

            // 수정
            else if(qt.contains("수정")){
                String findId = qt.split("=")[1];
                int modifyId = Integer.parseInt(findId);

                for(book modifyBook : bookArrayList){
                    if(modifyBook.getId() == modifyId){
                        System.out.println("명언(기존) : " + modifyBook.getTalking());
                        System.out.print("명언 : ");
                        String newTalking = sc.next();
                        modifyBook.setTalking(newTalking);

                        System.out.println("작가(기존) : " + modifyBook.getAuthor());
                        System.out.print("작가 : ");
                        String newAuthor = sc.next();
                        modifyBook.setAuthor(newAuthor);
                    }
                }
            }

            // app 종료
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

    ArrayList<book> bookArrayList = new ArrayList<>();

    public book(int id, String talking, String author){
        this.id = id;
        this.talking = talking;
        this.author = author;

    }

    boolean deleteBook(int id){
        System.out.println(id + "번 명언이 삭제되었습니다.");
        return true;
    }

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
}