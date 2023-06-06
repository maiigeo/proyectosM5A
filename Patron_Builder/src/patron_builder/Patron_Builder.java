/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron_builder;

/**
 *
 * @author HP
 */
public class Patron_Builder {

    public static void main(String[] args) {
        BankAccountBuilder builder = new BankAccountBuilder(12345l);

        BankAccount bankAccount = builder.withBalance(1000.20)
                
                .withOwner("Oaken")
                .withRate(10.15)
                //.withType("PLATINUM")
                .build();

        System.out.println(bankAccount);
    }
}
