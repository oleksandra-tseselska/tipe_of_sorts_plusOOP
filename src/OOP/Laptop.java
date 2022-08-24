package OOP;

public class Laptop extends Computer {
    private int battery;

    public Laptop(String cpu, String ram, String gpu,int battery){
        super(cpu, ram, gpu);
        this.battery = battery;
    }

    @Override
    public void configure(){
        super.configure();
        System.out.println("Configure battery "+battery);
    }
}


