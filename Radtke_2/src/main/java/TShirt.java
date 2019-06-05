import java.util.ArrayList;

//Clase polera, con su constructor, atributos y respectivos setters y getters.
public class TShirt {

    private boolean printed;
    private int id;
    private String material;
    private String size;

    public TShirt(boolean print, int id, String material, String size) {
        this.printed = print;
        this.id = id;
        this.material = material;
        this.size = size;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrint(boolean print) {
        this.printed = print;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    //Despliega un listado de todas las poleras ya creadas.
    public static void showTShirts(ArrayList<TShirt> tShirts) {
        if (tShirts.size() == 0) {
            System.out.println("There are no T-Shirts yet.");
        } else {
            System.out.println("Showing T-Shirts...");
        }
        for (TShirt tShirt : tShirts) {
            System.out.println("Printed: " + tShirt.isPrinted() + "; ID: " + tShirt.getId() + "; Material: " + tShirt.getMaterial() + "; Size: " + tShirt.getSize() + ".");
        }
    }

    //Metodo para crear paso a paso una nueva polera.
    public static void createTShirt(ArrayList<TShirt> tShirts) {
        System.out.println("Creating a T-Shirt...");
        String answer;
        do {
            System.out.println("Is printed? (true/false)");
            answer = UserInteraction.getInput().toLowerCase();
        } while (!answer.equals("true") && !answer.equals("false"));
        boolean print = Boolean.parseBoolean(answer);
        int id = 0;
        for (int i = 0; i < tShirts.size(); i++) {
            if (tShirts.get(i).getId() == id) {
                id++;
                i = 0;
            }
        }
        do {
            System.out.println("Which material? (cotton/polyester/spandex)");
            answer = UserInteraction.getInput().toLowerCase();
        } while (!answer.equals("cotton") && !answer.equals("polyester") && !answer.equals("spandex"));
        String material = answer;
        do {
            System.out.println("Which size? (S/M/L/XL)");
            answer = UserInteraction.getInput().toUpperCase();
        } while (!answer.equals("S") && !answer.equals("M") && !answer.equals("L") && !answer.equals("XL"));
        String size = answer;
        tShirts.add(id, new TShirt(print, id, material, size));
        System.out.println("T-Shirt created successfully.");
        FileManager.saveData(tShirts);
    }

    //Metodo para eliminar una polera ingresando su ID.
    public static void deleteTShirt(ArrayList<TShirt> tShirts) {
        System.out.println("Deleting a T-Shirt...");
        System.out.println("Input ID of the T-Shirt you want deleted.");
        boolean error;
        int id = 0;
        do {
            try {
                id = Integer.parseInt(UserInteraction.getInput());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                error = true;
            }
        } while (error);
        error = true;
        for (int i = 0; i < tShirts.size(); i++) {
            if (tShirts.get(i).getId() == id) {
                tShirts.remove(i);
                tShirts.trimToSize();
                System.out.println("T-Shirt deleted successfully.");
                error = false;
            }
        }
        if (error) System.out.println("There is no T-Shirt with such ID.");
        FileManager.saveData(tShirts);
    }
}
