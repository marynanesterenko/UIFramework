package utils;

public enum AccountOwnership {
    INDIVIDUAL("individual"),
    JOINT("joint");

    private final String ownership;

    AccountOwnership(String ownership){
        this.ownership = ownership;
    }

    public String getOwnership(){
        return ownership;
    }
}
