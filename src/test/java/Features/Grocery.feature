Feature: Grocery API Test


  Scenario: Ürün Bazlı Kontrol
    Given Name 'apple', price '3',stock '100' olan ürün olduğu kontrol edilir.

  Scenario: İsme Göre Ürün Kontrol
    Given Name 'apple' olan ürün olduğu kontrol edilir

   Scenario: Yeni Ürün Ekleme
     Given id '4', name 'string', price '12.3',stock '3' özellikli ürün eklenir