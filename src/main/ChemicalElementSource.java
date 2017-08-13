package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Data source for chemical elements.
 */
public class ChemicalElementSource {
    /**
     * Default path to the text file containing the chemical element data in CSV format.
     */
    private static String elementsPath = "src\\main\\resources\\chemical elements.txt";
    private Set<ChemicalElement> elements;

    /**
     * @throws ElementSourceUnavaibleException
     */
    public ChemicalElementSource() throws ElementSourceUnavaibleException {
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(elementsPath));
        } catch (IOException e) {
            throw new ElementSourceUnavaibleException(e);
        }
        elements = lines.map(line -> {
            String vals[] = line.split(" ");
            int atomicNumber = Integer.parseInt(vals[0]);
            String symbol = vals[1];
            return new ChemicalElement(atomicNumber, symbol);
        }).collect(Collectors.toSet());
    }


    /**
     * @return A Set containing data on chemical elements.
     */
    public Set<ChemicalElement> getElements() {
        return Collections.unmodifiableSet(elements);
    }


}
