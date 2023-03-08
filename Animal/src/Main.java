public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Bird bird1 = new Bird();

        cat1.eat();
        cat1.makeSound();
        cat1.run();

        bird1.eat();
        bird1.makeSound();
        bird1.fly();
    }
}