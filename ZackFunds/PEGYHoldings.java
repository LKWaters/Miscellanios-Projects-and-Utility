
public class PEGYHoldings {

	private float PEGY;
    private float SR3;
    private float SR5;
    private float SR10;
    private float Beta;
    private String name;

    public PEGYHoldings(float PEGY,String name,float SR3,float SR5, float SR10, float Beta){
        this.PEGY=PEGY;
        this.name=name;
        this.SR3=SR3;
        this.SR5=SR5;
        this.SR10=SR10;
        this.Beta = Beta;
    }

    public String toString(){
        return getPEGY() +", "+
                getname() +", "+
                getSR3() +", "+
                getSR5() +", "+
                getSR10() +", "+
                getBeta();
    }
    
    public float getPEGY() {
        return PEGY;
    }

    public void setPEGY(float PEGY) {
        this.PEGY = PEGY;
    }

    public String getname() {
        return name;
    }
    
    public void setname(String name){
    	this.name = name;
    }
	
    public float getSR3() {
        return SR3;
    }

    public void setSR3(float SR3) {
        this.SR3 = SR3;
    }
    
    public float getSR5() {
        return SR5;
    }

    public void setSR5(float SR5) {
        this.SR5 = SR5;
    }
    
    public float getSR10() {
        return SR10;
    }

    public void setSR10(float SR10) {
        this.SR10 = SR10;
    }
    
    public float getBeta() {
        return Beta;
    }

    public void setBeta(float Beta) {
        this.Beta = Beta;
    }
    
}
