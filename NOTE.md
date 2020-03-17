Фроненда нет, не успел. Backend проверял через Postman.

Для запуска приложения:
- либо в корне приложения запустить `gradlew build`, и затем в docker `docker-compose up -d`
- либо в `docker-compose.yml` у сервиса `backend` строку `build: ./backend` заменить на `image: denial0591/car_rental_backend`, и затем в docker `docker-compose up -d` 

DDL базы лежит в ./database/init-ddl.sql. Там же insert-data.sql с заполнением базы тестовыми данными.

Сам запускал на Windows, там docker machine имел ip 192.168.99.100, поэтому ниже использую этот адресс.
Rest API:
1) просмотр истории взятия автомобилей в прокат:
   - список всех договоров на автопрокат (СarRentalContract) можно получить по:
`GET http://192.168.99.100:8082/rest/carRentalContracts`
   - список договоров в разрезах можно получить добавив параметр filter:
`GET http://192.168.99.100:8082/rest/carRentalContracts?filter={"model": {"id": 1}, "startDate": "2019-01-01", "endDate": "2019-01-05", "customerLastName": "ошка", "customerFirstName": "Иван", "customerMiddleName": "ныч", "carNumber": "111"}`
      - `"model": {"id": 1}` - по модели авто с id=1
      - `"startDate": "2019-01-01"` - по дате взятия (в БД это dateTime) принадлежащему заданному дню. Хотя можно было указать промежуток
      - `"endDate": "2019-01-05"` - то же что startDate, но на дату возврата
      - `"customerLastName": "ошка", "customerFirstName": "Иван", "customerMiddleName": "ныч"` - по ФИО, через like
      - `"carNumber": "111"` - по номеру авто, через like
2) добавление в историю взятия:
   - `POST http://192.168.99.100:8082/rest/carRentalContract/save`
   body = `{
           	"customer": {"id": 1},
           	"car": {"id": 3},
           	"startDate": "2019-03-03T16:00:00",
           	"endDate": "2019-03-05T18:00:00"
           }`
3) средняя продолжительность проката авто по модели:
   - `GET http://192.168.99.100:8082/rest/carRentalContract/avgInterval?modelId=1`
   Возвращяет строку вида "04day 02h 00m 00s", т.е. 4 дня 2 часа. На скорую руку делал
      - modelId=1 - ид модели авто
4) Ещё есть `GET http://192.168.99.100:8082/rest/cars` для возврата всех авто, остальные модели можно делать по аналогии.
