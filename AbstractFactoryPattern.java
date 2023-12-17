import java.util.Arrays;
import java.util.List;


abstract class TransportFactory {
    public static <T> void presentAssembledTransport(T transportObj) {
        System.out.println(transportObj);
    }

    abstract public Car createCar();
    abstract public Truck createTruck();
}

// ----------------------- Products -------------------------
interface Car {
    void assembleCar();
}

interface Truck {
    void assembleTruck();
}

class MersedesCar implements Car {
    @Override
    public void assembleCar() {
        System.out.println("Assembling Mersedes car...");
    }
    
    @Override
    public String toString() {
        return "A new shiny Mersedes car!";
    }
}

class MersedesTruck implements Truck {
    @Override
    public void assembleTruck() {
        System.out.println("Assembling Mersedes Truck...");
    }
    
    @Override
    public String toString() {
        return "A new shiny Mersedes truck!";
    }
}

class BMWCar implements Car {
    @Override
    public void assembleCar() {
        System.out.println("Assembling BMW car...");
    }
    
    @Override
    public String toString() {
        return "A new shiny BMW Car!";
    }
}

class BMWTruck implements Truck {
    @Override
    public void assembleTruck() {
        System.out.println("Assembling BMW Truck...");
    }
    
    @Override
    public String toString() {
        return "A new shiny BMW Truck!";
    }
}

// ------------------------- Creators -------------------------------
class Mersedes extends TransportFactory {
    @Override
    public Car createCar() {
        return new MersedesCar();
    }
    @Override
    public Truck createTruck() {
        return new MersedesTruck();
    }
}

class BMW extends TransportFactory {
    @Override
    public Car createCar() {
        return new BMWCar();
    }

    @Override
    public Truck createTruck() {
        return new BMWTruck();
    }
}

class EntryPoint {
    public static void main(String[] args) {
        TransportFactory mersedes = new Mersedes();
        TransportFactory bmw = new BMW();
        
        Car mersedesCar = mersedes.createCar();
        Truck mersedesTruck = mersedes.createTruck();
        
        Car bmwCar = bmw.createCar();
        Truck bmwTruck = bmw.createTruck();

        mersedesCar.assembleCar();
        mersedesTruck.assembleTruck();
        
        bmwCar.assembleCar();
        bmwTruck.assembleTruck();
    
        List<Object> assembledTransportList = Arrays.asList(
            mersedesCar,
            mersedesTruck,
            bmwCar,
            bmwTruck
        );

        assembledTransportList.forEach(TransportFactory::presentAssembledTransport);
    }
}
