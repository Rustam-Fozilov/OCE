package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;

public class JDBC {

    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_RESET = "\u001B[0m";

    ArrayList<UserInformation> usersInformation = new ArrayList<>();

    public void getUserInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");
            ps = con.prepareStatement("SELECT * FROM users");
            rs = ps.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("UserId");
                String ismi = rs.getString("Ismi");
                String familiyasi = rs.getString("Familiyasi");
                String telefon = rs.getString("Telefon");
                String email = rs.getString("Email");
                String parol = rs.getString("Parol");
                String statusi = rs.getString("Statusi");

                usersInformation.add(new UserInformation(user_id, ismi, familiyasi, telefon, email, parol, statusi));
            }
            rs.close();

        } catch(SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<UserInformation> getUsersInformation() {
        return usersInformation;
    }

    ArrayList<AdminInformation> adminsInformation = new ArrayList<>();

    public void getAdminInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            ps = con.prepareStatement("SELECT * FROM admins");
            rs = ps.executeQuery();

            while (rs.next()) {
                String login = rs.getString("Login");
                String parol = rs.getString("Parol");
                String ismi = rs.getString("Ismi");
                String familiyasi = rs.getString("Familiyasi");

                adminsInformation.add(new AdminInformation(ismi, familiyasi, login, parol));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<AdminInformation> getAdminsInformation() {
        return adminsInformation;
    }

    public void courseAdd() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String nomi;
            int narxi;
            String davomiyligi;
            String oqituvchi;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            System.out.print("Kurs nomini kiriting: ");
            nomi = bufferedReader.readLine();

            System.out.print("Kurs narxini kiriting: ");
            narxi = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Kurs davomiyligini kiriting: ");
            davomiyligi = bufferedReader.readLine();

            System.out.print("O'qituvchi ism - familiyasini kiriting: ");
            oqituvchi = bufferedReader.readLine();

            ps = con.prepareStatement("INSERT INTO courses (Nomi, Narxi, Davomiyligi, Oqituvchi) VALUES (?, ?, ?, ?)");

            ps.setString(1, nomi);
            ps.setInt(2, narxi);
            ps.setString(3, davomiyligi);
            ps.setString(4, oqituvchi);
            ps.executeUpdate();

            System.out.println(ANSI_GREEN + "\nMA'LUMOT QO'SHILDI\n" + ANSI_RESET);

        } catch(SQLException e) {
            System.out.println();
        }
    }

    public void courseDelete() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String nomi;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            System.out.print("O'chirmoqchi bo'lgan kurs nomini kiriting: ");
            nomi = bufferedReader.readLine();

            ps = con.prepareStatement("DELETE FROM courses WHERE nomi = ?");
            ps.setString(1, nomi);
            ps.executeUpdate();
            System.out.println(ANSI_GREEN + "\nKURS MA'LUMOTLARI O'CHIRILDI !!!\n" + ANSI_RESET);

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void courseUpdate() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String oldName;
            String newName;
            int newPrice;
            String newDuration;
            String newTeacher;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            System.out.print("Yangilamoqchi bo'lgan kurs nomini kiriting: ");
            oldName = bufferedReader.readLine();

            System.out.println("\nYANGI MA'LUMOTLARNI KIRITING\n");

            System.out.print("Nomi: ");
            newName = bufferedReader.readLine();

            System.out.print("Narxi: ");
            newPrice = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Davomiyligi: ");
            newDuration = bufferedReader.readLine();

            System.out.print("O'qituvchi ism - familiyasi: ");
            newTeacher = bufferedReader.readLine();

            ps = con.prepareStatement("UPDATE courses SET Nomi = ?, Narxi = ?, Davomiyligi = ?, Oqituvchi = ? WHERE Nomi = ?");
            ps.setString(1, newName);
            ps.setInt(2, newPrice);
            ps.setString(3, newDuration);
            ps.setString(4, newTeacher);
            ps.setString(5, oldName);
            ps.executeUpdate();

            System.out.println(ANSI_GREEN + "\nKURS MA'LUMOTLARI YANGILANDI !!!\n" + ANSI_RESET);

        } catch (SQLException e) {
            System.out.println();
        }
    }

    ArrayList<Courses> couesesInformation = new ArrayList<>();

    public void getCourseInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            ps = con.prepareStatement("SELECT * FROM courses");
            rs = ps.executeQuery();

            while (rs.next()) {
                int kurs_id = rs.getInt("CourseId");
                String nomi = rs.getString("Nomi");
                int narxi = rs.getInt("Narxi");
                String davomiyligi = rs.getString("Davomiyligi");
                String oqituvchi = rs.getString("Oqituvchi");

                couesesInformation.add(new Courses(kurs_id, nomi, narxi, davomiyligi, oqituvchi));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<Courses> getCoursesInformation() {
        return couesesInformation;
    }

    public void registerUser() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String ismi;
            String familiyasi;
            String telefon;
            String email;
            String parol;
            String statusi = "Student";

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            System.out.print("Ismingizni kiriting: ");
            ismi = bufferedReader.readLine();

            System.out.print("Familiyangizni kiriting: ");
            familiyasi = bufferedReader.readLine();

            System.out.print("Telefon raqamingizni kiriting: ");
            telefon = bufferedReader.readLine();

            System.out.print("Mail pochtangizni kiriting: ");
            email = bufferedReader.readLine();

            System.out.print("Parol o'ylab toping: ");
            parol = bufferedReader.readLine();

            ps = con.prepareStatement("INSERT INTO users (Ismi, Familiyasi, Telefon, Email, Parol, Statusi) VALUES (?, ?, ?, ?, ?, ?)");

            ps.setString(1, ismi);
            ps.setString(2, familiyasi);
            ps.setString(3, telefon);
            ps.setString(4, email);
            ps.setString(5,parol);
            ps.setString(6, statusi);
            ps.executeUpdate();

            System.out.println(ANSI_GREEN + "\nRO'YHATDAN O'TISH MUVAFFAQIYATLI BAJARILDI\n" + ANSI_RESET);

        } catch(SQLException e) {
            System.out.println();
        }
    }

    public void deleteUser() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String email;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            System.out.print("O'chirmoqchi bo'lgan foydalanuvchi emailini kiriting: ");
            email = bufferedReader.readLine();

            ps = con.prepareStatement("DELETE FROM users WHERE Email = ?");
            ps.setString(1, email);
            ps.executeUpdate();
            System.out.println(ANSI_GREEN + "\nFOYDALANUVCHI MA'LUMOTLARI O'CHIRILDI !!!\n" + ANSI_RESET);

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void updateUser() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String oldEmail;
            String newName;
            String newSurname;
            String newPhoneNumber;
            String newEmail;
            String newPassword;
            String status = "Student";

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            System.out.print("Yangilamoqchi bo'lgan foydalanuvchi emailini kiriting: ");
            oldEmail = bufferedReader.readLine();

            System.out.println("\nYANGI MA'LUMOTLARNI KIRITING\n");

            System.out.print("Ismi: ");
            newName = bufferedReader.readLine();

            System.out.print("Familiyasi: ");
            newSurname = bufferedReader.readLine();

            System.out.print("Telefon: ");
            newPhoneNumber = bufferedReader.readLine();

            System.out.print("Email: ");
            newEmail = bufferedReader.readLine();

            System.out.print("Parol: ");
            newPassword = bufferedReader.readLine();

            ps = con.prepareStatement("UPDATE users SET Ismi = ?, Familiyasi = ?, Telefon = ?, Email = ?, Parol = ?, Statusi = ? WHERE Email = ?");
            ps.setString(1, newName);
            ps.setString(2, newSurname);
            ps.setString(3, newPhoneNumber);
            ps.setString(4, newEmail);
            ps.setString(5, newPassword);
            ps.setString(6, status);
            ps.setString(7, oldEmail);
            ps.executeUpdate();

            System.out.println(ANSI_GREEN + "\nFOYDALANUVCHI MA'LUMOTLARI YANGILANDI !!!\n" + ANSI_RESET);

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void followCourses(int user_id, int kurs_id, String tariff) throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "1w3r5y7i9");

            ps = con.prepareStatement("INSERT INTO followers(user_id, kurs_id, tarif) VALUE (?, ?, ?)");

            ps.setInt(1,user_id);
            ps.setInt(2,kurs_id);
            ps.setString(3, tariff);
            ps.executeUpdate();

            System.out.println(ANSI_GREEN + "\nTABRIKLAYMIZ, SIZ KURSGA MUVAFFAQIYATLI YOZILDINGIZ :)" + ANSI_RESET);

        } catch (SQLException e) {
            System.out.println();
        }
    }
}
