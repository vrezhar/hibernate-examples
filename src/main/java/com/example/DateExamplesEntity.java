package com.example;

import javax.persistence.*;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class DateExamplesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date simpleDate;
    private Instant simpleInstant;
    private Calendar aCalendar;
    private LocalDate aLocalDate;
    private LocalTime aLocalTime;
    private LocalDateTime aLocalDateTime;
    private ZonedDateTime aZonedDateTime;
    private OffsetDateTime anOffsetDateTime;
    private ZoneOffset aZoneOffset;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMappedAsTimeStamp;
    @Temporal(TemporalType.TIME)
    private Date dateMappedAsTime;
    @Temporal(TemporalType.DATE)
    private Date dateMappedAsDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSimpleDate() {
        return simpleDate;
    }

    public void setSimpleDate(Date simpleDate) {
        this.simpleDate = simpleDate;
    }

    public Instant getSimpleInstant() {
        return simpleInstant;
    }

    public void setSimpleInstant(Instant simpleInstant) {
        this.simpleInstant = simpleInstant;
    }

    public Calendar getaCalendar() {
        return aCalendar;
    }

    public void setaCalendar(Calendar aCalendar) {
        this.aCalendar = aCalendar;
    }

    public LocalDate getaLocalDate() {
        return aLocalDate;
    }

    public void setaLocalDate(LocalDate aLocalDate) {
        this.aLocalDate = aLocalDate;
    }

    public LocalTime getaLocalTime() {
        return aLocalTime;
    }

    public void setaLocalTime(LocalTime aLocalTime) {
        this.aLocalTime = aLocalTime;
    }

    public LocalDateTime getaLocalDateTime() {
        return aLocalDateTime;
    }

    public void setaLocalDateTime(LocalDateTime aLocalDateTime) {
        this.aLocalDateTime = aLocalDateTime;
    }

    public ZonedDateTime getaZonedDateTime() {
        return aZonedDateTime;
    }

    public void setaZonedDateTime(ZonedDateTime aZonedDateTime) {
        this.aZonedDateTime = aZonedDateTime;
    }

    public OffsetDateTime getAnOffsetDateTime() {
        return anOffsetDateTime;
    }

    public void setAnOffsetDateTime(OffsetDateTime anOffsetDateTime) {
        this.anOffsetDateTime = anOffsetDateTime;
    }

    public ZoneOffset getaZoneOffset() {
        return aZoneOffset;
    }

    public void setaZoneOffset(ZoneOffset aZoneOffset) {
        this.aZoneOffset = aZoneOffset;
    }

    public Date getDateMappedAsTimeStamp() {
        return dateMappedAsTimeStamp;
    }

    public void setDateMappedAsTimeStamp(Date dateMappedAsTimeStamp) {
        this.dateMappedAsTimeStamp = dateMappedAsTimeStamp;
    }

    public Date getDateMappedAsTime() {
        return dateMappedAsTime;
    }

    public void setDateMappedAsTime(Date dateMappedAsTime) {
        this.dateMappedAsTime = dateMappedAsTime;
    }

    public Date getDateMappedAsDate() {
        return dateMappedAsDate;
    }

    public void setDateMappedAsDate(Date dateMappedAsDate) {
        this.dateMappedAsDate = dateMappedAsDate;
    }
}
