package com.muhammet.SpringMono.repository;

import com.muhammet.SpringMono.repository.entity.Musteri;
import com.muhammet.SpringMono.repository.view.VwMusteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
     * select * from tblmusteri where yas>?
     *
     */
    List<Musteri> findAllByYasGreaterThan(Integer yas); // yas>?
    List<Musteri> findAllByYasGreaterThanEqual(Integer yas); // yas>=?

    /**
     * Belli bir harfin ya da kelimenin aranması  LIKE, ILIKE
     * select * from tblmusteri where ad like ?
     */
    List<Musteri> findAllByAdLike(String ad);

    /**
     * select * from tblmusteri ad like '?%'
     */
    List<Musteri> findAllByAdStartingWith(String ad);

    /**
     * select * from tblmusteri where ad=? and adres=? and telefon=?
     * @param ad
     * @param adres
     * @param telefon
     * @return
     */
    Musteri findByAdAndAdresAndTelefon(String ad,String adres,String telefon);

    /**
     * select * from tblmusteri where yas = 5000
     * Eğer sonuç yok ise, null dönebilir böyle durumlarda null kontrolü yapmak çokta
     * doğru değildir. Bunun yerine Optional kullanmak doğru olacaktır.
     */
    Optional<Musteri> findOptionalByTelefon(String telefon); // Eğer null ise empty
    Optional<List<Musteri>> findAllOptionalByAdres(String adres);

    /**
     * Order ->
     * -> ASC A...Z, 0...9
     * select * from tblmusteri order by yas
     * -> DESC  Z...a, 9..0
     * select * from tblmusteri order by yas  desc
     * En yaşlı müşterim kim?
     * select * from tblmusteri order by yas desc limit 1
     */
    List<Musteri> findByOrderByYas(); // yaşına göre küçükten büyüğe doğru sıralı liste verir.
    List<Musteri> findByOrderByYasDesc();
    Musteri findTopByOrderByYasDesc(); // En yaşlı müşteri


    /**
     * LIMIT kullanımı
     */
    List<Musteri> findTop5ByOrderByYas(); // en genç 5 üyemiz.
    Musteri findTopOptionalByOrderByYasDesc(); // En yaşlı müşteri optional olarak

    /**
     * select * from tblmusteri where yas>=18 and yas<=40  -- gençlerde satış oranı
     */
    List<Musteri> findAllByYasBetween(Integer start,Integer end);// yas>=? and yas<=? [bas,bit]
    List<Musteri> findAllByAdresAndYasBetween(String adres,Integer bas,Integer bit);

    /**
     * true-false
     */
    List<Musteri> findAllByState(boolean state); // aktif pasif kayıtları verir.
    List<Musteri> findAllByStateTrue(); // true- aktif olan kayıtlar
    List<Musteri> findAllByStateFalse();

    /**
     * Ahmet -> Tbl("ahmet") false
     */
    // List<Musteri> findAllByAdAndAdres(String ad,String adres);
    List<Musteri> findAllByAdIgnoreCaseAndAdresIgroneCase(String ad,String adres);

    /**
     * Belli isimlerin listesini çekelim.
     * List<String> adListesi = {"Ahmet","Ayşe","Canan"}
     */
    List<Musteri> findAllByAdIn(List<String> adListesi);

    /**
     *  JPQL ya da HQL veya NATIVESQL kullanılabilir.
     */
    /**
     * HQL Kullanımı
     * JPQL Kullanımı
     */
    @Query("select m from Musteri m where m.adres= ?1")
    List<Musteri> senBulTumunuMusterilerinAdresineGore(String adresOlabilir);
    @Query("select m from Musteri m where m.ad = ?3 and m.adres = ?1 and m.telefon = ?2")
    Musteri musteriyiBul(String adres,String telefon,String ad);

    /**
     * NATIVESQL kullanımı
     */
    @Query(value = "select * from Musteri where ad= ?1", nativeQuery = true)
    List<Musteri> bulAdinaGore(String ad);

    /**
     * Sorgu parametrelerinin kullanılarak tanımlanması ve MEthod içinden çekilmesi.
     */
    @Query("select m from Musteri m where m.ad = :ad and m.adres = :adres")
    List<Musteri> findAdAndAdres(
            @Param("ad") String musteriadi,
            @Param("adres") String musteriadresi);

    @Query("select COUNT (m)>0 from Musteri m where m.tckimlik=?1")
    Boolean musteriVarmi(String tckimlik);

    @Query("select new com.muhammet.SpringMono.repository.view.VwMusteri(m.id,m.ad) from Musteri m")
    List<VwMusteri> findAllViewMusteri();



}
