package com.example.smartconvert;

public class OptionItem {
    private String label;
    private double value;

    public OptionItem(String label, double value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        // Ceci est utilisé pour l'affichage dans le Spinner
        return label;
    }
}
