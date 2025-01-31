package tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tacos.TacoOrder;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findAllByOrderByPlacedAtDesc(/*User user*/Pageable pageable);

}