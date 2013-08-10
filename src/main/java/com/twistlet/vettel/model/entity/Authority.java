package com.twistlet.vettel.model.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Authority generated by hbm2java
 */
@Entity
@Table(name="authority"
)
public class Authority  implements java.io.Serializable {


     private String authority;
     private String description;
     private Set<PersonAuthority> personAuthorities = new HashSet<PersonAuthority>(0);

    public Authority() {
    }

	
    public Authority(String authority, String description) {
        this.authority = authority;
        this.description = description;
    }
    public Authority(String authority, String description, Set<PersonAuthority> personAuthorities) {
       this.authority = authority;
       this.description = description;
       this.personAuthorities = personAuthorities;
    }
   
     @Id 

    
    @Column(name="authority", unique=true, nullable=false, length=50)
    public String getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    
    @Column(name="description", nullable=false, length=120)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="authority")
    public Set<PersonAuthority> getPersonAuthorities() {
        return this.personAuthorities;
    }
    
    public void setPersonAuthorities(Set<PersonAuthority> personAuthorities) {
        this.personAuthorities = personAuthorities;
    }




}


