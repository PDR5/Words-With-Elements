package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A class that writes words using only chemical element symbols.
 */
public class ElementWriter {
    private ChemicalElementSource chemicalElements;

    /**
     * @throws ElementSourceUnavaibleException
     */
    public ElementWriter() throws ElementSourceUnavaibleException {
        this.chemicalElements = new ChemicalElementSource();
    }

    /**
     * @param source An object that contains a set of chemical element symbols.
     */
    public ElementWriter(ChemicalElementSource source) {
        this.chemicalElements = source;
    }

    /**
     * @param word The word to write as chemical elements symbols
     * @return A Set containing all the possible ways to write word with chemical element symbols.
     */
    public Set<ChemicalWord> write(String word) {
        List<ChemicalWordBuilder> cwbs = new ArrayList<>();
        writeRecur(word, cwbs);
        return cwbs.stream().map(cwb -> cwb.build()).collect(Collectors.toSet());
    }

    /**
     * @param word The word to write using chemical element Symbols.
     * @param wordBuilders A list used during recursion
     * @return If it is possible to write a word using chemical element symbols.
     */
    private boolean writeRecur(String word, List<ChemicalWordBuilder> wordBuilders) {

        if (word.length() == 0) {
            return true;
        }

        Set<ChemicalElement> possibleElements = new HashSet<>();
        for (ChemicalElement elem : chemicalElements.getElements()) {
            if (word.regionMatches(true, 0, elem.getSymbol(), 0, elem.getSymbol().length())) {
                possibleElements.add(elem);
            }
        }

        if (possibleElements.size() == 0) {
            return false;
        }

        boolean isPossible = false;
        for (ChemicalElement chemicalElement : possibleElements) {
            String remainingWord = word.substring(chemicalElement.getSymbol().length());
            if (chemicalElement.getSymbol().equalsIgnoreCase(word)) {
                ChemicalWordBuilder cwb = new ChemicalWordBuilder();
                cwb.append(chemicalElement);
                wordBuilders.add(cwb);
                isPossible = true;
                continue;
            }

            List<ChemicalWordBuilder> continuations = new ArrayList<>();
            if (writeRecur(remainingWord, continuations)) {
                isPossible = true;
                for (ChemicalWordBuilder continuation : continuations) {
                    ChemicalWordBuilder cwb = new ChemicalWordBuilder();
                    cwb.append(chemicalElement);
                    cwb.append(continuation.elements);
                    wordBuilders.add(cwb);
                }

            }
        }
        return isPossible;

    }



    public static int fatorial(int n){
        if(n == 0 )return 0;
        if(n==1 )return 1;
       return fatorial(n-1) + fatorial(n-2);
    }

}
