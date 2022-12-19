package com.example;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;
import java.util.UUID;

@Entity
public class BasicTypesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String simpleString;
    @Nationalized
    private String nationalizedVarchar;
    private Character aCharacter;
    @Nationalized
    private Character nationalizedCharacter;
    private Short shortValue;
    private Byte byteValue;
    private Integer anInteger;
    private char[] basicCharacterArray;
    @Lob
    private byte[] blobData;
    @Lob
    private char[] clobData;
    @Lob
    private Blob javaSqlBlob;
    @Lob
    private Clob javaSqlClob;
    private UUID uuidAsBinary; //would be native UUID in PostgreSQL and others that have support of UUID-s at engine level
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuidAsCompactBinary;
    @Type(type = "uuid-char")
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID uuidAsString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSimpleString() {
        return simpleString;
    }

    public void setSimpleString(String varchar) {
        this.simpleString = varchar;
    }

    public String getNationalizedVarchar() {
        return nationalizedVarchar;
    }

    public void setNationalizedVarchar(String nationalizedVarchar) {
        this.nationalizedVarchar = nationalizedVarchar;
    }

    public Character getACharacter() {
        return aCharacter;
    }

    public void setACharacter(Character character) {
        this.aCharacter = character;
    }

    public Character getNationalizedCharacter() {
        return nationalizedCharacter;
    }

    public void setNationalizedCharacter(Character nationalizedCharacter) {
        this.nationalizedCharacter = nationalizedCharacter;
    }

    public Short getShortValue() {
        return shortValue;
    }

    public void setShortValue(Short shortValue) {
        this.shortValue = shortValue;
    }

    public Byte getByteValue() {
        return byteValue;
    }

    public void setByteValue(Byte byteValue) {
        this.byteValue = byteValue;
    }

    public Integer getAnInteger() {
        return anInteger;
    }

    public void setAnInteger(Integer integer) {
        this.anInteger = integer;
    }

    public char[] getBasicCharacterArray() {
        return basicCharacterArray;
    }

    public void setBasicCharacterArray(char[] basicCharacterArray) {
        this.basicCharacterArray = basicCharacterArray;
    }

    public byte[] getBlobData() {
        return blobData;
    }

    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }

    public char[] getClobData() {
        return clobData;
    }

    public void setClobData(char[] clobData) {
        this.clobData = clobData;
    }

    public Blob getJavaSqlBlob() {
        return javaSqlBlob;
    }

    public void setJavaSqlBlob(Blob javaSqlBlob) {
        this.javaSqlBlob = javaSqlBlob;
    }

    public Clob getJavaSqlClob() {
        return javaSqlClob;
    }

    public void setJavaSqlClob(Clob javaSqlClob) {
        this.javaSqlClob = javaSqlClob;
    }

    public UUID getUuidAsBinary() {
        return uuidAsBinary;
    }

    public void setUuidAsBinary(UUID uuidAsBinary) {
        this.uuidAsBinary = uuidAsBinary;
    }

    public UUID getUuidAsCompactBinary() {
        return uuidAsCompactBinary;
    }

    public void setUuidAsCompactBinary(UUID uuidAsCompactBinary) {
        this.uuidAsCompactBinary = uuidAsCompactBinary;
    }

    public UUID getUuidAsString() {
        return uuidAsString;
    }

    public void setUuidAsString(UUID uuidAsString) {
        this.uuidAsString = uuidAsString;
    }
}
