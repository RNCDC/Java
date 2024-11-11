package Assignment_3_2;

public class room_record 
{

    private String roomType;
    public int roomNumber;
    private double pricePerDay;

    // Constructor //A
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