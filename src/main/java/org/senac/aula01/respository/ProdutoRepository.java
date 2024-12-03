package org.senac.aula01.respository;



import org.senac.aula01.model.Produto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProdutoRepository 
        extends JpaRepository<Produto, Integer> {
    
        List<Produto> findByNomeContains(String filter, Sort s);

        
     
}
