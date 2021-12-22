package vaestback;

public class Appartment {

    private String appartmentId;
    private Building building;
    private double surfaceArea;
    private String type;
    private String usage;
    private int roomsQty;
    private String additions;

    public Appartment(
            String appartmentId,
            Building building,
            double surfaceArea,
            String type,
            String usage,
            int roomsQty,
            String additions) {
        setAppartmentId(appartmentId);
        setBuilding(building);
        setSurfaceArea(surfaceArea);
        setType(type);
        setUsage(usage);
        setRoomsQty(roomsQty);
        setAdditions(additions);
    }

    public Appartment() {
    }

    // Get
    public String getAppartmentId() {
        return appartmentId;
    }

    public Building getBuilding() {
        return building;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public String getType() {
        return type;
    }

    public String getUsage() {
        return usage;
    }

    public int getRoomsQty() {
        return roomsQty;
    }

    public String getAdditions() {
        return additions;
    }

    // Set
    public void setAppartmentId(String appartmentId) {
        if (appartmentId.equals(null)) {
            if (appartmentId.length() > 1 && appartmentId.length() <= 10) {
                this.appartmentId = appartmentId;
            } else {
                throw new IllegalArgumentException("Appartment id must be between 2-10 characters");
            }
        } else {
            throw new IllegalArgumentException("Appartment id cannot be null");
        }
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setSurfaceArea(double surfaceArea) {
        if (surfaceArea > 0.0) {
            this.surfaceArea = surfaceArea;
        } else {
            throw new IllegalArgumentException("Surface area must be larger than 0.0");
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setRoomsQty(int roomsQty) {
        if (roomsQty > 0) {
            this.roomsQty = roomsQty;
        } else {
            throw new IllegalArgumentException("Room quantity must be bigger than 0");
        }
    }

    public void setAdditions(String additions) {
        this.additions = additions;
    }
}
