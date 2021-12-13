public class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public boolean isValid(){
        if (this.day < 1 || this.day > 31){
            if (this.month < 1 || this.month > 12){
                return this.year > 1900;
            }
        }
        return false;
    }

    public Date compareDate(Date x){
        if (this.year > x.year){
            return x;
        } else if(this.year < x.year) {
            return this;
        } else {
            if (this.month > x.month){
                return x;
            } else if (this.month < x.month){
                return this;
            } else {
                if (this.day > x.day){
                    return x;
                } else {
                    return this;
                }
            }
        }
    }

    public boolean sameYear(Date x){
        return this.year == x.year;
    }

    public String toString(){
        return (this.day + "/" + this.month + "/" + this.year);
    }
}
