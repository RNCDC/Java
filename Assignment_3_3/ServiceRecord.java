package Assignment_3_3;

public class ServiceRecord {

    private String serviceType;
    private String serviceName;
    private double price;

    // Constructor
    public ServiceRecord(String serviceType, String serviceName) {
        this.serviceType = serviceType;
        this.serviceName = serviceName;
    }

    public ServiceRecord(double price)
    {
        this.price = price;
    }
    // Getter methods
    public String getServiceType() {
        return serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}

