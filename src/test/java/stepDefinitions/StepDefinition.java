package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import static org.junit.Assert.*;
import utilities.JDBCReusableMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class StepDefinition {

    ResultSet resultSet;
    PreparedStatement preparedStatement;
    String query;
    int rowCount;
    QueryManage queryManage = new QueryManage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        JDBCReusableMethods.getConnection();
    }
    @Given("Query01 hazirlanir ve execute edilir.")
    public void query01_hazirlanir_ve_execute_edilir() throws SQLException {

        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("ResultSet01 sonuclari islenir.")
    public void result_set01_sonuclari_islenir() throws SQLException {

        resultSet.next();
       int actualUserID =resultSet.getInt("user_id");
       int expectedUserID = 1;

      assertEquals(expectedUserID,actualUserID);

    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();
    }

 // --------------QUERY02--------------
 @Given("Query02 hazirlanir ve execute edilir.")
 public void query02_hazirlanir_ve_execute_edilir() throws SQLException {
    query = queryManage.getQuery02();
    resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

 }
    @Given("ResultSet02 sonuclari islenir.")
    public void result_set02_sonuclari_islenir() throws SQLException {

        List<String> isimler = new ArrayList<>();
        while(resultSet.next()) {
           String isim = resultSet.getString("name");
           isimler.add(isim);
        }

        List<String> expectedName = new ArrayList<>();
        expectedName.add("5 Minutes");
        expectedName.add("10 Minutes");

        for(int i = 0; i < isimler.size(); i++){
            assertEquals(expectedName.get(i),isimler.get(i));
            System.out.println(i +". index dogrulandi");
        }

    }

 //   ------------- QUERY03------------

    @Given("Query03 hazirlanir ve execute edilir.")
    public void query03_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery03();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet03 sonuclari islenir.")
    public void result_set03_sonuclari_islenir() throws SQLException {

        String expectedName= "Mehmet Genç";
        resultSet.next();
        String actualName = resultSet.getString("firstname")+ " " + resultSet.getString("lastname");

        assertEquals(expectedName,actualName);
        System.out.println("expected= " + expectedName);
        System.out.println("actual= " + actualName);
    }

    //-----------------QUERY04---------------------

    @Given("Query04 hazirlanir ve execute edilir.")
    public void query04_hazirlanir_ve_execute_edilir() throws SQLException {
        query= queryManage.getQuery04();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet04 sonuclari islenir.")
    public void result_set04_sonuclari_islenir() throws SQLException {
        while(resultSet.next()){
            String kullanici_id = resultSet.getString("user_id");
            String browserOS = resultSet.getString("browser_os");

            System.out.println("kullanici_id " + kullanici_id);
            System.out.println("Browser & OS " + browserOS);
        }
    }

// ----------------------UPDATE QUERY (statement ile) ---------------------------

    @Given("Update query01 olusturulur ve execute edilir.")
    public void update_query01_olusturulur_ve_execute_edilir() throws SQLException {
        query= queryManage.getUpdateQuery05();
       rowCount= JDBCReusableMethods.updateQuery(query);

    }
    @Given("Sonuclar dogrulanir.")
    public void sonuclar_dogrulanir() {

        assertEquals(18, rowCount);

    }

    // -----------------------UPDATE QUERY (Prepared Statement)--------

    @Given("Prepared query02 olusturulur ve execute edilir.")
    public void prepared_query02_olusturulur_ve_execute_edilir() throws SQLException {

       query= queryManage.getPreparedQuery05();
       preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
       preparedStatement.setInt(1, 444444444);
       preparedStatement.setString(2, "%e_");

      rowCount = preparedStatement.executeUpdate();

    }
    @Given("Prepared query02 Sonuclar dogrulanir.")
    public void prepared_query02_sonuclar_dogrulanir() {

        assertEquals(18,rowCount);

    }

// -------------------------Query 03 (PreparedStatement)-------------------

    @Given("Prepared query03 olusturulur ve execute edilir.")
    public void prepared_query03_olusturulur_ve_execute_edilir() throws SQLException {
        query= queryManage.getPreparedQuery06();
         preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

     // INSERT INTO admin_password_resets (id,email,token,status) VALUES (?,?,?,?);

         preparedStatement.setInt(1,102);
         preparedStatement.setString(2,"email33@gmail.com");
         preparedStatement.setString(3,"125478");
         preparedStatement.setInt(4,1);
         rowCount = preparedStatement.executeUpdate();

    }
    @Given("Prepared query03 Sonuclar dogrulanir.")
    public void prepared_query03_sonuclar_dogrulanir() {

        assertEquals(1,rowCount);
    }






}



