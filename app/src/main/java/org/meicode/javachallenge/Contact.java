package org.meicode.javachallenge;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String email;
    private int number;
    private ArrayList<Message> messages;

    public Contact(String name, String email, int number, ArrayList<Message> messages) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.messages = messages;
    }

    public Contact(String name, String email, int number) {
        this.name = name;
        this.email = email;
        this.number = number;
        messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public void showDetails () {
        System.out.println("Name: " + this.name + "\n" +
                "Email: " + this.email + "\n" +
                "Number: " + this.number + "\n");
    }
}
