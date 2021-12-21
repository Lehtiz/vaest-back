package vaestback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Person {
    private String name;
    private String dateOfBirth;
    private String ssn;
    private String address;
    private String nationality;
    private String mainLanguage;
    private String maritalStatus;
    private String dateOfDeath;

    public Person() {
    }

    public Person(
            String name,
            String dateOfBirth,
            String ssn,
            String address,
            String nationality,
            String mainLanguage) {
        setName(name);
        setDateOfBirth(dateOfBirth);
        setSsn(ssn);
        setAddress(address);
        setNationality(nationality);
        setMainLanguage(mainLanguage);
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSsn() {
        return ssn;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMotherLanguage() {
        return mainLanguage;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    // SETTERS
    public void setName(String name) {
        try {
            if (!name.equals(null) && name.length() > 1) {
                if (name.length() < 255) {
                    this.name = name;
                } else {
                    throw new IllegalArgumentException("Name cannot be longer than 255 letters");
                }
            } else {
                throw new IllegalArgumentException("Name has to be at least 2 letters");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Name cannot be blank");
        }

    }

    public void setDateOfBirth(String dateOfBirth) {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date dob = format.parse(dateOfBirth);
            this.dateOfBirth = dob.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Incorrect format. Got " + dateOfBirth + " should fit pattern " + pattern);
        }
    }

    public void setDateOfDeath(String dateOfDeath) {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date dod = format.parse(dateOfDeath);
            this.dateOfDeath = dod.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Incorrect format. Got " + dateOfDeath + " should fit pattern " + pattern);
        }
    }

    public void setSsn(String ssn) {
        try {
            if (ssn.length() == 11) {
                // Needs to have the correct century identifier
                if (ssn.charAt(0) == '+' ||
                        ssn.charAt(6) == '-' ||
                        ssn.charAt(6) == 'A') {
                    this.ssn = ssn;
                } else {
                    throw new IllegalArgumentException(
                            "SSN must have correct century identifier, ddmmyyXyyyz, with X being either +, - or A");
                }
            } else {
                throw new IllegalArgumentException(
                        "Ssn has to be 11 characters");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("SSN cannot be blank");
        }
    }

    public void setAddress(String address) {
        if (address.length() > 4 && address.length() <= 255) {
            this.address = address;
        } else {
            throw new IllegalArgumentException(
                    "Address must be between 4-255 characters long");
        }
    }

    public void setNationality(String nationality) {
        if (nationality.length() > 4) {
            this.nationality = nationality;
        } else {
            throw new IllegalArgumentException(
                    "Nationality has to be 4 characters");
        }
    }

    public void setMainLanguage(String mainLanguage) {
        if (mainLanguage.length() > 1 && mainLanguage.length() < 50) {
            this.mainLanguage = mainLanguage;
        } else {
            throw new IllegalArgumentException(
                    "Main language must be between 2-50 characters long");
        }

    }

    public void setMaritalStatus(String maritalStatus) {
        if (maritalStatus.length() > 1) {
            this.maritalStatus = maritalStatus;
        } else {
            throw new IllegalArgumentException(
                    "Marital status must be between 2-50 characters long");
        }
    }
}