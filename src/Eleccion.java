import java.util.ArrayList;
import java.util.List;

public class Eleccion {
    private List<Candidato> candidatos;

    public Eleccion() {
        candidatos = new ArrayList<>();
        candidatos.add(new Candidato("Candidato A"));
        candidatos.add(new Candidato("Candidato B"));
        candidatos.add(new Candidato("Candidato C"));
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void votar(int indiceCandidato, MedioInfluencia medio) {
        if (indiceCandidato >= 0 && indiceCandidato < candidatos.size()) {
            candidatos.get(indiceCandidato).agregarVoto(medio);
        }
    }

    public void vaciarUrnas() {
        for (Candidato c : candidatos) {
            c.reiniciarVotos();
        }
    }

    public int getTotalVotos() {
        return candidatos.stream().mapToInt(Candidato::getTotalVotos).sum();
    }

    public double getPorcentajeVotos(int indiceCandidato) {
        int total = getTotalVotos();
        if (total == 0) return 0;
        return (double) candidatos.get(indiceCandidato).getTotalVotos() / total * 100;
    }

    public double getCostoPromedioCampania() {
        if (candidatos.isEmpty()) return 0;
        return candidatos.stream().mapToInt(Candidato::calcularCostoCampania).average().orElse(0);
    }
}
