package bean;

public class Estilo {
	private int idEstilo;
	private String tipoEstilo;

	public Estilo() {
		super();
	}

	public Estilo(int idEstilo, String tipoEstilo) {
		super();
		this.idEstilo = idEstilo;
		this.tipoEstilo = tipoEstilo;
	}

	public int getIdEstilo() {
		return idEstilo;
	}

	public void setIdEstilo(int idEstilo) {
		this.idEstilo = idEstilo;
	}

	public String getTipoEstilo() {
		return tipoEstilo;
	}

	public void setTipoEstilo(String tipoEstilo) {
		this.tipoEstilo = tipoEstilo;
	}

	@Override
	public String toString() {
		return "estilo [idEstilo=" + idEstilo + ", tipoEstilo=" + tipoEstilo + "]";
	}
}