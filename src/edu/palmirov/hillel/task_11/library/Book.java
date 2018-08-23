package edu.palmirov.hillel.task_11.library;

public class Book {
    private String title;
    private int page;
    private Author author;

    public Book(String title, int page, Author author) {
        setTitle(title);
        setPage(page);
        setAuthor(author);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPage(int page){
        this.page = page;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public String getTitle(){
        return this.title;
    }

    public int getPage() {
        return this.page;
    }

    public Author getAuthor() {
        return this.author;
    }

    //Returns the 'boolean' result after having compared the input object with the current one.
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(!Book.class.isAssignableFrom(obj.getClass())){
            return false;
        }
        final Book other = (Book)obj;
        boolean title = this.getTitle().equals(other.getTitle());
        boolean page = this.page == other.getPage();
        boolean author = this.author.equals(other.getAuthor());

//        boolean title = (this.title == null) ?
//                (other.getTitle() != null) :
//                !this.getTitle().equals(other.getTitle());
//
//        boolean page = this.page != other.getPage();
//
//        boolean author = this.getAuthor().equals(other.getAuthor());

        return (title && page && author);
    }
}