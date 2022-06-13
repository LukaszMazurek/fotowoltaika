# fotowoltaika
Setup:
* otwórz projekt w intelij
* intelij powinien automatycznie dociągnąć zależności z poma jeżeli tego nie zrobi to trzeba to zrobić ręcznie https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* używam mysql w wersji 8
* utwórz bazę danych fotowoltaika
* ustaw hasło do połaczenia z bazą w plik application.properties na twoje hasło
* na starcie ustawiany jest użytkownik z username defaultUser i hasłem defaultUser

# przykłady
## flow rejstracji z wykorzystanie JWT (json web tokens)
* POST (rejstracja)
```
http://localhost:8080/signup
{
    "username": "Joe",
    "password": "Doe",
}
```
![alt text](https://github.com/LukaszMazurek/fotowoltaika/blob/develop/docs/signup.jpg)
* GET (test page przed zalogowaniem zwraca 403 - forbidden)
![alt text](https://github.com/LukaszMazurek/fotowoltaika/blob/develop/docs/testPageBeforeLogin.jpg)
* POST (logowanie pobieramy token z hedera - Authorization  po poprawnym zalogowanie)
![alt text](https://github.com/LukaszMazurek/fotowoltaika/blob/develop/docs/loginWithToken.jpg)
* GET (używamy tutaj Bearer Token wklejamy nasz token i możemy korzystać z endpointa)
![alt text](https://github.com/LukaszMazurek/fotowoltaika/blob/develop/docs/toestWithTokenLogin.jpg)
* Pozostałe przykłady używają hateosa 

# Przypadki użycia
1.	Logowanie użytkownika
    * Given – użytkownik posiadający konto
    *	When - użytkownik wprowadza login i hasło
    *	Then – użytkownik dostaje dostęp do kolejnych endpointów
    *	Then – użytkownik wprowadził błędne dane i nie przechodzi dalej
2.	Rejstracja użytkownika
    *	Given – nowy użytkownik chce się zalogować
    *	When - użytkownik wprowadza login, hasło, email, nr_tel i kod paneli (jakiś identyfikator instalacji czy coś)
    *	Then – użytkownik otrzymuje konto
3.	Zapis licznika stanu licznika
    *	Given – zalogowany użytkownik chce podać odczyt
    *	When – zalogowany użytkownik wpisuje odczyt wyprodukowanego prącu
    *	Then – odczyt zostaje zapisany i odliczony od rachunku
4.	Sprawdzenie odczytów
    *	Given – zalogowany użytkownik chce sprawdzić odczyty
    *	When – zalogowany użytkownik pobiera odczyty
    *	Then – odczyt zostaje zwrócone
5.	Sprawdzenie faktur
    *	Given – zalogowany użytkownik chce sprawdzić faktury
    *	When – zalogowany użytkownik pobiera faktury
    *	Then – faktury zostaje zwrócone
6.	Zmiana ustawień konta
    *	Given – zalogowany użytkownik chce zmienić ustawienie na koncie
    *	When – zalogowany użytkownik wchodzi w zakładkę ustwienia
    *	Then – zmienia ustawienia
7.	Wprowadzenie danych o instalacji
    *	Given – zalogowany użytkownik chce dodać informacje o instalacji
    *	When – zalogowany użytkownik wprowadza informacje
    *	Then – ustawienia zostają zapisane
8.	Wprowadzenie danych do instalacji
    * Given – zalogowany użytkownik chce dodać informacje o instalacji
    * When – zalogowany użytkownik wprowadza informacje
    * Then – informacje zostają zapisane

# Schemat bazy danych
![alt text](https://github.com/LukaszMazurek/fotowoltaika/blob/develop/docs/DatabaseSchema.jpg)
