import java.util.ArrayList;
import java.util.List;

public class Feast {
    private List<Human> guests = new ArrayList<>();

    //Анонимный класс
    private Citizen specialGuest = new Citizen("Alexander Suvorov", 60, Layer.GENERAL, 1) {
        @Override
        public void openSpeech() {
            System.out.println("Здравствуйте, хорошего вечера!");
        }
    };
    Servant waiter = new Servant(ServantPosition.WAITER, "Alex");
    Servant cleaner = new Servant(ServantPosition.CLEANER, "Lupen");
    Servant maneger = new Servant(ServantPosition.MANAGER, "Jhon");



    public void addGuests(Human ... h) throws ExceedNumGuestException {
        if (h.length <= 25) {
            for (Human i : h) {
                guests.add(i);
            }
        }
        else {
            throw new ExceedNumGuestException("Количество мест превысило 25");
        }
    }

    public void prepareFood() {
        System.out.println("Производится первоначальные приготовления");
    }

    public void startFeast() {
        System.out.println("Начнет вечер специальный гость - " + specialGuest.toString());
        specialGuest.openSpeech();
    }

    public void SayToast() {
        int rand = (int) (Math.random() * guests.size());
        System.out.println("Сейчас прозвучит тост от " + guests.get(rand));

        // Локальный класс
        class Toast {
            String[] phrases = {"За счастье не пьют - за него борются. За здоровье не пьют - за него молятся. За любовь не пьют - ею занимаются. Выпьем за мечты - пусть они сбываются!",
                    "А этот тост будет за то, что бы наша печень всегда была здорова, и всегда выдерживала такие пьянки! Желудок не отказывал нам в количестве столько жирной и вкусной еды. А душа всегда была молода, что бы почаще так собираться!"};

            public void sayRandomPhrase() {
                int random = (int) (Math.random() * phrases.length);
                System.out.println(phrases[random]);
            }
        }
        Toast toast = new Toast();
        toast.sayRandomPhrase();
    }

    public void endFeast() {
        System.out.println("Пир закончен");
    }

    public void cleanTheRoom() {
        System.out.println();
    }

    // Внутренний (нестатичный) класс
    private class Servant {
        ServantPosition position;
        String name;
        private Servant(ServantPosition position, String name) {
            this.position = position;
            this.name = name;
        }
        public void doSomething() {
            System.out.println(name + " что-то делает");
        }
    }
    public void beginFeast() {
        prepareFood();
        startFeast();
        SayToast();
        endFeast();
        cleanTheRoom();
    }

}
