# fotowoltaika
Setup:
* otwórz projekt w intelij 
* intelij powinien automatycznie dociągnąć zależności z poma jeżeli toge nie zrobi to trzeba to zrobić ręcznie https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* używam mysql w wersji 8
* utwórz bazę danych fotowoltaika
* ustaw hasło do połaczenia z bazą w plik applicatio.yaml na twoje hasło

# start projektu
* wstaw do bazy role admina:
* INSERT INTO fotowoltaika.roles (id, name) VALUES(0, 'ROLE_ADMIN');
* wstaw do bazy role usera 
* INSERT INTO fotowoltaika.roles (id, name) VALUES(1, 'USER');
* domyslnie tworzony jest uzytkownik z rolą user

# przykłady
* POST (rejstracja)
```
http://localhost:8080/api/auth/signup
{
    "name": "bb",
    "username": "Marley",
    "email": "bob2@marley.com",
    "password": "bob123"
}
```
* POST (logowanie)
```
http://localhost:8080/api/auth/signin
{
    "usernameOrEmail": "Marley",
    "password": "bob123"
}
```
* GET (testowy get po zalogowaniu)
```
http://localhost:8080/api/auth/hello_admin
http://localhost:8080/api/auth/hello_user
```

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
7.	Zmiana ustawień konta
      *	Given – zalogowany użytkownik chce zmienić ustawienie na koncie
      *	When – zalogowany użytkownik wchodzi w zakładkę ustwienia
      *	Then – zmienia ustawienia
8.	Wprowadzenie danych o instalacji
      *	Given – zalogowany użytkownik chce dodać informacje o instalacji
      *	When – zalogowany użytkownik wprowadza informacje
      *	Then – ustawienia zostają zapisane
10.	Wprowadzenie danych do instalacji
       * Given – zalogowany użytkownik chce dodać informacje o instalacji
       * When – zalogowany użytkownik wprowadza informacje
       * Then – informacje zostają zapisane

# Schemat bazy danych
![alt text](https://github.com/LukaszMazurek/fotowoltaika/blob/master/docs/DatabaseSchema.jpg?raw=true)