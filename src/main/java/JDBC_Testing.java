import java.sql.*;

public class JDBC_Testing {

    // Sizden JDBC sorgusu yapmaniz istendiginde yapacaginiz ilk is:

    // DataBase Yoneticisi ile iletisime gecerek Access Information'lari edinmek.

    /*
    type: jdbc:mysql
    host/ip: 45.87.83.5
    port: 3306
    database_name: u168183796_qaloantec
    username: u168183796_qaloantecuser
    password: 0&vG1A/MuWN

    url = jdbc:mysql://45.87.83.5/u168183796_qaloantec
    username: u168183796_qaloantecuser
    password: 0&vG1A/MuWN

    */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. ADIM DOGRU SURUCUYU YUKLE

        Class.forName("com.mysql.cj.jdbc.Driver");


        // 2. ADIM: DATABASE ILE BAGLANTI OLUSTUR (connection)

        Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec",
                "u168183796_qaloantecuser",
                "0&vG1A/MuWN");


        // 3. ADIM: SQL QUERY'LERI OLUSTUR


        String query = "SELECT * FROM u168183796_qaloantec.users";

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Statement olusturmak icin mutlaka bir connection olmasi gerekli.
        // create edilen statement bir query calistirilacaksa atama yapilmadan kullanilabilir.
        // Ancak defalarca kullanilmak isteniyorsa atama yapilip kullanilabilir.


        // 4. ADIM: QUERY EXECUTE ET



      /*
      statement.executeQuery(query);

      connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(query);

        Yukaridaki iki ifade de aynidir.
       */

        ResultSet resultSet = statement.executeQuery(query);

        // 5. ADIM: SONUCLARI ISLE


        resultSet.next();  // iterator'i ilk satira koymus olduk
        System.out.println(resultSet.getString("firstname"));
        // Mehmet

        resultSet.next();  // 2. satir
        System.out.println(resultSet.getString("firstname"));
        // Test

        resultSet.next(); // 3. satir
        System.out.println(resultSet.getString("lastname"));
        // Genc

        System.out.println(resultSet.getString("email"));
        // mcenkk@gmail.com

        resultSet.absolute(10); // 10. satir
        System.out.println(resultSet.getString("firstname"));
        // Ahmet

        resultSet.first();
        System.out.println(resultSet.getString("email"));
        // elff931@gmail.com


    }


}
