public class Vehicle
{
    private int wheels;
    private double weight;
    public Vehicle(int wheels, double weight)
    {
        this.wheels = wheels;
        this.weight = weight;
    }
    public void printf()
    {
        System.out.println("wheels = " + wheels);
        System.out.println("weight = " + weight);
    }
    public static void main(String[]args)
    {
        Vehicle c=new Vehicle(3,12.5);
        Car v=new Car(4,16,4);
        Truck b=new Truck(8,80,2,100);
        c.printf();
        v.printf();
        b.printf();
    }
}
class Car extends Vehicle
{
    private int loader;
    public Car(int wheels, double weight, int loader)
    {
        super(wheels, weight);
        this.loader = loader;
    }
    public void printf()
    {
        super.printf();
        System.out.println("loader = " + loader);
    }
}
class Truck extends Car
{
    private int payload;
    public Truck(int wheels, double weight, int loader, int payload)
    {
        super(wheels, weight, loader);
        this.payload = payload;
    }
    public void printf()
    {
        super.printf();
        System.out.println("payload = " + payload);
    }
}
