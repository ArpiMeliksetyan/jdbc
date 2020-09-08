package am.basic.jdbcStart.model;


import java.util.Objects;

public class Card {
    private int id;
    private String name;
    private String surname;
    private  int cvv;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id &&
                cvv == card.cvv &&
                Objects.equals(name, card.name) &&
                Objects.equals(surname, card.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, cvv);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}
