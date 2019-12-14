/**
 * 
 */
package imo.com.model.photo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import imo.com.model.AbstractEntity;

/**
 * @author balde
 *
 */
@Entity
@Table(name = "imo_photos")
public class PhotosEntity extends AbstractEntity implements Serializable {

	/** ID SERIAL */
	private static final long serialVersionUID = -465864281697094887L;

	@Column(name = "path_photos", nullable = false)
	private String pathPhotos;

	/**
	 * @return the pathPhotos
	 */
	public String getPathPhotos() {
		return pathPhotos;
	}

	/**
	 * @param pathPhotos the pathPhotos to set
	 */
	public void setPathPhotos(String pathPhotos) {
		this.pathPhotos = pathPhotos;
	}
}
