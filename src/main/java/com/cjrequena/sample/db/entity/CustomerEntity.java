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
 * The persistent class for the customer database table.
 * 
 */
@Data
@Entity
@Table(name="customer")
@NamedQuery(name="CustomerEntity.findAll", query="SELECT c FROM CustomerEntity c")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int customerId;

	@Column(length=70)
	private String address;

	@Column(length=40)
	private String city;

	@Column(length=80)
	private String company;

	@Column(length=40)
	private String country;

	@Column(nullable=false, length=60)
	private String email;

	@Column(length=24)
	private String fax;

	@Column(nullable=false, length=40)
	private String firstName;

	@Column(nullable=false, length=20)
	private String lastName;

	@Column(length=24)
	private String phone;

	@Column(length=10)
	private String postalCode;

	@Column(length=40)
	private String state;

	//bi-directional many-to-one association to EmployeeEntity
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="SupportRepId")
	private EmployeeEntity employee;

	//bi-directional many-to-one association to InvoiceEntity
	@OneToMany(mappedBy="customer")
	private List<InvoiceEntity> invoices;

	public CustomerEntity() {
	}

	public InvoiceEntity addInvoice(InvoiceEntity invoice) {
		getInvoices().add(invoice);
		invoice.setCustomer(this);

		return invoice;
	}

	public InvoiceEntity removeInvoice(InvoiceEntity invoice) {
		getInvoices().remove(invoice);
		invoice.setCustomer(null);

		return invoice;
	}

}
