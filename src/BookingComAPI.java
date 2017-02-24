import java.util.Date;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI() {
        this.rooms = new Room[5];
        this.rooms[0] = new Room(1001, 800, 2, new Date(), "Hotel1", "Kiev");
        this.rooms[1] = new Room(1002, 900, 1, new Date(), "Hotel1", "Kharkov");
        this.rooms[2] = new Room(1003, 1000, 3, new Date(), "Hotel1", "Dnepr");
        this.rooms[3] = new Room(1004, 800, 2, new Date(), "Hotel1", "Kiev");
        this.rooms[4] = new Room(1005, 950, 2, new Date(), "Hotel1", "Vyshgorod");
    }

    @Override
    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] foundRooms = new Room[rooms.length];
        int index = 0;
        for (Room room : rooms) {
            if ((room.getPrice() == price) && (room.getPersons() == persons) && (room.getCityName().equals(city))
                    && (room.getHotelName().equals(hotel))) {
                foundRooms[index] = room;
                index++;
            }
        }
        Room[] resultRooms = new Room[index];
        int j = 0;
        for (int i = 0; i < foundRooms.length; i++) {
            if (foundRooms[i] != null) {
                resultRooms[j] = foundRooms[i];
                j++;
            }
        }
        return resultRooms;
    }
}
