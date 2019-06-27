package org.meicode.javachallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming");
        initOptions();
    }

    private static void initOptions() {
        scanner = new Scanner(System.in);
        System.out.println("1. Manage contacts\n" +
                "2. Send a message\n" +
                "3. Quit");
        int initialChoice = scanner.nextInt();
        switch (initialChoice) {
            case 1:
                manageContacts();
                break;
            case 2:
                sendMessage();
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    private static void manageContacts() {
        System.out.println("1. Show all contacts\n" +
                "2. Add new contact\n" +
                "3. Search for a contact\n" +
                "4. Remove a contact\n" +
                "5. Go back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                removeContact();
                break;
            case 5:
                initOptions();
                break;
            default:
                initOptions();
                break;
        }
    }

    private static void showAllContacts () {
        for (Contact contact: contacts) {
            contact.showDetails();
            System.out.println("***********");
        }

        initOptions();
    }

    private static void addNewContact() {
        System.out.println("Enter contact's name: ");
        String name = scanner.next();
        System.out.println("Enter contact's number: ");
        int number = scanner.nextInt();
        System.out.println("Enter contact's email");
        String email = scanner.next();
        Contact newContact = new Contact(name, email, number);
        contacts.add(newContact);
        initOptions();
    }

    private static void searchForContact() {
        System.out.println("Who are you looking for?");
        String contactName = scanner.next();

        boolean doesExist = false;

        for (int i=0; i<contacts.size(); i++) {
            if (contacts.get(i).getName().equals(contactName)) {
                contacts.get(i).showDetails();
                initOptions();
                doesExist = true;
            }
        }

        if (!doesExist) {
            System.out.println("There is no contact named " + contactName + " saved on this device.");
            initOptions();
        }
    }

    private static void removeContact() {
        System.out.println("Enter the contact's name:");
        String contactName = scanner.next();

        boolean doesExist = false;

        for (Contact contact: contacts) {
            if (contact.getName().equals(contactName)) {

                doesExist = true;
                System.out.println("Are you sure you want to remove " + contact.getName() + "? (Y/N)");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("y")) {
                    contacts.remove(contact);
                    System.out.println(contactName + " has been removed successfully");
                    initOptions();
                }else if (answer.equalsIgnoreCase("n")) {
                    initOptions();
                }else {
                    initOptions();
                }
            }
        }

        if (!doesExist) {
            System.out.println("There is no such contact");
            initOptions();
        }
    }

    private static void sendMessage() {
        System.out.println("Who are you going to send the message?");
        String contactName = scanner.next();

        boolean doesExist = false;

        for (Contact contact: contacts) {
            if (contact.getName().equals(contactName)) {
                doesExist = true;
                System.out.println("What are you going to send?");
                String text = scanner.next();
                id++;
                Message newMessage = new Message(text, contact.getName(), id);
                ArrayList<Message> messages = contact.getMessages();
                messages.add(newMessage);
                contact.setMessages(messages);
                Contact newContact = contact;
                contacts.remove(contact);
                contacts.add(newContact);
                System.out.println("Message " + newMessage.getText() + " has been sent to " + newMessage.getReceiver());
                initOptions();
            }
        }

        if (!doesExist) {
            System.out.println("There is no such contact");
            initOptions();
        }
    }
}
