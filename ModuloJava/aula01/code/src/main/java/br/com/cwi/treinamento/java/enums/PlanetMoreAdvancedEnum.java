package br.com.cwi.treinamento.java.enums;

public enum PlanetMoreAdvancedEnum {

    MERCURY (3.303e+23, 2.4397e6, "Mercúrio"),
    VENUS   (4.869e+24, 6.0518e6, "Vênus"),
    EARTH   (5.976e+24, 6.37814e6, "Terra"),
    MARS    (6.421e+23, 3.3972e6, "Marte"),
    JUPITER (1.9e+27,   7.1492e7, "Júpiter"),
    SATURN  (5.688e+26, 6.0268e7, "Saturno"),
    URANUS  (8.686e+25, 2.5559e7, "Urano"),
    NEPTUNE (1.024e+26, 2.4746e7, "Netuno"),
    PLUTO   (1.27e+22,  1.137e6, "Plutão");

    private final double mass;   // in kilograms
    private final double radius; // in meters
    private final String name;

    PlanetMoreAdvancedEnum(double mass, double radius, String name) {
        this.mass = mass;
        this.radius = radius;
        this.name = name;
    }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    @Override
    public String toString() {
        return String.format("%s { massa: %3.2e, diâmetro: %3.2e}", name, mass, radius * 2);
    }
}
