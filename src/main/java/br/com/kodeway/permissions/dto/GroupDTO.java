package br.com.kodeway.permissions.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class GroupDTO {
    private final Integer id;
    private final String name, prefix, suffix, color;
    private final Integer priority, tabListListOrder;
    private final Long discordGroupId;
    private final Integer serverId;
    private final List<PermissionDTO> permissions;

    public Character getColorChar() {
        return this.color.charAt(0);
    }

    public String getFancyPrefix() {
        return this.getColor() + (this.prefix.matches("[\\[\\]]") ? this.prefix : this.prefix.split("\\[")[1].split("]")[0]);
    }

    public Boolean isDefault() {
        return this.priority == 0;
    }

    public Boolean isHigherOrEqual(GroupDTO groupDTO) {
        return this.priority >= groupDTO.getPriority();
    }

    public Boolean hasPermission(String permission) {
        return this.permissions
                .stream()
                .anyMatch(permission1 -> permission1.getName().equals(permission));
    }
}