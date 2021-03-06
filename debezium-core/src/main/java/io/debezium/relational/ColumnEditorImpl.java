/*
 * Copyright Debezium Authors.
 * 
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.relational;

import java.sql.Types;

final class ColumnEditorImpl implements ColumnEditor {

    private String name;
    private int jdbcType = Types.INTEGER;
    private String typeName;
    private int length = -1;
    private int scale = -1;
    private int position = 1;
    private boolean optional = true;
    private boolean autoIncremented = false;
    private boolean generated = false;

    protected ColumnEditorImpl() {
    }
    
    @Override
    public String name() {
        return name;
    }
    
    @Override
    public String typeName() {
        return typeName;
    }
    
    @Override
    public int jdbcType() {
        return jdbcType;
    }
    
    @Override
    public int length() {
        return length;
    }
    
    @Override
    public int scale() {
        return scale;
    }
    
    @Override
    public int position() {
        return position;
    }
    
    @Override
    public boolean isOptional() {
        return optional;
    }
    
    @Override
    public boolean isAutoIncremented() {
        return autoIncremented;
    }

    @Override
    public boolean isGenerated() {
        return generated;
    }
    
    @Override
    public ColumnEditorImpl name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ColumnEditorImpl typeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    @Override
    public ColumnEditorImpl jdbcType(int jdbcType) {
        this.jdbcType = jdbcType;
        return this;
    }

    @Override
    public ColumnEditorImpl length(int length) {
        assert length >= -1;
        this.length = length;
        return this;
    }

    @Override
    public ColumnEditorImpl scale(int scale) {
        assert scale >= -1;
        this.scale = scale;
        return this;
    }

    @Override
    public ColumnEditorImpl optional(boolean optional) {
        this.optional = optional;
        return this;
    }

    @Override
    public ColumnEditorImpl autoIncremented(boolean autoIncremented) {
        this.autoIncremented = autoIncremented;
        return this;
    }

    @Override
    public ColumnEditorImpl generated(boolean generated) {
        this.generated = generated;
        return this;
    }

    @Override
    public ColumnEditorImpl position(int position) {
        this.position = position;
        return this;
    }

    @Override
    public Column create() {
        return new ColumnImpl(name, position, jdbcType, typeName, length, scale, optional, autoIncremented, generated);
    }

    @Override
    public int compareTo(Column that) {
        return create().compareTo(that);
    }

    @Override
    public String toString() {
        return create().toString();
    }
}