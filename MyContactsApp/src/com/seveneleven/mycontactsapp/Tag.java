package com.seveneleven.mycontactsapp;
import java.util.Objects;
public class Tag {
    private String name;
    public Tag(String name) {
        this.name = name.trim().toLowerCase();
    }
    public String getName() {
        return name;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tag)) return false;
        Tag other = (Tag) obj;
        return this.name.equals(other.name);
    }
    public int hashCode() {
        return Objects.hash(name);
    }
    public String toString() {
        return name;
    }
}