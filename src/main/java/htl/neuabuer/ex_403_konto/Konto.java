package htl.neuabuer.ex_403_konto;

import javax.swing.JLabel;

public class Konto {

    private double amount;
    private JLabel balance;

    public Konto(double amount, JLabel balance) {
        this.amount = amount;
        this.balance = balance;
        update();
    }

    public void update() {
        balance.setText(String.format("%.2f EUR", amount));
    }

    public double getAmount() {
        return amount;
    }

    public String withdraw(double amount) throws TooLittleMoneyException {
        if (this.amount < amount) {
            throw new TooLittleMoneyException();
        }
        this.amount -= amount;
        update();
        return " has withdrawn " + amount;
    }

    public String deposit(int amount) {
        this.amount += amount;
        update();
        return " has deposited " + amount;
    }

}
