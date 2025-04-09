public class Candidato {
    private String nombre;
    private int votosInternet;
    private int votosRadio;
    private int votosTv;

    public Candidato(String nombre) {
        this.nombre = nombre;
    }

    public void votar(MedioInfluencia medio) {
        if (medio == MedioInfluencia.INTERNET) votosInternet++;
        else if (medio == MedioInfluencia.RADIO) votosRadio++;
        else if (medio == MedioInfluencia.TELEVISION) votosTv++;
    }

    public int getTotalVotos() {
        return votosInternet + votosRadio + votosTv;
    }

    public int getCostoCampania() {
        return votosInternet * MedioInfluencia.INTERNET.getCosto()
                + votosRadio * MedioInfluencia.RADIO.getCosto()
                + votosTv * MedioInfluencia.TELEVISION.getCosto();
    }

    public void reiniciar() {
        votosInternet = 0;
        votosRadio = 0;
        votosTv = 0;
    }

    public String getNombre() {
        return nombre;
    }
}
