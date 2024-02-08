package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import manage.QueryManage;
import static org.junit.Assert.*;
import utilities.JDBCReusableMethods;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class StepDefinition {

    ResultSet resultSet;
    PreparedStatement preparedStatement;
    String query;
    int rowCount;

    Faker faker= new Faker();

    int id;
    String version;
    String updateLog;
    int supportMessageID;

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

// ----------------------QUERY(05) (statement ile) ---------------------------

    @Given("Update query01 olusturulur ve execute edilir.")
    public void update_query01_olusturulur_ve_execute_edilir() throws SQLException {
        query= queryManage.getUpdateQuery05();
       rowCount= JDBCReusableMethods.updateQuery(query);

    }
    @Given("Sonuclar dogrulanir.")
    public void sonuclar_dogrulanir() {

        assertEquals(18, rowCount);

    }

    // -----------------------QUERY(06) (Prepared Statement)--------

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

// -------------------------Query 07 (PreparedStatement)-------------------

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


// -------------------------Query 08 (PreparedStatement)-------------------

    @Given("Prepared query08 olusturulur ve execute edilir.")
    public void prepared_query08_olusturulur_ve_execute_edilir() throws SQLException {

    query= queryManage.getPreparedQuery08();
    preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

    preparedStatement.setInt(1,1);
    preparedStatement.setInt(2,800);
    rowCount = preparedStatement.executeUpdate();

    }
    @Given("Prepared query08 Sonuclar dogrulanir.")
    public void prepared_query08_sonuclar_dogrulanir() {

   assertEquals(1,rowCount);

    }
// ---------------------------QUERY 09 ------------------------------------
@Given("Update_logs tablosuna insert query hazirlanir ve calistirilir.")
public void update_logs_tablosuna_insert_query_hazirlanir_ve_calistirilir() throws SQLException {

        query= queryManage.getPreparedQuery09Insert();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        id = faker.number().numberBetween(450,550);
        version = faker.options().option("Windows 10", "MacOs Ventura", "LinUx");
        updateLog = faker.lorem().sentence(1); // insert deger

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,version);
        preparedStatement.setString(3,updateLog);
        preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
        rowCount = preparedStatement.executeUpdate();


        System.out.println("updateLOG: "+ updateLog);
        System.out.println("version: "+ version);
        System.out.println("id: "+ id);


        int flag=0;
    if (rowCount > 0) {
        flag++;
    }

    rowCount = 0;
    assertEquals(1, flag);

}
    @Given("update_logs tablosuna insert edilen datanin update log degeri degistirilir")
    public void update_logs_tablosuna_insert_edilen_datanin_update_log_degeri_degistirilir() throws SQLException {

        query= queryManage.getPreparedQuery09Update();
        String updatelogYeni = "yeni log"; // faker dan gelen insert degerini yeni log olarak degistirmek istiyorum.

        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,updatelogYeni);
        preparedStatement.setString(2,version);
        preparedStatement.setInt(3,id);


        rowCount = preparedStatement.executeUpdate();

        System.out.println("id: "+id);
    }
    @Given("update log degerinin degistigi dogrulanir")
    public void update_log_degerinin_degistigi_dogrulanir() {

        assertEquals(1,rowCount);
    }

//-----------------------QUERY10--------------------------

    @Given("update_logs tablosuna insert edilen data silinir.")
    public void update_logs_tablosuna_insert_edilen_data_silinir() throws SQLException {

        query = queryManage.getPreparedQuery10Delete();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setInt(1,id);
        rowCount = preparedStatement.executeUpdate();

       System.out.println("silinen id; "+ id);

    }
    @Given("Satirin silindigi dogrulanir")
    public void satirin_silindigi_dogrulanir() {

        assertEquals(1,rowCount);

    }

 //   --------------------QUERY11-----------------
 @Given("support_attachments tablosuna insert query hazirlanir ve calistirilir.")
 public void support_attachments_tablosuna_insert_query_hazirlanir_ve_calistirilir() throws SQLException {

        query=queryManage.getPreparedQuery11Insert();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = faker.number().numberBetween(400,600);
        supportMessageID = faker.number().numberBetween(250,300);

        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, supportMessageID);
        preparedStatement.setString(3, "658401a61409c1703149990.png");
        preparedStatement.setDate(4,Date.valueOf(LocalDate.now()));

        rowCount = preparedStatement.executeUpdate();

     System.out.println("id:  "+ id);
     System.out.println("supportMessageID:  "+ supportMessageID);

        assertEquals(1,rowCount);

 }
    @Given("support_attachments tablosuna insert edilen data silinir.")
    public void support_attachments_tablosuna_insert_edilen_data_silinir() throws SQLException {

    query = queryManage.getPreparedQuery11Delete();
    preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
    preparedStatement.setInt(1,supportMessageID);

    rowCount = preparedStatement.executeUpdate();
        System.out.println("silinen datanin support message id'si : " + supportMessageID);

    }












}



