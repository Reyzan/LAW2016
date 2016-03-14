/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address_book;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ari
 */
@Embeddable
public class UserMediaSosialPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "media_sosial_id")
    private int mediaSosialId;

    public UserMediaSosialPK() {
    }

    public UserMediaSosialPK(int userId, int mediaSosialId) {
        this.userId = userId;
        this.mediaSosialId = mediaSosialId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMediaSosialId() {
        return mediaSosialId;
    }

    public void setMediaSosialId(int mediaSosialId) {
        this.mediaSosialId = mediaSosialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) mediaSosialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMediaSosialPK)) {
            return false;
        }
        UserMediaSosialPK other = (UserMediaSosialPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.mediaSosialId != other.mediaSosialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "address_book.UserMediaSosialPK[ userId=" + userId + ", mediaSosialId=" + mediaSosialId + " ]";
    }
    
}
