package br.com.kodeway.permissions.storage.permissions.specs;

import br.com.kodeway.permissions.dto.PermissionDTO;
import br.com.kodeway.permissions.PermissionsConstants;
import com.google.common.collect.Sets;
import io.github.gutyerrez.core.shared.storage.repositories.specs.PreparedStatementCreator;
import io.github.gutyerrez.core.shared.storage.repositories.specs.ResultSetExtractor;
import io.github.gutyerrez.core.shared.storage.repositories.specs.SelectSqlSpec;

import java.util.Set;

/**
 * @author SrGabrieel
 */
public class FindAllPermissionsTableSpec extends SelectSqlSpec {

    @Override
    public ResultSetExtractor getResultSetExtractor() {
        return resultSet -> {
            Set<Object> permissions = Sets.newConcurrentHashSet();

            while (resultSet.next()) {
                PermissionDTO permissionDTO = new PermissionDTO(
                        resultSet.getString("name"),
                        resultSet.getInt("group_id"),
                        resultSet.getBoolean("grant_to_higher")
                );

                permissions.add(permissionDTO);
            }


            return permissions;
        };
    }

    @Override
    public PreparedStatementCreator getPreparedStatementCreator() {
        return connection -> {
            String query = String.format(
                    "SELECT * FROM %s",
                    PermissionsConstants.Databases.Mysql.Tables.PERMISSIONS_TABLE_NAME
            );

            return connection.prepareStatement(query);
        };
    }

}
