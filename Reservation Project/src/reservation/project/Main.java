/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation.project;
import java.util.Scanner;
/**
 *
 * @author faisa
 */
public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dlist n = new Dlist();
        
      
        
        while(true){
            String str = sc.nextLine();
            if(str.length() == 0){
                break;
            }
            int c = Integer.parseInt("" + str.charAt(0));
            Scanner in = new Scanner(str);
            switch(c){
                case 1:
                    in.nextInt();
                    int t = in.nextInt();
                    int v = in.nextInt();
                    String date = in.next();
                    int fid = in.nextInt();
                    String N = in.nextLine();
                    Node n1 = new Node(t, v, date, fid, N);
                    n.insert(n1);
                    
                    
                    break;

                    case 2:
                    
                    in.nextInt();
                    int vID = in.nextInt();
                    n.remove(vID);
                    
                    break;

                    case 3:
                    in.nextInt();
                    int FacilityID = in.nextInt();
                    System.out.println(n.earning(FacilityID));
                    
                    break;

                    case 4:
                   
                    in.nextInt();
                    int visitorID = in.nextInt();;
                    n.print1(visitorID);
                    
                    break;

                    case 5:
                    
                    in.nextInt();
                    String visitDate = in.next();
                    n.print2(visitDate);
                   
                    break;

                    case 6:
                    
                    in.nextInt();
                    int facID = in.nextInt();;
                    n.print3(facID);
                   
                    break;

                    
                        
                        
                    default:
                        break;
                    
               

        }
        in.close(); 
        


    }
    

        sc.close();
    }   
}
