package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Node{
    String name;
    String Email;
    String Number;
    Node next;
    Node(String name,String Email,String number){
        this.name=name;
        this.Email=Email;
        this.Number=number;
        this.next=null;
    }
}
class LinkedList {
    Logger log= Logger.getLogger("Contact");

    Node head;
    int size;

    LinkedList() {
        this.head = null;
        this.size = 0;
    }

    void insertFirst(String name, String Email, String number) {
        Node n = new Node(name, Email, number);
        if (this.head == null) {
            this.head = n;
        } else {
            n.next = this.head;
            this.head = n;
        }
    }
    void insertlast(String name,String Email,String Number){
        Node n=new Node(name,Email,Number);
        Node temp;
        if (this.head == null) {
            this.head = n;
        }
        else
        {
            temp=this.head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
            this.size++;
        }
    }
    void insertat(String name,String Email,String number,int index){
        Node n=new Node(name,Email,number);
        Node temp=this.head;
        for (int i=1;i<index;i++){
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
    }
    void removeFirst(){
        Node temp=this.head;
        this.head=temp.next;
    }
    void removeLast(){
        Node temp=this.head;
        Node prev=temp;
        while (temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
    }
    void removeAt(int index){
        Node temp=this.head;
        Node prev=temp;
        for (int i=0;i<index;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
    }
    void Display(){
        Node temp =this.head;
        while(temp!=null){
            log.info(temp.name+""+temp.Email+""+temp.Number);
            temp=temp.next;
        }
    }
}
public class Contact {
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        Scanner sc=new Scanner(System.in);
        Logger log= Logger.getLogger("Contact");
        int ch;
       do{
           log.info("1.InsertFirst \n 2.InsertLast\n3.InsertAtPos\n4.RemoveFirst\n5.RemoveLast\n6.RemoveAtPos\n7.Display");
           log.info("Enter the Choice :");
           ch= sc.nextInt();
           switch (ch){
               case 1->{
                   log.info("Enter the Name :");
                  String name= sc.next();
                  log.info("Enter the Email :");
                  String Email=sc.next();
                  log.info("Enter the Number :");
                  String number=sc.next();
                  l.insertFirst(name,Email,number);
               }
               case 2->{
                   log.info("Enter the Name :");
                   String name= sc.next();
                   log.info("Enter the Email :");
                   String Email=sc.next();
                   log.info("Enter the Number :");
                   String number=sc.next();
                   l.insertlast(name,Email,number);
               }
               case 3->{
                   log.info("Enter the Name :");
                   String name=sc.next();
                   log.info("Enter the Email :");
                   String Email= sc.next();
                   log.info("Enter the Number :");
                   String number=sc.next();
                   log.info("Enter the Position :");
                   int index=sc.nextInt();
                   l.insertat(name,Email,number,index);
               }
               case 4-> l.removeFirst();
               case 5-> l.removeLast();
               case 6-> {
                   log.info("Enter the Position :");
                   int index = sc.nextInt();
                   l.removeAt(index);
               }
               case 7->
                   l.Display();
               default ->
                   log.info("Wrong Choice !");

           }
           }while(ch!=8);
       }

    }
