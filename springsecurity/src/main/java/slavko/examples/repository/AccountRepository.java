package slavko.examples.repository;

import org.springframework.data.repository.CrudRepository;

import slavko.examples.model.Account;

public interface AccountRepository extends CrudRepository<Account, String> {

	public Account findByUsername(String username);

}
