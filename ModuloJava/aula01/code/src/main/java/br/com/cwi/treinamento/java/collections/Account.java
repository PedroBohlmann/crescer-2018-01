package br.com.cwi.treinamento.java.collections;

import java.util.Objects;

public class Account implements Comparable<Account> {

    private int id;
    private String ownerName;

    public Account(int id, String nomeTitular) {
        this.id = id;
        this.ownerName = nomeTitular;
    }

    public int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Account account) {
        if (this.id < account.getId()) {
            return -1;
        }

        if (this.id > account.getId()) {
            return 1;
        }

        return 0;
    }
}
