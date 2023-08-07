package concreteState;

import context.VendingMachine;
import state.State;

public class Ready implements State {

   private VendingMachine vendingMachine;

    public Ready(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        this.vendingMachine.addCollectedCash(cash);
    }

    @Override
    public void dispenseChange(String productCode) {
          vendingMachine.setState(new DispenseChange(vendingMachine));
          this.vendingMachine.dispenseChange(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {
       throw new RuntimeException("Transaction not initiated...Unable to dispense item");
    }

    @Override
    public void cancelTransaction() {
        this.vendingMachine.setState(new TransactionCancelled(vendingMachine));
        this.vendingMachine.cancelTransaction();

    }
}
