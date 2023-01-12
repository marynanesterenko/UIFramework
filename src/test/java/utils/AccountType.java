package utils;

public enum AccountType {
    STANDARD("standard"),
    INTEREST("interest"),
    SAVINGS("savings"),
    MONEY_MARKET("money_market");

    private final String type;

    AccountType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
