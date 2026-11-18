package com.acme.platform.u202000000.shared.infrastructure.persistence.jpa.configuration.strategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import static io.github.encryptorcode.pluralize.Pluralize.pluralize;

/**
 * Hibernate physical naming strategy that converts every database identifier to snake_case
 * and pluralizes table names (e.g. {@code product} -> {@code products}).
 *
 * @author Angel Valdez
 */
public class SnakeCaseWithPluralizedTablePhysicalNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(toPlural(identifier));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return toSnakeCase(identifier);
    }

    /**
     * Converts a camelCase identifier to snake_case.
     *
     * @param identifier the original identifier
     * @return the snake_case identifier, or {@code null} if the identifier is null
     */
    private Identifier toSnakeCase(Identifier identifier) {
        if (identifier == null) return null;
        var newName = identifier.getText().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
        return Identifier.toIdentifier(newName);
    }

    /**
     * Pluralizes an identifier.
     *
     * @param identifier the original identifier
     * @return the pluralized identifier
     */
    private Identifier toPlural(Identifier identifier) {
        return Identifier.toIdentifier(pluralize(identifier.getText()));
    }
}
