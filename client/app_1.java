package client;

import java.sql.SQLException;
import java.util.Scanner;

import core.model.Animal;
import core.presenter.Presenter;
import core.service.DataManager;
import core.service.IDataManager;
import core.service.IDataProvider;
import core.view.ConsoleView;
import core.view.IView;
import sql.ConfigData;
import sql.ConnectionDB;

public class app_1 {

    private app_1() {}

    public static void ButtonClick() {

        ConnectionDB connect = new ConnectionDB();
        System.out.println(connect.getRawData(new ConfigData()));

        // System.out.print("\033[H\033[J");
        // IView view = new ConsoleView();
        // IDataProvider<Animal> provider = new FileManager<>();
        // IDataManager<Animal> manager = new DataManager<>(provider, "sql/data.txt", "sql/pass.txt");
        // Presenter<Animal> presenter = new Presenter<>(view, manager);
        // System.out.print("\033[H\033[J");
        // int money = 100;

        // try (Scanner in = new Scanner(System.in)) {

        //     while (true) {

        //         if(presenter.isAdmin()) { //пароль admin

        //             System.out.println("0 - Выход из режима админа 1 - Вывести всё  2 - Добавить продукт 3 - Изменить кол-во товара 4 - Изменить вес товара\n 5 - Выход из программы");
        //             String key = in.next();
        //             System.out.print("\033[H\033[J");
        //             switch (key) {

        //                 case "0":
        //                     presenter.exitAdmin();
        //                     break;
                        
        //                 case "1":
        //                     presenter.gAllAnimals();
        //                     break;

        //                 case "2":
        //                     presenter.addNewProduct();
        //                     break;

        //                 case "3":
        //                     presenter.ChangeCountProducts();
        //                     break;

        //                 case "4":
        //                     presenter.ChangeWeightProduct();
        //                     break;
                        
        //                 case "5":
        //                     presenter.Quit();
        //                     System.exit(0);
        //                     break;

        //                 default:

        //                     System.out.println("Такой команды нет");
        //                     break;

        //             }

        //         } else {

        //             System.out.println(
        //                     "0 - Войти в режим админа \n1 - Розыгрыш  игрушек = 10р \n2 - Вывести список выйгранных игрушек\n3 - Показать все игрушки\n4 - Выход из программы");
        //             String key = in.next();
        //             System.out.print("\033[H\033[J");
        //             switch (key) {

        //                 case "0":
        //                     presenter.enterAdmin();
        //                     break;
                        
        //                 case "1":
        //                     if(money >= 10) {
        //                         money -= 10;
        //                         System.out.println(money + " руб осталось");
        //                         presenter.startPlay();

        //                     } else {

        //                         System.out.println("Денег не осталось");

        //                     }
        //                     break;

        //                 case "2":
                            
        //                     presenter.getToysWinner();

        //                     break;

        //                 case "3":
        //                     presenter.gAllAnimals();
        //                     break;

        //                 case "4":
        //                     presenter.Quit();
        //                     System.exit(0);
        //                     break;

        //                 default:

        //                     System.out.println("Такой команды нет");
        //                     break;

        //             }


        //         }
                
        //     }
        // }
    }
}
