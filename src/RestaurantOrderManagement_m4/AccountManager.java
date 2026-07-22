/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestaurantOrderManagement_m4;

/**
 *
 * @author Danas
 */

import java.util.ArrayList;

public class AccountManager {

    public static ArrayList<Account> accounts =
            new ArrayList<>();

    static {
        accounts.add(
                new Account(
                        "admin",
                        "admin123",
                        "Admin"
                )
        );
    }

    public static boolean usernameExists(String username) {

        for (Account account : accounts) {

            if (account.getUsername()
                    .equalsIgnoreCase(username)) {

                return true;
            }
        }

        return false;
    }

    public static Account login(
            String username,
            String password,
            String role) {

        for (Account account : accounts) {

            boolean sameUsername =
                    account.getUsername()
                            .equalsIgnoreCase(username);

            boolean samePassword =
                    account.getPassword()
                            .equals(password);

            boolean sameRole =
                    account.getRole()
                            .equals(role);

            if (sameUsername
                    && samePassword
                    && sameRole) {

                return account;
            }
        }

        return null;
    }
}