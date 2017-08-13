package main;

/**
 * A representation of a chemical element
 */

public class ChemicalElement {
    int atomicNumber;
    private String symbol;

    /**
     * @return
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * @return
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }

    /**
     * @param atomicNumber A given chemical element's atomic number
     * @param symbol       A given element's symbolic representation
     */

    public ChemicalElement(int atomicNumber, String symbol) {
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
