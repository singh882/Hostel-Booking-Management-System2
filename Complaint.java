import java.util.ArrayList;

public class Complaint {

    private final ArrayList<String> complaints;

    public Complaint() {

        complaints = new ArrayList<>();

    }

    public void addComplaint(String complaint) {

        complaints.add(complaint);

        System.out.println("Complaint Registered Successfully.");

    }

    public void displayComplaints() {

        if (complaints.isEmpty()) {

            System.out.println("\nNo Complaints Available.");

            return;

        }

        System.out.println("\n========== COMPLAINTS ==========");

        for (int i = 0; i < complaints.size(); i++) {

            System.out.println((i + 1) + ". " + complaints.get(i));

        }

        System.out.println("================================");

    }

}
