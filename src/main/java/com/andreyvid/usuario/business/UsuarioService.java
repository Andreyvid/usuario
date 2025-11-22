package com.andreyvid.usuario.business;

import com.andreyvid.usuario.business.converter.UsuarioConverter;
import com.andreyvid.usuario.business.dto.UsuarioDTO;
import com.andreyvid.usuario.infrastructure.entity.Usuario;
import com.andreyvid.usuario.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioConverter.paraUsuarioDTO(usuario);
    }
}
