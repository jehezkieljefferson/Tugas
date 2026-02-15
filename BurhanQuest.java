import java.util.Scanner;

public class BurhanQuest {
    // Banner pembuka, silakan manfaatkan variabel ini untuk menampilkan banner di awal dan di akhir program
    private static final String BANNER = """
                  ____             _                  ___                  _   \r"
                "| __ ) _   _ _ __| |__   __ _ _ __  / _ \\ _   _  ___  ___| |_ \r"
                "|  _ \\| | | | '__| '_ \\ / _` | '_ \\| | | | | | |/ _ \\/ __| __|\r" 
                "| |_) | |_| | |  | | | | (_| | | | | |_| | |_| |  __/\\__ \\ |_ \r" 
                "|____/ \\__,_|_|  |_| |_|\\__,_|_| |_|\\__\\_\\\\__,_|\\___||___/\\__|""";
    private static final String STUDENT_NAME = "Jehezkiel Jefferson I Latupeirissa";
    private static final String STUDENT_ID = "2506611156";


    // Penanda atribut, silakan manfaatkan variabel ini untuk menandai atribut di dalam data
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static int questId = 1;
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static int travelerId = 1;
    private static final char LEVEL_IDENTIFIER = '$';

    private static final int MAX_EXP = 1_310_720_000;

    // Scanner untuk input, silakan manfaatkan variabel ini untuk mengambil input dari user
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);System.out.println();
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        int questCount = 0, travelerCount = 0;
        boolean invalidInput = true;

        //Sub-Task2: Seeding Data dan Fitur Menambah Quest dan Pengembara
        //Input jumlah quest & pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            String questCountInput = input.nextLine();
            boolean validitasQuestCountInput = questCountInput.matches("\\d+");
            if (validitasQuestCountInput) validitasQuestCountInput = Integer.parseInt(questCountInput) >= 0;
            if (!validitasQuestCountInput) System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            else {questCount += Integer.parseInt(questCountInput); invalidInput = false;}}
        
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            boolean validitasTravelerCountInput = travelerCountInput.matches("\\d+");
            if (validitasTravelerCountInput) validitasTravelerCountInput = Integer.parseInt(travelerCountInput) >= 0;
            if (!validitasTravelerCountInput) System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            else {travelerCount+= Integer.parseInt(travelerCountInput); invalidInput = false;}}
            
        System.out.println();

        String questData = "";
        String travelerData = "";
        if (questCount > 0) System.out.println("Mulai memasukkan data quest.");
        int i = 1;
        while (i <= questCount) {
            System.out.printf("Quest %d\n", i);
            System.out.print("Masukan nama quest: ");
            String NamaQuest = input.nextLine().trim();
            //VNQ = ValiditasNamaQuest
            boolean VNQ = NamaQuest.matches("[a-zA-Z0-9 ]+");

            System.out.print("Masukan deskripsi quest: ");
            String DeskripsiQuest = input.nextLine().trim();
            //VDK = Validitas Deskripsi Quest
            boolean VDK = DeskripsiQuest.matches("[a-zA-Z0-9 ]+");

            System.out.print("Masukan reward quest berupa bilangan bulat nonnegatif: ");
            String RewardQuest = input.nextLine();
            //VRQ = Validitas Reward Quest
            boolean VRQ = RewardQuest.matches("\\d+") && Integer.parseInt(RewardQuest) >= 0;

            System.out.print("Masukan bonus exp quest berupa bilangan bulat nonnegatif: ");
            String BonusQuest = input.nextLine().trim();
            //VBQ = Validitas Bonus Quest
            boolean VBQ = BonusQuest.matches("\\d+") && Integer.parseInt(BonusQuest) >= 0;

            System.out.print("Masukan tingkat kesulitan quest (opsi: mudah, menengah, sulit): ");
            String KesulitanQuest = input.nextLine().trim();
            //VKQ = Validitas Kesulitan Quest
            boolean VKQ = KesulitanQuest.equalsIgnoreCase("Mudah") || KesulitanQuest.equalsIgnoreCase("menengah") || KesulitanQuest.equalsIgnoreCase("sulit");

            String IdQuest = "Q" + i; String StatusQuest = "tersedia";

            if (!(VNQ && VDK && VRQ && VBQ && VKQ)) System.out.println("Input tidak valid.Harap masukan data dengan benar: ");
            else{
                NamaQuest = NAME_IDENTIFIER + NamaQuest;
                DeskripsiQuest = DESC_IDENTIFIER + DeskripsiQuest;
                RewardQuest = REWARD_IDENTIFIER + RewardQuest;
                BonusQuest = EXP_IDENTIFIER + BonusQuest;
                StatusQuest = STATUS_IDENTIFIER + StatusQuest;
                KesulitanQuest = DIFFICULTY_IDENTIFIER + KesulitanQuest;
                System.out.println("Quest berhasil ditambahkan");
                questData = questData + IdQuest + '\n' + NamaQuest + '\n' + DeskripsiQuest + '\n' + RewardQuest + '\n' + BonusQuest + '\n' + KesulitanQuest + '\n'  + StatusQuest +'\n';
                i++;
            }
        }
        if (questCount>0) System.out.println();
        //Input data pengembara
        i = 1;
        if (travelerCount > 0) System.out.println("Mulai memasukkan data pengembara.");
        while (i <= travelerCount){
            System.out.printf("Pengembara %d\n", i);
            System.out.print("Masukan nama pengembara: ");
            String NamaTraveler = input.nextLine().trim();
            //VNT = Validitas Nama Traveler
            boolean VNT = NamaTraveler.matches("[a-zA-z0-9]+");

            System.out.print("Masukan level pengembara berupa bilangan bulat [1-20]: ");
            String LevelTraveler = input.nextLine();
            //VLT = Validitas Level Traveler
            boolean VLT = LevelTraveler.matches("\\d+") && Integer.parseInt(LevelTraveler) >= 1 && Integer.parseInt(LevelTraveler) <= 20;

            String IdTraveler = "P" + "" + i; String StatusTraveler = "kosong";
            String ExpTraveler = String.valueOf(5000 * (int) Math.pow(2, Integer.parseInt(LevelTraveler)-2));
            if (!(VNT && VLT)) {System.out.println("Input tidak valid. Harap masukan data dengan benar");}
            else {
                NamaTraveler = NAME_IDENTIFIER + NamaTraveler;
                LevelTraveler = LEVEL_IDENTIFIER + LevelTraveler;
                ExpTraveler = EXP_IDENTIFIER + ExpTraveler;
                travelerData = travelerData + IdTraveler + '\n' + NamaTraveler + '\n' + LevelTraveler + '\n' + ExpTraveler + '\n' + StatusTraveler + '\n';
                System.out.println("Pengembara berhasil ditambahkan");
                i++;
            }
        }
        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar quest");
            System.out.println("2. Lihat daftar pengembara");
            System.out.println("3. Tambah quest");
            System.out.println("4. Tambah pengembara");
            System.out.println("5. Menjalankan quest");
            System.out.println("6. Menyelesaikan quest");
            System.out.println("7. Filter daftar quest");
            System.out.println("8. Filter daftar pengembara");
            System.out.println("9.Tampilkan daftar quest terurut");
            System.out.println("10.Tampilkan daftar pengembara terurut");
            System.out.println("11. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    String questDataCase1 = questData;
                    Scanner Scanner1 = new Scanner(questDataCase1);
                    i = 1;
                    while (i<=questCount){
                        System.out.printf("ID Quest: %s\n", Scanner1.nextLine());
                        System.out.printf("Nama Quest: %s\n", Scanner1.nextLine().substring(1));
                        System.out.printf("Deskripsi Quest: %s\n", Scanner1.nextLine().substring(1));
                        System.out.printf("Reward Quest: %s koin\n", Scanner1.nextLine().substring(1));
                        System.out.printf("Bonus EXP Quest: %s poin exp\n", Scanner1.nextLine().substring(1));
                        String TingkatKesulitanCase1 = Scanner1.nextLine();
                        String SimbolKesulitanQuest = "";
                        if (TingkatKesulitanCase1.substring(1).equalsIgnoreCase("mudah")) SimbolKesulitanQuest = "\u2605";
                        else if (TingkatKesulitanCase1.substring(1).equalsIgnoreCase("menengah")) SimbolKesulitanQuest ="\u2605\u2605";
                        else SimbolKesulitanQuest = "\u2605\u2605\u2605";
                        System.out.printf("Tingkat kesulitan: %s\n", SimbolKesulitanQuest);
                        String StatusQuestCase1 = Scanner1.nextLine().substring(1);
                        if (StatusQuestCase1.equalsIgnoreCase("tersedia")) StatusQuestCase1 += " \ud83d\udfe2";
                        else if (StatusQuestCase1.equalsIgnoreCase("diambil")) StatusQuestCase1+= " \u231b";
                        else StatusQuestCase1 += " \ud83c\udfc6";
                        System.out.printf("Status Quest: %s\n", StatusQuestCase1);
                        System.out.println(); i++;
                    }
                    Scanner1.close();
                    break;
                case "2":
                    String travelerDataCase2 = travelerData;
                    Scanner Scanner2 = new Scanner(travelerDataCase2);
                    i = 1;
                    while (i <= travelerCount){
                        System.out.printf("ID Pengembara: %s\n", Scanner2.nextLine());
                        System.out.printf("Nama Pengembara: %s\n", Scanner2.nextLine().substring(1));
                        System.out.printf("Level Pengembara: %s\n", Scanner2.nextLine().substring(1));
                        System.out.printf("EXP Pengembara: %s poin exp\n", Scanner2.nextLine().substring(1));
                        String StatusPengembaraCase2 = Scanner2.nextLine().substring(1);
                        if (StatusPengembaraCase2.equalsIgnoreCase("kosong")) StatusPengembaraCase2 += " \u2705";
                        else StatusPengembaraCase2 += " \u274c";
                        System.out.printf("Status Pengembara: %s\n", StatusPengembaraCase2);
                        System.out.println(); i++;
                    }
                    Scanner2.close();
                    break;
                case "3":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "4":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "5":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "6":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "7":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "8":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "9":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                    System.out.println("Belum diimplementasikan");
                    break;
                case "11":
                    running = false;
                    System.out.println("Terima kasih telah menggunakan BurhanQuest!");
                    System.out.printf("Dibuat oleh: %s - %s\n", STUDENT_NAME, STUDENT_ID);
                    System.out.println(BANNER);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}