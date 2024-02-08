Feature: UPDATE (update delete insert queryleri)

  Background: Database baglantisi
     * Database baglantisi kurulur.

    @query05
    Scenario: "users" tablosunda sondan bir önceki harfi e olan
              "usernamelerin" "mobile" numarasını update ediniz.


      * Update query01 olusturulur ve execute edilir.
      * Sonuclar dogrulanir.
      * Database baglantisi kapatilir.


    @query06
    Scenario: "users" tablosunda sondan bir önceki harfi e olan
              "usernamelerin" "mobile" numarasını update ediniz.

      * Prepared query02 olusturulur ve execute edilir.
      * Prepared query02 Sonuclar dogrulanir.
      * Database baglantisi kapatilir.

  @query07
    Scenario: admin_password_resets tablosuna yeni (id,email,token,status,created_at datalarla)
              veri girisi yapiniz.

    # id,email,token,status,created_at

      * Prepared query03 olusturulur ve execute edilir.
      * Prepared query03 Sonuclar dogrulanir.
      * Database baglantisi kapatilir.

    @query08
    Scenario: "id=800" olan kullanıcının "is_read=0" olan bildirimlerini '1' Olarak Update edip doğrulayınız.


      * Prepared query08 olusturulur ve execute edilir.
      * Prepared query08 Sonuclar dogrulanir.
      * Database baglantisi kapatilir.

    @query09
    Scenario: "update_logs" tablosunda "version=? " ve "id=?" olan datanın "update_log"
              değerini update edip doğrulayınız.

      * Update_logs tablosuna insert query hazirlanir ve calistirilir.
      * update_logs tablosuna insert edilen datanin update log degeri degistirilir
      * update log degerinin degistigi dogrulanir
      * Database baglantisi kapatilir.

    @query10
    Scenario: Update_logs tablosunda "id=?" değerine göre
              bir datayı siliniz ve silindiğini doğrulayınız.

      * Update_logs tablosuna insert query hazirlanir ve calistirilir.
      * update_logs tablosuna insert edilen data silinir.
      * Satirin silindigi dogrulanir
      * Database baglantisi kapatilir.

    @query11
    Scenario: "support_attachments" tablosunda "support_message_id=?"
    değerine göre  bir dosyayı siliniz ve silindiğini doğrulayınız.

  # once insert sonra delete yapariz.
  # Insert isleminde daha dinamik olmasi icin Faker class'ina deger urettiririz.
  # Insert ettigimiz faker degerlerine sahip datayi yine faker degerlerini alarak delete ederiz.

    * support_attachments tablosuna insert query hazirlanir ve calistirilir.
    * support_attachments tablosuna insert edilen data silinir.
    * Satirin silindigi dogrulanir
    * Database baglantisi kapatilir.






















