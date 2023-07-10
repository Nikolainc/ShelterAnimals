package core.service;

import java.util.ArrayList;
import java.util.List;

import core.enums.AnimalType;
import core.model.Animal;
import core.model.Command;
import core.model.PackAnimal;
import core.model.Pet;
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
    public List<T> getList() {

        List<T> list = new ArrayList<>();
        String[] data;

        try
        {
            List<Command> commandList = new ArrayList<>();
            data = this.provider.getRawData(dataConfig).split("\n");

            for (String item : data) {

                String[] rawData = item.split(";");
                commandList.add(new Command(rawData[5], rawData[6]));

                switch (rawData[3]) {

                    case "Кот":

                        list.add((T) new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.CAT));
                        break;

                    case "Собака":

                        list.add((T) new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.DOG ));
                        break;

                    case "Хомяк":

                        list.add((T) new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.HUMSTER ));
                        break;

                    case "Лошадь":

                        list.add((T) new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.HORSE ));
                        break;

                    case "Осел":

                        list.add((T) new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.DUNKEY ));
                        break;

                    case "Верблюд":

                        list.add((T) new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[2], commandList, AnimalType.CAMAL ));
                        break;
                
                    default:

                        System.out.println("Такой группы животных нет!");

                        break;

                }

            }

        } catch (Exception e) {

            System.out.println(e);

        }
        for (T item : list) {
            System.out.println(item);
        }
        return list;

    }

    @Override
    public boolean saveList(List<T> objects) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savePass'");
    }

}