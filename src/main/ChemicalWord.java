package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * A word written using a sequence of chemical element symbols.
 */
public class ChemicalWord {
    private List<ChemicalElement> elements;

    /**
     * @param elements A list of chemical elements whose symbols represent a given word.
     */
    public ChemicalWord(List<ChemicalElement> elements){
        this.elements = new ArrayList<>();
        this.elements.addAll(elements);
    }

    /**
     * @return A list of chemical elements whose symbols represent a given word.
     */
    public List<ChemicalElement> getElements(){
        return Collections.unmodifiableList(this.elements);
    }

    @Override
    public String toString(){
        Stream<String> symbols = elements.stream().map(ChemicalElement::getSymbol);
        return symbols.reduce("", (a,b) -> a.concat(b));
    }
}
