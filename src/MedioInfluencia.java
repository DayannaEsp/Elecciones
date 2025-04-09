public enum MedioInfluencia {
    INTERNET(700000),
    RADIO(200000),
    TELEVISION(600000);

    private final int costo;

    MedioInfluencia(int costo) {
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }
}


