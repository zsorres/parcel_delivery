package dpd.parcel_delivery.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "parcel")
public class Parcel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "parcel_number")
	private Long parcelNumber;

	@Column(name = "status")
	private String status;

	@Column(name = "status_date")
	private Date statusDate;

	@Column(name = "deleted")
	private Boolean deleted;

	@Column(name = "actual_position")
	private String actualPosition;

	@Column(name = "delivered")
	private Boolean delivered;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
}
