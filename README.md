Wstrzykiwanie zależności:

Spring Boot działa tak, że tworzy się kontekst aplikacji i są rejestrowane wszystkie beany. Beanem jest każdy @RestController @Service @Repository @Component i pewnie coś jeszcze ale tylko te pamiętam.
Spring boot skanuje wszystkie klasy i tworzy po jednej instancji każdej z nich. 
Jeżeli w konstruktorze np. UserControler jest wstrzykniecie UserService to Najpier utworzy UserService i wszystkie zależności z tym związane i potem dopiero UserService.


Ściezka jaka powinno przechodzić zapytanie:

Z Frontu spływa nam wcześniej ustalony DTO czyli dane jakie chcemy wysłać na front i tyle. Zapytanie takie trafia z Controlera na service w serwisie dzieje się cała logika czyli dobranie jakiś danych czy jakaś modyfikacja. Także powinno nastąpić przejście Z DTO na pełny DataObject oraz w drugą strone w przypadku zwrotki. Nastepnie tafia to DAO i tam jest logia komunikacji z bazą. Czasem dopisanie czegoś do zapytania czasem ograniczenie zapytania. Takie zapytanie trafia do Repositroy, które już bezpośrednio komunikuje się z bazą. 


