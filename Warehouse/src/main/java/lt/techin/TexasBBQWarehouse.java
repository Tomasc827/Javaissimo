package lt.techin;

import lt.itakademija.exam.*;
import lt.itakademija.exam.Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TexasBBQWarehouse extends Warehouse {
    private HashMap<Client,ArrayList<Package>> sets = new HashMap<>();

    public TexasBBQWarehouse(IdGenerator clientIdGenerator, IdGenerator packageIdGenerator, int totalSpace) {
        super(clientIdGenerator, packageIdGenerator, totalSpace);
        if (totalSpace <=0) {
            throw new IllegalArgumentException("Total space must be greater than 0");
        }
    }

    @Override
    public int getTotalSpace() {
        return totalSpace;
    }

    @Override
    public int getAvailableSpace() {
        return totalSpace - getReservedSpace();
    }

    @Override
    public int getTotalAvailableSpace() {
        return getTotalSpace() - sets.keySet().stream().flatMap(client -> client.getPackages().stream()).mapToInt(Package::getSpace).sum();
    }

    @Override
    public int getReservedSpace() {
        return sets.keySet().stream().mapToInt(Client::getReservedSpace).sum();
    }

    @Override
    public Client registerClient(String name, int space) {
        if (space > getAvailableSpace()) {
            throw new InsufficientSpaceException("Not enough space available to register client");
        }
        if (space <= 0) {
            throw new IllegalArgumentException("Space must be greater than 0");
        }
        Client client = new Client(clientIdGenerator.generateId(), name, space);
        sets.put(client,new ArrayList<>());
        return client;
    }

    @Override
    public Package createPackage(String name, int space) {
       if (space <= 0) {
           throw new IllegalArgumentException("Space must be greater than 0");
       }
        Package pkg = new Package(packageIdGenerator.generateId(), name, space);
        return pkg;
    }

    @Override
    public void storePackage(Client client, Package aPackage) {
        if (client.getAvailableSpace() < aPackage.getSpace()) {
            throw new InsufficientSpaceException("Client does not have enough space to store package");
        }
        client.addPackage(aPackage);
        sets.get(client).add(aPackage);
    }

    @Override
    public Client getClientById(int id) {
        return sets.keySet().stream().filter(client -> client.getId()== id).findFirst().orElse(null);
    }

    @Override
    public boolean hasClientById(int id) {
        return sets.keySet().stream().anyMatch(client -> client.getId() == id);
    }

    @Override
    public List<Client> findClientsBy(ClientPredicate clientPredicate) {

        return sets.keySet().stream().filter(clientPredicate::test).collect(Collectors.toList());
    }
}
