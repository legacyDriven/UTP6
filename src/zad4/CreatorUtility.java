package zad4;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CreatorUtility {

    private CreatorUtility() {
        throw new AssertionError("CreatorUtility should not be instantiated!");
    }

    private static List<Integer> generateRandomValuesInRange(int count, int lowerBound, int upperBound) {
        return ThreadLocalRandom.current()
                .ints(count, lowerBound, upperBound).boxed()
                .collect(Collectors.toList());
    }

    public static List<Product> createProductListSortedByid(int count, int lowerBound, int upperBound){
        List<Integer> productWeight = generateRandomValuesInRange(count, lowerBound, upperBound);
        List<Product> resultList = new ArrayList<>(count);
        for(int i = 0; i < count; i++){
            resultList.add(new Product(i+1, productWeight.get(i)));
        }
        return resultList;
    }

    public static void createProductListAndWriteToFile(String fileName, int count, int lowerBound, int upperBound) throws IOException {
        List<Product> temp = CreatorUtility.createProductListSortedByid(count, lowerBound, upperBound);
        FileWriter writer = new FileWriter(fileName);
        for(Product str: temp) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }



    public static void main(String[] args) throws IOException {

        List<String> plainTextProducts = new ArrayList<>(50);
        try {
            CreatorUtility.createProductListAndWriteToFile("Towary.txt", 15000, 10, 500);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (Stream<String> stream = Files.lines(Paths.get("Towary.txt"))) {
            stream.forEach(plainTextProducts::add);
        }

        System.out.println(plainTextProducts.size());

    }
}

