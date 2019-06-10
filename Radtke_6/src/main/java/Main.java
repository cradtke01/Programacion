import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] phoneData = FileManager.readFile("celulares.csv").split("\n");
        ArrayList<Phone> phones = new ArrayList<>();
        for (int i = 1; i < phoneData.length; i++) {
            phones.add(new Phone(phoneData[i].split(";")[0], Double.parseDouble(phoneData[i].split(";")[1])));
        }
        print(phones);
        Sorter.selectionModel(phones);
        //Sorter.insertionModel(phones);
        //Sorter.mergeModel(phones,phones.size());
        //Sorter.selectionSize(phones);
        //Sorter.insertionSize();
        //Sorter.mergeSize(phones,phones.size());
        System.out.println("-----------------");
        print(phones);
    }

    public static void print(ArrayList<Phone> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
    }
}