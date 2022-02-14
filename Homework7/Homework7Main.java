package HillelHomeworks.Homework7;

import java.text.Format;
import java.util.Scanner;

public class Homework7Main {
    public static void main(String[] args) {

        //создаём юзеров - база данных в виде массива
        User population[] = new User[4];
        population[0] = new User("admin","admin",UserEnum.ADMIN);
        population[1] = new User("ProUser1","pass1",UserEnum.PREMIUM);
        population[2] = new User("login","password",UserEnum.AUTHORIZED);
        population[3] = new User("guest","null",UserEnum.GUEST); // вот тут хотел оставить null в логине и пароле, но не понял, как реализовать - сканер требует чтобы что-то было введено
        //Пробуем авторизоваться (криво, но всё же)
        User customUser = creatingUser();
        while (!authorization(population,customUser)){
            customUser = creatingUser();
        }
        showUser(customUser);
    }
    public static User creatingUser (){
        User customUser = new User(enterLogin(), enterPassword(), enterAs());
        return  customUser;
    }

    public static Boolean authorization(User [] population, User customUser){
        if (checkUser(population,customUser)){
            System.out.println("Хэшкод существующего пользователя " + population.hashCode()); // вот тут я не додумался как можно обратится к элементу в массиве population именно в рамках метода , мне выводит хэшкод всего массива, но если указать идекс хэшкод будет правильным, однако что-то забуксовл как запомнить индекс найденного элемента в методе checkUser
            System.out.println("Хэшкод пользователя под которым входили " + customUser.hashCode());
            System.out.println("Вход будет выполнен успешно");
            return true;
        }else {
            System.out.println("Хэшкод существующего пользователя " + population.hashCode()); // аналогично 29 строке
            System.out.println("Хэшкод пользователя под которым входили " + customUser.hashCode());
            System.out.println("неверная комбинация логина и пароля? попробуйте всё сначала");
            return false;
            }
    }

    public static String enterLogin (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        return scanner.next();
    }
    public static String enterPassword (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пароль");
        return scanner.next();
    }


    public static boolean checkUser (User[] userExist,User custom) {
        Boolean result = false;
        for (int i = 0; i<userExist.length; i++ ){
            if (userExist[i].equals(custom)){
                result = true;
            }
        }
        return result;
    }

    public static UserEnum enterAs() {
        System.out.println("Под кем будем входить?");
        UserEnum result = null;
        Scanner scanner = new Scanner(System.in);
        switch (scanner.next()){
            case "ADMIN":
                System.out.println("Пробуем войти, как админ");
                result = UserEnum.ADMIN;
                break;
            case "AUTHORIZED":
                System.out.println("Пробуем войти, обычный пользователь");
                result = UserEnum.AUTHORIZED;
                break;
            case "PREMIUM":
                System.out.println("Пробуем войти, премиальный гость");
                result = UserEnum.PREMIUM;
                break;
            case "GUEST":
                System.out.println("Пробуем войти, как гость");
                result = UserEnum.GUEST;
                break;
            default:
                System.out.println("Вы ввели неверное значение - возможные варианты ADMIN, GUEST, PREMIUM, AUTHORIZED");
                return enterAs();
        }
        return  result;
    }

    public  static void showUser(User user){

        System.out.println(user);
    }
}
