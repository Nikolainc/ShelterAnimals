package core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.enums.AnimalType;
import core.model.Animal;
import core.model.Command;
import core.model.PackAnimal;
import core.model.Pet;
import core.service.interfaces.IDataManager;
import core.service.interfaces.IDataProvider;
import sql.ConfigData;

public class BDataManager<T extends Animal> implements IDataManager<T> {

    private IDataProvider provider;
    private ConfigData dataConfig;
    public final int passHash;
    private StringBuilder stringBuilder;

    public BDataManager (IDataProvider provider, ConfigData dataConfig) {

        this.provider = provider;
        this.dataConfig = dataConfig;
        this.passHash = 92668751;
        this.stringBuilder = new StringBuilder();

    }

    @Override
    public boolean IsPass(String InputPass) {

        return this.passHash == InputPass.hashCode();

    }

    @Override
    public Map<Integer, T> getList() {

        Map<Integer, T> list = new HashMap<>();

        String[] data;

        try
        {

            data = this.provider.getRawData(dataConfig).split("\n");

            for (String item : data) {

                List<Command> commandList = new ArrayList<>();
                String[] rawData = item.split(";");
                commandList.add(new Command(rawData[5], rawData[6]));

                switch (rawData[3]) {

                    case "Кот":

                        Animal cat = new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.CAT);

                        if(list.containsValue(cat)) {

                            list.get(cat.getId()).getCommands().add(commandList.get(0));

                        } else {

                            list.put(cat.getId(), (T) cat);

                        }
                         
                        break;

                    case "Собака":

                        Animal dog = new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.DOG);

                        if(list.containsValue(dog)) {

                            list.get(dog.getId()).getCommands().add(commandList.get(0));

                        } else {

                            list.put(dog.getId(), (T) dog);

                        }
                         
                        break;

                    case "Хомяк":

                        Animal humster = new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.HUMSTER);

                        if(list.containsValue(humster)) {

                            list.get(humster.getId()).getCommands().add(commandList.get(0));

                        } else {

                            list.put(humster.getId(), (T) humster);

                        }
                         
                        break;

                    case "Лошадь":

                        Animal horse = new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.HORSE);

                        if(list.containsValue(horse)) {

                            list.get(horse.getId()).getCommands().add(commandList.get(0));

                        } else {

                            list.put(horse.getId(), (T) horse);

                        }
                         
                        break;

                    case "Осел":

                        Animal dunkey = new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.DUNKEY);

                        if(list.containsValue(dunkey)) {

                            list.get(dunkey.getId()).getCommands().add(commandList.get(0));

                        } else {

                            list.put(dunkey.getId(), (T) dunkey);

                        }
                         
                        break;

                    case "Верблюд":

                        Animal camal = new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.CAMAL);

                        if(list.containsValue(camal)) {

                            list.get(camal.getId()).getCommands().add(commandList.get(0));

                        } else {

                            list.put(camal.getId(), (T) camal);

                        }
                         
                        break;
                
                    default:

                        System.out.println("Такой группы животных нет!");

                        break;

                }

            }

        } catch (Exception e) {

            System.out.println(e);

        }

        return list;

    }

    @Override
    public boolean save(T objects) {

        try {

            return this.provider.setRawData(this.dataConfig, objects);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
        
    }

}