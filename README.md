# fotowoltaika
Setup:
* otwórz projekt w intelij 
* intelij powinien automatycznie dociągnąć zależności z poma jeżeli toge nie zrobi to trzeba to zrobić ręcznie https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* używam mysql w wersji 8
* utwórz bazę danych fotowoltaika
* ustaw hasło do połaczenia z bazą w plik applicatio.yaml na twoje hasło

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
* GET
```
http://localhost:8080/hello
```
