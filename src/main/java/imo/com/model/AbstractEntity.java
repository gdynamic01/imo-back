/**
 * 
 */
package imo.com.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author mbalde
 *
 */
@MappedSuperclass
public abstract class AbstractEntity {

	/** date creation */
	@Column(name = "create_at")
	private LocalDateTime createAt = LocalDateTime.now();

	/** date modification */
	@Column(name = "update_at")
	private LocalDateTime updateAt = LocalDateTime.now();

	/** Id entity */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	/** nombre de modification */
	@Column(name = "modificationcounter")
	private int modificationcounter = 0;

	/**
	 * @return the createAt
	 */
	public LocalDateTime getCreateAt() {
		return createAt;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the modificationcounter
	 */
	public int getModificationcounter() {
		return modificationcounter;
	}

	/**
	 * @param createAt
	 *                 the createAt to set
	 */
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param modificationcounter
	 *                            the modificationcounter to set
	 */
	public void setModificationcounter(int modificationcounter) {
		this.modificationcounter = modificationcounter;
	}

	/**
	 * @return the updateAt
	 */
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	/**
	 * @param updateAt the updateAt to set
	 */
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

}
