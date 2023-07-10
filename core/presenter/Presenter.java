package core.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import core.model.Animal;
import core.service.IDataManager;
import core.view.IView;

public class Presenter<T extends Animal> {

    private IView view;
    private IDataManager<T> manager;
    private List<T> AnimalsFeed;
    private boolean admin;

    public Presenter(IView view, IDataManager<T> manager) {

        this.view = view;
        this.manager = manager;
        this.AnimalsFeed = this.manager.getList();
        this.admin = false;

    }

    public boolean isAdmin() {

        return this.admin;

    }

    public void exitAdmin() {

        this.admin = false;
        this.view.set("Режим админа выключен");

    }

    public void enterAdmin() {

        this.view.set("Введите пароль админа: ");
        String pass = this.view.get();

        if(this.manager.savePass(pass)) {

            this.view.set("Режим админа включен");
            this.admin = true;

        } else {

            this.view.set("Пароль не верный");

        }

    }
    
}