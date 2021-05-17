package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Eggs {

    public Rabbit getRabbitWithMaxEggs() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Eggs.class.getResourceAsStream("/eggs.csv")))) {

            return getRabbit(br);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private Rabbit getRabbit(BufferedReader br) throws IOException {
        String name = "";
        int maxEggs = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(";");
            int numberOfEggs = Integer.parseInt(temp[1]);
            if (numberOfEggs > maxEggs) {
                maxEggs = numberOfEggs;
                name = temp[0];
            }
        }
        return new Rabbit(name, maxEggs);
    }
}
