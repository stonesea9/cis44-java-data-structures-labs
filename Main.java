public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> trip = new LinkedPositionalList<>();

        trip.addLast("Beijing");
        trip.addLast("Shanghai");
        trip.addLast("Chongqing");

        Position<String> tokyo = trip.first();
        tokyo = trip.after(tokyo); // now points to "Tokyo"
        trip.addAfter(tokyo, "Chengdu");

        System.out.println("Final Itinerary:");
        for (String stop : trip) {
            System.out.println("-> " + stop);
        }
    }
}
