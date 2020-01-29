package com.cjrequena.sample.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the artist database table.
 *
 */
@Data
@Entity
@Table(name = "artist")
@NamedQuery(name = "ArtistEntity.findAll", query = "SELECT a FROM ArtistEntity a")
public class ArtistEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private int artistId;

  @Column(length = 120)
  private String name;

  //bi-directional many-to-one association to AlbumEntity
  @OneToMany(mappedBy = "artist")
  private List<AlbumEntity> albums;

  public ArtistEntity() {
  }

  public AlbumEntity addAlbum(AlbumEntity album) {
    getAlbums().add(album);
    album.setArtist(this);

    return album;
  }

  public AlbumEntity removeAlbum(AlbumEntity album) {
    getAlbums().remove(album);
    album.setArtist(null);

    return album;
  }

}
