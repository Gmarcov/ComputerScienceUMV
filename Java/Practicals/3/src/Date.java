public class Date {
    int day, month, year;

    public Date(){
        this.day = 1;
        this.month = 1;
        this.year = 1;
    }

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValid(Date d){
        if (this.year < d.year) return false;
        if (this.year > d.year) return true;
        if (this.month < d.month) return false;
        if (this.month > d.month) return true;
        return (this.day > d.day);
    }

    public boolean equals(Date D){
        return (this.day == D.day && this.month == D.month && this.year == D.year);
    }

    public String toString(){
        return this.day + "/" + this.month + "/" + this.year;
    }
}
