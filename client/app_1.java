package client;

import java.sql.SQLException;
import java.util.Scanner;

import core.model.Animal;
import core.presenter.Presenter;
import core.service.BDataManager;
import core.service.IDataManager;
import core.service.IDataProvider;
import core.view.ConsoleView;
import core.view.IView;
import sql.ConfigData;
import sql.ConnectionDB;

public class app_1 {

    private app_1() {}

    public static void ButtonClick() {

        System.out.print("\033[H\033[J");
        IView view = new ConsoleView();
        IDataProvider provider = new ConnectionDB();
        IDataManager<Animal> manager = new BDataManager<>(provider, new ConfigData());
        Presenter<Animal> presenter = new Presenter<>(view, manager);
        System.out.print("\033[H\033[J");

        try (Scanner in = new Scanner(System.in)) {

            while (true) {

                if(presenter.isAdmin()) { //пароль admin

                    System.out.println("0 - Выход из режима админа\n1 - Вывести всё\n5 - Выход из программы");
                    String key = in.next();
                    System.out.print("\033[H\033[J");
                    switch (key) {

                        case "0":

                            presenter.exitAdmin();
                            break;
                        
                        case "1":
                            presenter.gAllAnimals();
                            break;
                        
                        case "5":

                            System.exit(0);
                            break;

                        default:

                            System.out.println("Такой команды нет");
                            break;

                    }

                } else {

                    System.out.println(
                            "0 - Войти в режим админа\n1 - Показать всех животных\n4 - Выход из программы");
                    String key = in.next();
                    System.out.print("\033[H\033[J");

                    switch (key) {

                        case "0":

                            presenter.enterAdmin();
                            break;
                        
                        case "1":

                            presenter.gAllAnimals();
                            break;

                        case "4":

                            System.exit(0);
                            break;

                        default:

                            System.out.println("Такой команды нет");
                            break;

                    }
                }
            }
        }
    }
}
