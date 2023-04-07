package org.aguzman.springcloud.msvc.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//@FeignClient(name="msvc-cursos", url = "${msvc.cursos.url}")
@FeignClient(name="msvc-cursos", url = "host.docker.internal:8002")
public interface CursoClienteRest {

    @DeleteMapping("/eliminar-curso-usuario-by-usuarioid/{id}")
    void eliminarCursoUsuarioPorId(@PathVariable Long id);

}
