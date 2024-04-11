package Fitnes;
import java.util.ArrayList;
import java.util.Date;

class Client {
    private String firstName;
    private String lastName;
    private int birthYear;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Client(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    // геттеры для получения информации о клиенте
}

class Membership {
    public Date getRegistrationDate() {
        return registrationDate;
    }

    private Date registrationDate;

    public Date getExpiryDate() {
        return expiryDate;
    }

    private Date expiryDate;

    public Client getClient() {
        return client;
    }

    private Client client;

    public Membership(Client client, Date registrationDate, Date expiryDate) {
        this.client = client;
        this.registrationDate = registrationDate;
        this.expiryDate = expiryDate;
    }

}

class FitnessClub {
    private ArrayList<Membership> gymMemberships;
    private ArrayList<Membership> poolMemberships;
    private ArrayList<Membership> groupClassMemberships;
    private final int MAX_CAPACITY = 20;

    public FitnessClub() {
        this.gymMemberships = new ArrayList<>();
        this.poolMemberships = new ArrayList<>();
        this.groupClassMemberships = new ArrayList<>();
    }

    public void addMembership(Membership membership, String zone) {
        switch (zone) {
            case "тренажерный зал":
                if (gymMemberships.size() < MAX_CAPACITY && !isMembershipExpired(membership)) {
                    gymMemberships.add(membership);
                } else {
                    System.out.println("Невозможно добавить абонемент в тренажерный зал.");
                }
                break;
            case "бассейн":
                if (poolMemberships.size() < MAX_CAPACITY && !isMembershipExpired(membership)) {
                    poolMemberships.add(membership);
                } else {
                    System.out.println("Невозможно добавить абонемент в бассейн.");
                }
                break;
            case "групповые занятия":
                if (groupClassMemberships.size() < MAX_CAPACITY && !isMembershipExpired(membership)) {
                    groupClassMemberships.add(membership);
                } else {
                    System.out.println("Невозможно добавить абонемент на групповые занятия.");
                }
                break;
            default:
                System.out.println("Неизвестная зона: " + zone);
        }
    }

    private boolean isMembershipExpired(Membership membership) {
        Date currentDate = new Date();
        return currentDate.after(membership.getExpiryDate());
    }

    public void printVisitors() {
        System.out.println("Посетители зала:");
        printMemberships(gymMemberships);
        System.out.println("\nПосетители бассейна:");
        printMemberships(poolMemberships);
        System.out.println("\nПосетители групповых занятий:");
        printMemberships(groupClassMemberships);
    }

    private void printMemberships(ArrayList<Membership> memberships) {
        for (Membership membership : memberships) {
            System.out.println(membership.getClient().getFirstName() + " " + membership.getClient().getLastName());
        }
    }
}

public class FitnesClub {
    public static void main(String[] args) {
        FitnessClub fitnessClub = new FitnessClub();

        
        Client client1 = new Client("Иван", "Иванов", 1990);
        Client client2 = new Client("Петр", "Петров", 1985);


        Membership membership1 = new Membership(client1, new Date(), new Date());
        Membership membership2 = new Membership(client2, new Date(), new Date());


        fitnessClub.addMembership(membership1, "тренажерный зал");
        fitnessClub.addMembership(membership2, "бассейн");


        fitnessClub.printVisitors();
    }
}
