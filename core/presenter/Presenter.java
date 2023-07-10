package core.presenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import core.enums.AnimalGroup;
import core.enums.AnimalType;
import core.model.Animal;
import core.model.Command;
import core.model.PackAnimal;
import core.model.Pet;
import core.service.IDataManager;
import core.view.IView;

public class Presenter<T extends Animal> {

    private IView view;
    private IDataManager<T> manager;
    private boolean admin;
    private Map<Integer, T> animalsFeed;

    public Presenter(IView view, IDataManager<T> manager) {

        this.view = view;
        this.manager = manager;
        this.animalsFeed = this.manager.getList();
        this.admin = false;

    }

    public void learnNewCommand() {

        gAllAnimals();
        this.view.set("Введите id животного: ");
        String input = this.view.get();

        try {

            int id = Integer.parseInt(input);

            try {

                T animal = this.animalsFeed.get(id);
                this.view.set("Введите название команды:");
                String comInput = this.view.get();
                this.view.set("Введите описание команды:");
                String desInput = this.view.get();
                Command newCom = new Command(comInput, desInput);
                List<Command> commands = animal.getCommands();
                commands.add(newCom);
                this.view.set(animal.gType() + " " + animal.gName() + " знает команды:");

                for (Command com : commands) {

                    this.view.set(com.toString());

                }

            } catch (NullPointerException e) {

                this.view.set("Такого id нету");
                this.view.set(e.toString());
                gAllAnimals();

            }
            

        } catch (NumberFormatException e) {

            this.view.set("ОШИБКА ВВОДА, введите число");
            this.view.set(e.toString());

        }

    }

    public void addAnimal(){

        this.view.set("Введите имя животного: ");
        String name = this.view.get();
        AnimalType type;
        this.view.set("Введите что это за животное\n1 - Кот\n2 - Собака\n3 - Хомяк\n4 - Лошадь\n5 - Осел\n6 - Верблюд");
        
        switch (this.view.get()) {

            case "1":
                type = AnimalType.CAT;
                break;
            case "2":
                type = AnimalType.DOG;
                break;
            case "3":
                type = AnimalType.HUMSTER;
                break;
            case "4":
                type = AnimalType.HORSE;
                break;
            case "5":
                type = AnimalType.DUNKEY;
                break;
            case "6":
                type = AnimalType.CAMAL;
                break;
            default:
                this.view.set("Таких животных не принимаем в приют!");
                return;
        }

        this.view.set("Введите дату рождения животного в формате гггг-мм-дд:");
        String birthday = this.view.get();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

          dateFormat.parse(birthday);

        }
        catch(ParseException e){

            this.view.set("Неверный формат даты");
            this.view.set(birthday);
            this.view.set(e.toString());
            return;

        }

        this.view.set("Обучено ли животное?\n1 - Да\n2 - Нет");
        List<Command> command = new ArrayList<>();

        switch (this.view.get()) {

            case "1":
                this.view.set("Введите название команды:");
                String comName = this.view.get();
                this.view.set("Введите описание команды:");
                String desName = this.view.get();
                command.add(new Command(comName, desName));
                break;

            case "2":
                command.add(new Command("Незнает команд", "Необученное животное"));
                break;

            default:
                this.view.set("Не понятно, нужно ввести 1 или 2");
                return;
        } 

        Animal animal;

        int id = 0;

        for (id = 1; id <= this.animalsFeed.size(); id++) {

            if(!this.animalsFeed.containsKey(id)){
                break;
            }
            
        }

        if(type == AnimalType.CAT || type == AnimalType.DOG || type == AnimalType.HUMSTER ){

            animal = new Pet(id, name, birthday, command, type);

        } else {

            animal = new PackAnimal(id, name, birthday, command, type);

        }
        this.view.set("Получилось такое животное:");
        this.view.set(animal.toString());
        this.view.set("Добавить? [y/Y]:");
        switch (this.view.get()) {
            case "y":
            case "Y":
            case "у":
            case "У":
                this.animalsFeed.put(id, (T)animal);
                break;
            default:
                this.view.set("Удалили");
                break;
        }


    }

    public void gCommands(){

        gAllAnimals();
        this.view.set("Введите id животного: ");
        String input = this.view.get();

        try {

            int id = Integer.parseInt(input);

            try {

                T animal = this.animalsFeed.get(id);
                List<Command> commands = animal.getCommands();
                this.view.set(animal.gType() + " " + animal.gName() + " знает команды:");

                for (Command com : commands) {

                    this.view.set(com.toString());

                }

            } catch (NullPointerException e) {

                this.view.set("Такого id нету");
                this.view.set(e.toString());
                gAllAnimals();

            }
            

        } catch (NumberFormatException e) {

            this.view.set("ОШИБКА ВВОДА, введите число");
            this.view.set(e.toString());

        }

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

        if(this.manager.IsPass(pass)) {

            this.view.set("Режим админа включен");
            this.admin = true;

        } else {

            this.view.set("Пароль не верный");

        }

    }

    public void gAllAnimals() {

        printAnimals();

    }

    public void gAllPets() {

        printPets();

    }

    public void gAllPackAnimals() {

        printPackAnimals();

    }

    private void printAnimals() {

        for(Map.Entry<Integer, T> entry : this.animalsFeed.entrySet()) {

            this.view.set(entry.getValue().toString());

        }

    }

    private void printPets() {

        for(Map.Entry<Integer, T> entry : this.animalsFeed.entrySet()) {

            if(AnimalGroup.PET == entry.getValue().gGroup()) {

                this.view.set(entry.getValue().toString());

            }
            
            

        }

    }

    private void printPackAnimals() {

        for(Map.Entry<Integer, T> entry : this.animalsFeed.entrySet()) {

            if(AnimalGroup.PACKANIMAL == entry.getValue().gGroup()) {

                this.view.set(entry.getValue().toString());

            }
            
            

        }

    }
    
}