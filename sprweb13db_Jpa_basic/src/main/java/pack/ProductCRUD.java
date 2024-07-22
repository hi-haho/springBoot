package pack;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductCRUD extends CrudRepository<ProductVo, Integer>{ //기본형나오면 안된다. 객체를 만들어야한다.
	// save(), findById(), count(), ... 지원 받음
}
