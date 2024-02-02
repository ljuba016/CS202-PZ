/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import exceptions.NevalidanBrojGodinaException;
import exceptions.NevalidanTelefonException;
import java.sql.SQLException;
import java.util.Scanner;
import klase.Klijent;
import klase.VlasnikNekretnine;
import util.DBCRUD;
import util.DatabaseConnector;
import util.BruteForce;
import static util.DBCRUD.sortiranjeBaze;

/**
 *
 * @author aleks
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NevalidanTelefonException, SQLException, NevalidanBrojGodinaException {
        DatabaseConnector.getConnection();
        
        
        boolean exit = false;
            while (!exit) {
                
                System.out.println("Izaberite opciju:");
                System.out.println("1. Dodavanje novog kljenta");
                System.out.println("2. Dodavanje novog vlasnika");
                System.out.println("3. Prikaz lokacije");
                System.out.println("4. Prikaz dodatno");
                System.out.println("5. Update ugovor");
                System.out.println("6. Update vlasnika");
                System.out.println("7. Sortiranje");
                System.out.println("8. Brute Force napad");
                System.out.println("9. Izlaz iz programa");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.println("Unesi id klijenta:");
                        int idKlijenta = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Unesi adresu klijenta:");
                        String adresaKlijenta = scanner.nextLine();
                        System.out.println("Unesi ime klijenta:");
                        String imeKlijenta = scanner.nextLine();
                        System.out.println("Unesi broj telefona klijenta:");
                        String telefonKlijenta = scanner.nextLine();
                        
                        Klijent klijent = new Klijent(idKlijenta, adresaKlijenta, imeKlijenta, telefonKlijenta);
                        
                        DBCRUD.dodajKlijenta(klijent);
                        
                        break;
                        
                    case 2:
                        System.out.println("Unesi id vlasnika:");
                        int idVlasnika = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Unesi adresu vlasnika:");
                        String adresaVlasnika = scanner.nextLine();
                        System.out.println("Unesi godine vlasnika:");
                        int godinevlasnika = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Unesi ime vlasnika:");
                        String imeVlasnika = scanner.nextLine();
                        System.out.println("Unesi broj telefona vlasnika:");
                        String telefonVlasnika = scanner.nextLine();
                        
                        VlasnikNekretnine vlasnik = new VlasnikNekretnine(idVlasnika, adresaVlasnika, godinevlasnika, imeVlasnika, telefonVlasnika );
                        
                        DBCRUD.dodajVlasnika(vlasnik);
                        
                        break;
                    case 3:
                        DBCRUD.ispisLokacije();
                        break;
                    case 4:
                        DBCRUD.ispisDodatno();
                        break;
                    case 5:
                        
                        System.out.println("Unesi novu naknadu agenciji:");
                        int novaNaknada = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Unesi id ugovora:");
                        int idUgovora = scanner.nextInt();
                        
                        DBCRUD.updateUgovor(novaNaknada, idUgovora);
                        
                        break;
                    case 6:
                        
                        System.out.println("Unesi novo ime vlasnika:");
                        String novoIme = scanner.nextLine();
                        System.out.println("Unesi id vlasnika:");
                        int idStarogVlasnika = scanner.nextInt();
                        
                        DBCRUD.updateVlasnik(novoIme, idStarogVlasnika);
                        scanner.nextLine();
                        break;
                    case 7:
                        
                        System.out.println("Unesite tabelu koju sortirate");
                        String tabela = scanner.nextLine();
                        
                        System.out.println("Unesite kolonu po kojoj sortirate");
                        String kolona = scanner.nextLine();
                        
                        System.out.println("Unesite nacin na koji sortirate (ASC ili DESC)");
                        String nacin = scanner.nextLine();
                        
                        DBCRUD.sortiranjeBaze(tabela, kolona, nacin);
                        
                        break;
                    case 8:
                        String targetPassword = "123";
                        String characterSet = "abcdefghijklmnopqrstuvwxyz0123456789";
                        int maxLength = 3;
                        BruteForce.bruteForceAttack(targetPassword, characterSet, maxLength);
                        break;
                    case 9:
                        exit = true;
                        break;
                    default:
                        System.out.println("Nevažeći izbor. Molimo unesite ponovo.");
                }
            }
        
        
        
        
        //DBCRUD.ispisLokacije();
        //DBCRUD.ispisDodatno();
        //DBCRUD.updateUgovor(11000, 1);
        //DBCRUD.updateVlasnik("Ana Nikolic", 1);
        
        //BruteForce
//        String targetPassword = "root";
//        String characterSet = "abcdefghijklmnopqrstuvwxyz0123456789";
//        int maxLength = 4;
//        BruteForce.bruteForceAttack(targetPassword, characterSet, maxLength);
    }
    
}
