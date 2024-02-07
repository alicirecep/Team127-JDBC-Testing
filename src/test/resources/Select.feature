
Feature: SELECT QUERY EXECUTE


  Background: Database baglantisi
    * Database baglantisi kurulur.

  @query01
  Scenario: Database içindeki "deposits" toblosunda "amount" değeri 100$ ile 500$ arasında olan user_id’leri doğrulayınız.


    * Query01 hazirlanir ve execute edilir.
    * ResultSet01 sonuclari islenir.
    * Database baglantisi kapatilir.

    @query02
   Scenario: Database içindeki "cron_schedules" tablosunda ilk 2 kaydın "name" bilgisini doğrulayınız


     * Query02 hazirlanir ve execute edilir.
     * ResultSet02 sonuclari islenir.
     * Database baglantisi kapatilir.

  @query03
   Scenario: Database üzerinde "Users" tablosunda "country_code=TR" olmayan
             ve "id=11" olan datanın "firstname" ve "lastname" bilgilerini doğrulayınız.

     # test datalarina ihtiyacim var.
     # Mehmet Genc

  * Query03 hazirlanir ve execute edilir.
  * ResultSet03 sonuclari islenir.
  * Database baglantisi kapatilir.

  @query04
 Scenario: user_logins tablosunda user_id lere gore sisteme giris yapilan
           browser ve os leri gruplayip ekrana yazdiriniz


   * Query04 hazirlanir ve execute edilir.
   * ResultSet04 sonuclari islenir.
   * Database baglantisi kapatilir.


