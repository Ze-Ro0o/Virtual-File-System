import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (!FileParser.getInstance().parseFile())
        {
            System.out.println("Enter the size of the system in KB: ");
            Scanner scanner = new Scanner(System.in);
            int systemSizeInKB = scanner.nextInt();
            VirtualFileSystem.getInstance().setSystemSizeInKB(systemSizeInKB);
        }
        // TODO code application logic here
        VirtualFileSystem vfs = VirtualFileSystem.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose type of allocation: \n"
                            + "1- Contiguous allocation\n"
                            + "2- Indexed allocation\n"
                            + "3- Linked allocation\n");
        int allocationType = sc.nextInt();

        if (allocationType == 1) {
            ContiguousAllocator ca = new ContiguousAllocator();
            vfs.setAllocation(ca);
        } else if (allocationType == 2) {
            IndexedAllocator ia = new IndexedAllocator();
            vfs.setAllocation(ia);
        } else if (allocationType == 3) {
            LinkedAllocator la = new LinkedAllocator();
            vfs.setAllocation(la);
        } else {
            System.out.println("Invalid allocation type");
            return;
        }
        Scanner sc2 = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: \n");
            String input = sc2.nextLine();
            ArrayList<String> command;
            try {
                command = CommandParser.getInstance().parseCommand(input);
            } catch (Exception e) {
                System.out.println(e.toString());
                continue;
            }
            if (command.get(0).equals("CreateFile")) {
                try {
                    vfs.createFile(command.get(1), Integer.parseInt(command.get(2)));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            } else if (command.get(0).equals("DeleteFile")) {
                try {
                    vfs.deleteFile(command.get(1));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            } else if (command.get(0).equals("CreateFolder")) {
                try {
                    vfs.createFolder(command.get(1));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            } else if (command.get(0).equals("DeleteFolder")) {
                try {
                    vfs.deleteFolder(command.get(1));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            } else if (command.get(0).equals("DisplayDiskStatus")) {
                // TODO
            } else if (command.get(0).equals("DisplayDiskStructure")) {
                // TODO
            } else if (command.get(0).equals("Exit")) {
                FileParser.getInstance().updateFile();
                System.out.println("Exiting...");
                break;
            }
        }
    }

}
