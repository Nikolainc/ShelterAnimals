package core.service;

import java.util.ArrayList;
import java.util.List;

import core.enums.AnimalType;
import core.model.Animal;
import core.model.Command;
import core.model.PackAnimal;
import core.model.Pet;
import sql.ConfigData;

public class DataManager<T extends Animal> implements IDataManager<T> {

    private IDataProvider provider;
    private ConfigData dataFileName;
    private final String pass;
    private StringBuilder stringBuilder;

    public DataManager (IDataProvider provider, ConfigData dataName) {

        this.provider = provider;
        this.dataFileName = dataName;
        this.pass = "92668751";
        this.stringBuilder = new StringBuilder();

    }

    public List<T> getList() {

        List<T> list = new ArrayList<>();
        String[] data;

        try
        {
            data = this.provider.getRawData(dataFileName).split("\n");
            for (String item : data) {

            String[] rawData = item.split(";");

            switch (Integer.parseInt(rawData[2])) {

                case 1:

                    list.add((T) new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[3], new ArrayList<Command>(), AnimalType.CAT ));
                    break;

                case 2:

                    list.add((T) new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[3], new ArrayList<Command>(), AnimalType.DOG ));
                    break;

                case 3:

                    list.add((T) new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[3], new ArrayList<Command>(), AnimalType.HUMSTER ));
                    break;

                case 4:

                    list.add((T) new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[3], new ArrayList<Command>(), AnimalType.HORSE ));
                    break;

                case 5:

                    list.add((T) new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[3], new ArrayList<Command>(), AnimalType.DUNKEY ));
                    break;

                case 6:

                    list.add((T) new PackAnimal(Integer.parseInt(rawData[0]), rawData[1], rawData[3], new ArrayList<Command>(), AnimalType.CAMAL ));
                    break;
            
                default:

                    list.add((T) new Pet(Integer.parseInt(rawData[0]), rawData[1], rawData[3], new ArrayList<Command>(), AnimalType.UNKNOWN ));
                    break;

            }

        }

        } catch (Exception e) {

            System.out.println(e);

        }
        
        return list;

    }

    public boolean saveList(List<T> objects) {

        for (int i = 0; i < objects.size() - 1; i++) {

            var item = objects.get(i);
            stringBuilder.append(item.getId() + ";" + item.gName() + ";" + item.gType() + ";" + item.gBirthday() + ";" + item + "\n");

        }

        String rawData = stringBuilder.toString();
        stringBuilder.setLength(0);
        return true;

    }

    @Override
    public boolean savePass(String pass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savePass'");
    }

    @Override
    public boolean isEmpty(String fileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

}