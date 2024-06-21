# Filtering flights 
***
## Здравствуйте, уважаемые, надеюсь будущие коллеги))
Представляю вам тестовую программу для трудоусстройтсва в компанию GridnaneSystems
***
Программа содержит методы (в классе com.gridnine.testing.services.FlightServicesImpl), которые исключают из набора перелётов, перелёты в которых:
1. Вылет до текущего момента времени.
2. Имеются сегменты с датой прилёта раньше даты вылета.
3. Общее время, проыедённое на земле превышает два часа (время на земле - это интервал между прилётом одного сегмента и вылетом следующего за ним).
***
### Запуск приложения и ее работа
Для запуска приложения необходимо запустить метод Main в IDE, программа сама создаст тестовый вариант набора рейсов и выведит их в консоль, далее поочередно будет выведена в консоль работа целевых методов с комментарием в начале.
***
### Технологии
* JDK 17
* JUnit