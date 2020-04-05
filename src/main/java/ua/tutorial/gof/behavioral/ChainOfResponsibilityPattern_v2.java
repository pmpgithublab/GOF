package ua.tutorial.gof.behavioral;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

// https://refactoring.guru/design-patterns/chain-of-responsibility
public class ChainOfResponsibilityPattern_v2 {
    public static void main(String[] args) {
        Map<Integer, Integer> bancnotesByValue = new HashMap<>();
        BanknoteCounter counter100 = new BanknoteCounter(100);
        BanknoteCounter counter50 = new BanknoteCounter(50);
        BanknoteCounter counter20 = new BanknoteCounter(20);
        BanknoteCounter counter10 = new BanknoteCounter(10);
        BanknoteCounter counter5 = new BanknoteCounter(5);
        BanknoteCounter counter1 = new BanknoteCounter(1);

        counter100.setNext(counter50);
        counter50.setNext(counter20);
        counter20.setNext(counter10);
        counter10.setNext(counter5);
        counter5.setNext(counter1);

        System.out.println(counter100.getCash(477, bancnotesByValue));
    }
}

@Setter
class BanknoteCounter {
    int value;
    BanknoteCounter next;

    public BanknoteCounter(int value) {
        this.value = value;
    }

    public Map<Integer, Integer> getCash(int sum, Map<Integer, Integer> cashByBanknote) {
        if (sum > value) {
            int banknotesCount = sum / value;
            cashByBanknote.put(value, banknotesCount);
            sum -= banknotesCount * value;
        }
        if (next != null && sum > 0) {
            return next.getCash(sum, cashByBanknote);
        }
        return cashByBanknote;
    }
}