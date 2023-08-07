package concreteState;

import context.VendingMachine;
import state.State;


public class DispenseItem implements State {
    private VendingMachine vendingMachine;
    public DispenseItem(VendingMachine vendingMachine) {
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Dispensing itme ..unable to collect cash");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Dispensing item ..unable to dispense change");
    }

    @Override
    public void dispenseItem(String productCode) {
          vendingMachine.removeProduct(productCode);
          System.out.println("Dispensing item "+productCode);
          vendingMachine.setState(new Ready(vendingMachine));
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Dispensing item ..unable to cancel transaction");
    }
}
