package semana09.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import semana09.entidad.Administrador;
import semana09.repositorio.IAdministradorRepositorio;

@Service
public class AdministradorService 
				implements 
				IAdministradorService, UserDetailsService {
	
	@Autowired
	IAdministradorRepositorio repositorio;
    
	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		
		Administrador admin = buscarPorCorreo(correo);
		if(admin == null){
			return null;
		}else{
			List<GrantedAuthority> autorizaciones = new ArrayList<GrantedAuthority>();
			autorizaciones.add(new SimpleGrantedAuthority(admin.getRol().getNombre()));
			return new User(admin.getCorreo(), admin.getClave(), autorizaciones);
		}
	}

	@Override
	public Administrador buscarPorCorreo(String correo) {
		
		return repositorio.buscarPorCorreo(correo);
	}
	
}
