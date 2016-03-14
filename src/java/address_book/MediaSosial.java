/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address_book;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ari
 */
@Entity
@Table(name = "media_sosial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MediaSosial.findAll", query = "SELECT m FROM MediaSosial m"),
    @NamedQuery(name = "MediaSosial.findById", query = "SELECT m FROM MediaSosial m WHERE m.id = :id"),
    @NamedQuery(name = "MediaSosial.findByNama", query = "SELECT m FROM MediaSosial m WHERE m.nama = :nama")})
public class MediaSosial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediaSosial")
    private Collection<UserMediaSosial> userMediaSosialCollection;

    public MediaSosial() {
    }

    public MediaSosial(Integer id) {
        this.id = id;
    }

    public MediaSosial(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @XmlTransient
    public Collection<UserMediaSosial> getUserMediaSosialCollection() {
        return userMediaSosialCollection;
    }

    public void setUserMediaSosialCollection(Collection<UserMediaSosial> userMediaSosialCollection) {
        this.userMediaSosialCollection = userMediaSosialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaSosial)) {
            return false;
        }
        MediaSosial other = (MediaSosial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "address_book.MediaSosial[ id=" + id + " ]";
    }
    
}
