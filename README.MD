# Итоговая контрольная работа

[Задания](https://gbcdn.mrgcdn.ru/uploads/asset/4868005/attachment/1f0bfdadc1c954fc748a4890b644e605.pdf)

## Задание 1-5

> 1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
> 2. Создать директорию, переместить файл туда.
> 3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
> 4. Установить и удалить deb-пакет с помощью dpkg.
> 5. Выложить историю команд в терминале ubuntu

### 1. Для начала подключаемся к ubuntu server по ssh
\
![Скриншот](/img/2023-07-09_17-55-47.png)

### 2. Выполняем все команды для выполнения всех заданий с 1 по 5 получив список команд при помощи команды в консоли "history":
\
![Скриншот](/img/2023-07-09_18-01-03.png)

### Команды:
\
_533  cat > Pets.txt_

_534  cat > Animals.txt_

_535  ls -la_

_536  cat Animals.txt Pets.txt > Friends.txt_

_537  ls -la_

_538  mv Friends.txt Shelter/_

_539  cd Shelter/_

_540  cat Friends.txt_

_541  dpkg -i nginx_1.18.0-6ubuntu14.3_amd64.deb_

_542  sudo apt-get -f install_

_543  dpkg -r nginx_

_544  dpkg -l_

_545  dpkg -r nginx-core_

_546  dpkg -r nginx-common_


### Установка MySQL командой:

![Скриншот](/img/2023-07-09_18-11-19.png)

### Установка пакета dpkg:

![Скриншот](/img/2023-07-09_18-16-59.png)
![Скриншот](/img/2023-07-09_18-17-25.png)
### При помощи команды dpkg -l проверяем, что пакет установлен
![Скриншот](/img/2023-07-09_18-19-44.png)
### Удаляем пакет
![Скриншот](/img/2023-07-09_18-20-12.png)

## Задание 6

>6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы.

### Рисуем схему

![Скриншот](/img/2023-07-08_20-37-18.png)

## Задание 7-12

>7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
>8. Создать таблицы с иерархией из диаграммы в БД
>9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
>10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
>11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
>12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

### Всю работа с MySQL server проводим в консоли Ubuntu server
### Проверяем работу
![Скриншот](/img/2023-07-09_18-26-27.png)
### Создаем базу данных
![Скриншот](/img/2023-07-09_18-26-56.png)