package br.com.kodeway.permissions.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PermissionDTO {
    @Getter
    private final String name;

    @Getter
    private final Integer groupId;

    private final Boolean grantToHigher;

    public Boolean grantToHigher() {
        return this.grantToHigher;
    }

}