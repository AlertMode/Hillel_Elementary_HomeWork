package edu.palmirov.hillel.task_11.library;

public class Author {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(String firstName, String lastName, int birthYear) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthYear(birthYear);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(!Author.class.isAssignableFrom(obj.getClass())){
            return false;
        }
        Author other = (Author)obj;
        boolean firstName = this.firstName.equals(other.getFirstName());
        boolean lastName = this.lastName.equals(other.getLastName());
        boolean birthYear = this.birthYear == other.getBirthYear();

//        boolean firstName = (this.firstName == null) ?
//                (other.getFirstName() != null) :
//                !this.firstName.equals(other.getFirstName());
//
//        boolean lastName = (this.lastName == null) ?
//                (other.getFirstName() != null) :
//                !this.lastName.equals(other.getLastName());
//
//        boolean birthYear = this.getBirthYear() != other.getBirthYear();

        return (firstName && lastName && birthYear);
    }
}