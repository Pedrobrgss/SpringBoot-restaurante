package br.com.cursoSpring.restaurante.usuario;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cursoSpring.restaurante.config.CriptografiaSenha;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByLogin(login);
    }

    public DadosUsuariosCadastro cadastrarUsuario(DadosUsuariosCadastro dto){
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        //Criptografando a senha
        String senhaCriptografada = CriptografiaSenha.criptografia(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);
        
        repository.save(usuario);
        return modelMapper.map(usuario, DadosUsuariosCadastro.class);
    }

}
