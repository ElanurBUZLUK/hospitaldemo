# Hospital Management Demo

Bu proje, hastane yönetim sistemi için bir demo uygulamasıdır. Angular tabanlı bir ön yüz ve Spring Boot tabanlı bir arka yüz içerir.

## Teknolojiler

- **Ön Yüz:** Angular 14
- **Arka Yüz:** Spring Boot 3.2.0, Java 21
- **Veritabanı:** MySQL
- **Diğer:** JPA, Hibernate, ModelMapper, Lombok, Swagger

## Gereksinimler

- Node.js (Angular için)
- Java 21
- MySQL
- Maven

## Kurulum

### Arka Yüz (HospitalDemo)

1. MySQL'de `hospitalsystem` veritabanını oluşturun.
2. `HospitalDemo/src/main/resources/application.properties` dosyasındaki veritabanı bilgilerini güncelleyin (varsayılan: username=ela_nur, password=123456).
3. Proje dizinine gidin: `cd HospitalDemo`
4. Bağımlılıkları yükleyin: `mvn clean install`
5. Uygulamayı çalıştırın: `mvn spring-boot:run`

### Ön Yüz (FrontEnd)

1. Proje dizinine gidin: `cd FrontEnd`
2. Bağımlılıkları yükleyin: `npm install`
3. Uygulamayı çalıştırın: `ng serve`
4. Tarayıcıda `http://localhost:4200` adresine gidin.

## Özellikler

- Doktor kaydı
- Hasta kaydı
- Doktor ve hasta listesi görüntüleme

## API Dokümantasyonu

Swagger UI ile API dokümantasyonuna erişmek için: `http://localhost:8080/swagger-ui.html`

## Test

- Ön yüz: `ng test`
- Arka yüz: `mvn test`

## Katkıda Bulunma

Lütfen pull request gönderin.

## Lisans

Bu proje açık kaynaklıdır.