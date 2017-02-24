public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();

        Room[] firstRequestRooms = controller.requestRooms(700, 1, "Kharkov", "Hotel1");
        for (Room room : firstRequestRooms) {
            System.out.println(room);
        }
        Room[] secondRequestRooms = controller.requestRooms(1000, 3, "Dnepr", "Hotel1");
        for (Room room : secondRequestRooms) {
            System.out.println(room);
        }
        Room[] thirdRequestRoom = controller.requestRooms(950, 2, "Vyshgorod", "Hotel1");
        for (Room room : thirdRequestRoom) {
            System.out.println(room);
        }

        API booking = new BookingComAPI();
        Room[] bookingRooms = booking.findRooms(800, 2, "Kiev", "Hotel1");
        for (Room bookingRoom : bookingRooms) {
            System.out.println(bookingRoom);
        }
        API google = new GoogleAPI();
        Room[] googleRooms = google.findRooms(900, 1, "Kharkov", "Hotel1");
        for (Room googleRoom : googleRooms) {
            System.out.println(googleRoom);
        }
        API tripAdvisor = new TripAdvisorAPI();
        Room[] tripAdvisorRooms = tripAdvisor.findRooms(950, 2, "Vishgorod", "Hotel1");
        for (Room tripAdvisorRoom : tripAdvisorRooms) {
            System.out.println(tripAdvisorRoom);
        }
    }
}
