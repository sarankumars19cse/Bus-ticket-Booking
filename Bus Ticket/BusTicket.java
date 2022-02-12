import java.util.*;

public class BusTicket {
    public ArrayList register(Scanner scan)
    {
        ArrayList<String> list= new ArrayList<>();
        String regName,price="450";
        System.out.println("Enter the name of the register...");
        // BusTicket obj = new BusTicket();
        regName = scan.next();
        System.out.println("Enter the age of the register...");
        String age = scan.next();
        System.out.println("Enter the Starting point...");
        String startPoint = scan.next();
        System.out.println("Enter the Ending point...");
        String endPoint = scan.next();
        System.out.println("Enter the Travelling Date...");
        String date = scan.next();
        list.add(regName);
        list.add(age);
        list.add(startPoint);
        list.add(endPoint);
        list.add(date);
        if(Integer.parseInt(age)>10)
        {
            list.add(price);
        }
        else
        {
            list.add("0");
        }
        System.out.println(list);
        return list;
    }
    public void displayTicket(HashMap<Integer , ArrayList<String>> map)
    {
        System.out.println("SNo\tName\tAge\tFrom\tTo\tDate\t\tPrice");
        for(Map.Entry<Integer , ArrayList<String>> i : map.entrySet())
        {
            System.out.print(i.getKey()+"\t");
            for(String j : i.getValue())
            {
                System.out.print(j+"\t");
            }
            System.out.println();
        }
    }
    public int remove(int sno,HashMap<Integer , ArrayList<String>> map)
    {
        map.remove(sno);
        sno--;
        System.out.println("Ticket cancelled successfully....");
        return sno;
    }
    public int removeMiddile(HashMap<Integer , ArrayList<String>> map,Scanner scan)
    {
        System.out.println("Enter the given Sno to Cancel the Registration...");
        int serial = scan.nextInt();
        for(int i : map.keySet())
        {
            if(serial == i)
            {
                System.out.println("Your Ticket Cancelation is Successfull");
                map.remove(i);
                return 0;
            }
        }
        System.out.println("Serial no Not found");
        return 0;
    }
    public void vacancy(int size)
    {
        int vac = 30-size;
        System.out.println("Total vacancy is 30");
        System.out.println("Vacancy Available is : "+vac);
    }
    public static void main(String arg[])
    {
        int ch,sno = 0;
        Scanner scan = new Scanner(System.in);
        BusTicket obj = new BusTicket();
        HashMap<Integer , ArrayList<String>> map = new HashMap<>();
        System.out.println("Note : Enter the details according to the single seat...");
        do{
            System.out.println("1 - Registration\t2 - To Cancel Last Registered Ticket\t3 - To Cancel Prviously Booked Ticket\t4 - View Booked Tickets\t5 - View Vacancy");
            System.out.println("Enter the Choice to preform..");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    sno++;
                    map.put(sno,obj.register(scan));
                    break;
                case 2:
                    sno=obj.remove(sno,map);
                    break; 
                case 3:
                    obj.removeMiddile(map,scan);
                    break;    
                case 4:
                    obj.displayTicket(map);   
                    break;   
                case 5:
                    obj.vacancy(map.size());
                    break;     
                default:
                    System.out.println("Enter the valid choice...");    
            }
            System.out.println("Press 0 to Exit if not Press 1...");
            ch = scan.nextInt();
        }while(ch != 0);
        System.out.println(map);
        obj.displayTicket(map);
    }
}
