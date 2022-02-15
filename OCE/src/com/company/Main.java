package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JDBC db = new JDBC();
        db.getUserInformation();
        db.getAdminInformation();
        db.getCourseInformation();


        ArrayList<UserInformation> usersInformation = db.getUsersInformation();
        ArrayList<AdminInformation> adminsInformation = db.getAdminsInformation();
        ArrayList<Courses> coursesInformation = db.getCoursesInformation();


        Scanner menuScanner = new Scanner(System.in);
        Scanner loginScanner = new Scanner(System.in);
        Scanner passwordScanner = new Scanner(System.in);
        Scanner registerCourseScanner = new Scanner(System.in);


        int option;
        boolean isLogged = true;
        boolean isThereThisCourse = true;


        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_GREEN = "\u001B[32m";


        System.out.println("\n" + "ONLAYN KURSLARGA RO'YHATDAN O'TISH DASTURIGA XUSH KELIBSIZ !!!");
        while (true) {
            mainMenuOuter:
            {
                System.out.println("\n" + "*** ASOSIY MENYU ***" + "\n");
                System.out.println("1. Kirish/Registratsiya");
                System.out.println("2. Kurslar haqida");
                System.out.println("3. Tariflar haqida");
                System.out.println("4. Biz haqimizda");
                System.out.println("0. Dasturdan chiqish");
                System.out.print("\n" + "MENYULARDAN BIRINI TANLANG: ");

                option = menuScanner.nextInt();

                switch (option) {
                    case 1:
                        while (true) {
                            loginOrRegisterMenuOuter:
                            {
                                System.out.println("\n" + "KIRISH/REGISTRATSIYA MENYUSI." + "\n");
                                System.out.println("1. Dasturga kirish uchun 1 ni bosing");
                                System.out.print("2. Ro'yhatdan o'tish uchun 2 ni bosing: ");
                                option = menuScanner.nextInt();

                                switch (option) {
                                    case 1:
                                        while (true) {
                                            loginMenuOuter:
                                            {
                                                System.out.println("\nDASTURGA KIRISH\n");
                                                System.out.println("1. Admin sifatida kirish uchun 1 ni bosing");
                                                System.out.print("2. Foydalanuvchi sifatida kirish uchun 2 ni bosing: ");

                                                option = menuScanner.nextInt();

                                                switch (option) {
                                                    case 1:
                                                        System.out.println("\nADMIN SIFATIDA KIRISH\n");
                                                        System.out.print("Login: ");
                                                        String login = loginScanner.nextLine();
                                                        System.out.print("Parol: ");
                                                        String parol = passwordScanner.nextLine();

                                                        for (AdminInformation admin : adminsInformation) {
                                                            if (admin.getLogin().equals(login) && admin.getParol().equals(parol)) {

                                                                while (true) {
                                                                    adminMenuOuter:
                                                                    {
                                                                        System.out.println("\n*** ADMIN MODULI ***\n");
                                                                        System.out.println("1. Kurslarni boshqarish");
                                                                        System.out.println("2. Foydalanuvchilarni boshqarish");
                                                                        System.out.println("0. Asosiy menyuga qaytish");
                                                                        System.out.print("\n" + "MENYULARDAN BIRINI TANLANG: ");
                                                                        option = menuScanner.nextInt();

                                                                        if (option == 0) {
                                                                            break mainMenuOuter;
                                                                        }

                                                                        switch (option) {
                                                                            case 1:
                                                                                while (true) {
                                                                                    courseControllOuter:
                                                                                    {
                                                                                        System.out.println("\nKURSLARNI BOSHQARISH\n");
                                                                                        System.out.println("1. Yangi kurs qo'shish");
                                                                                        System.out.println("2. Kurs ma'lumotlarini o'chirish");
                                                                                        System.out.println("3. Kurs ma'lumotlarini yangilash");
                                                                                        System.out.println("4. Kurs ma'lumotlarini ko'rish");
                                                                                        System.out.println("0. Ortga qaytish");
                                                                                        System.out.print("\n" + "MENYULARDAN BIRINI TANLANG: ");
                                                                                        option = menuScanner.nextInt();
                                                                                        if (option == 0) {
                                                                                            break adminMenuOuter;
                                                                                        }

                                                                                        switch (option) {
                                                                                            case 1:
                                                                                                System.out.println("\nYANGI KURS QO'SHISH\n");
                                                                                                db.courseAdd();

                                                                                                System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break courseControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            case 2:
                                                                                                System.out.println("\nKURS MA'LUMOTLARINI O'CHIRISH\n");
                                                                                                db.courseDelete();

                                                                                                System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break courseControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            case 3:
                                                                                                System.out.println("\nKURS MA'LUMOTLARINI YANGILASH\n");
                                                                                                db.courseUpdate();

                                                                                                System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break courseControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            case 4:
                                                                                                System.out.println("\nKURS MA'LUMOTLARINI KO'RISH\n");

                                                                                                for (Courses courses : coursesInformation) {
                                                                                                    courses.showCourses();
                                                                                                }

                                                                                                System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break courseControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            default: {
                                                                                                System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }

                                                                            case 2:
                                                                                while (true) {
                                                                                    usersControllOuter:
                                                                                    {
                                                                                        System.out.println("\nFOYDALANUVCHILARNI BOSHQARISH\n");
                                                                                        System.out.println("1. Yangi foydalanuvchini qo'shish");
                                                                                        System.out.println("2. Foydalanuvchi ma'lumotlarini o'zgartirish");
                                                                                        System.out.println("3. Foydalanuvchi ma'lumotlarini o'chirish");
                                                                                        System.out.println("4. Foydalanuvchi ma'lumotlarini ko'rish");
                                                                                        System.out.println("0. Ortga qaytish");
                                                                                        System.out.print("\nMENYULARDAN BIRINI TANLANG: ");
                                                                                        option = menuScanner.nextInt();

                                                                                        if (option == 0) {
                                                                                            break adminMenuOuter;
                                                                                        }

                                                                                        switch (option) {
                                                                                            case 1:
                                                                                                System.out.println("\nYANGI FOYDALANUVCHINI QO'SISH\n");
                                                                                                db.registerUser();

                                                                                                System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break usersControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            case 2:
                                                                                                System.out.println("\nFOYDALANUVCHI MA'LUMOTLARINI O'ZGARTIRISH\n");
                                                                                                db.updateUser();

                                                                                                System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break usersControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            case 3:
                                                                                                System.out.println("\nFOYDALANUVCHI MA'LUMOTLARINI O'CHIRISH\n");
                                                                                                db.deleteUser();

                                                                                                System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break usersControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            case 4:
                                                                                                System.out.println("\nFOYDALANUVCHI MA'LUMOTLARINI KO'RISH\n");

                                                                                                for (UserInformation users : usersInformation) {
                                                                                                    users.showUsersInformation();
                                                                                                }

                                                                                                System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                option = menuScanner.nextInt();

                                                                                                if (option == 0) {
                                                                                                    break usersControllOuter;
                                                                                                }

                                                                                                break;
                                                                                            default:
                                                                                                System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                                                                                                break usersControllOuter;

                                                                                        }
                                                                                    }
                                                                                }
                                                                            default:
                                                                                System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                                                                                break;

                                                                        }
                                                                    }
                                                                }

                                                            } else {
                                                                isLogged = false;
                                                            }
                                                        }
                                                        if (!isLogged) {
                                                            System.out.println(ANSI_RED + "\nOOPS, LOGIN YOKI PAROL XATO :(" + ANSI_RESET);
                                                            break loginMenuOuter;
                                                        }

                                                        break;
                                                    case 2:
                                                        System.out.println("\nFOYDALANUVCHI SIFATIDA KIRISH\n");
                                                        System.out.print("Email: ");
                                                        String email = loginScanner.nextLine();
                                                        System.out.print("Parol: ");
                                                        parol = passwordScanner.nextLine();

                                                        for (UserInformation user: usersInformation) {
                                                            if (user.getEmail().equals(email) && user.getParol().equals(parol)) {
                                                                while (true) {
                                                                    userMenuOuter:
                                                                    {
                                                                        System.out.println("\n*** FOYDALANUVCHI MODULI ***\n");
                                                                        System.out.println("1. Profilni ko'rish");
                                                                        System.out.println("2. Yangi kursga yozilish");
                                                                        System.out.println("0. Asosiy menyuga qaytish");
                                                                        System.out.print("\nMENYULARDAN BIRINI TANLANG: ");
                                                                        option = menuScanner.nextInt();

                                                                        if (option == 0) {
                                                                            break mainMenuOuter;
                                                                        }

                                                                        switch (option) {
                                                                            case 1:
                                                                                System.out.println("\nPROFILNI KO'RISH\n");
                                                                                user.showUsersInformation();

                                                                                System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                                                                option = menuScanner.nextInt();

                                                                                if (option == 0) {
                                                                                    break userMenuOuter;
                                                                                }

                                                                            case 2:
                                                                                System.out.println("\nYANGI KURSGA YOZILISH\n");
                                                                                System.out.print("Yozilmoqchi bo'lgan kurs nomini kiriting: ");
                                                                                String courseName = registerCourseScanner.nextLine();

                                                                                for (Courses courses: coursesInformation) {
                                                                                    if (courses.getNomi().equalsIgnoreCase(courseName)) {
                                                                                        System.out.print("Yozilmoqchi bo'lgan tarifigiz nomini kiriting: ");
                                                                                        String tarifName = registerCourseScanner.nextLine();

                                                                                        int amount;
                                                                                        int percent = (courses.getNarxi() * 2)/10;

                                                                                        while (true) {
                                                                                            payMenuOuter:
                                                                                            {
                                                                                                if (tarifName.equalsIgnoreCase("Silver")) {
                                                                                                    System.out.print("To'lov miqdorini kiriting: ");
                                                                                                    amount = registerCourseScanner.nextInt();

                                                                                                    if (amount == courses.getNarxi() - percent) {
                                                                                                        db.followCourses(user.getUserId(), courses.getCourseId(), tarifName);

                                                                                                        System.out.println(ANSI_GREEN + "TARIFINGIZ: SILVER" + ANSI_RESET);
                                                                                                        System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                                                                                        option = menuScanner.nextInt();

                                                                                                        if (option == 0) {
                                                                                                            break userMenuOuter;
                                                                                                        }

                                                                                                    } else {
                                                                                                        System.out.println(ANSI_RED + "\nTO'LOV MIQDORI NOTO'G'RI KIRITILDI !!!" +
                                                                                                                "\nQAYTADAN URUNING\n" + ANSI_RESET);
                                                                                                    }

                                                                                                    break mainMenuOuter;

                                                                                                } else if (tarifName.equalsIgnoreCase("Gold")) {
                                                                                                    System.out.print("To'lov miqdorini kiriting: ");
                                                                                                    amount = registerCourseScanner.nextInt();

                                                                                                    if (amount == courses.getNarxi() - percent) {
                                                                                                        db.followCourses(user.getUserId(), courses.getCourseId(), tarifName);

                                                                                                        System.out.println(ANSI_GREEN + "TARIFINGIZ: GOLD" + ANSI_RESET);
                                                                                                        System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                                                                                        option = menuScanner.nextInt();

                                                                                                        if (option == 0) {
                                                                                                            break userMenuOuter;
                                                                                                        }

                                                                                                    } else {
                                                                                                        System.out.println(ANSI_RED + "\nTO'LOV MIQDORI NOTO'G'RI KIRITILDI !!!" +
                                                                                                                "\nQAYTADAN URUNING\n" + ANSI_RESET);
                                                                                                        break payMenuOuter;
                                                                                                    }

                                                                                                } else if (tarifName.equalsIgnoreCase("Platinum")) {
                                                                                                    System.out.print("To'lov miqdorini kiriting: ");
                                                                                                    amount = registerCourseScanner.nextInt();

                                                                                                    if (amount == courses.getNarxi() - percent - courses.getNarxi()/10) {
                                                                                                        db.followCourses(user.getUserId(), courses.getCourseId(), tarifName);

                                                                                                        System.out.println(ANSI_GREEN + "TARIFINGIZ: PLATINUM" + ANSI_RESET);
                                                                                                        System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                                                                                        option = menuScanner.nextInt();

                                                                                                        if (option == 0) {
                                                                                                            break userMenuOuter;
                                                                                                        }

                                                                                                    } else {
                                                                                                        System.out.println(ANSI_RED + "\nTO'LOV MIQDORI NOTO'G'RI KIRITILDI !!!" +
                                                                                                                "\nQAYTADAN URUNING\n" + ANSI_RESET);
                                                                                                        break payMenuOuter;
                                                                                                    }

                                                                                                } else {
                                                                                                    System.out.println(ANSI_RED + "\nBUNDAY TARIF MAVJUD EMAS :(" + ANSI_RESET);
                                                                                                    break userMenuOuter;
                                                                                                }
                                                                                            }
                                                                                        }

                                                                                    } else {
                                                                                        isThereThisCourse = false;
                                                                                    }
                                                                                }

                                                                                if (!isThereThisCourse) {
                                                                                    System.out.println(ANSI_RED + "\nBUNDAY KURS MAVJUD EMAS :(" + ANSI_RESET);
                                                                                    break userMenuOuter;
                                                                                }

                                                                            default:
                                                                                System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                                                                                break userMenuOuter;

                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                isLogged = false;
                                                            }
                                                        }

                                                        if (!isLogged) {
                                                            System.out.println(ANSI_RED + "\nOOPS, EMAIL YOKI PAROL XATO :(" + ANSI_RESET);
                                                            break loginMenuOuter;
                                                        }

                                                        break;
                                                    default:
                                                        System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                                                        break;

                                                }
                                            }
                                        }

                                    case 2:
                                        System.out.println("\nRO'YHATDAN O'TISH\n");
                                        db.registerUser();

                                        System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                        option = menuScanner.nextInt();

                                        if (option == 0) {
                                            break mainMenuOuter;
                                        }

                                        break;
                                    default:
                                        System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                                        break loginOrRegisterMenuOuter;

                                }
                            }
                        }
                    case 2:
                        System.out.println("\n" + "KURSLAR HAQIDA MA'LUMOT OLISH MENYUSI." + "\n");
                        for (Courses courses : coursesInformation) {
                            courses.showCourses();
                        }

                        System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                        option = menuScanner.nextInt();

                        if (option == 0) {
                            break mainMenuOuter;
                        }

                        break;
                    case 3:
                        while (true) {
                            tariffMenuOuter:
                            {
                                System.out.println("\n" + "TARIFLAR HAQIDA MENYUSI." + "\n");
                                System.out.println("1. Silver");
                                System.out.println("2. Gold");
                                System.out.println("3. Platinum");
                                System.out.println("0. Asosiy menyuga qaytish");
                                System.out.print("\nQaysi tarif haqida ma'lumot olishni istaysiz: ");
                                option = menuScanner.nextInt();

                                if (option == 0) {
                                    break mainMenuOuter;
                                }

                                switch (option) {
                                    case 1:
                                        System.out.println("\nSILVER TARIFI HAQIDA\n");
                                        System.out.println("Silver tarifi - bu barcha kurslarga 20% lik chegirmani taqdim etadi." +
                                                "\nKursni tugatgandan so'ng sizga takrorlash uchun yana 3 oy muddat beriladi.");

                                        System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                        option = menuScanner.nextInt();

                                        if (option == 0) {
                                            break tariffMenuOuter;
                                        }

                                        break;
                                    case 2:
                                        System.out.println("\nGOLD TARIFI HAQIDA\n");
                                        System.out.println("Gold tarifi - bu barcha kurslarga 20% lik chegirmani taqdim etadi." +
                                                "\nTelegramda yopiq guruhga qo'shilish, qo'shimcha bonus darslar, vebinarlarda" +
                                                "\nqatnashish imkoniyati mavjud. Kursni tugatgandan so'ng sizga takrorlash" +
                                                "\nuchun yana 6 oy muddat beriladi.");

                                        System.out.print("\nOrtga qaytish uchun 0 ni: ");
                                        option = menuScanner.nextInt();

                                        if (option == 0) {
                                            break tariffMenuOuter;
                                        }

                                        break;
                                    case 3:
                                        System.out.println("\nPLATINUM TARIFI HAQIDA\n");
                                        System.out.println("Platinum tarifi - bu barcha kurslarga 30% lik chegirmani taqdim etadi." +
                                                "\nTelegramda yopiq guruhga qo'shilish, qo'shimcha bonus darslar, vebinarlarda" +
                                                "\nqatnashish va portfolio uchun proyekt olish imkoniyatlari taqdim etiladi." +
                                                "\nKursni tugatgandan so'ng sizga takrorlash uchun yana 12 oy muddat beriladi.");

                                        System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                        option = menuScanner.nextInt();

                                        if (option == 0) {
                                            break tariffMenuOuter;
                                        }

                                        break;
                                    default:
                                        System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                                        break tariffMenuOuter;

                                }
                            }
                        }
                    case 4:
                        System.out.println("\n" + "BIZ HAQIMIZDA MENYUSI." + "\n");
                        System.out.println("Bizning maqsadimiz - har bir insonga yoshi va yashash manzilidan qat'iy nazar " +
                                "\nkuchli mutaxassis bo'lish imkonini berishdir. Biz professional va muvaffaqiyatli" +
                                "\nkaryera uchun keng doiradagi kurslarni taklif qilamiz. Eng talabgor sohalarda" +
                                "\nkuchli mutaxasisslardan sifatli kurslar sizga muntazir, o'zingizga kerakli" +
                                "\nbo'lgan kursni bir zumda topasiz.");

                        System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                        option = menuScanner.nextInt();

                        if (option == 0) {
                            break mainMenuOuter;
                        }

                        break;
                    case 0:
                        System.out.println("\n*** DASTUR TUGATILDI ***");
                        System.exit(0);
                    default:
                        System.out.print(ANSI_YELLOW + "\nMENYU RAQAMINI TO'GRI KIRITING !\n" + ANSI_RESET);
                        break;
                }
            }
        }
    }
}
