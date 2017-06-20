package controle;

import dao.CarroDAO;
import dao.DAOFactory;
import modelo.Carro;

public class ControleCarro {
	
	public static ControleCarro instance;
	private CarroDAO carroDAO = DAOFactory.getCarroDAO();
	
	private ControleCarro() {
		
	}
	
	public static ControleCarro getInstance() {
		if (instance == null) {
			instance = new ControleCarro();
		}
		return instance;
	}
	
	public void salvar() {
		String placa = "AAA1111";
		String modelo = "Fusca";
		String marca = "Volkswagen";
		Carro c = new Carro(placa, modelo, marca);
		carroDAO.salvar(c);
		
		placa = "AAA2222";
		modelo = "HB20";
		marca = "Hyundai";
		c = new Carro(placa, modelo, marca);
		carroDAO.salvar(c);
		
		placa = "AAA3333";
		modelo = "Golf";
		marca = "Volkswagen";
		c = new Carro(placa, modelo, marca);
		carroDAO.salvar(c);
	}

	public CarroDAO getCarroDAO() {
		return carroDAO;
	}
	
	public Carro buscaPorPlaca(String placa) {
		return carroDAO.buscaPorPlaca(placa);
	}
	
	
	
	

}
