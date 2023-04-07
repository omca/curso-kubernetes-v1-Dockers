package org.aguzman.springcloud.msvc.cursos.clients;

import org.aguzman.springcloud.msvc.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="msvc-usuarios", url="${msvc.usuarios.url}")
public interface UsuarioClientRest {

    /**
     * obtener detalle de un usuario
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Usuario detalle(@PathVariable Long id);

    /**
     * registrar usuario
     * @param usuario
     * @return
     */
    @PostMapping("/")
    Usuario crear(@RequestBody Usuario usuario);

    /**
     * obtener alumnos por curso
     * @param ids
     * @return
     */
    @GetMapping("/usuarios-por-curso")
    List<Usuario> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
