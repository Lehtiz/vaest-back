package vaestback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Building {

    private String buildingId;
    private String location;
    private String dateOfCompletion;
    private String owner;
    private String ownerType;
    private String buildingType;
    private String UtilityConnections;
    private ArrayList<Appartment> appartments;

    public Building(String buildingId) {
        setBuildingId(buildingId);
    }

    public Building() {
    }

    // GETTERS
    public String getBuildingId() {
        return buildingId;
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<Appartment> getAppartments() {
        return appartments;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public String getDateOfCompletion() {
        return dateOfCompletion;
    }

    public String getLocation() {
        return location;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public String getUtilityConnections() {
        return UtilityConnections;
    }

    // SETTERS
    public void setBuildingId(String buildingId) {
        if (buildingId.length() == 10) {

            char c = buildingId.charAt(0);
            int firstCharAsInt = Integer.parseInt(String.valueOf(c));

            if (firstCharAsInt == 1) {
                try {
                    int validityCheck = Integer.parseInt(buildingId.substring(0, 8));
                    if (validityCheck > 0) {
                        this.buildingId = buildingId;
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException(
                            "Format should be 10 characters: 9 numeric characters followed by 1 alphanumeric character");
                }
            } else {
                throw new IllegalArgumentException("Building id must start with 1");
            }
        } else {
            throw new IllegalArgumentException("Building id has 10 characters");
        }
    }

    public void setLocation(String location) {
        if (location.length() > 1 && location.length() <= 255) {
            this.location = location;
        } else {
            throw new IllegalArgumentException("Location must be between 2-255 characters");
        }
    }

    public void setDateOfCompletion(String dateOfCompletion) {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date dob = format.parse(dateOfCompletion);
            this.dateOfCompletion = dob.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Incorrect format. Got " + dateOfCompletion + " should fit pattern " + pattern);
        }
    }

    public void setAppartments(ArrayList<Appartment> appartments) {
        if (this.appartments == null) {
            var list = new ArrayList<Appartment>();
            for (int i = 0; i < appartments.size(); i++) {
                list.add(appartments.get(i));
            }
            this.appartments = new ArrayList<Appartment>();
            this.appartments.addAll(appartments);
        } else {
            this.appartments.addAll(appartments);
        }
    }

    public void setOwner(String owner) {
        if (owner.equals(null)) {
            if (owner.length() > 1 && owner.length() < 255) {
                this.owner = owner;
            } else {
                throw new IllegalArgumentException("Owner must be between 2-255 characters");
            }
        } else {
            throw new IllegalArgumentException("Owner cannot be null");
        }
    }

    public void setBuildingType(String buildingType) {
        if (ownerType.equals(null)) {
            if (ownerType.length() > 1 && ownerType.length() < 255) {
                this.buildingType = buildingType;
            } else {
                throw new IllegalArgumentException("Owner type must be between 2-255 characters");
            }
        } else {
            throw new IllegalArgumentException("Owner type cannot be null");
        }
    }

    public void setOwnerType(String ownerType) {
        if (ownerType.equals(null)) {
            if (ownerType.length() > 1 && ownerType.length() < 255) {
                this.ownerType = ownerType;
            } else {
                throw new IllegalArgumentException("Owner type must be between 2-255 characters");
            }
        } else {
            throw new IllegalArgumentException("Owner type cannot be null");
        }
    }

    public void setUtilityConnections(String utilityConnections) {
        UtilityConnections = utilityConnections;
    }

}
