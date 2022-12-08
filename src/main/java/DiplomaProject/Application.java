/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом:
Фамилия Имя Отчество датарождения номер_телефона пол
Форматы данных:
 - фамилия, имя, отчество - строки
 - дата_рождения - строка формата dd.mm.yyyy
 - номер_телефона - целое беззнаковое число без форматирования
 - пол - символ латиницей f или m.

    Приложение должно проверить введенные данные по количеству.
Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
что он ввел меньше и больше данных, чем требуется.
    Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
    Можно использовать встроенные типы java и создать свои.
    Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида:
<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.
Dobrova Alina Olegovna 27.10.1995 94454781 f - строка для быстрого теста
TODO: 1) Предположить и пробросить все возможные исключения в классе Data, смотри TODO
TODO: 2) Добавить работу с файлами, если все данные успешно распарсились
TODO: 3) Пробросить возможные Exceptions при работе с файлами
TODO: 4) Сделать свои классы Exceptions, унаследовать их от уже известных и применить
TODO: 5) Протестировать приложение на множестве разных входных данных
TODO: 6) Интерфейсы?
TODO: 7) Обработать ввод через маленькую букву
 */
package DiplomaProject;

public class Application {
    public static void main(String[] args) {
        Data newData = new Data();
        newData.launchButton();
        System.out.println(newData);
    }
}
