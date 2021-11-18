package br.com.kodeway.permissions.storage.permissions.specs;

import br.com.kodeway.permissions.PermissionsConstants;
import io.github.gutyerrez.core.shared.storage.repositories.specs.ExecuteSqlSpec;
import io.github.gutyerrez.core.shared.storage.repositories.specs.PreparedStatementCallback;
import io.github.gutyerrez.core.shared.storage.repositories.specs.PreparedStatementCreator;

/**
 * @author SrGabrieel
 */
public class CreatePermissionsTableSpec extends ExecuteSqlSpec<Void> {

    @Override
    public PreparedStatementCallback<Void> getPreparedStatementCallback() {
        return null;
    }

    @Override
    public PreparedStatementCreator getPreparedStatementCreator() {
        return connection -> {
            String query = String.format(
                    "CREATE TABLE IF NOT EXISTS %s " +
                            "(" +
                            "`id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                            "`name` VARCHAR(50) NOT NULL," +
                            "`group_id` INTEGER NOT NULL," +
                            "`grant_to_higher` BOOLEAN NOT NULL" +
                            ");",
                    PermissionsConstants.Databases.Mysql.Tables.PERMISSIONS_TABLE_NAME
            );

            return connection.prepareStatement(query);
        };
    }

}
