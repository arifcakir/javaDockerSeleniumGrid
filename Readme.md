Zalenium üzerinde Selenium Grid ve Docker kullanarak test koşumu için gerekli ortam hazırlanmıştır. 

## Gerekli Kurulumlar
* Java JDK 8 +
* Apache Maven
* Docker
* Zalenium

## Kullanılan Teknolojiler
* Java 8
* Docker
* Zalenium
* Maven
* Selenium Grid
* TestNG

## Zalenium Kurulumu ve Çalıştırılması

### Pull docker-selenium
    docker pull elgalu/selenium
### Pull Zalenium
    docker pull dosel/zalenium
### Run
    docker run --rm -ti --name zalenium -p 4444:4444 ^
      -v /var/run/docker.sock:/var/run/docker.sock ^
      -v /c/Users/arif.cakir/temp/videos:/home/seluser/videos ^
      --privileged dosel/zalenium start ^
	  --desiredContainers 4

### Stop
    docker stop zalenium
 
### Testlerin koştugu containerları erişmek için; http://localhost:4444/grid/admin/live  

### Test sonuçları, loglama, test koşum videoları için; http://localhost:4444/dashboard
adreslerine gidilir.

*  Zalenium bize raporlama, loglama, test sırasında ekran kaydı, Paralel koşum, içerisinde barındırdıgı VNC ile containerları direk izleyebilme imkanı sağlar.

### Testin Çalıştırılabilmesi İçin Gerekli Ortam Nasıl Oluşturulur?

* Proje Github'dan clone edilir.
* Docker başlatışır ve projenin olduğu dizinin içine girilerek
 **`docker-compose up --force-recreate`**  komutu çalıştırılır.
    * Bu yml dosyası gerekli altyapıları içindeki image'lar ile kurar. 
    
* Bu compose.yml dosyası 2 farklı nod başlatır. Eğer scale etmek istoyorsanız compose dosyası içerisindeki **`--desiredContainers 2`** değiştirebilirsiniz.

* **`http://localhost:4444/grid/admin/live`**'e giderek Zalenium üzerinde Selenium Grid hub'nın ayakta olduğu ve node'ların register olup olduğu kontrol edilir.
* **`http://localhost:4444/dashboard`**' giderek Zalenium ile sağlanan test koşum dashboard ekranına erişim sağlanır.

### Test Nasıl Çalıştırılır?

* Step 1: BoutiqueUrlAndResponseCodeTest  testini çalıştırmak için;
    *   **`mvn test -DsuiteXmlFile=UrlAndResponseCodeTestNG.xml`**

* Step 2: ImgResponseCodeAndLoadTimeTest testini çalıştırmak için;
    *   **`mvn test -DsuiteXmlFile=ImgResponseCodeLoadTimeTestNG.xml`**
    
* Step 3: DDLoginTest testini çalıştırmak için;
    *   **`mvn test -DsuiteXmlFile=DDLoginTestNG.xml`**

#### Not: Bu komutlar proje dizininin içerisinde çalıştırılması gerekmektedir, aksi takdirde .xml file uzantısı için tam path vermeniz gerekir.

