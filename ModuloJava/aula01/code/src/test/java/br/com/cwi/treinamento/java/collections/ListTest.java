package br.com.cwi.treinamento.java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListTest {

    @Test
    public void shouldAddElementsOnArrayList() {
        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account(1, "Robson");
        Account account2 = new Account(2, "Bruno");
        Account account3 = new Account(3, "Everton");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        assertEquals(3, accounts.size());
    }

    @Test
    public void shouldIterateElementsUsingFor() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(1, "Robson"));
        accounts.add(new Account(2, "Bruno"));
        accounts.add(new Account(3, "Everton"));

        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).getOwnerName());
        }
    }

    @Test
    public void shouldIterateElementsUsingEnhancedFor() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(1, "Robson"));
        accounts.add(new Account(2, "Bruno"));
        accounts.add(new Account(3, "Everton"));

        for (Account account : accounts) {
            System.out.println(account.getOwnerName());
        }
    }

    @Test
    public void shouldDeleteElementFromTheListByIndex() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(1, "Robson"));
        accounts.add(new Account(2, "Bruno"));
        accounts.add(new Account(3, "Everton"));

        Account removedAccount = accounts.remove(1);

        assertEquals(2, accounts.size());
        assertEquals("Bruno", removedAccount.getOwnerName());

        assertEquals("Robson", accounts.get(0).getOwnerName());
        assertEquals("Everton", accounts.get(1).getOwnerName());
    }

    @Test
    public void shouldDeleteElementFromTheListByReference() {
        List<Account> accounts = new ArrayList<>();

        Account a1 = new Account(1, "Robson");
        Account a2 = new Account(2, "Bruno");
        Account a3 = new Account(3, "Everton");

        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);

        boolean wasRemoved = accounts.remove(a2);

        assertTrue(wasRemoved);
        assertEquals(2, accounts.size());

        assertEquals("Robson", accounts.get(0).getOwnerName());
        assertEquals("Everton", accounts.get(1).getOwnerName());
    }

    @Test
    public void shouldOrderAccountsById() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(1, "Robson"));
        accounts.add(new Account(3, "Everton"));
        accounts.add(new Account(2, "Bruno"));

        Collections.sort(accounts);

        assertEquals(1, accounts.get(0).getId());
        assertEquals(2, accounts.get(1).getId());
        assertEquals(3, accounts.get(2).getId());
    }

    @Test
    public void shouldOrderAccountsByName() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(1, "Robson"));
        accounts.add(new Account(3, "Everton"));
        accounts.add(new Account(2, "Bruno"));

        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getOwnerName().compareTo(o2.getOwnerName());
            }
        });

        assertEquals("Bruno", accounts.get(0).getOwnerName());
        assertEquals("Everton", accounts.get(1).getOwnerName());
        assertEquals("Robson", accounts.get(2).getOwnerName());
    }

}
