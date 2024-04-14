package com.graphqljava.tutorial.retail;

import graphql.GraphQLContext;
import graphql.Internal;
import graphql.execution.CoercedVariables;
import graphql.language.StringValue;
import graphql.language.Value;
import graphql.scalars.util.Kit;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Internal
public final class LocalDateTimeScalar {

    private LocalDateTimeScalar() {
    }

    public static final GraphQLScalarType INSTANCE = GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .coercing(new Coercing<LocalDateTime, String>() {
                    @Override
                    public String serialize(
                            final Object input,
                            final GraphQLContext context,
                            final Locale locale) throws CoercingSerializeException
                    {
                        LocalDateTime localDateTime;
        
                        if (input instanceof LocalDateTime) {
                            localDateTime = (LocalDateTime) input;
                        } else {
                            if (!(input instanceof String)) {
                                throw new CoercingSerializeException("Expected something we can convert to 'java.time.LocalDateTime' but was '" + Kit.typeName(input) + "'.");
                            }
        
                            localDateTime = LocalDateTime.parse(input.toString());
                        }
        
                        try {
                            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);
                        } catch (DateTimeException dte) {
                            throw new CoercingSerializeException("Cannot serialize LocalDateTime", dte);
                        }
                    }
        
                    @Override
                    public LocalDateTime parseValue(
                            final Object input,
                            final GraphQLContext context,
                            final Locale locale) throws CoercingParseValueException
                    {
                        if (input instanceof LocalDateTime) {
                            return (LocalDateTime) input;
                        } else {
                            if (!(input instanceof String)) {
                                throw new CoercingParseValueException("Expected a 'String' but was '" + Kit.typeName(input) + "'.");
                            }
        
                            return LocalDateTime.parse(input.toString());
                        }
                    }
        
                    @Override
                    public LocalDateTime parseLiteral(
                            final Value<?> input,
                            final CoercedVariables variables,
                            final GraphQLContext context,
                            final Locale locale) throws CoercingParseLiteralException
                    {
                        if (!(input instanceof StringValue)) {
                            throw new CoercingParseLiteralException("Expected AST type 'StringValue' but was '" + Kit.typeName(input) + "'.");
                        }
        
                        return LocalDateTime.parse(input.toString());
                    }
        
                    @Override
                    public Value<?> valueToLiteral(
                            final Object input,
                            final GraphQLContext context,
                            final Locale locale)
                    {
                        String s = this.serialize(input, context, locale);
                        return StringValue.newStringValue(s).build();
                    }
                })
                .build();
}
