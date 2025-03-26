package br.com.cursoSpring.restaurante.pratoPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;

//Implementa o CRUD(Create, Read, Update e Delete)
//JpaRepository: interface que fornece os métodos básicos de acesso ao banco de dados, como salvar, buscar, atualizar e deletar registros.É uma extensão de CrudRepository e PagingAndSortingRepository, permitindo operações CRUD e paginação/sorting de forma simplificada.
public interface PratoPrincipalRepository extends JpaRepository<PratoPrincipal,Long>{
}
