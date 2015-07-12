package com.zcode.springrestserver.web.domain;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="Event")
public class Event extends AbstractEntity<Long> {

    private String name;
    private Date from;
    private Date to;

    @ManyToOne
    private EventOrganiser organiser;

    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY)
    public List<Artist> artists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public EventOrganiser getOrganiser() {
        return organiser;
    }

    public void setOrganiser(EventOrganiser organiser) {
        this.organiser = organiser;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
