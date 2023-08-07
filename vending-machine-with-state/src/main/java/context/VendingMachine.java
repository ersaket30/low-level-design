package context;

import state.State;

import java.util.Map;
import java.util.Set;


//https://medium.com/swlh/vending-machine-design-a-state-design-pattern-approach-5b7e1a026cd2

public class VendingMachine {
    private int collectedCash;
    private State state;
    private Map<String, Set<String>> productCodeItemMap;
    private Map<String, Integer> productCodePriceMap;

    public void addCollectedCash(int collectedCash) {
        this.collectedCash += collectedCash;
    }

    public VendingMachine setCollectedCash(int collectedCash) {
        this.collectedCash = collectedCash;
        return this;
    }

    public State getState() {
        return state;
    }

    public VendingMachine setState(State state) {
        this.state = state;
        return this;
    }

    public void removeProduct(String productCode) {

    }

    public void dispenseChange(String productCode) {
        this.state.dispenseChange(productCode);
    }

    public void cancelTransaction() {
        this.state.cancelTransaction();
    }

    public int calculateChange(String productCode) {
        return collectedCash - productCodePriceMap.get(productCode);
    }

    public void dispenseItem(String productCode) {
        this.state.dispenseItem(productCode);
    }

    public int getCollectedCash() {
        return collectedCash;
    }
}
