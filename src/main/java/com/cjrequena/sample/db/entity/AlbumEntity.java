package com.cjrequena.sample.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the album database table.
 *
 */

@Data
@Entity
@Table(name = "album")
@NamedQuery(name = "AlbumEntity.findAll", query = "SELECT a FROM AlbumEntity a")
public class AlbumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int albumId;

	@Column(nullable = false, length = 160)
	private String title;

	// bi-directional many-to-one association to ArtistEntity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ArtistId", nullable = false)
	private ArtistEntity artist;

	// bi-directional many-to-one association to TrackEntity
	@OneToMany(mappedBy = "album")
	private List<TrackEntity> tracks;

	public AlbumEntity() {
	}



	public TrackEntity addTrack(TrackEntity track) {
		getTracks().add(track);
		track.setAlbum(this);

		return track;
	}

	public TrackEntity removeTrack(TrackEntity track) {
		getTracks().remove(track);
		track.setAlbum(null);

		return track;
	}

}
