package com.epam.batrachenko.task1.Entity;

import com.epam.batrachenko.task7.field_annotaions.FieldTittle;

import java.math.BigDecimal;
import java.util.Objects;

public class GraphicsCard extends ComputerPart {
    @FieldTittle(tittle = "memory")
    private Integer memory;
    @FieldTittle(tittle = "memoryType")
    private String memoryType;
    @FieldTittle(tittle = "connector")
    private String connector;

    public GraphicsCard() {
    }

    public GraphicsCard(String name, BigDecimal price, String country, String category, String purpose, int memory, String memoryType, String connector) {
        super(name, price, country, category, purpose);
        this.memory = memory;
        this.memoryType = memoryType;
        this.connector = connector;
    }

    public Integer getMemory() {
        return this.memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getMemoryType() {
        return this.memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getConnector() {
        return this.connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Override
    public String toString() {
        return "GraphicsCard{" +
                "name='" + name + '\'' +
                ", price='" + price +'\'' +
                ", country='" + country + '\'' +
                ", category='" + category + '\'' +
                ", purpose='" + purpose + '\'' +
                ", memory='" + memory +'\'' +
                ", memoryType='" + memoryType + '\'' +
                ", connector='" + connector + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GraphicsCard that = (GraphicsCard) o;
        return Objects.equals(memory, that.memory) && Objects.equals(memoryType, that.memoryType) && Objects.equals(connector, that.connector);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), this.memory, this.memoryType, this.connector);
    }
}

