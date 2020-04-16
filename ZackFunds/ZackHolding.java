public class ZackHolding {
    private String symbol;
    private long shares;
    private float percentage;
    private String companyName;
    private float pe;
    private float epsGrowth;
    private float yield;
    public ZackHolding(String symbol,
                       long shares,
                       float percentage,
                       String companyName, float PE, float growth, float yield){
        this.symbol=symbol;
        this.shares=shares;
        this.percentage=percentage;
        this.companyName=companyName;
        this.pe = PE;
        this.epsGrowth= growth;
        this.yield = yield;
    }
    public String toString(){
        return getSymbol() +", "+
                getShares() +", "+
                getPercentage() +", "+
                getCompanyName() +", "+
                getPe() +", "+
                getEpsGrowth()+", "+
                getYield();
    }
/*
    public static void main(String[] args) {
        String symbol = "NEM";
        ZackHolding zh = new ZackHolding(symbol,
        3269678,9.05f,"Newmont Mining Corp");
        System.out.println(zh);
    }
/**
 * PE for the last year.
 */
    public float getPe() {
        return pe;
    }

    public void setPe(float pe) {
        this.pe = pe;
    }

    /**
     * Keep in mind these number are estimates
     * @return growth for the next 5 years (predicted)
     */
    public float getEpsGrowth() {
        return epsGrowth;
    }

    public void setEpsGrowth(float epsGrowth) {
        this.epsGrowth = epsGrowth;
    }

    /**
     *
     * @return the yield over the last year.
     */
    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }

    public String getSymbol() {
        return symbol;
    }

    public long getShares() {
        return shares;
    }

    public float getPercentage() {
        return percentage;
    }

    public String getCompanyName() {
        return companyName;
    }
}


