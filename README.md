# fotowoltaika
Setup:
* otwórz projekt w intelij
* intelij powinien automatycznie dociągnąć zależności z poma jeżeli toge nie zrobi to trzeba to zrobić ręcznie https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* używam mysql w wersji 8
* utwórz bazę danych fotowoltaika
* ustaw hasło do połaczenia z bazą w plik applicatio.properties na twoje hasło

# przykłady
* POST (rejstracja)
```
http://localhost:8080/register
{
    "firstName": "Bob",
    "lastName": "Marley",
    "email": "bob@marley.com",
    "password": "bob123"
}
```
* POST (resetowanie hasło)
```
http://localhost:8080/resetPassword
{
    "email": "bob@marley.com",
}
response:
adres do resetowania hasła przykład
http://localhost:8080/savePassword?token=1b206ddd-4a6a-437a-ae0c-f978406af82c
```
* POST (ustawianie hasła)
```
http://localhost:8080/savePassword?token=1b206ddd-4a6a-437a-ae0c-f978406af82c
{
    "newPassword": "123"
}
response:
wynik zapyatania w postaci widomości
```
* GET (aktywacja konta)
```
http://localhost:8080/resendVerifyToken?token=dc1c1644-e241-4999-8e3d-840589d33cb8
token - jest to token który powstaje przy tworzeniu użytkowanika
```
* GET
```
http://localhost:8080/hello
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