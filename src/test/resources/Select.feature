Feature: SELECT QUERY EXECUTE

  Background: Database baglantisi
    * Database baglantisi kurulur.

  @query01
  Scenario: Database içindeki "deposits" toblosunda
            "amount" değeri 100$ ile 500$ arasında olan user_id’leri doğrulayınız.


    * Query01 hazirlanir ve execute edilir.
    * ResultSet01 sonuclari islenir.
    * Database baglantisi kapatilir.

    @query02
   Scenario: Database içindeki "cron_schedules" tablosunda ilk 2 kaydın "name" bilgisini doğrulayınız


     * Query02 hazirlanir ve execute edilir.
     * ResultSet02 sonuclari islenir.
     * Database baglantisi kapatilir.
