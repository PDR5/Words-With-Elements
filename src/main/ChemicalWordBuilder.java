package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * A mutable representation of a ChemicalWord.
 */
public class ChemicalWordBuilder {
    List<ChemicalElement> elements;

    /**
     * Creates an entity that represents a word with no characters
     */
    public ChemicalWordBuilder(){
        this.elements = new ArrayList<>();
    }

    /**
     * @param elements The initial content of this object.
     */
    public ChemicalWordBuilder(List<ChemicalElement> elements) {
        this();
        this.elements.addAll(elements);
    }


    /**
     * @param elem Element to append.
     * @return A reference to this object.
     */
    public ChemicalWordBuilder append(ChemicalElement elem){
        this.elements.add(elem);
        return this;
    }

    /**
     * @param index The index to append the elements to.
     * @param elems List of elements to be appended.
     * @return A reference to this object.
     */
    public ChemicalWordBuilder addAll(int index, List<ChemicalElement> elems){
        this.elements.addAll(index, elems);
        return this;
    }


    public ChemicalWord build(){
        return new ChemicalWord(elements);
    }

    /**
     * Creates a mutable representation of a ChemicalWord given some initial values.
     * @param chemWord Initial values.
     * @return A mutable representation of chemWord.
     */
    public static ChemicalWordBuilder of(ChemicalWord chemWord){
        ChemicalWordBuilder cwb = new ChemicalWordBuilder(chemWord.getElements());
        return cwb;
    }


    /**
     * @param elements The elemnts to append.
     * @return A reference to this object.
     */
    public ChemicalWordBuilder append(List<ChemicalElement> elements) {
        this.elements.addAll(elements);
        return this;
    }

    @Override
    public String toString(){
        Stream<String> symbols = elements.stream().map(ChemicalElement::getSymbol);
        return symbols.reduce("", (a,b) -> a.concat(b));
    }
}
