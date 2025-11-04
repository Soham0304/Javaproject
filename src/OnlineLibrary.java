class Library1{
    int book=10;
    private String name_book;

    public void setName_book(String b1){
        name_book=b1;
    }
    public String getName_book(){
        return name_book;
    }
    public void issuedBook(){
        System.out.println("The issued book is:"+book);
        book++;
    }
    public void addedBook(){
        System.out.println("The added book is:"+book);
        book++;
    }
    public void showAvailableBook(){
        System.out.println("The available books are:"+book++);
        book++;
    }
}
public class OnlineLibrary {
    public static void main(String[] args) {
        Library1 l =new Library1();
        l.setName_book("wings of fire");
        System.out.println(l.getName_book());
        l.issuedBook();
        l.setName_book("Hello");
        System.out.println(l.getName_book());
        l.addedBook();
        l.setName_book("Good");
        System.out.println(l.getName_book());
        l.showAvailableBook();
    }
}
