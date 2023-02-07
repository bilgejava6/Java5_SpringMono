package com.muhammet.SpringMono.repository;

import com.muhammet.SpringMono.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring BeanFactory ile oluşturacağı nesneleri belirlemek için belli anotasyonları arar.
 * Bunlardan 1. si Veritabanı işlemleri içiç
 * @Repository dir.
 */
@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {

    /**
     * !! DİKKAT !!
     * Spring in devraldığı repository interface lerinde, method tanımlamaları için özel
     * keyword ler kullanılmaktadır. bunlar üzerinden sorgular oluşturulur.
     * 1- ReturnType -> Musteri, List<Musteri>, Boolean, Integer v.s.
     * 2- find, kelimesini kullanıyoruz.
     * 3- By, ne için arama yapılacağının belirlenmesi işaretlenmesi için kullanılır.
     * 4- Entity Property[entity-> değişkenin adı], Üzserinde çalıştığınız repository nin kullanmakta
     * olduğu entity sınıfından bir değişkenin birebir adını yazmalısınız.
     * ÇOOOOOK DİKKAT!!!! burada varlık adı yazılırken büyük harf ile başlanır. yine dikkat
     * edilmesi gereken bir husus eğer değişken adı camelcase şeklinde (musteriAdSoyad) şeklinde
     * yazılmış ise buna dikkat ederek yazılmalıdır.
     * 5- Method için gerekli parametereler değişken türüne göre eklenir.
     * !!!DİKKAT!!! burada değişken adı önemli değil, değişken türü önemlidir.
     * select * from tblmusteri where ad=?
     */
    List<Musteri> findByAd(String burayabirdegeryazmamgerekli);
    /**
     * select * from tblmusteri where ad=? and adres=?
     * @param bisey
     * @param baskabisey
     * @return
     */
    List<Musteri> findAllByAdAndAdres(String bisey,String baskabisey);

    /**
     * HAngi yaş grubunun hangi ürüleri daha fazla satın aldığını merak ediyorsunuz.
     * örn: 40 yaş üzeri müşterilerin listesi.
     *
     */
    List<Musteri> findAllByYasGreaterThan(Integer yas); // yas>?
    List<Musteri> findAllByYasGreaterThanEqual(Integer yas); // yas>=?

    /**
     * Belli bir harfin ya da kelimenin aranması  LIKE, ILIKE
     */
    List<Musteri> findAllByAdLike(String ad);

}
