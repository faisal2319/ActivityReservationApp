/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation.project;

/**
 *
 * @author faisa
 */
public class Dlist {
     Node head;
    Node tail;
    int size;
   
   public Dlist(){

   }

   //Method Used to compare dates
   public int compareDate(String i1, String i2){

       int d1 = Integer.parseInt(i1.substring(0,2));
       int d2 = Integer.parseInt(i2.substring(0,2));
       int m1 = Integer.parseInt(i1.substring(2, 4));
       int m2 = Integer.parseInt(i2.substring(2, 4));
       int y1 = Integer.parseInt(i1.substring(4, 8));
       int y2 = Integer.parseInt(i2.substring(4, 8));

       if(y1 > y2){return -1;}
       else if(y1 < y2){return 1;}
       else if(m1 > m2){return -1;}
       else if(m1 < m2){return 1;}
       else if(d1 > d2){return -1;}
       else if(d1 < d2){return 1;}
       else{return 0;}

       
   }
   
   // inserts the node N in the correct position, ordered by the date
   public Node insert(Node n){
    
    //if no other node exists node is placed at the beginning 
    if(head == null){
        head = n;
        tail = n;
        head.prev = null;
        tail.next = null;
        size++;  
    }

    //if only one node exists 
    else if(head == tail){
        if(compareDate(n.vDate, head.vDate) == -1){
            head.next = n;
            n.prev = head;
            tail = n;
            size++;
        }else if(compareDate(n.vDate, head.vDate) == 0){
            head.prev = n;
            n.next= head;
            head = n;
            size++;
        }else if(compareDate(n.vDate, head.vDate) == 1){
            n.next = head;
            head.prev = n;
            head = n;
            size++;
        }
    }

    
    // if 2 or more node exists
    else if(head != tail) {
        Node temp = new Node();
        temp = head;
            if(compareDate(n.vDate, temp.vDate) == -1){
                for (int i = 0; i < size; i++) {                
                    if(compareDate(n.vDate, temp.vDate) == 1){
                       n.prev = temp.prev;
                       temp.prev.next = n;
                       n.next = temp;
                       temp.prev = n;
                    
                       size++;
                    break;
                    }else if(compareDate(n.vDate, temp.vDate) == 0){

                       n.prev = temp.prev;
                        temp.prev.next = n;
                        n.next = temp;
                        temp.prev = n;
                        
                        size++;
                        
                        break;
                    }else if(temp.next == null){
                        n.prev = temp;
                        n.next = null;
                        temp.next = n;
                        tail = n;
                        
                        size++;
                        break;
                    }
                         else{
                             
                         }
                        temp = temp.next;
                    
                    
                    
                }

            }else if(compareDate(n.vDate, temp.vDate) == 0){
                n.next = temp;
                temp.prev = n;
                head = n;
                size++;

              
            }else if(compareDate(n.vDate, temp.vDate) == 1){
                    n.next = temp;
                    temp.prev = n;
                    head = n;
                    n.prev = null;

                    size++;

                }
                
            }

        
           

            return n;  
    }
    
   
   //Remove Method: removes the first occurrence (starting from head) of a node with matching vID
    public void remove(int visID){
        
         
        Node temp;
        temp = head;
       

        for (int i = 0; i < size; i++) {
           if(visID == temp.vID){
                if(head == temp){
                head = temp.next;
                temp.next.prev = null;
                size--;
                break;
            }else if(temp != head && temp != tail){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
                break;
            }else if(temp == tail){
                tail = temp.prev;
                temp.prev.next = null;
                size--;
                break;
            }
                
                
            }
            
        }
       
    }


    //This method searches for all Nodes with dID and computes the amount of money earned of ALL visits for a facility with fID. The return value is rounded off
    public int earning(int fID){
        Node temp = new Node();
        temp = head;
        int sum = 0;

       
        if(fID == 1){
            for (int i = 0; i < size; i++) {
                if(temp.fID == 1){
                    if(Integer.parseInt(temp.vDate.substring(0,2)) == 07 || Integer.parseInt(temp.vDate.substring(0,2)) == 14 ||Integer.parseInt(temp.vDate.substring(0,2)) == 21 ||Integer.parseInt(temp.vDate.substring(0,2)) == 28){
                        sum += 250;
                    }else if(Integer.parseInt(temp.vDate.substring(0,4)) == 2202 ||Integer.parseInt(temp.vDate.substring(0,4)) == 2309 ){
                        sum += 100;
                    }else{
                        sum += 200;
                    }
                }
                temp = temp.next;
            }
            
        }
        
        else if(fID == 2){
            for (int i = 0; i < size; i++) {
                if(temp.fID == 2){
                    if(Integer.parseInt(temp.vDate.substring(0,2)) == 07 || Integer.parseInt(temp.vDate.substring(0,2)) == 14 ||Integer.parseInt(temp.vDate.substring(0,2)) == 21 ||Integer.parseInt(temp.vDate.substring(0,2)) == 28){
                        sum += 150;
                    }else if(Integer.parseInt(temp.vDate.substring(0,4)) == 2202 ||Integer.parseInt(temp.vDate.substring(0,4)) == 2309 ){
                        sum += 50;
                    }else{
                        sum += 100;
                    }
                }
                temp = temp.next;
            }
            
        }
        
       
        else if(fID == 3){
            for (int i = 0; i < size; i++) {
                if(temp.fID == 3){
                    if(Integer.parseInt(temp.vDate.substring(0,2)) == 07 || Integer.parseInt(temp.vDate.substring(0,2)) == 14 ||Integer.parseInt(temp.vDate.substring(0,2)) == 21 ||Integer.parseInt(temp.vDate.substring(0,2)) == 28){
                        sum += 50;
                    }else if(Integer.parseInt(temp.vDate.substring(0,4)) == 2202 ||Integer.parseInt(temp.vDate.substring(0,4)) == 2309 ){
                        sum += 15;
                    }else{
                        sum += 30;
                    }
                }
                temp = temp.next;
            }
            
        }
        
        else if(fID == 4){
            for (int i = 0; i < size; i++) {
                if(temp.fID == 4){
                    if(Integer.parseInt(temp.vDate.substring(0,2)) == 07 || Integer.parseInt(temp.vDate.substring(0,2)) == 14 ||Integer.parseInt(temp.vDate.substring(0,2)) == 21 ||Integer.parseInt(temp.vDate.substring(0,2)) == 28){
                        sum += 50;
                    }else if(Integer.parseInt(temp.vDate.substring(0,4)) == 2202 ||Integer.parseInt(temp.vDate.substring(0,4)) == 2309 ){
                        sum += 15;
                    }else{
                        sum += 30;
                    }
                }
                temp = temp.next;
            }

        }
        
       
        else if(fID == 5){
            for (int i = 0; i < size; i++) {
                if(temp.fID == 5){
                    if(Integer.parseInt(temp.vDate.substring(0,2)) == 07 || Integer.parseInt(temp.vDate.substring(0,2)) == 14 ||Integer.parseInt(temp.vDate.substring(0,2)) == 21 ||Integer.parseInt(temp.vDate.substring(0,2)) == 28){
                        sum += 100;
                    }else if(Integer.parseInt(temp.vDate.substring(0,4)) == 2202 ||Integer.parseInt(temp.vDate.substring(0,4)) == 2309 ){
                        sum += 25;
                    }
                    else{
                        sum += 50;
                    }
                }
                temp = temp.next;
            }
        }


        return sum;
    }


    //searches for vID in the list. Prints ALL nodes with vID
    public void print1(int VID){
        Node temp = new Node();
        temp = head;
        for (int i = 0; i < size; i++) {
            if(temp.vID == VID){
                System.out.println(temp);
            }
            temp = temp.next;
        }

    }

    //searches for vDate in the list. Prints ALL nodes with vDate.
    public void print2(String vDate){
        Node temp = new Node();
        temp = head;
    
        for (int i = 0; i < size; i++) {
            if(compareDate(vDate, temp.vDate) == 0){
                System.out.println(temp);
            }
            temp = temp.next;
        }
    }

//searches for fID in the list. Prints ALL nodes with FID.
    public void print3(int ID){
        Node temp = new Node();
        temp = head;
        for (int i = 0; i < size; i++) {
            if(temp.fID == ID){
                System.out.println(temp);
            }
            temp = temp.next;
        }

    }

    
    //searches for ticketID in the list. Prints ONE node with ticketID.
    public void print4(int tID){
        Node temp = new Node();
        temp = head;
        for (int i = 0; i < size; i++) {
            if(temp.ticketID == tID){
                System.out.println(temp);
            }

            temp = temp.next;
        } 
    }


 

 

  
}

