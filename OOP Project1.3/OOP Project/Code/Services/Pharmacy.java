package Services;

import java.util.HashMap;
import java.util.Scanner;

public class Pharmacy {
    HashMap<String, Integer> medicineType1 = new HashMap<>();
    HashMap<String, Integer> medicineType2 = new HashMap<>();
    HashMap<String, Integer> medicineType3 = new HashMap<>();
    HashMap<String, Integer> medicineType4 = new HashMap<>();
    HashMap<String, Integer> medicineType5 = new HashMap<>();
    HashMap<String, Integer> medicineType6 = new HashMap<>();
    

    HashMap<String, Integer> cart = new HashMap<>();
    
    
    public Pharmacy() {
        
        medicineType1.put("Paracetamol (500mg)", 30);
        medicineType1.put("Ibuprofen (200mg)", 50);
        medicineType1.put("Calpol (120mg)", 40);
        medicineType1.put("Crocin (500mg)", 35);
        medicineType1.put("Dolo 650 (650mg)", 60);
        medicineType1.put("Panadol (500mg)", 45);
        medicineType1.put("Advil (200mg)", 55);
        medicineType1.put("Tylenol (500mg)", 50);
        
        medicineType2.put("Omeprazole (20mg)", 80);
        medicineType2.put("Pantoprazole (40mg)", 75);
        medicineType2.put("Ranitidine (150mg)", 60);
        medicineType2.put("Esomeprazole (20mg)", 100);
        medicineType2.put("Gasex", 70);
        medicineType2.put("Digene", 45);
        medicineType2.put("Maalox", 55);
        medicineType2.put("Gaviscon", 50);
        
        medicineType3.put("Zedex Syrup", 80);
        medicineType3.put("Tixylix (100ml)", 100);
        medicineType3.put("Robitussin (100ml)", 120);
        medicineType3.put("Dextromethorphan", 45);
        medicineType3.put("Vicks VapoRub", 40);
        medicineType3.put("Codelac", 85);
        
        medicineType4.put("Diclofenac (50mg)", 60);
        medicineType4.put("Voltaren Gel", 120);
        medicineType4.put("Methylprednisolone (4mg)", 100);
        medicineType4.put("Tramadol (50mg)", 120);
        
        medicineType5.put("Betnovate Cream", 75);
        medicineType5.put("Clobetasol (20g)", 90);
        medicineType5.put("Neosporin Ointment", 60);
        medicineType5.put("Fucidin Cream", 110);
        medicineType5.put("Cetrizine", 40);
        medicineType5.put("Calamine Lotion", 50);
        
        medicineType6.put("Amoxicillin (500mg)", 40);
        medicineType6.put("Azithromycin (250mg)", 80);
        medicineType6.put("Ciprofloxacin (500mg)", 50);
    }
    
    
    public void buyMedicines() {
        Scanner scanner = new Scanner(System.in);
    
        String boldWhite = "\033[1;37m";  
        String reset = "\033[0m";         
    
        
        System.out.println(boldWhite + "What kind of medicines do you need?" + reset);
        System.out.println(boldWhite + "1. Fever Medicines" + reset);
        System.out.println(boldWhite + "2. Gastric Medicines" + reset);
        System.out.println(boldWhite + "3. Cough Syrups" + reset);
        System.out.println(boldWhite + "4. Pain Relief" + reset);
        System.out.println(boldWhite + "5. Skin Care" + reset);
        System.out.println(boldWhite + "6. Antibiotics" + reset);
        System.out.print(boldWhite + "Enter the type of medicine (1-6): " + reset);
        int medicineTypeChoice = scanner.nextInt();
    
        HashMap<String, Integer> selectedType = null;
    
        switch (medicineTypeChoice) {
            case 1:
                selectedType = medicineType1;
                break;
            case 2:
                selectedType = medicineType2;
                break;
            case 3:
                selectedType = medicineType3;
                break;
            case 4:
                selectedType = medicineType4;
                break;
            case 5:
                selectedType = medicineType5;
                break;
            case 6:
                selectedType = medicineType6;
                break;
            default:
                System.out.println(boldWhite + "Invalid choice. Please try again." + reset);
                return;
        }
    
        
        System.out.println(boldWhite + "\nSelect the medicine you want to buy:" + reset);
        int index = 1;
        for (String medicine : selectedType.keySet()) {
            System.out.println(boldWhite + index + ". " + medicine + " - " + selectedType.get(medicine) + " Taka"  + reset);
            index++;
        }
    
        System.out.print(boldWhite + "\nEnter the number of the medicine you want to buy: " + reset);
        int selectedMedicine = scanner.nextInt();
    
        String selectedMedicineName = (String) selectedType.keySet().toArray()[selectedMedicine - 1];
        int selectedPrice = selectedType.get(selectedMedicineName);
        cart.put(selectedMedicineName, selectedPrice);
    
        System.out.print(boldWhite + "\nDo you want to buy more medicines? (yes/no): " + reset);
        scanner.nextLine();  
        String continueBuying = scanner.nextLine();
    
        if (continueBuying.equalsIgnoreCase("yes")) {
            buyMedicines();  
        } else {
            int total = 0;
            System.out.println(boldWhite + "\n=== Your Cart ===" + reset);
            for (String medicine : cart.keySet()) {
                System.out.println(boldWhite + medicine + " - " + cart.get(medicine) + " Taka" + reset);
                total += cart.get(medicine);
            }
            System.out.println(boldWhite + "\nTotal Price: " + total + " Taka" + reset);
            System.out.println("");
        }
    }
    
    
    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.buyMedicines();
    }
}