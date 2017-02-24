public class Controller {

    private API[] apis;

    public Controller() {
        apis = new API[3];
        apis[0] = new BookingComAPI();
        apis[1] = new GoogleAPI();
        apis[2] = new TripAdvisorAPI();
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        int count = 0;
        for (API elem : apis) {
            Room[] arr = elem.findRooms(price, persons, city, hotel);
            count = count + arr.length;
        }

        Room[] foundRooms = new Room[count];

        int counterFoundRooms = 0;
        for (int i = 0; i < apis.length; i++) {
            Room[] arr = apis[i].findRooms(price, persons, city, hotel);

            for (Room room : arr) {
                foundRooms[counterFoundRooms] = room;
                counterFoundRooms++;
            }
        }
        return foundRooms;
    }

    public Room[] check(API api1, API api2) {

        Room[] roomsApi1 = api1.getRooms();
        Room[] roomsApi2 = api2.getRooms();
        int count = 0;
        for (int i = 0; i < roomsApi1.length; i++) {
            for (int i1 = 0; i1 < roomsApi2.length; i1++) {
                if (roomsApi1[i].equals(roomsApi2[i1])) {
                    count++;
                }
            }
        }
        Room[] sharedRooms = new Room[count];
        int index = 0;
        for (int i = 0; i < roomsApi1.length; i++) {
            for (int i1 = 0; i1 < roomsApi2.length; i1++) {
                if (roomsApi1[i].equals(roomsApi2[i1])) {
                    sharedRooms[index] = roomsApi1[i];
                    index++;
                }
            }
        }
        return sharedRooms;
    }
}
