package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Node{
    String name;
    String email;
    String number;
    Node next;
    Node(String name,String email,String number){
        this.name=name;
        this.email=email;
        this.number=number;
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

    void insertFirst(String name, String email, String number) {
        Node n = new Node(name, email, number);
         if(this.head == null)
             this.head = n;
        else {
            n.next = this.head;
            this.head = n;
        }
    }
    void insertLast(String name,String email,String number){
        Node n=new Node(name,email,number);
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
    void insertAt(String name,String email,String number,int index){
        Node n=new Node(name,email,number);
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
    int search(String name)
    {
        int cnt=1;
        Node temp =this.head;
        while(temp!=null){
            if(temp.name.equals(name))
            {
                return cnt;
            }
            temp=temp.next;
            cnt++;
        }
            return -1;
    }
    void display(){
        Node temp =this.head;
        while(temp!=null){
            String s="Name--"+temp.name+"\nEmail-- "+temp.email+"\nNumber--"+temp.number;
            log.info(s);
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
        String s1="Enter the Name :";
        String s2="Enter the Email :";
        String s3="Enter the Number :";
       do{
           log.info("1.InsertFirst \n 2.InsertLast\n3.InsertAtPos\n4.RemoveFirst\n5.RemoveLast\n6.RemoveAtPos\n7.Display\n8.search by Name");
           log.info("Enter the Choice :");
           ch= sc.nextInt();
           switch (ch){
               case 1->{
                   log.info(s1);
                  String nameInsertFirst= sc.next();
                  log.info(s2);
                  String emailInsertFirst=sc.next();
                  log.info(s3);
                  String numberInsertFirst=sc.next();
                  l.insertFirst(nameInsertFirst,emailInsertFirst,numberInsertFirst);
               }
               case 2->{
                   log.info(s1);
                   String nameInsertLast= sc.next();
                   log.info(s2);
                   String emailInsertLast=sc.next();
                   log.info(s3);
                   String numberInsertLast=sc.next();
                   l.insertLast(nameInsertLast,emailInsertLast,numberInsertLast);
               }
               case 3->{
                   log.info(s1);
                   String nameInsertAt=sc.next();
                   log.info(s2);
                   String emailInsertAt= sc.next();
                   log.info(s3);
                   String numberInsertAt=sc.next();
                   log.info("Enter the Position :");
                   int index=sc.nextInt();
                   l.insertAt(nameInsertAt,emailInsertAt,numberInsertAt,index);
               }
               case 4-> l.removeFirst();
               case 5-> l.removeLast();
               case 6-> {
                   log.info("Enter the Position :");
                   int index = sc.nextInt();
                   l.removeAt(index);
               }
               case 7->
                   l.display();
               case 8->
               {
                   log.info(s1);
                   String name=sc.next();
                   int res=l.search(name);
                   if(res>0)
                   {
                       log.log(Level.INFO,()->"Element is At Position :"+res);

                   }
                   else
                   {
                       log.info("The name is not found");
                   }

               }

               default ->
                   log.info("Wrong Choice !");

           }
           }while(ch!=9);
       }

    }
