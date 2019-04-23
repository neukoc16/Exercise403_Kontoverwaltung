package htl.neuabuer.ex_403_konto;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class KontoBenutzer implements Runnable {

    private final String name;
    private final Konto account;
    private final JTextArea log;
    Random ra = new Random();
    String output;
    private int counter;

    public KontoBenutzer(String name, Konto account, JTextArea log) {
        this.name = name;
        this.account = account;
        this.log = log;
    }

    @Override
    public void run() {
        while (counter < 5) {
            int betrag = ra.nextInt(50);
            System.out.println(Thread.currentThread().getName() + " deposits ");
            synchronized (account) {
                output = account.deposit(betrag);
                log.append(Thread.currentThread().getName() + output + "\n");
            }
            counter++;
            System.out.println(Thread.currentThread().getName() + " withdraws ");
            synchronized (account) {
                try {
                    output = account.withdraw(betrag);
                    log.append(Thread.currentThread().getName() + output + "\n");
                    counter++;
                } catch (TooLittleMoneyException ex) {
                    try {
                        account.notifyAll();
                        account.wait();
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
