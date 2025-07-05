import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberDAO memberDAO = new MemberDAO();
        MembershipPlanDAO planDAO = new MembershipPlanDAO();
        MemberPlanDAO memberPlanDAO = new MemberPlanDAO();

        while (true) {
            System.out.println("\n=== GYM MEMBERSHIP SYSTEM ===");
            System.out.println("1. Add Member");
            System.out.println("2. View All Members");
            System.out.println("3. Add Membership Plan");
            System.out.println("4. Assign Plan to Member");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Add Member
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Member member = new Member(name, age, gender, phone, email);
                    if (memberDAO.addMember(member)) {
                        System.out.println(" Member added.");
                    } else {
                        System.out.println(" Failed to add member.");
                    }
                    break;

                case 2:
                    // View Members
                    List<String> members = memberDAO.getAllMembers();
                    if (members.isEmpty()) {
                        System.out.println("No members found.");
                    } else {
                        System.out.println("--- Member List ---");
                        members.forEach(System.out::println);
                    }
                    break;

                case 3:
                    // Add Plan
                    System.out.print("Plan Name: ");
                    String planName = sc.nextLine();
                    System.out.print("Duration (months): ");
                    int duration = sc.nextInt(); sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble(); sc.nextLine();

                    MembershipPlan plan = new MembershipPlan(planName, duration, price);
                    if (planDAO.addPlan(plan)) {
                        System.out.println("Plan added.");
                    } else {
                        System.out.println("Failed to add plan.");
                    }
                    break;

                case 4:

                    System.out.println("Available Members:");
                    List<String> allMembers = memberDAO.getAllMembers();
                    allMembers.forEach(System.out::println);


                    System.out.println("Available Plans:");
                    List<String> allPlans = planDAO.getAllPlans(); // You need to implement this
                    allPlans.forEach(System.out::println);


                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Plan ID: ");
                    int planId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = sc.nextLine();

                    boolean assigned = memberPlanDAO.assignPlanToMember(memberId, planId, startDate);
                    if (assigned) {
                        System.out.println("Plan assigned to member.");
                    } else {
                        System.out.println("Failed to assign plan.");
                    }
                    break;


                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
