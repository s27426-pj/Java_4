package zj1.example.zad1;

public class CarResponse {
        private String name;
        private int yearOfProduction;
        private String history;
        private int lastViews;

    public String getName() {
        return name;
    }

    public int getLastViews() {
        return lastViews;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getHistory() {
        return history;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setLastViews(int lastViews) {
        this.lastViews = lastViews;
    }
}
