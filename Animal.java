public abstract class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    void eat() {
        System.out.println(name + " eats food");
    }
    public abstract void makeSound(); 
}
