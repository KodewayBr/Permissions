package br.com.kodeway.permissions.storage.group.specs;

import br.com.kodeway.permissions.PermissionsConstants;
import io.github.gutyerrez.core.shared.storage.repositories.specs.ExecuteSqlSpec;
import io.github.gutyerrez.core.shared.storage.repositories.specs.PreparedStatementCallback;
import io.github.gutyerrez.core.shared.storage.repositories.specs.PreparedStatementCreator;

/**
 * @author SrGabrieel
 */
public class CreateGroupTableSpec extends ExecuteSqlSpec<Void> {

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
                            "`name` VARCHAR(25) NOT NULL," +
                            "`prefix` VARCHAR(25) NOT NULL," +
                            "`suffix` VARCHAR(25) NOT NULL," +
                            "`color` VARCHAR(15) NOT NULL," +
                            "`priority` INTEGER NOT NULL," +
                            "`tab_list_order` INTEGER NOT NULL," +
                            "`discord_group_id` LONG NOT NULL" +
                            ")",
                    PermissionsConstants.Databases.Mysql.Tables.GR
            );

            return connection.prepareStatement(query);
        };
    }

}
