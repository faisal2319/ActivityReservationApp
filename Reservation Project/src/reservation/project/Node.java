/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation.project;

/**
 *
 * @author faisa
 */
class Node{
    int ticketID;
    int vID;
    String vDate;
    int fID;
    String vName;
    Node next;
    Node prev;
    

    public Node(){
    }

    public Node(int t, int vi, String d, int fi, String n){
        ticketID = t;
        vID = vi;
        vDate = d;
        fID = fi;
        vName = n;
    }

    public String toString(){
        return ticketID + " " + vID + " " + vDate + " " +  fID + "" + vName;
    }
}
