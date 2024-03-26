class Planeta extends CuerpoCeleste {
    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste satelite) {
        return satelite.getTipoCuerpo() == TipoCuerpoCeleste.LUNA && super.addSatelite(satelite);
    }
}
