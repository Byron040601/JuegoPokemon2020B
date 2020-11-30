package Game;

//Byron Huaraca
//Jorge Alaba
//Bernabé Dávila 
//Karen Hurtado

import javafx.beans.property.SimpleStringProperty;
//Persona cuenta con atributos; nombre, apellido, identificacion, usuario, id y victorias

public class Person {

    private final SimpleStringProperty name;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty identification;
    private final SimpleStringProperty user;
    private int id;
    private int victories;
//Datos de la persona
    public Person(int id, String name, String lastName, String identification, String user, int victories) {
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.identification = new SimpleStringProperty(identification);
        this.user = new SimpleStringProperty(user);
        this.id = id;
        this.victories = victories;
    }


// Getter y Setter calse Peron

    public void victories() {
        this.victories += 1;
    }

    public String getName() {
        return name.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getIdentification() {
        return identification.get();
    }

    public String getUser() {
        return user.get();
    }

    public int getId() {
        return id;
    }

    public int getVictories() {
        return victories;
    }

}
