
// Find Itinerary from tickets
// conditions -: 1. No loops is there , 2. From one start point there is only one destination (Unique city to Unique city)
// "Chennai"->"Bengaluru" , "Mumbai->"Delhi" , "Goa->"Chennai" , "Delhi->"Goa"
// required ans -: "Mumbai"->"Delhi"->"Goa"->"Chennai"->"Bengaluru"
import java.util.*;
public class ItineraryTickets {
    public static  String getStart(HashMap<String , String > tick){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key : tick.keySet()){
            revMap.put(tick.get(key), key );
        }
        for( String key : tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String > tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        while(tickets.containsKey(start)){
            System.out.print(start+"->");
            start = tickets.get(start);
        }
        System.out.print(start);

    }
}
