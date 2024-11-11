package Assignment_3_3;

public class room_record 
{

    private String roomType;
    private int roomNumber;
    private double pricePerDay;

    // Constructor
    public room_record(String roomType, int roomNumber, double pricePerDay) 
    {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
    }

    // Getter methods
    public String getRoomType() 
    {
        return roomType;
    }

    public int getRoomNumber() 
    {
        return roomNumber;
    }

    public double getPricePerDay() 
    {
        return pricePerDay;
    }
}
