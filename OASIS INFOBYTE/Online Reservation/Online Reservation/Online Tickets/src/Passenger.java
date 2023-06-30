public class Passenger {
    private String age, gender, from, to, date, Class, train_no, pnr;

    private String name;

    public Passenger(String name, String age, String gender, String from, String to, String date, String Class, String train_no, String pnr) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.from = from;
        this.to = to;
        this.date = date;
        this.Class = Class;
        this.train_no = train_no;
        this.pnr = pnr;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getClas() {
        return Class;
    }

    public String getName2() {
        return train_no;
    }

    public String getPnr() {
        return pnr;
    }

    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age + ", Gender: " + this.gender + ", From: " + this.from + ", To: "
                + this.to + ", Date: " + this.date + ", Class: " + this.Class + ", Train Number: " + this.train_no + ", PNR: " + this.pnr;
    }

}
