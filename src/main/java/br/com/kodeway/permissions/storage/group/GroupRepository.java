package br.com.kodeway.permissions.storage.group;

import br.com.kodeway.permissions.storage.group.specs.CreateGroupTableSpec;
import io.github.gutyerrez.core.shared.providers.MysqlDatabaseProvider;
import io.github.gutyerrez.core.shared.storage.repositories.MysqlRepository;

/**
 * @author SrGabrieel
 */
public class GroupRepository extends MysqlRepository {

    public GroupRepository(MysqlDatabaseProvider databaseProvider) {
        super(databaseProvider);

        this.createTable();
    }

    private void createTable() {
        this.query(new CreateGroupTableSpec());
    }



}
