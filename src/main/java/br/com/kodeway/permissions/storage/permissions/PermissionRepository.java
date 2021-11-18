package br.com.kodeway.permissions.storage.permissions;

import br.com.kodeway.permissions.storage.permissions.specs.CreatePermissionsTableSpec;
import io.github.gutyerrez.core.shared.providers.MysqlDatabaseProvider;
import io.github.gutyerrez.core.shared.storage.repositories.MysqlRepository;

/**
 * @author SrGabrieel
 */
public class PermissionRepository extends MysqlRepository {

    public PermissionRepository(MysqlDatabaseProvider databaseProvider) {
        super(databaseProvider);

        this.createTable();
    }

    private void createTable() {
        this.query(new CreatePermissionsTableSpec());
    }



}
