import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    public enum TipoCuerpoCeleste {
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }

    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satélites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        this.satélites = new HashSet<>();
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return new HashSet<>(satélites);
    }

    public boolean addSatelite(CuerpoCeleste satelite) {
        if (satelite.getTipoCuerpo() == TipoCuerpoCeleste.LUNA) {
            return satélites.add(satelite);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) obj;
        return Objects.equals(nombre, that.nombre) &&
                tipoCuerpo == that.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCuerpo) + 42; // Arbitrary number
    }

    @Override
    public String toString() {
        return nombre + ": " + tipoCuerpo + ", " + periodoOrbital;
    }
}