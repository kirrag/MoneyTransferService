# MoneyTransferService

# Курсовой проект «Сервис перевода денег»
## Описание проекта

> Необходимо разработать приложение — REST-сервис. Сервис должен предоставить интерфейс для перевода денег с одной карты на другую по заранее описанной спецификации.

> Заранее подготовленное веб-приложение (FRONT) должно подключаться к разработанному сервису без доработок и использовать его функционал для перевода денег.

## Требования к приложению

*    Сервис должен предоставлять REST-интерфейс для интеграции с FRONT.
*    Сервис должен реализовывать все методы перевода с одной банковской карты на другую, описанные в [протоколе](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml).
*    Все изменения должны записываться в файл — лог переводов в произвольном формате с указанием:
*    даты;
*    времени;
*    карты, с которой было списание;
*    карты зачисления;
*    суммы;
*    комиссии;
*    результата операции, если был.

## Требования в реализации

*    Приложение разработано с использованием Spring Boot.
*    Использован сборщик пакетов gradle/maven.
*    Для запуска используется Docker, Docker Compose .
*    Код размещён на GitHub.
*    Код покрыт юнит-тестами с использованием mockito.
*    Добавлены интеграционные тесты с использованием testcontainers.

## Шаги реализации:

*    Изучить протокол получения и отправки сообщений.
*    Нарисовать схему приложений.
*    Описать архитектуру приложения, где хранятся настройки, описать формат хранения данных о картах.
*    Создать репозиторий проекта на GitHub.
*    Протестировать приложение с помощью curl/postman.
*    Написать Dockerfile и создать контейнер.
*    Написать Docker Compose скрипт для запуска FRONT и написанного REST-SERVICE.
*    Протестировать запуск с помощью Docker Compose и интеграцию с FRONT.
*    Написать README.md к проекту, где описать команду запуска, порт и примеры запросов.
*    Отправить на проверку.

## Описание интеграции с FRONT

> FRONT доступен по [адресу](https://github.com/serp-ya/card-transfer). Можно скачать репозиторий и запустить Node.js приложение локально (в описании репозитория FRONT добавлена информация, как запустить) или использовать уже развёрнутое демо-приложение по [адресу](https://serp-ya.github.io/card-transfer/) (тогда ваш API должен быть запущен по [адресу](http://localhost:5500/)).

>>    Весь API FRONT был описан в соответствии [YAML](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml) файла по спецификации OpenAPI (подробнее по [ссылке 1](https://swagger.io/specification/) и [ссылке 2](https://starkovden.github.io/introduction-openapi-and-swagger.html)).

## При возникновении любых вопросов, пожалуйста, задавайте их преподавателю.

## Успехов в разработке!

# Описание реализации
## Команды запуска:

```
	
mvn spring-boot:run
tail -f logs/spring.log
```
	
```
	
docker start moneytransfer
docker exec -it moneytransfer /bin/sh
tail -f logs/spring.log
```
```
	
docker-compose up
docker exec -it moneytransferservice_moneytransfer_1 /bin/sh
tail -f logs/spring.log
```

## Порт: 5500

## Примеры запросов:

При старте создаются две карты:

```
	
{
	CardNumber: '0000000000000001', 
	validTill: '01/24',
	cvv: '101'
	Amount: { value: 1000000, type: 'RUB'}
}
```
	
```
	
{
	CardNumber: '0000000000000002', 
	validTill= '02/24',
	cvv: '102'
	Amount: {value: 2000000, type: 'RUB'}
}
```


### Запросы для тестов:

#### Провести транзакцию:

```
	
POST:
{
    "cardFromNumber": "0000000000000001",
    "cardFromValidTill": "01/24",
    "cardFromCVV": "101",
    "cardToNumber": "0000000000000002",
    "amount": {"value": 100000, "type": "RUB"}
}

```

#### Запросить состояние карт:
```
	
GET:
http://localhost:5500/cards/0000000000000001

GET:
http://localhost:5500/cards/0000000000000002
```

