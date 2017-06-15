package ua.nure.babenko.dotaanalyzer.db.entity;


public class ConfrontationEntity {

    private int firstHeroId;
    private int secondHeroId;
    private int profitability;

    public int getFirstHeroId() {
        return firstHeroId;
    }

    public void setFirstHeroId(int firstHeroId) {
        this.firstHeroId = firstHeroId;
    }

    public int getSecondHeroId() {
        return secondHeroId;
    }

    public void setSecondHeroId(int secondHeroId) {
        this.secondHeroId = secondHeroId;
    }

    public int getProfitability() {
        return profitability;
    }

    public void setProfitability(int profitability) {
        this.profitability = profitability;
    }

    @Override
    public String toString() {
        return "ConfrontationEntity{" +
                "firstHeroId=" + firstHeroId +
                ", secondHeroId=" + secondHeroId +
                ", profitability=" + profitability +
                '}';
    }
}
