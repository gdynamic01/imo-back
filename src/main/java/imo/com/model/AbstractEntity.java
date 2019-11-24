/**
 * 
 */
package imo.com.model;

import java.time.LocalDate;

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
	private LocalDate createAt = LocalDate.now();

	/** Id entity */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	/** nombre de modification */
	@Column(name = "modificationcounter")
	private int modificationcounter = 0;

	/** date mise a jour */
	@Column(name = "update_at")
	private LocalDate updateAt = LocalDate.now();

	/**
	 * @return the createAt
	 */
	public LocalDate getCreateAt() {
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
	 * @return the updateAt
	 */
	public LocalDate getUpdateAt() {
		return updateAt;
	}

	/**
	 * @param createAt
	 *                 the createAt to set
	 */
	public void setCreateAt(LocalDate createAt) {
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
	 * @param updateAt
	 *                 the updateAt to set
	 */
	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

}
