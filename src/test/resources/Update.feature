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