import java.util.ArrayList;

public class Sorter {

    public static void swap(ArrayList<Phone> array, int i, int j) {
        Phone aux = array.get(i);
        array.set(i, array.get(j));
        array.set(j, aux);
    }

    public static void selectionSize(ArrayList<Phone> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j).getSize() < array.get(i).getSize()) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void insertionSize(ArrayList<Phone> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = i; 0 < j; j--) {
                if (array.get(j).getSize() < array.get(j - 1).getSize()) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void selectionModel(ArrayList<Phone> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                for (int k = 0; k < array.get(j).getModel().length() && k < array.get(i).getModel().length(); k++) {
                    if (array.get(j).getModel().charAt(k) != array.get(i).getModel().charAt(k)) {
                        if ((int) array.get(j).getModel().charAt(k) < (int) array.get(i).getModel().charAt(k)) {
                            swap(array, i, j);
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void insertionModel(ArrayList<Phone> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = i; 0 < j; j--) {
                for (int k = 0; k < array.get(j).getModel().length() && k < array.get(j - 1).getModel().length(); k++) {
                    if (array.get(j).getModel().charAt(k) != array.get(j - 1).getModel().charAt(k)) {
                        if ((int) array.get(j).getModel().charAt(k) < (int) array.get(j - 1).getModel().charAt(k)) {
                            swap(array, j, j - 1);
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void mergeSize(ArrayList<Phone> array, int arrayLength) {
        if (arrayLength < 2) {
            return;
        }
        int mid = arrayLength / 2;
        ArrayList<Phone> l = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            l.add(new Phone("", 0));
        }
        ArrayList<Phone> r = new ArrayList<>();
        for (int i = 0; i < arrayLength - mid; i++) {
            r.add(new Phone("", 0));
        }

        for (int i = 0; i < mid; i++) {
            l.set(i, array.get(i));
        }
        for (int i = mid; i < arrayLength; i++) {
            r.set(i - mid, array.get(i));
        }
        mergeSize(l, mid);
        mergeSize(r, arrayLength - mid);

        int left = mid;
        int right = arrayLength - mid;
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l.get(i).getSize() <= r.get(j).getSize()) {
                array.set(k++, l.get(i++));
            } else {
                array.set(k++, r.get(j++));
            }
        }
        while (i < left) {
            array.set(k++, l.get(i++));
        }
        while (j < right) {
            array.set(k++, r.get(j++));
        }
    }

    public static void mergeModel(ArrayList<Phone> array, int arrayLength) {
        if (arrayLength < 2) {
            return;
        }
        int mid = arrayLength / 2;
        ArrayList<Phone> l = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            l.add(new Phone("", 0));
        }
        ArrayList<Phone> r = new ArrayList<>();
        for (int i = 0; i < arrayLength - mid; i++) {
            r.add(new Phone("", 0));
        }

        for (int i = 0; i < mid; i++) {
            l.set(i, array.get(i));
        }
        for (int i = mid; i < arrayLength; i++) {
            r.set(i - mid, array.get(i));
        }
        mergeSize(l, mid);
        mergeSize(r, arrayLength - mid);

        int left = mid;
        int right = arrayLength - mid;
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            for (int x = 0; x < l.get(i).getModel().length() && x < r.get(j).getModel().length(); x++) {
                if (l.get(i).getModel().charAt(x) != r.get(j).getModel().charAt(x)) {
                    if ((int) l.get(i).getModel().charAt(x) <= (int) r.get(j).getModel().charAt(x)) {
                        array.set(k++, l.get(i++));
                    } else {
                        array.set(k++, r.get(j++));
                    }
                    break;
                }
            }
        }
        while (i < left) {
            array.set(k++, l.get(i++));
        }
        while (j < right) {
            array.set(k++, r.get(j++));
        }
    }
}