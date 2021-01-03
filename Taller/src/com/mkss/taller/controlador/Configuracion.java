package com.mkss.taller.controlador;

import com.mkss.taller.capaDatos.Dao;
import com.mkss.taller.capaDatos.DaoUsuario;
import com.mkss.taller.capaDatos.ProductoDaoMySql;
import com.mkss.taller.capaDatos.UsuarioDaoMySql;
import com.mkss.taller.modelo.Producto;

public class Configuracion {
	
	public static DaoUsuario daoUsuarios = UsuarioDaoMySql.getInstancia();
	public static Dao<Producto> daoProductos = ProductoDaoMySql.getInstancia();
	//public static Dao<Producto> daoProductos = ProductoDaoTreeMap.getInstancia();

}
