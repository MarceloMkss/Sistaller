package com.mkss.taller.capaDatos;

import com.mkss.taller.modelo.Usuario;

public interface DaoUsuario extends Dao<Usuario>{ // P = tipo de dato

	Usuario obtenerPorEmail(String email);
	
}
